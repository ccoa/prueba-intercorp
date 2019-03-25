package com.occoa.intercorp.bean;

import io.swagger.annotations.ApiModelProperty;

public class ClienteBean {
	
	private Long idCliente;
	
	@ApiModelProperty(required = true)
	private String nombre;
	
	@ApiModelProperty(required = true)
	private String apellido;
	
	@ApiModelProperty(required = true)
	private Integer edad;
	
	@ApiModelProperty(notes = "Formato requerido: dd/MM/yyyy", required = true)
	private String fechaNacimiento;
	
	private String fechaProbableMuerte;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaProbableMuerte() {
		return fechaProbableMuerte;
	}

	public void setFechaProbableMuerte(String fechaProbableMuerte) {
		this.fechaProbableMuerte = fechaProbableMuerte;
	}

	
}
