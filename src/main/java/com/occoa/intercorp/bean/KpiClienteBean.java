package com.occoa.intercorp.bean;

import java.math.BigDecimal;

public class KpiClienteBean {

	private BigDecimal promedioEdades;
	
	private BigDecimal desviacionEstandarEdades;

	public BigDecimal getPromedioEdades() {
		return promedioEdades;
	}

	public void setPromedioEdades(BigDecimal promedioEdades) {
		this.promedioEdades = promedioEdades;
	}

	public BigDecimal getDesviacionEstandarEdades() {
		return desviacionEstandarEdades;
	}

	public void setDesviacionEstandarEdades(BigDecimal desviacionEstandarEdades) {
		this.desviacionEstandarEdades = desviacionEstandarEdades;
	}
	
}
