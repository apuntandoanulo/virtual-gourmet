package com.acme.core;

public abstract class ElementoCocina implements ElementoPreparacion {

	private String nombre;
	
	public ElementoCocina(String nombre) {
		this.nombre = nombre;
	}
		
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}