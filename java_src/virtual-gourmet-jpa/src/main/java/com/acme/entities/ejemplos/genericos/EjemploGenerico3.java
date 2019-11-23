package com.acme.entities.ejemplos.genericos;

public class EjemploGenerico3 {

	public static void main(String[] args) {
		MiClaseGenericaNumeros<Integer> miGen = new MiClaseGenericaNumeros<Integer>(new Integer[]{1,2,3,4,5});
		
		System.out.println(miGen.calcularPromedio());
	}
}
