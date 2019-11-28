package com.acme.core.ingredientes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.acme.core.EnumIngrediente;
import com.acme.core.Ingrediente;

@XmlRootElement(name = "carne")
@XmlAccessorType(XmlAccessType.FIELD)
public class Carne extends Ingrediente {

	private String selloCalidad;
	
	public Carne() {
		super("Carne ???");
		setTipo(EnumIngrediente.PROTEINA);
	}
	
	public Carne(String nombre) {
		super(nombre);
		setTipo(EnumIngrediente.PROTEINA);
	}
	
	@Override
	public void alistar() {
		System.out.println(getNombre() + ": Tasajeando...");
	}

	public String getSelloCalidad() {
		return selloCalidad;
	}
	
	public void setSelloCalidad(String selloCalidad) {
		this.selloCalidad = selloCalidad;
	}
}
