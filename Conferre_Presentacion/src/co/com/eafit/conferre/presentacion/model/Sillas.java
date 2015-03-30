package co.com.eafit.conferre.presentacion.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Sillas {
	private String id;
	private String idEspacio;
	private int numero;
	private String fila;
	private String tipo;
	private boolean reservado;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdEspacio() {
		return idEspacio;
	}
	public void setIdEspacio(String idEspacio) {
		this.idEspacio = idEspacio;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getFila() {
		return fila;
	}
	public void setFila(String fila) {
		this.fila = fila;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isReservado() {
		return reservado;
	}
	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}
	public String elegirSilla() {//throws ClassNotFoundException, InstantiationException, IllegalAccessException, ExceptionMiddleware, ExcepcionUnitOfWork, ExcepcionValidacion, ExcepcionTransferenciaDAO{
		//JSONObject silla = new JSONObject();
		//RestConferenciaFachade fachada = new RestConferenciaFachade();
		//fachada.elegirSillasDisponibles(silla);
		return("menuView");
	}
	public String mostrarSillas() {//throws ClassNotFoundException, InstantiationException, IllegalAccessException, ExceptionMiddleware, ExcepcionUnitOfWork, ExcepcionValidacion, ExcepcionTransferenciaDAO{
		//JSONObject evento = new JSONObject();
		//RestConferenciaFachade fachada = new RestConferenciaFachade();
		//fachada.mostrarSillasDisponibles(evento);
		return("menuView");
	}
}
