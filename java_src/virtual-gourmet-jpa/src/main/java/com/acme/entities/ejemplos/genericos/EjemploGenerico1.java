package com.acme.entities.ejemplos.genericos;

public class EjemploGenerico1 {

	public static void main(String[] args) {
		MiClaseGenerica1<Integer> genEntero = new MiClaseGenerica1<Integer>(50);
		
		System.out.println(genEntero.getMiobjeto());
		System.out.println(genEntero.obtenerNombreClase());
		
		MiClaseGenerica1<String> genCadena = new MiClaseGenerica1<String>("Uniremington");
		
		System.out.println(genCadena.getMiobjeto());
		System.out.println(genCadena.obtenerNombreClase());
	}
}
