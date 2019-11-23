package com.acme.entities.ejemplos.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsercionPostresql {

	public static void main(String[] args) throws SQLException {
		Connection conexion = null;
		PreparedStatement ps = null;
		
		String urlBD = "jdbc:postgresql://127.0.0.1:5432/curso_java_bd?searchpath=public";
		String usuario = "curso_java";
		String password = "curso_java";
		
		try {
			conexion = DriverManager.getConnection(urlBD, usuario, password);
			
			System.out.println("Conectado OK!");
			
			ps = conexion.prepareStatement("INSERT INTO INGREDIENTE (nombre, cantidad, precio) VALUES ('Fresas', 8, 100);");
			ps.executeUpdate();
			
			System.out.println("Guardado OK");
		} finally {
			if(ps != null) {
				ps.close();
			}
		}
	}
}
