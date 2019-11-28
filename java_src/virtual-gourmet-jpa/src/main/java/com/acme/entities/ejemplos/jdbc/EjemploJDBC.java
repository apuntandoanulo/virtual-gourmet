package com.acme.entities.ejemplos.jdbc;

import java.sql.SQLException;

import com.acme.core.Ingrediente;
import com.acme.core.ingredientes.Fruta;

public class EjemploJDBC {

	public static void main(String[] args) throws SQLException {
		String urlBD = "jdbc:postgresql://127.0.0.1:5432/curso_java_bd?currentSchema=public";
		String usuario = "curso_java";
		String password = "curso_java";
		
		IngredienteJDBCUtil jdbcUtil = new IngredienteJDBCUtil(urlBD, usuario, password);
		jdbcUtil.conectar();
		
		//Se crea un nuevo objeto tipo FRUTA
		Fruta fr = new Fruta("Mora");
		fr.setStock(500);
		fr.setCosto(20.0);
		
		//Se inserta una nueva fruta
		jdbcUtil.insertar(fr);
				
		mostrarIngredientes(jdbcUtil);
		
		System.out.println();
		
		//Se duplica el precio de todos
		jdbcUtil.actualizarIngredientes("precio = precio * 2", "tipo = 'FRUTA'");
		
		mostrarIngredientes(jdbcUtil);
		
		System.out.println();
				
		//Se elimina la fruta con nombre mora
		jdbcUtil.eliminarIngrediente("Mora");
		
		jdbcUtil.desconectar();
	}
	
	private static void mostrarIngredientes(IngredienteJDBCUtil jdbcUtil) throws SQLException {
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
