package com.acme.core;

public abstract class Ingrediente implements ElementoPreparacion {
	private Double costo;
	private String nombre;
	private Integer stock;
	private EnumIngrediente tipo;
	private Integer unidadMedida;
	
	public Ingrediente(String nombre) {
		this.nombre = nombre;
		this.costo = 0.0;
		this.stock = 0;
		this.tipo = EnumIngrediente.DESCONOCIDO;
	}
	
	public Ingrediente(String nombre, Double costo) {
		this.nombre = nombre;
		this.costo = costo;
	}
	
	public void alistar() {
		System.out.println(this.nombre + ": No requiere alistamiento...");
	}
	
	public Double getCosto() {
		return costo;
	}
	
	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public EnumIngrediente getTipo() {
		return tipo;
	}

	public void setTipo(EnumIngrediente tipo) {
		this.tipo = tipo;
	}

	public Integer getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(Integer unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
	@Override
	public String toString() {
		return getTipo() + " : " + getNombre();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.getNombre().equalsIgnoreCase( ((Ingrediente) obj).getNombre());
	}
}
