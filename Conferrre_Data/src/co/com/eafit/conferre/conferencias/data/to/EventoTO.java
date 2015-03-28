package co.com.eafit.conferre.conferencias.data.to;

import java.util.Date;

import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;

public class EventoTO implements ObjetoTO {
	
	private String id;
	private String idConferencia;
	private String idEspacio;
	private String nombre;
	private String descripcion;
	private Date fecha;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getId_conferencia() {
		return idConferencia;
	}
	public void setId_conferencia(String id_conferencia) {
		this.idConferencia = id_conferencia;
	}
	public String getId_espacio() {
		return idEspacio;
	}
	public void setId_espacio(String id_espacio) {
		this.idEspacio = id_espacio;
	}
}
