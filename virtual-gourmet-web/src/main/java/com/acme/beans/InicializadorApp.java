package com.acme.beans;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.acme.entities.Ingrediente;
import com.acme.entities.Mesero;

@Singleton
@Startup
public class InicializadorApp {

	@PersistenceContext(unitName = "virtual-gourmet-pu")
	private EntityManager em;
	
	@PersistenceContext(unitName = "virtual-gourmet-pu2")
	private EntityManager em2;
	
	//@PostConstruct
	public void init() {
		System.out.println("INICIANDO TRANSACCION");
		
		Ingrediente ig1 = new Ingrediente();
		ig1.setName("Sal");
		ig1.setDescripcion("Para sazonar");
		
		Ingrediente ig2 = new Ingrediente();
		ig2.setName("Azucar");
		ig2.setDescripcion("Para endulzar");
		
		Mesero ms1 = new Mesero();
		ms1.setNombre("Mesero01");
		ms1.setFechaCreacion(new Date());
		
		Mesero ms2 = new Mesero();
		ms2.setNombre("Mesero02");
		ms2.setFechaCreacion(new Date());
		
		Mesero ms3 = new Mesero();
		ms3.setNombre("Mesero03");
		ms3.setFechaCreacion(new Date());
		
		em.persist(ig1);
		em2.persist(ig2);
		em.persist(ms1);
		em2.persist(ms2);
		em2.persist(ms3);
	}
}
