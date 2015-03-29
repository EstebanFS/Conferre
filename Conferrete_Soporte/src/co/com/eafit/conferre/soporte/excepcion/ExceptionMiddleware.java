package co.com.eafit.conferre.soporte.excepcion;

public class ExceptionMiddleware extends Exception {
	public ExceptionMiddleware(Throwable error){
		super(error);
	}
}
