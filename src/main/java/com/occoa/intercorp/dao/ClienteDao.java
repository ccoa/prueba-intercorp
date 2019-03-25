package com.occoa.intercorp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.occoa.intercorp.model.Cliente;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Long>{
	
	

}
