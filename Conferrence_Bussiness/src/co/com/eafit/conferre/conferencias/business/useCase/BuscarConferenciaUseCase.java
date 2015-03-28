package co.com.eafit.conferre.conferencias.business.useCase;

import co.com.eafit.conferre.conferencias.business.base.UnitOfWork;
import co.com.eafit.conferre.conferencias.data.base.FabricaDAO;
import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.conferencias.data.dac.ConferenciaDAO;
import co.com.eafit.conferre.conferencias.data.to.ConferenciaTO;
import co.com.eafit.conferre.soporte.ExcepcionTransferenciaDAO;
import co.com.eafit.conferre.soporte.ExcepcionValidacion;

public class BuscarConferenciaUseCase implements UnitOfWork {

	@Override
	public ObjetoTO ejecutar(ObjetoTO param) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ExcepcionValidacion, ExcepcionTransferenciaDAO {
		ConferenciaTO conferencia = (ConferenciaTO) param;
		validar(conferencia);
		ConferenciaTO result = null;
		ConferenciaDAO conferenciaDAO = FabricaDAO.createConferenciaDAO();
		result = (ConferenciaTO)conferenciaDAO.recuperar(conferencia);
		return result;
	}

	@Override
	public void validar(ObjetoTO param) throws ExcepcionValidacion {
		if(((ConferenciaTO) param).getId() == null) throw new ExcepcionValidacion("El id de la conferencia no puede ser nulo");
	}

}
