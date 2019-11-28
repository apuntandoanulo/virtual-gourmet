package com.acme.core.ingredientes;

import com.acme.core.EnumIngrediente;
import com.acme.core.Ingrediente;

public class Vegetal extends Ingrediente {

	public Vegetal(String nombre) {
		super(nombre);
		setTipo(EnumIngrediente.VEGETAL);
	}
	
	@Override
	public void alistar() {
		System.out.println(getNombre() + ": Lavar y cortar...");
	}
}
