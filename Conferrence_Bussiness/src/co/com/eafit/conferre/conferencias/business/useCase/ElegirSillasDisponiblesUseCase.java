package co.com.eafit.conferre.conferencias.business.useCase;

import co.com.eafit.conferre.conferencias.business.base.UnitOfWork;
import co.com.eafit.conferre.conferencias.data.base.FabricaDAO;
import co.com.eafit.conferre.conferencias.data.dac.SillaDAO;
import co.com.eafit.conferre.soporte.base.ObjetoTO;
import co.com.eafit.conferre.soporte.excepcion.ExcepcionTransferenciaDAO;
import co.com.eafit.conferre.soporte.excepcion.ExcepcionValidacion;
import co.com.eafit.conferre.soporte.to.SillaTO;

public class ElegirSillasDisponiblesUseCase implements UnitOfWork{

	@Override
	public ObjetoTO ejecutar(ObjetoTO param) throws ExcepcionValidacion, ClassNotFoundException, InstantiationException, IllegalAccessException, ExcepcionTransferenciaDAO {
		SillaTO sillaTO = (SillaTO) param;
		validar(sillaTO);
		SillaTO result = null;
		SillaDAO sillaDAO = FabricaDAO.createSillaDAO();
		sillaTO.setReservado(true);
		result = (SillaTO)sillaDAO.update(sillaTO);
		return result;
	}

	@Override
	public void validar(ObjetoTO param) throws ExcepcionValidacion {
		if(((SillaTO)param).getId() == null) throw new ExcepcionValidacion("El id de la silla no puede ser nulo");
		if(((SillaTO)param).getReservado() == true) throw new ExcepcionValidacion("La silla ya se encuentra reservada");
	}
}
