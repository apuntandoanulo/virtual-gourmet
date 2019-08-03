package com.acme.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.acme.entities.Mesero;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path(value = "/ingredientes")
@Stateless
public class ServicioRest {

	private static final Logger logger = LogManager.getLogger(ServicioRest.class);
	
	@PersistenceContext(unitName = "virtual-gourmet-pu2")
	private EntityManager em2;
	
	@GET
	@Produces({"application/json"})
	public Response obtenerListaMeseros() {
		logger.debug("Ingresando al metodo obtenerListaMeseros");
		
		Query queryJPQL = em2.createQuery("SELECT ms FROM Mesero ms ORDER BY ms.nombre");
		
		List<Mesero> meseros = queryJPQL.getResultList();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		
		String json = gson.toJson(meseros);
		
		logger.info("Se encontraron {} registros", meseros.size());
		
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Consumes({"application/json"})
	public Response agregarMesero(String body) {
		logger.debug("Agregando nuevo mesero...");
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		
		Mesero nuevoMesero = gson.fromJson(body, Mesero.class);
		nuevoMesero.setId(null);
		nuevoMesero.setFechaCreacion(new Date());
		
		try {
			em2.persist(nuevoMesero);
			
			logger.debug("El nuevo mesero ha sido registrado");
			
			return Response.ok().build();
		} catch (Exception ex) {
			logger.error("Ha ocurrido un error: " + ex.getMessage());
			
			return Response.serverError().build();
		}
	}
}
