package co.com.eafit.conferre.conferencias.business.useCase;

import co.com.eafit.conferre.conferencias.business.base.UnitOfWork;
import co.com.eafit.conferre.conferencias.data.base.FabricaDAO;
import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.conferencias.data.dac.ApiTransferenciaDAO;
import co.com.eafit.conferre.conferencias.data.to.TransferenciaTO;
import co.com.eafit.conferre.soporte.ExcepcionValidacion;

public class PagarUseCase implements UnitOfWork {

	@Override
	public ObjetoTO ejecutar(ObjetoTO param) throws ExcepcionValidacion {
		TransferenciaTO transferenciaTO = (TransferenciaTO)param;
		validar(transferenciaTO);
		ApiTransferenciaDAO apiTransferenciaDAO = FabricaDAO.createApiTransferenciaDAO();
		TransferenciaTO result = (TransferenciaTO) apiTransferenciaDAO.generarPago(transferenciaTO);
		return result;
	}

	@Override
	public void validar(ObjetoTO param) throws ExcepcionValidacion {
		if(((TransferenciaTO)param).getValor() == null) throw new ExcepcionValidacion("El valor de la transferencia no puede ser nulo");
	}

}
