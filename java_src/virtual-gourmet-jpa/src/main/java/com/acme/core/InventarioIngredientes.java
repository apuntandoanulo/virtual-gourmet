package com.acme.core;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.acme.core.ingredientes.Carne;

@XmlRootElement(name = "inventario")
@XmlAccessorType(XmlAccessType.FIELD)
public class InventarioIngredientes {

	@XmlElement(name = "carne", required = true)
	private ArrayList<Carne> listaCarnes;
	
	public InventarioIngredientes() {
		listaCarnes = new ArrayList<Carne>();
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
}