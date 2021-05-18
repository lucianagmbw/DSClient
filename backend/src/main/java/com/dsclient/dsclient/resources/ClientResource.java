//controlador REST DA APLICAÇÃO (API)para front
package com.dsclient.dsclient.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsclient.dsclient.entities.Client;
import com.dsclient.dsclient.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<List<Client>>findAll(){
		
		List <Client> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
