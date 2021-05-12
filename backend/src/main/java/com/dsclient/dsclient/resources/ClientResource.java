//controlador REST DA APLICAÇÃO (API)para front
package com.dsclient.dsclient.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsclient.dsclient.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@GetMapping
	public ResponseEntity<List<Client>>findAll(){
		List <Client> list = new ArrayList<>();
		list.add( new Client( 1L, "Maria","10354917706",10.0, "20:32:00", 0 ));
		return ResponseEntity.ok().body(list);
	}
}
