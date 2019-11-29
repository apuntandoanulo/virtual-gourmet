package com.acme.core;

public enum EnumIngrediente {
	VEGETAL("Vegetal"),
	FRUTA("Fruta"),
	GRANO("Grano"),
	PROTEINA("Proteina"),
	CONDIMENTO("Condimento"),
	DESCONOCIDO("Desconocido");
	
	private String nombre;
	
	private EnumIngrediente(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
}
