package com.acme.entities.ejemplos.lambdas;

public class VerificarPar implements TestearNumero {

	@Override
	public boolean hacerPrueba(Integer numero) {
		return numero % 2 == 0;
	}

}
