package com.jantorno.shopping.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jantorno.shopping.domain.Cliente;
import com.jantorno.shopping.services.ClientesServices;

@RestController
@RequestMapping("/clientes")
public class ClientesResources {

	@Autowired
	private ClientesServices clientesService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> clientes = clientesService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(clientes);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Cliente cliente) {
		cliente = clientesService.salvar(cliente);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(cliente.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> buscar(@PathVariable("id") Long id) {
		Cliente cliente = clientesService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}
}