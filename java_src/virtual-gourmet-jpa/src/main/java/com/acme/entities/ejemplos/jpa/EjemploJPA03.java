package com.acme.entities.ejemplos.jpa;

import com.acme.core.Ingrediente;
import com.acme.core.ingredientes.Fruta;

public class EjemploJPA03 {

	public static void main(String[] args) {
		IngredienteJPAUtil jpaUtilPostresql = new IngredienteJPAUtil("VirtualGourmet");
		jpaUtilPostresql.abrirConexion();
		
		IngredienteJPAUtil jpaUtilSQLServer = new IngredienteJPAUtil("VirtualGourmet2");
		jpaUtilSQLServer.abrirConexion();
		
		//Se crea un nuevo objeto tipo FRUTA
		Fruta fr1 = new Fruta("Mora", 500, 20.0);
		Fruta fr2 = new Fruta("Mora", 500, 20.0);
				
		//Se inserta una nueva fruta
		jpaUtilPostresql.insertar(fr1);
		jpaUtilSQLServer.insertar(fr2);
		
		mostrarIngredientes(jpaUtilPostresql);
		
		System.out.println();
		
		//Se duplica el precio de la mora
		fr1.setCosto(fr1.getCosto() * 2);
		
		jpaUtilPostresql.actualizarIngrediente(fr1);
		
		mostrarIngredientes(jpaUtilPostresql);
		
		System.out.println();
				
		//Se elimina la fruta con nombre mora
		jpaUtilPostresql.eliminarIngrediente(fr1);
		
		jpaUtilPostresql.cerrarConexion();
		jpaUtilSQLServer.cerrarConexion();
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
