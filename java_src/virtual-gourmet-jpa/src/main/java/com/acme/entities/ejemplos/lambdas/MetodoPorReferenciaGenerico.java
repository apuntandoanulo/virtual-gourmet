package com.acme.entities.ejemplos.lambdas;

public class MetodoPorReferenciaGenerico {

	static <T> int misOpciones(MiInterfaceFuncional<T> f, T[] vals, T v) {
		return f.hacerAlgo(vals, v);
	}
	
	public static void main(String[] args) {
		Integer[] enteros = {1,4,5,8,7,4};
		String[] cadenas = {"Cadena1","Cadena4","Cadena3","Cadena1","Cadena1"};
		
		int conteo = misOpciones(OperacionesArray::<Integer>contarCoincidencias, enteros, 4);
		int conteo2 = misOpciones(OperacionesArray::<String>contarCoincidencias, cadenas, "Cadena1");
		
		System.out.println(conteo);
		System.out.println(conteo2);
	}
}
