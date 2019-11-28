package com.acme.core.ingredientes;

import com.acme.core.EnumIngrediente;
import com.acme.core.Ingrediente;

public class Condimento extends Ingrediente {

	public Condimento(String nombre) {
		super(nombre);
		setTipo(EnumIngrediente.CONDIMENTO);
	}
}
