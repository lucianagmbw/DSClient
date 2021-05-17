package com.dsclient.dsclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsclient.dsclient.entities.Client;

public interface ClientRepository extends JpaRepository<Client , Long>  {

}
