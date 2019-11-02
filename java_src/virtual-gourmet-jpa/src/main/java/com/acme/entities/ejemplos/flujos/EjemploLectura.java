package com.acme.entities.ejemplos.flujos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjemploLectura {

	public static void main(String[] args) throws IOException {
		char c;
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
				
		String str;
		
		System.out.println("Escriba 'stop' para salir");
		
		do {
			str = bfr.readLine();
			System.out.println(str);
		} while (!str.equalsIgnoreCase("stop"));
	}
}
