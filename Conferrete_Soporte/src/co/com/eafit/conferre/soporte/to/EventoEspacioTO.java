package co.com.eafit.conferre.soporte.to;

import co.com.eafit.conferre.soporte.base.ObjetoTO;

public class EventoEspacioTO implements ObjetoTO{
	private String idEvento;
	private String idEspacio;
	
	public String getIdEspacio() {
		return idEspacio;
	}
	public void setIdEspacio(String idEspacio) {
		this.idEspacio = idEspacio;
	}
	public String getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}

}
