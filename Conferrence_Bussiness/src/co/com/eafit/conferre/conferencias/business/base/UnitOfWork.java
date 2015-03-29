package co.com.eafit.conferre.conferencias.business.base;

import co.com.eafit.conferre.soporte.base.ObjetoTO;
import co.com.eafit.conferre.soporte.excepcion.ExcepcionTransferenciaDAO;
import co.com.eafit.conferre.soporte.excepcion.ExcepcionUnitOfWork;
import co.com.eafit.conferre.soporte.excepcion.ExcepcionValidacion;

public interface UnitOfWork {
	public ObjetoTO ejecutar(ObjetoTO param) throws ExcepcionUnitOfWork, ClassNotFoundException, InstantiationException, IllegalAccessException, ExcepcionValidacion, ExcepcionTransferenciaDAO;
	public void validar(ObjetoTO param) throws ExcepcionValidacion;
}
