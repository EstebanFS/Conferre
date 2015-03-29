package co.com.eafit.conferre.soporte.to;

import co.com.eafit.conferre.soporte.base.ObjetoTO;

public class ClienteConferenciaTO implements ObjetoTO{
	private int idCliente;
	private String idConferencia;
	
	public String getIdConferencia() {
		return idConferencia;
	}
	public void setIdConferencia(String idConferencia) {
		this.idConferencia = idConferencia;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
}
