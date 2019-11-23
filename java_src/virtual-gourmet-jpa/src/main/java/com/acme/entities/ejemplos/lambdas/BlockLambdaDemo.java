package com.acme.entities.ejemplos.lambdas;

import java.util.function.Function;

public class BlockLambdaDemo{
	public static void main(String[] args) {
		Function<Integer, Integer> factorial  = (numero) -> {
			int result = 1;
			
			for(int i = 1; i <= numero; i++) {
				result *= i;
			}
			
			return result;
		};
		
		System.out.println("El factorial de 3 es " + factorial.apply(3));
		System.out.println("El factorial de 5 es " + factorial.apply(5));
		System.out.println("El factorial de 8 es " + factorial.apply(8));
	}
}

