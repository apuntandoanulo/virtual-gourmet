package com.acme.entities;

public class Receta {
	String nombre;
	String pasos;
	
	public static void main(String[] args) {
		int i, j;
		String s1 = "Hola";
		
		switch (s1) {
		case "Hola":
			
			for(i=0; i < 10; i++) {
				for(j=i; j < 10; j++) { 
					if(i == 5) {
						break;
					}
					
					System.out.print(".");
				}
				
				System.out.println();	
				
			}
			
			break;

		default:
			break;
		}
		
		
			
	}
}
