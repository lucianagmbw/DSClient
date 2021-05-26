//controlador REST DA APLICAÇÃO (API)para front
package com.dsclient.dsclient.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dsclient.dsclient.dto.ClientDTO;
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
	
	@GetMapping (value ="/{id}")
	public ResponseEntity<ClientDTO>findById( @PathVariable Long id){
		
		ClientDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}")
				  .buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping (value ="/{id}")
	public ResponseEntity<ClientDTO> update(@PathVariable Long id , @RequestBody ClientDTO dto){
		dto = service.update(id , dto);
		return ResponseEntity.ok().body(dto);
	}
	
}
