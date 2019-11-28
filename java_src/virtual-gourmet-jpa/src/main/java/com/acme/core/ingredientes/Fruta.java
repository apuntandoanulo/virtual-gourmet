package com.acme.core.ingredientes;

import com.acme.core.EnumIngrediente;
import com.acme.core.Ingrediente;

public class Fruta extends Ingrediente {

	public Fruta(String nombre) {
		super(nombre);
		setTipo(EnumIngrediente.FRUTA);
	}
	
	@Override
	public void alistar() {
		System.out.println(getNombre() + ": Lavar...");
	}
}
