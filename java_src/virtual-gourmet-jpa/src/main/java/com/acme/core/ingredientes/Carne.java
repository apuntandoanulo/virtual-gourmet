package com.acme.core.ingredientes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.acme.core.EnumIngrediente;
import com.acme.core.Ingrediente;

@XmlRootElement(name = "carne")
@XmlAccessorType(XmlAccessType.FIELD)
public class Carne extends Ingrediente {

	public Carne() {
		super("Carne ???");
	}
	
	public Carne(String nombre) {
		super("Carne " + nombre);
		setTipo(EnumIngrediente.PROTEINA);
	}
	
	@Override
	public void alistar() {
		System.out.println(getNombre() + ": Tasajeando...");
	}

}
