package com.acme.entities.ejemplos.excepciones;

public class LimiteSuperadoException extends Exception {

	private Integer cantidadSuperada;
	
	public LimiteSuperadoException(String mensaje, Integer cantidadSuperada) {
		super(mensaje);
		this.cantidadSuperada = cantidadSuperada;
	}
	
	public Integer getCantidadSuperada() {
		return cantidadSuperada;
	}
}
