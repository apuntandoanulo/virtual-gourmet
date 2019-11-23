package com.acme.entities.ejemplos.basedatos;

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
		
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery("SELECT nombre, cantidad, precio FROM INGREDIENTE ");
		
		while(rs.next()) {
			System.out.println(rs.getString("nombre") + " - " + rs.getInt("cantidad") );
		}
		
	}
}
