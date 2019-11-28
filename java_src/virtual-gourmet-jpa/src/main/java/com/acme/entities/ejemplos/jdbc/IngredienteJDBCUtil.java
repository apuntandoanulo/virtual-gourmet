package com.acme.entities.ejemplos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.acme.core.EnumIngrediente;
import com.acme.core.Ingrediente;
import com.acme.core.ingredientes.Carne;
import com.acme.core.ingredientes.Condimento;
import com.acme.core.ingredientes.Fruta;
import com.acme.core.ingredientes.Grano;
import com.acme.core.ingredientes.Vegetal;

/**
 * Clase utilitaria para el manejo de las operaciones de bases de datos con JDBC
 * 
 * @author Jairo Henao
 *
 */
public class IngredienteJDBCUtil {

	private String urlBD;
	private String usuario;
	private String password;
	
	private Connection conexion;
	
	private static final String NOMBRE_TABLA = "INGREDIENTE";
	
	public IngredienteJDBCUtil(String urlBD, String usuario, String password) {
		this.urlBD = urlBD;
		this.usuario = usuario;
		this.password = password;
	}
	
	/**
	 * Establece la conexion a la BD
	 * 
	 * @throws SQLException
	 */
	public void conectar() throws SQLException {
		conexion = DriverManager.getConnection(urlBD, usuario, password);
		
		System.out.println("Conectado a BD");
	}
	
	/**
	 * Inserta un nuevo registro en la tabla INGREDIENTE
	 * 
	 * @param ingrediente
	 * @throws SQLException
	 */
	public void insertar(Ingrediente ingrediente) throws SQLException {
		try(PreparedStatement ps = conexion.prepareStatement("INSERT INTO " + NOMBRE_TABLA +" (nombre, cantidad, precio, tipo) VALUES (?, ?, ?, ?)")) {
			//Estableciendo los parametros
			ps.setString(1, ingrediente.getNombre());
			ps.setInt(2, ingrediente.getStock());
			ps.setDouble(3, ingrediente.getCosto());
			ps.setString(4, ingrediente.getTipo().name());
			
			//Ejecutando la sentencia
			ps.executeUpdate();
			
			System.out.println("Registro insertado correctamente");	
		}
	}
	
	/**
	 * Obtiene toda la lista de ingredientes ordena por nombre
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Ingrediente> obtenerListaIngredientes(String ordenadoPor) throws SQLException {
		List<Ingrediente> resultado = new ArrayList<Ingrediente>();
		
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery("SELECT nombre, cantidad, precio, tipo FROM " + NOMBRE_TABLA + " ORDER BY " + ordenadoPor);
		
		while(rs.next()) {
			EnumIngrediente tipo = EnumIngrediente.valueOf(rs.getString("tipo"));
			
			Ingrediente ing = null;
			
			//Se crea la instancia dependiendo el tipo
			switch (tipo) {
				case FRUTA :
					ing = new Fruta(rs.getString("nombre"));
					
					break;
					
				case GRANO :
					ing = new Grano(rs.getString("nombre"));
					
					break;
				
				case PROTEINA :
					ing = new Carne(rs.getString("nombre"));
					
					break;
				
				case CONDIMENTO :
					ing = new Condimento(rs.getString("nombre"));
					
					break;
					
				case VEGETAL :
					ing = new Vegetal(rs.getString("nombre"));
					
					break;
					
				case DESCONOCIDO :
					//Nada por hacer
					
					break;
			}
			
			if(ing != null) {
				ing.setStock(rs.getInt("cantidad"));
				ing.setCosto(rs.getDouble("precio"));
				ing.setTipo(tipo);
				
				resultado.add(ing);
			}
		}
		
		return resultado;
	}
	
	/**
	 * Actualiza los ingredientes que cumplan con los filtros enviados
	 * 
	 * @param sqlSet
	 * @param filtros
	 * @return
	 * @throws SQLException
	 */
	public void actualizarIngredientes(String sqlSet, String filtros) throws SQLException {
		StringBuilder sqlUpdate = new StringBuilder("UPDATE " + NOMBRE_TABLA + " SET ");
		sqlUpdate.append(sqlSet);
	
		//Verificando que los filtros no esten vacios
		if(!StringUtils.isBlank(filtros)) {
			sqlUpdate.append(" WHERE ");
			sqlUpdate.append(filtros);
		}
		
		try(PreparedStatement ps = conexion.prepareStatement(sqlUpdate.toString())) {
			//Ejecutando la sentencia
			Integer actualizados = ps.executeUpdate();
			
			System.out.println("Se han actualizado " + actualizados + " ingredientes");
		}
	}
	
	/**
	 * Elimina el ingrediente que coincide con el nombre
	 * 
	 * @param nombre
	 * @return
	 * @throws SQLException
	 */
	public void eliminarIngrediente(String nombre) throws SQLException {
		StringBuilder sqlUpdate = new StringBuilder("DELETE FROM " + NOMBRE_TABLA + " WHERE nombre = ?");
		
		try(PreparedStatement ps = conexion.prepareStatement(sqlUpdate.toString())) {
			ps.setString(1, nombre);
			
			//Ejecutando la sentencia
			Integer eliminados = ps.executeUpdate();
			
			System.out.println("Se eliminaron " + eliminados + " registros con nombre " + nombre);
		}
	}
	
	/**
	 * Cierra la conexion abierta a la BD
	 * 
	 * @throws SQLException
	 */
	public void desconectar() throws SQLException {
		if(conexion != null) {
			conexion.close();
		}
		
		System.out.println("Desconectado de BD");
	}
}
