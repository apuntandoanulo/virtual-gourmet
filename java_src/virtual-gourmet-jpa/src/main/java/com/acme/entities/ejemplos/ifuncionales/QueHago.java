package com.acme.entities.ejemplos.ifuncionales;

public class QueHago implements Alpha, Beta {

	@Override
	public void imprimir(String str) {
		Alpha.super.imprimir(str);
	}

}
