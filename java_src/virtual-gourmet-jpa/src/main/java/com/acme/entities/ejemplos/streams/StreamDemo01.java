package com.acme.entities.ejemplos.streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamDemo01 {

	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(5);
		lista.add(7);
		lista.add(8);
		lista.add(62);
		lista.add(12);
		lista.add(2);
		lista.add(25);
		
		/*Integer menor = lista.get(0);
		
		for(Integer numero : lista) {
			if(numero < menor) {
				menor = numero;
			}
		}
		
		System.out.println(menor);
		*/
		
		System.out.println(lista.stream().min(Integer::compareTo).get());
	}
}
