package com.acme.entities.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.acme.core.Empleado;
import com.acme.entities.ejemplos.comparadores.OrdenamientoEmpleados;

public class EjemploCompare {

	public static void main(String[] args) {
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		
		Empleado empl1 = new Empleado();
		empl1.setCedula(1456l);
		empl1.setNombres("Juan");
		empl1.setApellidos("Suarez");
		
		empleados.add(empl1);
		empleados.add(new Empleado(8564l, "Luis", "Perez"));
		empleados.add(new Empleado(64l, "Ana", "Martinez"));
		
		for(Empleado ep : empleados) {
			System.out.println(ep.toString());
		}
		
		System.out.println("----");
		
		Collections.sort(empleados, new OrdenamientoEmpleados(true));
		
		System.out.println("----");
		
		for(Empleado ep : empleados) {
			System.out.println(ep.toString());
		}
		
		System.out.println("----");
		
		Collections.sort(empleados, new OrdenamientoEmpleados(false));
		
		System.out.println("----");
		
		for(Empleado ep : empleados) {
			System.out.println(ep.toString());
		}
		
		System.out.println("----");
		
		Collections.sort(empleados, new Comparator<Empleado>() {

			public int compare(Empleado o1, Empleado o2) {
				return o1.getCedula().compareTo(o2.getCedula());
			}
			
		});
		
		System.out.println("----");
		
		for(Empleado ep : empleados) {
			System.out.println(ep.toString());
		}
		
		Empleado[] arregloEmpleados = {new Empleado(415l, "n1", "ap1"), new Empleado(825l, "n2", "ap2")};
		
		List<Empleado> nuevaLista = Arrays.asList(arregloEmpleados);
		
	}
}
