package com.acme.entities.ejemplos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import com.acme.core.Ingrediente;
import com.acme.core.ingredientes.Carne;
import com.acme.core.ingredientes.Condimento;
import com.acme.core.ingredientes.Grano;
import com.acme.core.ingredientes.Vegetal;

public class EjemploColecciones {

	public static void main(String[] args) {
		mostrarEjemploLista();
		//mostrarEjemploMapa();
		//mostrarEjemploMapa();
	}
	
	private static void mostrarEjemploConjunto() {
		HashSet<Ingrediente> mapaElementos = new HashSet<Ingrediente>();
		
		mapaElementos.add(new Condimento("Sal"));
		mapaElementos.add(new Carne("Pollo"));
		mapaElementos.add(new Carne("Pollo"));
		mapaElementos.add(new Vegetal("Brocoli"));
		mapaElementos.add(new Grano("Arroz"));
		
		for(Ingrediente ingrediente : mapaElementos) {
			System.out.println(ingrediente.getNombre());
		}
	}
	
	private static void mostrarEjemploLista() {
		ArrayList<Ingrediente> listaElementos = new ArrayList<Ingrediente>(); 
		listaElementos.add(new Condimento("Sal"));
		listaElementos.add(new Carne("Pollo"));
		listaElementos.add(new Carne("Pollo"));
		listaElementos.add(new Vegetal("Brocoli"));
		listaElementos.add(new Grano("Arroz"));
		
		Iterator<Ingrediente> iteradorIngredientes = listaElementos.iterator();
		
		while(iteradorIngredientes.hasNext()) {
			Ingrediente ig = iteradorIngredientes.next();
			
			if(ig.getNombre().contains("Pollo")) {
				iteradorIngredientes.remove();
			}
		}
		
		iteradorIngredientes = listaElementos.iterator();
		
		while(iteradorIngredientes.hasNext()) {
			Ingrediente ig = iteradorIngredientes.next();
			
			System.out.println(ig.getNombre());
		}
		
		/*
		boolean contiene = listaElementos.contains(new Vegetal("BROColi"));
		
		System.out.println((contiene ? "SI" : "NO") + " lo contiene");
		*/
		/*
		for(int i = 0; i < listaElementos.size(); i++) {
			Ingrediente ingrediente = listaElementos.get(i);
			
		}*/
		/*
		for(Ingrediente ingrediente : listaElementos) {
			//System.out.println(ingrediente.getNombre());
			if(ingrediente.getNombre().equalsIgnoreCase("Pollo")) {
				System.out.println(ingrediente.toString());
			}
		}*/
		
		/*
		 * Error de eliminacion dentro del ciclo
		int longitud = listaElementos.size();
		
		for(int i = 0; i < longitud; i++) {
			Ingrediente ingrediente = listaElementos.get(i);
			
			if(ingrediente.getNombre().contains("Pollo")) {
				listaElementos.remove(i);
			}
			
			System.out.println(listaElementos.size());
			
		}*/
	}
	
	private static void mostrarEjemploMapa() {
		HashMap<String, Ingrediente> mapaIngredientes = new HashMap<String, Ingrediente>();
		mapaIngredientes.put("Sal", new Condimento("Sal"));
		mapaIngredientes.put("Pollo", new Carne("Pollo"));
		mapaIngredientes.put("Pollo", new Carne("Pollo"));
		mapaIngredientes.put("Brocoli", new Vegetal("Brocoli"));
		mapaIngredientes.put("Arroz", new Grano("Arroz"));
		/*
		for(Entry<String, Ingrediente> ingrediente : mapaIngredientes.entrySet()) {
			System.out.println(ingrediente.getKey() + " - " + ingrediente.getValue().getNombre());
		}*/
		
		//System.out.println(mapaIngredientes.get("CUATRO").getNombre());
		
		System.out.println(mapaIngredientes.containsKey("Pollo"));
		System.out.println(mapaIngredientes.containsKey("Cerdo"));
	}
}
