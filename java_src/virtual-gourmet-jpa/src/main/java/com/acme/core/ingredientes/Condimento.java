package com.acme.core.ingredientes;

import javax.persistence.Entity;

import com.acme.core.EnumIngrediente;
import com.acme.core.Ingrediente;

@Entity
public class Condimento extends Ingrediente {

	public Condimento(String nombre) {
		super(nombre);
		setTipo(EnumIngrediente.CONDIMENTO);
	}
}
