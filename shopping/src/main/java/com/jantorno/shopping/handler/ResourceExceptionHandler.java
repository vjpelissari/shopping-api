package com.jantorno.shopping.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jantorno.shopping.domain.DetalhesErro;
import com.jantorno.shopping.services.exceptions.ClienteNaoEncontradoException;
import com.jantorno.shopping.services.exceptions.ClienteExistenteException;
import com.jantorno.shopping.services.exceptions.ProdutoNaoEncontradoException;


@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ProdutoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleProdutoNaoEncontradoException
							(ProdutoNaoEncontradoException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O produto não pôde ser encontrado");
		erro.setMensagemDesenvolvedor("http://erros.shopping.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(ClienteExistenteException.class)
	public ResponseEntity<DetalhesErro> handleClienteExistenteException
							(ClienteExistenteException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Cliente já existente");
		erro.setMensagemDesenvolvedor("http://erros.shopping.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(ClienteNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleClienteNaoEncontradoException
							(ClienteNaoEncontradoException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O Cliente não pôde ser encontrado");
		erro.setMensagemDesenvolvedor("http://erros.shopping.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException
							(DataIntegrityViolationException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisição inválida");
		erro.setMensagemDesenvolvedor("http://erros.shopping.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}