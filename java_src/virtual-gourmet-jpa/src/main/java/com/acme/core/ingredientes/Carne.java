package com.acme.core.ingredientes;

import com.acme.core.EnumIngrediente;
import com.acme.core.Ingrediente;

public class Carne extends Ingrediente {

	public Carne(String nombre) {
		super("Carne " + nombre);
		setTipo(EnumIngrediente.PROTEINA);
	}
	
	@Override
	public void alistar() {
		System.out.println(getNombre() + ": Tasajeando...");
	}

}
