package com.jantorno.shopping.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jantorno.shopping.domain.Comentario;
import com.jantorno.shopping.domain.Produto;
import com.jantorno.shopping.repository.ComentariosRepository;
import com.jantorno.shopping.repository.ProdutosRepository;
import com.jantorno.shopping.services.exceptions.ProdutoNaoEncontradoException;

@Service
public class ProdutosServices {

	@Autowired
	private ProdutosRepository produtosRepository;
	
	@Autowired
	private ComentariosRepository comentariosRepository; 
	
	public List<Produto> listar() {
		return produtosRepository.findAll();
	}
	
	public Produto buscar(Long id) {
		Produto produto = this.produtosRepository.findById(id).orElse(null);
		
		if(produto == null) {
			throw new ProdutoNaoEncontradoException("O produto não foi encontrado.");
		}
		return produto;
	}
	
	public Produto salvar(Produto produto) {
		produto.setId(null);
		return produtosRepository.save(produto);
	}
	
	public void deletar(Long id) {
		try {
			produtosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ProdutoNaoEncontradoException("O produto não foi encontrado.");
		}
	}
	
	public void atualizar(Produto produto) {
		verificarExistencia(produto);
		produtosRepository.save(produto);
	}
	
	private void verificarExistencia(Produto produto) {
		buscar(produto.getId());
	}
	
	public Comentario salvarComentario(Long produtoId, Comentario comentario) {
		Produto produto = buscar(produtoId);
		comentario.setProduto(produto);
		return comentariosRepository.save(comentario);
	}
	
	public List<Comentario> listarComentarios(Long produtoId) {
		Produto produto = buscar(produtoId);
		return produto.getComentarios();
	}
}