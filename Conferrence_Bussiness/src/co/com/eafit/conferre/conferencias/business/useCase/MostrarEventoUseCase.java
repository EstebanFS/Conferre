package co.com.eafit.conferre.conferencias.business.useCase;

import co.com.eafit.conferre.conferencias.business.base.UnitOfWork;
import co.com.eafit.conferre.conferencias.data.base.FabricaDAO;
import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.conferencias.data.dac.EventoDAO;
import co.com.eafit.conferre.conferencias.data.to.EventoTO;
import co.com.eafit.conferre.soporte.ExcepcionTransferenciaDAO;
import co.com.eafit.conferre.soporte.ExcepcionValidacion;

public class MostrarEventoUseCase implements UnitOfWork{

	@Override
	public ObjetoTO ejecutar(ObjetoTO param) throws ExcepcionValidacion, ClassNotFoundException, InstantiationException, IllegalAccessException, ExcepcionTransferenciaDAO {
		EventoTO evento = (EventoTO) param;
		validar(evento);
		EventoTO result = null;
		EventoDAO eventoDAO = FabricaDAO.createEventoDAO();
		result = (EventoTO)eventoDAO.recuperar(evento);
		return result;
	}

	@Override
	public void validar(ObjetoTO param) throws ExcepcionValidacion {
		if(((EventoTO)param).getId() == null) throw new ExcepcionValidacion("El id del evento no puede ser nulo");		
	}

}
