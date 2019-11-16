package com.acme.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Ingrediente implements ElementoPreparacion, Comparable<Ingrediente> {
	
	private Double costo;
	
	@XmlAttribute
	private String nombre;
	
	@XmlElement(name = "cantidad", required = true)
	private Integer stock;
	
	@XmlAttribute(name = "tipo", required = true)
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equalsIgnoreCase(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ingrediente [costo=" + costo + ", nombre=" + nombre + "]";
	}

	public int compareTo(Ingrediente o) {
		return getNombre().compareTo(o.getNombre());
	}
	
}
