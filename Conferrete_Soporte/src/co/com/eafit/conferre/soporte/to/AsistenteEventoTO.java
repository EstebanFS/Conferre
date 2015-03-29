package co.com.eafit.conferre.soporte.to;

import co.com.eafit.conferre.soporte.base.ObjetoTO;

public class AsistenteEventoTO implements ObjetoTO{
	private int idAsistente;
	private String idEvento;
	
	public int getIdAsistente() {
		return idAsistente;
	}
	public void setIdAsistente(int idAsistente) {
		this.idAsistente = idAsistente;
	}
	public String getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}
}
