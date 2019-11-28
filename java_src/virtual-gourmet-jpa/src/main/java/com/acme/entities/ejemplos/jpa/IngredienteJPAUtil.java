package com.acme.entities.ejemplos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.acme.core.Ingrediente;
import com.acme.core.ingredientes.Fruta;
import com.acme.core.ingredientes.Vegetal;

public class IngredienteJPAUtil {
	
	public static void main(String[] args) {
		// Create an EntityManager
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("VirtualGourmet");
        EntityManager em = emFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
         
        // Begin the transaction
        transaction.begin();

        // Create a new Student object
        Fruta fr = new Fruta("Banano");
		fr.setId(1001L);
        fr.setStock(500);
		fr.setCosto(20.0);

        // Save the student object
        em.persist(fr);

        Vegetal vg = new Vegetal("Brocoli");
        vg.setId(1002L);
        vg.setStock(10);
        vg.setCosto(50.0);
        
        em.persist(vg);
        
        List<Ingrediente> ingredientes = em.createQuery("FROM Ingrediente", Ingrediente.class).getResultList();
        
        for(Ingrediente ing : ingredientes) {
        	System.out.print(ing.getTipo());
			System.out.print("\t" + ing.getNombre());
			System.out.print("\t Cantidad: " + ing.getStock());
			System.out.println("\t Precio: " + ing.getCosto());
        }
        
        // Commit the transaction
        transaction.commit();
        
        em.close();
	}
}
