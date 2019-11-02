package com.acme.core;

public class Empleado /*implements Comparable<Empleado>*/ {

	private Long cedula;
	private String nombres;
	private String apellidos;
	
	public Empleado() {}

	public Empleado(Long cedula, String nombres, String apellidos) {
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public Long getCedula() {
		return cedula;
	}
	
	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empleado [cedula=" + cedula + ", nombre completo =" + nombres + ", " + apellidos + "]";
	}
/*
	public int compareTo(Empleado empleado) {
		return nombres.compareTo(empleado.getNombres());
	}*/
}
