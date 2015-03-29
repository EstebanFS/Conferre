package co.com.eafit.conferre.conferencias.business.useCase;

import java.util.ArrayList;

import co.com.eafit.conferre.conferencias.business.base.UnitOfWork;
import co.com.eafit.conferre.conferencias.data.base.FabricaDAO;
import co.com.eafit.conferre.conferencias.data.dac.SillaDAO;
import co.com.eafit.conferre.soporte.base.ObjetoTO;
import co.com.eafit.conferre.soporte.excepcion.ExcepcionTransferenciaDAO;
import co.com.eafit.conferre.soporte.excepcion.ExcepcionValidacion;
import co.com.eafit.conferre.soporte.to.EventoTO;
import co.com.eafit.conferre.soporte.to.SillaTO;

public class MostrarSillasDisponiblesUseCase implements UnitOfWork {
	@Override
	public ObjetoTO ejecutar(ObjetoTO param) throws ExcepcionValidacion, ClassNotFoundException, InstantiationException, IllegalAccessException, ExcepcionTransferenciaDAO {
		return null;
	}

	@Override
	public void validar(ObjetoTO param) throws ExcepcionValidacion {
		if(((SillaTO)param).getIdEspacio() == null) throw new ExcepcionValidacion("El id del espacio no puede ser nulo");
	}
	
	//Este metodo devuelve todas las sillas del espacio
	public ArrayList<ObjetoTO> elegirTodasLasSillas(ObjetoTO param) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ExcepcionValidacion, ExcepcionTransferenciaDAO{
		EventoTO evento = (EventoTO) param;
		SillaTO silla = new SillaTO();
		silla.setIdEspacio(evento.getId_espacio());
		validar(silla);
		ArrayList<ObjetoTO> result = null;
		SillaDAO sillaDAO = FabricaDAO.createSillaDAO();
		result = (ArrayList<ObjetoTO>) sillaDAO.recuperar(silla);
		return result;
	}
}
