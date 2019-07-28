package com.acme.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.acme.entities.Mesero;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path(value = "/ingredientes")
@Stateless
public class ServicioRest {

	@PersistenceContext(unitName = "virtual-gourmet-pu2")
	private EntityManager em2;
	
	@GET
	@Produces({"application/json"})
	public Response obtenerListaMeseros() {
		Query queryJPQL = em2.createQuery("SELECT ms FROM Mesero ms ORDER BY ms.nombre");
		
		List<Mesero> meseros = queryJPQL.getResultList();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		
		String json = gson.toJson(meseros);
		
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}
}