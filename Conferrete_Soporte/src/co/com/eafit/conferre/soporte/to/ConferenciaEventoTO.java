package co.com.eafit.conferre.soporte.to;

import co.com.eafit.conferre.soporte.base.ObjetoTO;

public class ConferenciaEventoTO implements ObjetoTO{
	private String idConferencia;
	private String idEvento;
	
	public String getIdConferencia() {
		return idConferencia;
	}
	public void setIdConferencia(String idConferencia) {
		this.idConferencia = idConferencia;
	}
	public String getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}

}
