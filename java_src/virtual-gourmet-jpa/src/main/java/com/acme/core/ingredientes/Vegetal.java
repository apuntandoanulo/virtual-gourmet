package com.acme.core.ingredientes;

import javax.persistence.Entity;

import com.acme.core.EnumIngrediente;
import com.acme.core.Ingrediente;

@Entity
public class Vegetal extends Ingrediente {

	public Vegetal() {}
	
	public Vegetal(String nombre) {
		super(nombre);
		setTipo(EnumIngrediente.VEGETAL);
	}
	
	@Override
	public void alistar() {
		System.out.println(getNombre() + ": Lavar y cortar...");
	}
}
