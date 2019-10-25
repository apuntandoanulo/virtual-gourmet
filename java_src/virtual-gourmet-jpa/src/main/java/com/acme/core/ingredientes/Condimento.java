package com.acme.core.ingredientes;

import com.acme.core.EnumIngrediente;
import com.acme.core.Ingrediente;

public class Condimento extends Ingrediente {

	public Condimento(String nombre) {
		super("Condimento " + nombre);
		setTipo(EnumIngrediente.CONDIMENTO);
		setStock(1);
		setCosto(1.0);
	}

	public void alistar() {
		System.out.println(getNombre() + ": Destapando el recipiente...");
	}
}
