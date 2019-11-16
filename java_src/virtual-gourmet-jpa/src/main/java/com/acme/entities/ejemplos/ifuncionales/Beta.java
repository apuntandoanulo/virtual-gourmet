package com.acme.entities.ejemplos.ifuncionales;

public interface Beta {

	default void imprimir(String str) {
		System.out.println("Beta" + str);
	}
}
