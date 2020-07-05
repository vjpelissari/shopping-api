package com.jantorno.shopping.resources;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jantorno.shopping.domain.Comentario;
import com.jantorno.shopping.domain.Produto;
import com.jantorno.shopping.services.ProdutosServices;

@RestController
@RequestMapping (value = "/produtos")
public class ProdutosResources {

	@Autowired
	private ProdutosServices produtosServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(produtosServices.listar());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Produto produto) {
		
		/*
		 *  Ao criar um recurso, retornei um 201.
		 *  Retorna também a URI de onde esse recurso pode ser localizado. 
		 */
		
		produto = produtosServices.salvar(produto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(produto.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Produto produto = produtosServices.buscar(id);
		
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(produto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		produtosServices.deletar(id);
		return ResponseEntity.noContent().build();
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Produto produto, 
			@PathVariable("id") Long id) {
		produto.setId(id);
		produtosServices.atualizar(produto);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}/comentarios", method = RequestMethod.POST)
	public ResponseEntity<Void> adicionarComentario(@PathVariable("id") Long produtoId, 
			@RequestBody Comentario comentario) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		comentario.setUsuario(auth.getName());
		
		produtosServices.salvarComentario(produtoId, comentario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}/comentarios", method = RequestMethod.GET)
	public ResponseEntity<List<Comentario>> listarComentarios(
			@PathVariable("id")Long produtoId) {
		List<Comentario> comentarios = produtosServices.listarComentarios(produtoId);
		return ResponseEntity.status(HttpStatus.OK).body(comentarios);
	}
}