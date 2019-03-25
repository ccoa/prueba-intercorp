package com.occoa.intercorp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class FechaUtil {
	
	private static final int EDAD_MAXIMA = 122;
	private static final String FORMATO_FECHA = "dd/MM/yyyy";
	
	public static String convertirDateAstring(Date fecha) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMATO_FECHA);
		String fechaConFormato = simpleDateFormat.format(fecha);
		
		return fechaConFormato;
	}
	
	public static Date convertirStringAdate(String fechaString) throws Exception {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMATO_FECHA);
		
		Date fecha;
		
		try {
			
			fecha = simpleDateFormat.parse(fechaString);
			
		} catch (ParseException e) {
			
			throw new Exception(String.format("Debe ingresar la fecha en el formato %s", FORMATO_FECHA));
		}
		
		return fecha;
	}
		
	public static String obtenerFechaProbableMuerte(Date fechaNacimientoParam) {
		    
        Date maximaFechaProbableMuerte = obtenerMaximaFechaProbableMuerte(fechaNacimientoParam, EDAD_MAXIMA);
        
        Date fechaProbableMuerte = new Date(ThreadLocalRandom.current().nextLong(new Date().getTime(), maximaFechaProbableMuerte.getTime()));
        
        return convertirDateAstring(fechaProbableMuerte);
    }
	

	public static Date obtenerMaximaFechaProbableMuerte(Date fecha, int anios) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		
		calendar.add(Calendar.YEAR, anios);
		
		return calendar.getTime();
	}
}
