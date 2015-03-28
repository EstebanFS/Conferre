package co.com.eafit.conferre.conferencias.business.base;

import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.soporte.ExcepcionTransferenciaDAO;
import co.com.eafit.conferre.soporte.ExcepcionUnitOfWork;
import co.com.eafit.conferre.soporte.ExcepcionValidacion;

public interface UnitOfWork {
	public ObjetoTO ejecutar(ObjetoTO param) throws ExcepcionUnitOfWork, ClassNotFoundException, InstantiationException, IllegalAccessException, ExcepcionValidacion, ExcepcionTransferenciaDAO;
	public void validar(ObjetoTO param) throws ExcepcionValidacion;
}
