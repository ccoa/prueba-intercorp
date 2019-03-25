package com.occoa.intercorp.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.occoa.intercorp.dao.ClienteDao;
import com.occoa.intercorp.model.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	public List<Cliente> listar() throws Exception {
		
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	public void crear(Cliente cliente) throws Exception {
		clienteDao.save(cliente);
	}

	@Override
	public BigDecimal obtenerPromedioEdades(List<Cliente> clientes) throws Exception {
		
		BigDecimal sumaEdades = new BigDecimal(clientes.stream().mapToInt(cliente -> cliente.getEdad()).sum());
		BigDecimal cantidadClientes = new BigDecimal(clientes.size()); 
		
		BigDecimal promedio = sumaEdades.divide(cantidadClientes, 2, RoundingMode.HALF_UP);
		
		return promedio;
	}

	@Override
	public BigDecimal obtenerDesviacionEstandarEdades(List<Cliente> clientes) throws Exception {
		
		BigDecimal variacionEstandar = BigDecimal.ZERO;
		
		BigDecimal totalElementos = new BigDecimal(clientes.size());
		
		BigDecimal media = obtenerPromedioEdades(clientes);
		
		BigDecimal sumaCuadradosDistancia = BigDecimal.ZERO;
		
		for (Cliente cliente : clientes) {
			BigDecimal cuadradoDistancia = BigDecimal.ZERO;
			
			BigDecimal edad = new BigDecimal(cliente.getEdad());
			
			cuadradoDistancia = (edad.subtract(media)).pow(2).setScale(2, RoundingMode.HALF_UP);
			
			sumaCuadradosDistancia = sumaCuadradosDistancia.add(cuadradoDistancia);
		}
		
		variacionEstandar = new BigDecimal(Math.sqrt(sumaCuadradosDistancia.divide(totalElementos, 2 , RoundingMode.HALF_UP).doubleValue()))
				.setScale(2, RoundingMode.HALF_UP);
		
		return variacionEstandar;
	}
	
	

}
