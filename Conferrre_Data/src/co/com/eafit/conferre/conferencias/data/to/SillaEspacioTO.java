package co.com.eafit.conferre.conferencias.data.to;

import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;

public class SillaEspacioTO implements ObjetoTO {
	private String idSilla;
	private String idEspacio;
	
	public String getIdSilla() {
		return idSilla;
	}
	public void setIdSilla(String idSilla) {
		this.idSilla = idSilla;
	}
	public String getIdEspacio() {
		return idEspacio;
	}
	public void setIdEspacio(String idEspacio) {
		this.idEspacio = idEspacio;
	}

}
