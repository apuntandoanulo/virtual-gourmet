package com.acme.core.tallerEmpleado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Clase utilitaria para el manejo de las operaciones de bases de datos con JDBC
 * 
 * @author Jairo Henao
 *
 */
public class EmpleadoJDBCUtil {

	private String urlBD;
	private String usuario;
	private String password;
	
	private Connection conexion;
	
	private static final String NOMBRE_TABLA = "EMPLEADO";
	
	public EmpleadoJDBCUtil(String urlBD, String usuario, String password) {
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
	 * Inserta un nuevo registro en la tabla EMPLEADO
	 * 
	 * @param empleado
	 * @throws SQLException
	 */
	public void insertar(Empleado empleado) throws SQLException {
		try(PreparedStatement ps = conexion.prepareStatement("INSERT INTO " + NOMBRE_TABLA +" (cedula, nombres, apellidos, genero, fecha_nacimiento, fecha_ingreso, salario, estado_civil, numero_hijos) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
			//Estableciendo los parametros
			//cedula, nombres, apellidos, genero, fecha_nacimiento, fecha_ingreso, salario, estado_civil, numero_hijos
			ps.setLong(1, empleado.getCedula());
			ps.setString(2, empleado.getNombres());
			ps.setString(3, empleado.getApellidos());
			ps.setString(4, empleado.getGenero().name());
			ps.setDate(5, new java.sql.Date(empleado.getFechaNacimiento().getTime()));
			ps.setDate(6, new java.sql.Date(empleado.getFechaIngreso().getTime()));
			ps.setDouble(7, empleado.getSalario());
			ps.setString(8, empleado.getEstadoCivil().name());
			ps.setInt(9, empleado.getNumeroHijos());
						
			//Ejecutando la sentencia
			ps.executeUpdate();
			
			System.out.println("Registro insertado correctamente");	
		}
	}
	
	/**
	 * Obtiene toda la lista de empleados ordena por nombre
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Empleado> obtenerListaEmpleados(String ordenadoPor) throws SQLException {
		List<Empleado> resultado = new ArrayList<Empleado>();
		
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery("SELECT cedula, nombres, apellidos, genero, fecha_nacimiento, fecha_ingreso, salario, estado_civil, numero_hijos FROM " + NOMBRE_TABLA + " ORDER BY " + ordenadoPor);
		
		while(rs.next()) {
			Empleado emp = new Empleado();
			
			emp.setCedula(rs.getLong("cedula"));
			emp.setNombres(rs.getString("nombres"));
			emp.setApellidos(rs.getString("apellidos"));
			emp.setGenero(EnumGenero.valueOf(rs.getString("genero")));
			emp.setFechaNacimiento(rs.getDate("fecha_nacimiento"));	
			emp.setFechaIngreso(rs.getDate("fecha_ingreso"));
			emp.setSalario(rs.getDouble("salario"));
			emp.setEstadoCivil(EnumEstadoCivil.valueOf(rs.getString("estado_civil")));
			emp.setNumeroHijos(rs.getInt("numero_hijos"));
						
			resultado.add(emp);
		}
		
		return resultado;
	}
	
	/**
	 * Actualiza los empleados que cumplan con los filtros enviados
	 * 
	 * @param sqlSet
	 * @param filtros
	 * @return
	 * @throws SQLException
	 */
	public void actualizarEmpleados(String sqlSet, String filtros) throws SQLException {
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
	public void eliminarEmpleado(Long cedula) throws SQLException {
		StringBuilder sqlUpdate = new StringBuilder("DELETE FROM " + NOMBRE_TABLA + " WHERE cedula = ?");
		
		try(PreparedStatement ps = conexion.prepareStatement(sqlUpdate.toString())) {
			ps.setLong(1, cedula);
			
			//Ejecutando la sentencia
			Integer eliminados = ps.executeUpdate();
			
			System.out.println("Se eliminaron " + eliminados + " registros con cedula " + cedula);
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
