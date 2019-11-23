package com.acme.entities.ejemplos.lambdas;

public class VerificarNoNegativo implements TestearNumero {

	@Override
	public boolean hacerPrueba(Integer numero) {
		return numero >= 0;
	}

}
