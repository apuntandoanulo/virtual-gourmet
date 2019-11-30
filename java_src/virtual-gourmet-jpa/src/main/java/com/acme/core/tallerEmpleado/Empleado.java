/**
 * 
 */
package com.acme.core.tallerEmpleado;

import java.util.Date;

enum EnumGenero {
	MUJER,
	HOMBRE
}

enum EnumEstadoCivil {
	CASADO,
	SOLTERO,
	UNION_LIBRE,
	OTRO
}

/**
 * @author Jairo Henao
 *
 */
public class Empleado {

	private Long cedula;
	private String nombres;
	private String apellidos;
	private EnumGenero genero;
	private Date fechaNacimiento;
	private Date fechaIngreso;
	private Double salario;
	private EnumEstadoCivil estadoCivil;
	private Integer numeroHijos;
	public Long getCedula() {
		return cedula;
	}
	public void setCedula(Long cedula) {
		this.cedula = cedula;
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
	public EnumGenero getGenero() {
		return genero;
	}
	public void setGenero(EnumGenero genero) {
		this.genero = genero;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public EnumEstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EnumEstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public Integer getNumeroHijos() {
		return numeroHijos;
	}
	public void setNumeroHijos(Integer numeroHijos) {
		this.numeroHijos = numeroHijos;
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
	
	
}
