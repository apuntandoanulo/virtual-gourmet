package com.acme.entities.ejemplos;

public class EjemploString {

	public static void main(String[] args) {
		/*String s1 = new String("JAVA");
		String s2 = new String("Java");
		String s3 = new String("Java es;un excelente;lenguaje");
		
		String[] cadenas = s3.split(";");
		
		for(String s : cadenas) {
			System.out.println(s);
		}
		
		System.out.println("Encontre " + cadenas.length + " cadenas");*/
		
		StringBuilder s1 = new StringBuilder("  Java");
		s1.append(" es un ");
		s1.append(" excelente lenguaje ");
		s1.append(10 + " !!!    ");
		
		System.out.println("Excelente esta en la posicion: " + s1.indexOf("excelente"));
		
		System.out.println(s1);
		
		System.out.println(s1.reverse());
		
		System.out.println(s1.reverse());
		System.out.println(s1.toString().trim());
	}
}
