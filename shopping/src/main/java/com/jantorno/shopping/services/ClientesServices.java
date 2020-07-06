package com.jantorno.shopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jantorno.shopping.domain.Cliente;
import com.jantorno.shopping.repository.ClientesRepository;
import com.jantorno.shopping.services.exceptions.ClienteNaoEncontradoException;
import com.jantorno.shopping.services.exceptions.ClienteExistenteException;

@Service
public class ClientesServices {

	@Autowired
	private ClientesRepository autoresRepository;
	
	public List<Cliente> listar() {
		return autoresRepository.findAll();
	}	
	
	public Cliente salvar(Cliente cliente) {
		if(cliente.getId() != null) {
			Cliente a = autoresRepository.findById(cliente.getId()).orElse(null);
			if(a != null) {
				throw new ClienteExistenteException("O autor já existe.");
			}
		}
		return autoresRepository.save(cliente);
	}
	
	public Cliente buscar(Long id) {
		Cliente cliente = autoresRepository.findById(id).orElse(null);
		
		if(cliente == null) {
			throw new ClienteNaoEncontradoException("O autor não pôde ser encontrado.");
		}
		return cliente;
	}
}