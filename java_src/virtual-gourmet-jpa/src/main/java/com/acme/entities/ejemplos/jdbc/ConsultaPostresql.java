package com.acme.entities.ejemplos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaPostresql {

	public static void main(String[] args) throws SQLException {
		Connection conexion = null;
				
		String urlBD = "jdbc:postgresql://127.0.0.1:5432/curso_java_bd?currentSchema=public";
		String usuario = "curso_java";
		String password = "curso_java";
		
		conexion = DriverManager.getConnection(urlBD, usuario, password);
		
		System.out.println("Conectado a BD");
		
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery("SELECT nombre, cantidad, precio FROM INGREDIENTE ");
		
		int numeroRegistros = 0;
		
		while(rs.next()) {
			System.out.println(rs.getString("nombre") + " - " + rs.getInt("cantidad") );
			
			numeroRegistros++;
		}
		
		System.out.println("Se han encontrado " + numeroRegistros + " registros");
				
		conexion.close();
		
		System.out.println("Desconectado de BD");
	}
}
