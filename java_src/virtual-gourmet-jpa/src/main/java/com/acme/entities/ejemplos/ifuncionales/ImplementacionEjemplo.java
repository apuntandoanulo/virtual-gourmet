package com.acme.entities.ejemplos.ifuncionales;

public class ImplementacionEjemplo implements Ejemplo01 {

	public static void main(String[] args) {
		ImplementacionEjemplo ie = new ImplementacionEjemplo();
		ie.imprimir("XXX");
		
		//System.out.println(Ejemplo01.imprimir(2, 8));
	}
}
