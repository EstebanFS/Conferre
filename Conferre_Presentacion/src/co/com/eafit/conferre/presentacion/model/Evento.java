package co.com.eafit.conferre.presentacion.model;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Evento {
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
	public String getIdConferencia() {
		return idConferencia;
	}
	public void setIdConferencia(String idConferencia) {
		this.idConferencia = idConferencia;
	}
	public String getIdEspacio() {
		return idEspacio;
	}
	public void setIdEspacio(String idEspacio) {
		this.idEspacio = idEspacio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String asignarEvento(){ //throws ClassNotFoundException, InstantiationException, IllegalAccessException, ExceptionMiddleware, ExcepcionUnitOfWork, ExcepcionValidacion, ExcepcionTransferenciaDAO{
		//JSONObject evento = new JSONObject();
		//RestConferenciaFachade fachada = new RestConferenciaFachade();
		//fachada.asignarEvento(evento);
		return("menuView");
	}
	public String mostrarEvento(){ //throws ClassNotFoundException, InstantiationException, IllegalAccessException, ExceptionMiddleware, ExcepcionUnitOfWork, ExcepcionValidacion, ExcepcionTransferenciaDAO{
		//JSONObject evento = new JSONObject();
		//RestConferenciaFachade fachada = new RestConferenciaFachade();
		//fachada.mostrarEvento(evento);
		return("menuView");
	}

}
