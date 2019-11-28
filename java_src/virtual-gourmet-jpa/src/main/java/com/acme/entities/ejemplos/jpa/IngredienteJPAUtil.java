package com.acme.entities.ejemplos.jpa;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.acme.core.Ingrediente;

public class IngredienteJPAUtil {
	
	private EntityManager em;
	private EntityManagerFactory emFactory;
	private String unidadPersistencia;
	
    private static final Logger logger = LogManager.getLogger(IngredienteJPAUtil.class);
	
	public IngredienteJPAUtil(String unidadPersistencia) {
		this.unidadPersistencia = unidadPersistencia;
		
		emFactory = Persistence.createEntityManagerFactory(unidadPersistencia);
		
		logger.info("Esquema BD conectado y actualizado: {}", unidadPersistencia);
	}
	
	public void abrirConexion() {
		em = emFactory.createEntityManager();
		
		logger.info("EntityManager conectado a BD: " +  unidadPersistencia);
	}
	
	/**
	 * Inserta un nuevo registro en la tabla INGREDIENTE
	 * 
	 * @param ingrediente
	 * @throws SQLException
	 */
	public void insertar(Ingrediente ingrediente) {
		logger.debug("Iniciando la insercion...");
		
		//Obtienendo e iniciando la transaccion
		em.getTransaction().begin();
		
		//Guardando el registro
		em.persist(ingrediente);
		
		//Confirmacion de los cambios en la transaccion
		em.getTransaction().commit();
		
		logger.debug("Insercion confirmada: ID = {}", ingrediente.getId());
	}
	
	/**
	 * Obtiene toda la lista de ingredientes ordena por nombre
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Ingrediente> obtenerListaIngredientes(String ordenadoPor) {
		logger.debug("Iniciando la consulta de ingredientes...");
		
		//Obtienendo e iniciando la transaccion
		em.getTransaction().begin();
		
		try {
			return em.createQuery("FROM Ingrediente ORDER BY " + ordenadoPor, Ingrediente.class).getResultList();
		} finally {
			//Confirmacion de los cambios en la transaccion
			em.getTransaction().commit();
			
			logger.debug("Consulta de ingredientes efectuada correctamente...");
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
		logger.debug("Iniciando la actualizacion del ingrediente con nombre = {}", ingrediente.getNombre());
		
		//Obtienendo e iniciando la transaccion
		em.getTransaction().begin();
		
		try {
			//Guardando el registro
			return em.merge(ingrediente);
		} finally {
			//Confirmacion de los cambios en la transaccion
			em.getTransaction().commit();
			
			logger.debug("Actualizacion confirmada para el ingrediente con nombre = {}", ingrediente.getNombre());
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
		logger.debug("Iniciando la eliminacion del ingrediente con nombre = {}", ingrediente.getNombre());
		
		//Obtienendo e iniciando la transaccion
		em.getTransaction().begin();
		
		//Guardando el registro
		em.remove(ingrediente);
		
		//Confirmacion de los cambios en la transaccion
		em.getTransaction().commit();
		
		logger.debug("Eliminacion del ingrediente confirmada");
	}
	
	/**
	 * Cierra la conexion abierta a la BD
	 * 
	 */
	public void cerrarConexion() { 
		//Cerrando el entity manager
		em.close();
		
		logger.info("EntityManager desconectado de BD: " +  unidadPersistencia);
	}
}
