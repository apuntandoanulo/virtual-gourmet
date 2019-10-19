package com.acme.entities;

public class Main {

	public static void main(String[] args) {
		Aditivo ig1 = new Aditivo();
		Ingrediente ig2 = new Carne();
		Ingrediente ig3 = new Vegetal();
		
		ig1.alistar("XX");
		ig2.alistar();
		ig3.alistar();
	}
}
