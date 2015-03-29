package co.com.eafit.conferre.soporte.to;

import java.util.List;

import co.com.eafit.conferre.soporte.base.ObjetoTO;

public class ListaDeEsperaTO implements ObjetoTO {
	
	private ConferenciaTO esperando;
	private List<AsistenteTO> colaDeEspera;
	
	public ConferenciaTO getEsperando() {
		return esperando;
	}
	public void setEsperando(ConferenciaTO esperando) {
		this.esperando = esperando;
	}
	public List<AsistenteTO> getColaDeEspera() {
		return colaDeEspera;
	}
	public void setColaDeEspera(List<AsistenteTO> colaDeEspera) {
		this.colaDeEspera = colaDeEspera;
	}
	
}
