package com.acme.entities.ejemplos.comparadores;

import java.util.Comparator;

import com.acme.core.Empleado;

public class OrdenamientoEmpleadosNombre implements Comparator<Empleado> {

	public int compare(Empleado e1, Empleado e2) {
		return e1.getNombres().compareTo(e2.getNombres());
	}	
}
