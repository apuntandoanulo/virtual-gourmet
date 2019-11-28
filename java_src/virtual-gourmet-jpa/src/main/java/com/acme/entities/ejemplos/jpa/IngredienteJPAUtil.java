package com.acme.entities.ejemplos.jpa;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.acme.core.Ingrediente;

public class IngredienteJPAUtil {
	
	private EntityManager em;
	private EntityManagerFactory emFactory;
	
	public IngredienteJPAUtil(String unidadPersistencia) {
		emFactory = Persistence.createEntityManagerFactory(unidadPersistencia);
		
		System.out.println("Esquema BD conectado y actualizado");
	}
	
	public void abrirConexion() {
		em = emFactory.createEntityManager();
		
		System.out.println("EntityManager conectado a BD");
	}
	
	/**
	 * Inserta un nuevo registro en la tabla INGREDIENTE
	 * 
	 * @param ingrediente
	 * @throws SQLException
	 */
	public void insertar(Ingrediente ingrediente) {
		//Obtienendo e iniciando la transaccion
		em.getTransaction().begin();
		
		//Guardando el registro
		em.persist(ingrediente);
		
		//Confirmacion de los cambios en la transaccion
		em.getTransaction().commit();
	}
	
	/**
	 * Obtiene toda la lista de ingredientes ordena por nombre
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Ingrediente> obtenerListaIngredientes(String ordenadoPor) {
		//Obtienendo e iniciando la transaccion
		em.getTransaction().begin();
		
		try {
			return em.createQuery("FROM Ingrediente ORDER BY " + ordenadoPor, Ingrediente.class).getResultList();
		} finally {
			//Confirmacion de los cambios en la transaccion
			em.getTransaction().commit();
		}
	}
	
	/**
	 * Actualiza los ingredientes que cumplan con los filtros enviados
	 * 
	 * @param sqlSet
	 * @param filtros
	 * @return
	 * @throws SQLException
	 */
	public Ingrediente actualizarIngrediente(Ingrediente ingrediente) {
		//Obtienendo e iniciando la transaccion
		em.getTransaction().begin();
		
		try {
			//Guardando el registro
			return em.merge(ingrediente);
		} finally {
			//Confirmacion de los cambios en la transaccion
			em.getTransaction().commit();
		}
	}
	
	/**
	 * Elimina el ingrediente que coincide con el nombre
	 * 
	 * @param nombre
	 * @return
	 * @throws SQLException
	 */
	public void eliminarIngrediente(Ingrediente ingrediente) {
		//Obtienendo e iniciando la transaccion
		em.getTransaction().begin();
		
		//Guardando el registro
		em.remove(ingrediente);
		
		//Confirmacion de los cambios en la transaccion
		em.getTransaction().commit();
	}
	
	/**
	 * Cierra la conexion abierta a la BD
	 * 
	 */
	public void cerrarConexion() { 
		//Cerrando el entity manager
		em.close();
	}
}
