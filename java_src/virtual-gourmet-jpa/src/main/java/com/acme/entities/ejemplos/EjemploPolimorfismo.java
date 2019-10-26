package com.acme.entities.ejemplos;

import com.acme.core.ElementoPreparacion;
import com.acme.core.elementosCocina.Recipiente;
import com.acme.core.ingredientes.Carne;
import com.acme.core.ingredientes.Condimento;
import com.acme.core.ingredientes.Fruta;
import com.acme.core.ingredientes.Grano;
import com.acme.core.ingredientes.Vegetal;

public class EjemploPolimorfismo {
			
	public static void main(String[] args) {
		ElementoPreparacion[] listaElementos = new ElementoPreparacion[10];
		
		listaElementos[0] = new Condimento("Sal"); 
		listaElementos[1] = new Carne("Cerdo");
		listaElementos[2] = new Carne("Pollo");
		listaElementos[3] = new Vegetal("Brocoli");
		listaElementos[4] = new Vegetal("Apio");
		listaElementos[5] = new Grano("Arroz");
		listaElementos[6] = new Grano("Lenteja");
		listaElementos[7] = new Recipiente("Caldero");
		listaElementos[8] = new Fruta("Pera");
		listaElementos[9] = new ElementoPreparacion() {

			public void alistar() {
				System.out.println("Mi ingrediente desconocido...");
			}
			
		};
		
		// Usando un for-each para 'alistar' todos los elementos
		for(ElementoPreparacion ep : listaElementos) {
			if(ep != null) {
				System.out.println(ep);
			}
		}
	}
}
