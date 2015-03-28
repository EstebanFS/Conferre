package co.com.eafit.conferre.conferencias.business.useCase;

import java.util.UUID;

import co.com.eafit.conferre.conferencias.business.base.UnitOfWork;
import co.com.eafit.conferre.conferencias.data.base.FabricaDAO;
import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.conferencias.data.dac.ClienteConferenciaDAO;
import co.com.eafit.conferre.conferencias.data.dac.ConferenciaDAO;
import co.com.eafit.conferre.conferencias.data.to.ClienteConferenciaTO;
import co.com.eafit.conferre.conferencias.data.to.ConferenciaTO;
import co.com.eafit.conferre.soporte.ExcepcionTransferenciaDAO;
import co.com.eafit.conferre.soporte.ExcepcionUnitOfWork;
import co.com.eafit.conferre.soporte.ExcepcionValidacion;

public class CrearConferenciaUseCase implements UnitOfWork{
	@Override
	public ObjetoTO ejecutar(ObjetoTO param) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ExcepcionUnitOfWork, ExcepcionValidacion, ExcepcionTransferenciaDAO{
		ConferenciaTO conferencia = (ConferenciaTO)param;
		ConferenciaTO resulto = null;
		validar(conferencia);
		ConferenciaDAO conferenceDAO = FabricaDAO.createConferenciaDAO();
		ClienteConferenciaDAO clientConferenceDAO = FabricaDAO.createClienteConferenciaDAO();
		UUID id = UUID.randomUUID();
		conferencia.setId(id.toString());
		ClienteConferenciaTO clientConferenceTO = new ClienteConferenciaTO();
		clientConferenceTO.setIdCliente(conferencia.getIdCliente());
		clientConferenceTO.setIdConferencia(conferencia.getId());
		clientConferenceDAO.create(clientConferenceTO);
		resulto = (ConferenciaTO) conferenceDAO.create(conferencia);
		return resulto;
	}

	@Override
	public void validar(ObjetoTO param) throws ExcepcionValidacion {
		if(((ConferenciaTO)param).getNombre() == null) throw new ExcepcionValidacion("El nombre de la"
				+ " Conferencia no puede ser nulo");
	}
}
