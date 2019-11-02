package com.acme.entities.ejemplos.comparadores;

import java.util.Comparator;

import com.acme.core.Empleado;

public class OrdenamientoEmpleados implements Comparator<Empleado> {

	private Boolean ordernarNombres;
	
	public OrdenamientoEmpleados(Boolean ordernarNombres) {
		this.ordernarNombres = ordernarNombres;
	}
	
	public int compare(Empleado e1, Empleado e2) {
		if(Boolean.TRUE.equals(ordernarNombres)) {
			return e1.getNombres().compareTo(e2.getNombres());
		} else {
			return e1.getApellidos().compareTo(e2.getApellidos());
		}
	}	
}
