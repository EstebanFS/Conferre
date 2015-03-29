package co.com.eafit.conferre.presentacion.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Usuario {
	private String nombre;
	private String cedula;
	public String getNombre() {
		return (nombre);
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return (cedula);
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
}
