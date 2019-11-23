package com.acme.entities.ejemplos.lambdas;

public class SinLambdaDemo2 {

	public static void main(String[] args) {
		VerificarPar verPar = new VerificarPar();
		VerificarNoNegativo verNonNen = new VerificarNoNegativo();
		
		System.out.println(verPar.hacerPrueba(4));
		System.out.println(verPar.hacerPrueba(9));
		
		System.out.println(verNonNen.hacerPrueba(25));
		System.out.println(verNonNen.hacerPrueba(-50));
	}
}
