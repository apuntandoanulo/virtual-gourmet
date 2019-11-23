package com.acme.entities.ejemplos.lambdas;

interface MiInterfaceFuncional<T> {
	int hacerAlgo(T[] arreglo, T valor);
}

public class OperacionesArray {
	static <T> int contarCoincidencias(T[] arreglo, T valor) {
		int conteo = 0;
		
		for(int i=0; i<arreglo.length; i++) {
			if(arreglo[i] == valor) {
				conteo++;
			}
		}
		
		return conteo;
	}
}
