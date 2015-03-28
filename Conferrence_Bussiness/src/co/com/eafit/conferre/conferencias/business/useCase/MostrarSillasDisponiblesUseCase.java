package co.com.eafit.conferre.conferencias.business.useCase;

import java.util.ArrayList;

import co.com.eafit.conferre.conferencias.business.base.UnitOfWork;
import co.com.eafit.conferre.conferencias.data.base.FabricaDAO;
import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.conferencias.data.dac.SillaDAO;
import co.com.eafit.conferre.conferencias.data.to.SillaTO;
import co.com.eafit.conferre.soporte.ExcepcionTransferenciaDAO;
import co.com.eafit.conferre.soporte.ExcepcionValidacion;

public class MostrarSillasDisponiblesUseCase implements UnitOfWork {
	@Override
	public ObjetoTO ejecutar(ObjetoTO param) throws ExcepcionValidacion, ClassNotFoundException, InstantiationException, IllegalAccessException, ExcepcionTransferenciaDAO {
		SillaTO silla = (SillaTO) param;
		validar(silla);
		SillaTO result = null;
		SillaDAO sillaDAO = FabricaDAO.createSillaDAO();
		result = (SillaTO)sillaDAO.recuperarSilla(silla);
		return result;
	}

	@Override
	public void validar(ObjetoTO param) throws ExcepcionValidacion {
		if(((SillaTO)param).getId() == null) throw new ExcepcionValidacion("El id de la silla no puede ser nulo");
	}
	
	//Este metodo devuelve todas las sillas del espacio
	public ArrayList<ObjetoTO> elegirTodasLasSillas(ObjetoTO param) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ExcepcionValidacion, ExcepcionTransferenciaDAO{
		SillaTO silla = (SillaTO) param;
		validar(silla);
		ArrayList<ObjetoTO> result = null;
		SillaDAO sillaDAO = FabricaDAO.createSillaDAO();
		result = (ArrayList<ObjetoTO>) sillaDAO.recuperar(silla);
		return result;
	}
}
