package com.acme.entities.ejemplos.jpa;

import com.acme.core.Ingrediente;
import com.acme.core.ingredientes.Fruta;

public class EjemploJPA02 {

	public static void main(String[] args) {
		IngredienteJPAUtil jpaUtil = new IngredienteJPAUtil("VirtualGourmet");
		jpaUtil.abrirConexion();
		
		//Se crea un nuevo objeto tipo FRUTA
		Fruta fr = new Fruta("Mora");
		fr.setStock(500);
		fr.setCosto(20.0);
		
		//Se inserta una nueva fruta
		jpaUtil.insertar(fr);
				
		mostrarIngredientes(jpaUtil);
		
		System.out.println();
		
		//Se duplica el precio de la mora
		fr.setCosto(fr.getCosto() * 2);
		
		jpaUtil.actualizarIngrediente(fr);
		
		mostrarIngredientes(jpaUtil);
		
		System.out.println();
				
		//Se elimina la fruta con nombre mora
		jpaUtil.eliminarIngrediente(fr);
		
		jpaUtil.cerrarConexion();
	}
	
	private static void mostrarIngredientes(IngredienteJPAUtil jdbcUtil) {
		System.out.println("----------------------------");
		
		for(Ingrediente ing : jdbcUtil.obtenerListaIngredientes("nombre")) {
			System.out.print(ing.getTipo());
			System.out.print("\t" + ing.getNombre());
			System.out.print("\t Cantidad: " + ing.getStock());
			System.out.println("\t Precio: " + ing.getCosto());
		}
		
		System.out.println("----------------------------");
	}
}
