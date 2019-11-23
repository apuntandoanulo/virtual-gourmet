package com.acme.entities.ejemplos.genericos;

public class MiClaseGenerica2<A, B> {
	A miobjeto1;
	B miobjeto2;
	
	public MiClaseGenerica2(A obj1, B obj2) {
		this.miobjeto1 = obj1;
		this.miobjeto2 = obj2;
	}
	
	public A getMiobjeto1() {
		return miobjeto1;
	}
	
	public B getMiobjeto2() {
		return miobjeto2;
	}
	
	public String obtenerNombreClase() {
		return "El tipo A es de clase : " + miobjeto1.getClass().getSimpleName() +
				"El tipo B es de clase : " + miobjeto2.getClass().getSimpleName();
	}
}

