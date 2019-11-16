package com.acme.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.acme.core.ingredientes.Carne;
import com.acme.core.ingredientes.Fruta;
import com.acme.core.ingredientes.Vegetal;
import com.acme.entities.ejemplos.flujos.UtilitarioJSON;

@XmlRootElement(name = "inventario")
@XmlAccessorType(XmlAccessType.FIELD)
public class InventarioIngredientes {

	@XmlElement(name = "carne", required = true)
	private ArrayList<Carne> listaCarnes;
	
	@XmlElement(name = "vegetal", required = true)
	private ArrayList<Vegetal> listaVegetales;
	
	@XmlElement(name = "fruta", required = true)
	private ArrayList<Fruta> listaFrutas;
	
	public InventarioIngredientes() {
		listaCarnes = new ArrayList<Carne>();
		listaVegetales = new ArrayList<Vegetal>();
		listaFrutas = new ArrayList<Fruta>();
	}
	
	public void agregarCarne(Carne carne) {
		this.listaCarnes.add(carne);
	}
	
	public void agregarIngrediente(Ingrediente ing) {
		//if(EnumIngrediente.PROTEINA.equals(ing.getTipo())) {
		
		if(ing instanceof Carne) {
			listaCarnes.add((Carne) ing);
		} else if(EnumIngrediente.FRUTA.equals(ing.getTipo())) {
			listaFrutas.add((Fruta) ing);
		} else if(ing instanceof Vegetal) {
			listaVegetales.add((Vegetal) ing);
		}
	}
	
	public Integer obtenerCantidadElementos() {
		return listaCarnes.size() + listaFrutas.size() + listaVegetales.size();
	}
	
	public InventarioIngredientes(ArrayList<Carne> listaCarnes) {
		this.listaCarnes = listaCarnes;
	}

	public ArrayList<Carne> getListaCarnes() {
		return listaCarnes;
	}

	public void setListaCarnes(ArrayList<Carne> listaCarnes) {
		this.listaCarnes = listaCarnes;
	}

	public ArrayList<Vegetal> getListaVegetales() {
		return listaVegetales;
	}

	public void setListaVegetales(ArrayList<Vegetal> listaVegetales) {
		this.listaVegetales = listaVegetales;
	}

	public ArrayList<Fruta> getListaFrutas() {
		return listaFrutas;
	}

	public void setListaFrutas(ArrayList<Fruta> listaFrutas) {
		this.listaFrutas = listaFrutas;
	}
	
	public Carne buscarCarneConNombre(String nombre) {
		for(Carne cr : listaCarnes) {
			if(cr.getNombre().contains(nombre)) {
				return cr;
			}
		}
		
		return null;
	}
	
	public Optional<Carne> buscarCarneConNombreV2(String nombre) {
		for(Carne cr : listaCarnes) {
			if(cr.getNombre().contains(nombre)) {
				return Optional.of(cr);
			}
		}
		
		return Optional.empty();
	}
	
	public static void main(String[] args) throws IOException {
		String nombre = "XXX";
		
		InventarioIngredientes ii = (InventarioIngredientes) UtilitarioJSON.leerArchivo(
				"D:\\DELETE_ME\\virtual_gourmet_inventario.json", InventarioIngredientes.class);
		
		Carne res = ii.buscarCarneConNombre("Res");
		System.out.println(res.getStock());
		
		//Optional<Carne> res2 = ii.buscarCarneConNombreV2("Res");
		//System.out.println(res2.isPresent() ? res2.get().getStock() : "NADA");
	}
}