package com.acme.entities.ejemplos.ifuncionales;

public interface Ejemplo01 {
	
	default void imprimir(String str) {
		System.out.println(str);
	}
	
	static int sumar(int a, int b) {
		return a+ b;
	}
}
