package com.acme.entities.ejemplos.lambdas;

interface FuncionNumerica {

	int myFuncion(int xyz);
}

public class BlockLambdaDemo2{
	public static void main(String[] args) {
		FuncionNumerica factorial = (numero) -> {
			int result = 1;
			
			for(int i = 1; i <= numero; i++) {
				result *= i;
			}
			
			return result;
		};
		
		System.out.println("El factorial de 3 es " + factorial.myFuncion(3));
		System.out.println("El factorial de 5 es " + factorial.myFuncion(5));
		System.out.println("El factorial de 8 es " + factorial.myFuncion(8));
	}
}

