package com.acme.entities.ejemplos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsercionPostresql {

	public static void main(String[] args) throws SQLException {
		Connection conexion = null;
		PreparedStatement ps = null;
		
		String urlBD = "jdbc:postgresql://127.0.0.1:5432/curso_java_bd?currentSchema=public";
		String usuario = "curso_java";
		String password = "curso_java";
		
		try {
			conexion = DriverManager.getConnection(urlBD, usuario, password);
			
			System.out.println("Conectado a BD");
			
			ps = conexion.prepareStatement("INSERT INTO INGREDIENTE (nombre, cantidad, precio, tipo) VALUES ('Fresas', 8, 100, 'FRUTA');");
			ps.executeUpdate();
			
			System.out.println("Registro insertado correctamente");
		} finally {
			if(ps != null) {
				ps.close();
			}
			
			if(conexion != null) {
				conexion.close();
			}
			
			System.out.println("Desconectado de BD");
		}
	}
}
