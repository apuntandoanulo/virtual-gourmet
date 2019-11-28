package com.acme.core.ingredientes;

import javax.persistence.Entity;

import com.acme.core.EnumIngrediente;
import com.acme.core.Ingrediente;

@Entity
public class Grano extends Ingrediente {

	public Grano(String nombre) {
		super(nombre);
		setTipo(EnumIngrediente.GRANO);
	}
	
	/*
	 * Comentario de multiples lineas
	 * 
	 * No se sobre-escribio el metodo alistar entonces usara el metodo
	 * heredado de la clase Ingrediente
	 */
}
