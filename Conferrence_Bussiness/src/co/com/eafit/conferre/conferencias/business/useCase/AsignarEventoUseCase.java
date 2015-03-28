package co.com.eafit.conferre.conferencias.business.useCase;

import java.util.UUID;

import co.com.eafit.conferre.conferencias.business.base.UnitOfWork;
import co.com.eafit.conferre.conferencias.data.base.FabricaDAO;
import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.conferencias.data.dac.ConferenciaEventoDAO;
import co.com.eafit.conferre.conferencias.data.dac.EventoDAO;
import co.com.eafit.conferre.conferencias.data.dac.EventoEspacioDAO;
import co.com.eafit.conferre.conferencias.data.to.ConferenciaEventoTO;
import co.com.eafit.conferre.conferencias.data.to.EventoEspacioTO;
import co.com.eafit.conferre.conferencias.data.to.EventoTO;
import co.com.eafit.conferre.soporte.ExcepcionTransferenciaDAO;
import co.com.eafit.conferre.soporte.ExcepcionValidacion;

public class AsignarEventoUseCase implements UnitOfWork{
	@Override
	public ObjetoTO ejecutar(ObjetoTO param) throws ExcepcionValidacion, ClassNotFoundException, InstantiationException, IllegalAccessException, ExcepcionTransferenciaDAO {
		EventoTO evento = (EventoTO) param;
		validar(evento);
		EventoTO result = null;
		EventoDAO eventoDAO = FabricaDAO.createEventoDAO();
		ConferenciaEventoDAO conferenciaEventoDAO = FabricaDAO.createConferenciaEventoDAO();
		EventoEspacioDAO eventoEspacioDAO = FabricaDAO.createEventoEspacioDAO();
		UUID idEvento = UUID.randomUUID();
		evento.setId(idEvento.toString());
		ConferenciaEventoTO conferenciaEventoTO = new ConferenciaEventoTO();
		EventoEspacioTO eventoEspacioTO = new EventoEspacioTO();
		conferenciaEventoTO.setIdConferencia(evento.getId_conferencia());
		conferenciaEventoTO.setIdEvento(evento.getId());
		eventoEspacioTO.setIdEspacio(evento.getId_espacio());
		eventoEspacioTO.setIdEvento(evento.getId());
		conferenciaEventoDAO.create(conferenciaEventoTO);
		eventoEspacioDAO.create(eventoEspacioTO);
		result = (EventoTO)eventoDAO.create(evento);
		return result;
	}

	@Override
	public void validar(ObjetoTO param) throws ExcepcionValidacion {
		if(((EventoTO)param).getNombre() == null) throw new ExcepcionValidacion("El nombre del evento no puede ser nulo");	
	}

}
