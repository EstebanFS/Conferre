package co.com.eafit.conferre.presentacion.model;

import java.util.Date;

import javax.faces.bean.ManagedBean;



//import org.json.simple.JSONObject;
//import co.com.eafit.conferre.conferencias.business.middleware.RestConferenciaFachade;
//import co.com.eafit.conferre.soporte.excepcion.ExcepcionTransferenciaDAO;
//import co.com.eafit.conferre.soporte.excepcion.ExcepcionUnitOfWork;
//import co.com.eafit.conferre.soporte.excepcion.ExcepcionValidacion;
//import co.com.eafit.conferre.soporte.excepcion.ExceptionMiddleware;

@ManagedBean
public class Conferencia{
	private String id;
	private int idCliente;
	private String nombre;
	private String nombreConferencista;
	private String tipo;
	private Date fecha;
	private int sillasDisponibles;
	private String descripcion;
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
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
	public String getNombreConferencista() {
		return nombreConferencista;
	}
	public void setNombreConferencista(String nombreConferencista) {
		this.nombreConferencista = nombreConferencista;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getSillasDisponibles() {
		return sillasDisponibles;
	}
	public void setSillasDisponibles(int sillasDisponibles) {
		this.sillasDisponibles = sillasDisponibles;
	}
	
	public String crearConferencia() {//throws ClassNotFoundException, InstantiationException, IllegalAccessException, ExceptionMiddleware, ExcepcionUnitOfWork, ExcepcionValidacion, ExcepcionTransferenciaDAO{
		//JSONObject conferencia = new JSONObject();
		//RestConferenciaFachade fachada = new RestConferenciaFachade();
		//fachada.crearConferencia(conferencia);
		return("menuView");
	}
	
	public String buscarConferencia() {//throws ClassNotFoundException, InstantiationException, IllegalAccessException, ExceptionMiddleware, ExcepcionUnitOfWork, ExcepcionValidacion, ExcepcionTransferenciaDAO{
		//JSONObject conferencia = new JSONObject();
		//RestConferenciaFachade fachada = new RestConferenciaFachade();
		//fachada.buscarConferencia(conferencia);
		return("menuView");
	}

}
