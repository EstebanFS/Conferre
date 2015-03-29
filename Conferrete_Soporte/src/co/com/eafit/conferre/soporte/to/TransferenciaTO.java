package co.com.eafit.conferre.soporte.to;

import co.com.eafit.conferre.soporte.base.ObjetoTO;

public class TransferenciaTO implements ObjetoTO{
	private String estado;
	private String valor;

	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
