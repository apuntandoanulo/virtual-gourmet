package com.acme.entities.ejemplos.genericos;

import com.acme.core.ingredientes.Carne;

public class EjemploGenerico2 {

	public static void main(String[] args) {
		Double numero = 10d;
		
		MiClaseGenerica2<Double, Carne> genEntero = new MiClaseGenerica2<Double, Carne>(numero, new Carne("Pollo"));
		
		System.out.println(genEntero.getMiobjeto1());
		System.out.println(genEntero.getMiobjeto2());
		System.out.println(genEntero.obtenerNombreClase());
		
	}
}
