package co.com.eafit.conferre.presentacion.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ControllerViews {
	public String sendToMenuView() {
		return("menuView");
	}
	
	public String sendToCrearConferencia(){
		return ("crearConferenciaView");
	}
	
	public String sendToAsignarEvento(){
		return ("asignarEventoView");
	}
	
	public String sendToBuscarConferencia(){
		return ("buscarConferenciaView");
	}
	
	public String sendToMostrarEvento(){
		return ("mostrarEventoView");
	}
	
	public String sendToMostrarSillas(){
		return ("mostrarSillasView");
	}
	
	public String sendToElegirSillas(){
		return ("elegirSillasView");
	}
	
	public String sendToModificarSillas(){
		return ("modificarSillasView");
	}
	
	public String sendToPagar(){
		return ("pagarView");
	}
}
