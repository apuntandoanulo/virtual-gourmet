package com.acme.entities.ejemplos.genericos;

public class MiClaseGenerica1<T> {
	T miobjeto;
	
	public MiClaseGenerica1(T obj) {
		this.miobjeto = obj;
	}
	
	public T getMiobjeto() {
		return miobjeto;
	}
	
	public String obtenerNombreClase() {
		return "El tipo T es de clase : " + miobjeto.getClass().getSimpleName();
	}
}
