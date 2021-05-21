package com.dsclient.dsclient.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsclient.dsclient.dto.ClientDTO;
import com.dsclient.dsclient.entities.Client;
import com.dsclient.dsclient.repositories.ClientRepository;

@Service

public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional (readOnly = true)
	public List<Client>findAll(){
		
		return repository.findAll();
		
	}
	
	@Transactional (readOnly = true)
	public ClientDTO findById(Long id) {
		Optional <Client> obj = repository.findById(id);
		Client entity = obj.get();
		return new ClientDTO(entity); 
	}
	
	
}
