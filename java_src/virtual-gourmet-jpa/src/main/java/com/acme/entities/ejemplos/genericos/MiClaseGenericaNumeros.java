package com.acme.entities.ejemplos.genericos;

public class MiClaseGenericaNumeros<U extends Number> {

	U[] arregloNumeros;
	
	public MiClaseGenericaNumeros(U[] arregloNumeros) {
		this.arregloNumeros = arregloNumeros;
	}
	
	public Double calcularPromedio() {
		Double suma = 0D;
		
		for(int i=0; i<arregloNumeros.length; i++) {
			suma += arregloNumeros[i].doubleValue();
		}
		
		return suma / arregloNumeros.length;
	}
}
