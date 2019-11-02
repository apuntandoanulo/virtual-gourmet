package com.acme.entities.ejemplos;

import com.acme.core.Empleado;
import com.acme.core.ingredientes.Carne;

public class EjemploExcepciones {

	public static void main(String[] args) {
		metodo1();
	}
	
	private static void metodo1() {
		try {
			metodo2();
		} catch(ClassCastException ex) {
			System.out.println("Hubo un error casteando el objeto");
		} catch(ArithmeticException ex) {
			System.out.println("Hubo un error en el calculo: " + ex.getMessage());
		} catch(Exception ex) {
			System.out.println("Hubo un error desconocido");
		}
	}
	
	private static void metodo2() {
		Object i1 = new Carne("Pescado");
		
		System.out.println(54/0);
		
		Empleado e1 = (Empleado)i1;
	}
}
