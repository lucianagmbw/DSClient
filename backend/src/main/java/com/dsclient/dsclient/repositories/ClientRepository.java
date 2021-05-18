package com.dsclient.dsclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsclient.dsclient.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client , Long>  {

}
