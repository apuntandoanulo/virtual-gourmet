package com.acme.entities.ejemplos;

import com.acme.core.ingredientes.Carne;

public class EjemploMetodosObject {

	public static void main(String[] args) {
		Carne ep1 = new Carne("Pollo");
		ep1.setStock(10);
		
		Carne ep2 = new Carne("POLLO");
		ep2.setStock(10);
		
		System.out.println(ep1.equals(ep2));
	}

}
