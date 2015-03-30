package co.com.eafit.conferre.presentacion.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Pago {
	private String valor;
	private String banco;
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String generarPago(){ //throws ClassNotFoundException, InstantiationException, IllegalAccessException, ExceptionMiddleware, ExcepcionUnitOfWork, ExcepcionValidacion, ExcepcionTransferenciaDAO{
		//JSONObject pago = new JSONObject();
		//RestConferenciaFachade fachada = new RestConferenciaFachade();
		//fachada.pagar(pago);
		return("menuView");
	}
}
