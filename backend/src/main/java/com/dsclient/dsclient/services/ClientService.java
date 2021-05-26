package com.dsclient.dsclient.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsclient.dsclient.dto.ClientDTO;
import com.dsclient.dsclient.entities.Client;
import com.dsclient.dsclient.repositories.ClientRepository;
import com.dsclient.dsclient.services.exceptions.ResourceNotFoundException;
import javax.persistence.EntityNotFoundException;
@Service

public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional (readOnly = true)
	public List<Client>findAll(){
		
		return repository.findAll();
		
	}
	//esse busca do pacote  ds client  - pode dar errro
	@Transactional (readOnly = true)
	public ClientDTO findById(Long id) {
		Optional <Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow( ()-> new ResourceNotFoundException("Entity not found"));
		return new ClientDTO(entity); 
	}
	
	@Transactional 
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}
	
	
	@Transactional 
	public ClientDTO update(Long id ,ClientDTO dto) {
		
		try {
		Client entity = repository.getOne(id);
		
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		
		entity = repository.save(entity);
		return new ClientDTO(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not founf" +id);
		}
		
	}
	
	
}
