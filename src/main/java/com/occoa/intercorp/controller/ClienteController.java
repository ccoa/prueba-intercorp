package com.occoa.intercorp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.occoa.intercorp.bean.ClienteBean;
import com.occoa.intercorp.bean.KpiClienteBean;
import com.occoa.intercorp.model.Cliente;
import com.occoa.intercorp.service.ClienteService;
import com.occoa.intercorp.util.FechaUtil;

import io.swagger.annotations.ApiOperation;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/creacliente", method = RequestMethod.POST)
	@ApiOperation(value = "Crear un cliente. PD: no se valida la relacion edad - fecha de nacimiento en lo datos de entrada")
	public ResponseEntity<String> crear(@RequestBody ClienteBean clienteBean) {
		
		try {
			
			Cliente cliente = new Cliente();
			cliente.setNombre(clienteBean.getNombre());
			cliente.setApellido(clienteBean.getApellido());
			cliente.setEdad(clienteBean.getEdad());
			cliente.setFechaNacimiento(FechaUtil.convertirStringAdate(clienteBean.getFechaNacimiento()));
			
			clienteService.crear(cliente);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/kpideclientes", method = RequestMethod.GET)
	@ApiOperation(value = "Obtener promedio de edades y variacion estandar de edades de los clientes", response = KpiClienteBean.class)
	public ResponseEntity<Object> obtenerKpis() {
		
		KpiClienteBean kpiClienteBean = new KpiClienteBean();
		
		try {
			
			List<Cliente> clientes = clienteService.listar();
			
			if (!clientes.isEmpty()) {
				
				kpiClienteBean.setPromedioEdades(clienteService.obtenerPromedioEdades(clientes));
				
				kpiClienteBean.setDesviacionEstandarEdades(clienteService.obtenerDesviacionEstandarEdades(clientes));
			}
			
		} catch (Exception e) {
			
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Object>(kpiClienteBean, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/listclientes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "Listar clientes con fecha probable de muerte de cada uno.", response = List.class)
	public ResponseEntity<Object> listar() {
		
		List<ClienteBean> clientesBeans = new ArrayList<>();
		
		try {
			
			List<Cliente> clientes = clienteService.listar();
			
			for (Cliente cliente : clientes) {
				ClienteBean clienteBean = new ClienteBean();
				clienteBean.setIdCliente(cliente.getIdCliente());
				clienteBean.setNombre(cliente.getNombre());
				clienteBean.setApellido(cliente.getApellido());
				clienteBean.setEdad(cliente.getEdad());
				clienteBean.setFechaNacimiento(FechaUtil.convertirDateAstring(cliente.getFechaNacimiento()));
				clienteBean.setFechaProbableMuerte(FechaUtil.obtenerFechaProbableMuerte(cliente.getFechaNacimiento()));
				
				clientesBeans.add(clienteBean);
			}
			
		} catch (Exception e) {
			
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Object>(clientesBeans, HttpStatus.OK);
	}
}
