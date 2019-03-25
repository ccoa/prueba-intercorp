package com.occoa.intercorp.service;

import java.math.BigDecimal;
import java.util.List;

import com.occoa.intercorp.model.Cliente;

public interface ClienteService {
	
	List<Cliente> listar() throws Exception;
	
	void crear(Cliente cliente) throws Exception;
	
	BigDecimal obtenerPromedioEdades(List<Cliente> clientes) throws Exception;
	
	BigDecimal obtenerDesviacionEstandarEdades(List<Cliente> clientes) throws Exception;
	
}
