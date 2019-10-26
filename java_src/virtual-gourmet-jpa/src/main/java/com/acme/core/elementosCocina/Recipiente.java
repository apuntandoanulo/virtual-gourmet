package com.acme.core.elementosCocina;

import com.acme.core.ElementoCocina;

public class Recipiente extends ElementoCocina {

	public Recipiente(String nombre) {
		super("Recipiente " + nombre);
	}

	public void alistar() {
		System.out.println(getNombre() + ": Limpiar");
	}

}
