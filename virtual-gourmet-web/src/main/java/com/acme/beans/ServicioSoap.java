package com.acme.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.acme.entities.Mesero;

@WebService(serviceName = "virtual-gourmet-soap", targetNamespace = "http//com.acme.virtual-gourmet")
@Stateless
public class ServicioSoap {

	@PersistenceContext(unitName = "virtual-gourmet-pu2")
	private EntityManager em2;
	
	@WebMethod(operationName = "listaMeseros")
	@WebResult(name = "mesero")
	public List<Mesero> obtenerListaMeseros() {
		Query queryJPQL = em2.createQuery("SELECT ms FROM Mesero ms ORDER BY ms.nombre");
		
		return queryJPQL.getResultList();
	}
}
