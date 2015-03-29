package co.com.eafit.conferre.conferencias.business.base;



import org.json.simple.JSONObject;

import co.com.eafit.conferre.soporte.excepcion.ExcepcionTransferenciaDAO;
import co.com.eafit.conferre.soporte.excepcion.ExcepcionUnitOfWork;
import co.com.eafit.conferre.soporte.excepcion.ExcepcionValidacion;
import co.com.eafit.conferre.soporte.excepcion.ExceptionMiddleware;

public interface ConferenciasFachade {
	public JSONObject crearConferencia(JSONObject conferencia) throws ExceptionMiddleware, ClassNotFoundException, InstantiationException, IllegalAccessException, ExcepcionUnitOfWork, ExcepcionValidacion, ExcepcionTransferenciaDAO;
	public JSONObject asignarEvento(JSONObject evento) throws ExceptionMiddleware, ClassNotFoundException, InstantiationException, IllegalAccessException, ExcepcionValidacion, ExcepcionTransferenciaDAO;
	public JSONObject buscarConferencia(JSONObject conferencia) throws ExceptionMiddleware, ClassNotFoundException, InstantiationException, IllegalAccessException, ExcepcionValidacion, ExcepcionTransferenciaDAO;
	public JSONObject elegirSillasDisponibles(JSONObject silla) throws ExceptionMiddleware, ClassNotFoundException, InstantiationException, IllegalAccessException, ExcepcionValidacion, ExcepcionTransferenciaDAO ;
	public JSONObject mostrarEvento(JSONObject evento) throws ExceptionMiddleware, ClassNotFoundException, InstantiationException, IllegalAccessException, ExcepcionValidacion, ExcepcionTransferenciaDAO ;
	public JSONObject mostrarSillasDisponibles(JSONObject evento) throws ExceptionMiddleware, ClassNotFoundException, InstantiationException, IllegalAccessException, ExcepcionValidacion, ExcepcionTransferenciaDAO ;
	public JSONObject pagar(JSONObject pagar) throws ExceptionMiddleware, ExcepcionValidacion ;
}
