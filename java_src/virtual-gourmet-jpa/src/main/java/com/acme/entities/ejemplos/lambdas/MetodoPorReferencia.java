package com.acme.entities.ejemplos.lambdas;

interface FuncionCadena {
	
	String hacerAlgo(String cadena);
}

class MyClaseCadena {
	static String reversar(String cadena) {
		String resultado = "";
		
		for(int i=cadena.length()-1; i >= 0; i--) {
			resultado += cadena.charAt(i);
		}
		
		return resultado;
	}
}

public class MetodoPorReferencia {

	static String operarCadena(FuncionCadena funcion, String cadena) {
		return funcion.hacerAlgo(cadena);
	}
	
	public static void main(String[] args) {
		String cadena = "Lambdas agrega poder a Java!";
		String salida;
		
		salida = operarCadena(MyClaseCadena::reversar, cadena);
		
		System.out.println(salida);
		
	}
}
