package com.acme.core.ingredientes;

import javax.persistence.Entity;

import com.acme.core.EnumIngrediente;
import com.acme.core.Ingrediente;

@Entity
public class Fruta extends Ingrediente {

	public Fruta() {}
	
	public Fruta(String nombre) {
		super(nombre);
		setTipo(EnumIngrediente.FRUTA);
	}
	
	public Fruta(String nombre, Integer stock, Double costo) {
		this(nombre);
		setCosto(costo);
		setStock(stock);
	}

	@Override
	public void alistar() {
		System.out.println(getNombre() + ": Lavar...");
	}
}
