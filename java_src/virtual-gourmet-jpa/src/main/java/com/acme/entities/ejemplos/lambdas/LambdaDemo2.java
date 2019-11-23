package com.acme.entities.ejemplos.lambdas;

interface Numerictest {
	
	boolean hacerPrueba(int n);
}

public class LambdaDemo2 {

	public static void main(String[] args) {
		Numerictest esPar = (n) -> (n % 2) == 0;
		
		if(esPar.hacerPrueba(10)) {
			System.out.println("10 es par");
		}
		
		if(!esPar.hacerPrueba(9)) {
			System.out.println("9 es impar");
		}
		
		Numerictest isNonNeg = (n) -> n >= 0;
		
		if(isNonNeg.hacerPrueba(1)) {
			System.out.println("El 1 no es negativo");
		}
		
		if(!isNonNeg.hacerPrueba(-1)) {
			System.out.println("El -1 es negativo");
		}
	}
	
	
}
