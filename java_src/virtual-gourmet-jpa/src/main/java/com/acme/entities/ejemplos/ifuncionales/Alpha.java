package com.acme.entities.ejemplos.ifuncionales;

public interface Alpha {

	default void imprimir(String str) {
		System.out.println("Alpha " + str);
	}
}
