package co.com.eafit.conferre.conferencias.business.middleware;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import co.com.eafit.conferre.conferencias.business.JsonTools.ConferenciaJsonTool;
import co.com.eafit.conferre.conferencias.business.JsonTools.EventoJsonTool;
import co.com.eafit.conferre.conferencias.business.JsonTools.SillaJsonTool;
import co.com.eafit.conferre.conferencias.business.JsonTools.TransferenciaJsonTool;
import co.com.eafit.conferre.conferencias.business.base.ConferenciasFachade;
import co.com.eafit.conferre.conferencias.business.useCase.AsignarEventoUseCase;
import co.com.eafit.conferre.conferencias.business.useCase.BuscarConferenciaUseCase;
import co.com.eafit.conferre.conferencias.business.useCase.CrearConferenciaUseCase;
import co.com.eafit.conferre.conferencias.business.useCase.ElegirSillasDisponiblesUseCase;
import co.com.eafit.conferre.conferencias.business.useCase.MostrarEventoUseCase;
import co.com.eafit.conferre.conferencias.business.useCase.MostrarSillasDisponiblesUseCase;
import co.com.eafit.conferre.conferencias.business.useCase.PagarUseCase;
import co.com.eafit.conferre.soporte.base.ObjetoTO;
import co.com.eafit.conferre.soporte.excepcion.ExcepcionTransferenciaDAO;
import co.com.eafit.conferre.soporte.excepcion.ExcepcionUnitOfWork;
import co.com.eafit.conferre.soporte.excepcion.ExcepcionValidacion;
import co.com.eafit.conferre.soporte.excepcion.ExceptionMiddleware;
import co.com.eafit.conferre.soporte.to.ConferenciaTO;
import co.com.eafit.conferre.soporte.to.EventoTO;
import co.com.eafit.conferre.soporte.to.SillaTO;
import co.com.eafit.conferre.soporte.to.TransferenciaTO;

/**
 * @author Jesús Lopera
 * @author Esteban Foronda
 * @author Felipe Tovar
 *
 */

public class RestConferenciaFachade implements ConferenciasFachade{

	/*@Override
	@Path("/conferencias")
	@POST
	@Consumes("application/json")
	@Produces("application/json")*/
	public JSONObject crearConferencia(JSONObject conferencia) 
			throws ExceptionMiddleware, ClassNotFoundException, 
			InstantiationException, IllegalAccessException, ExcepcionUnitOfWork,
			ExcepcionValidacion, ExcepcionTransferenciaDAO {
		ConferenciaJsonTool conferenciaJsonTool = new ConferenciaJsonTool();
		ConferenciaTO conferenciaTO = (ConferenciaTO) conferenciaJsonTool.mapearJsonAObjetoTO(conferencia);
		CrearConferenciaUseCase useCase = new CrearConferenciaUseCase();
		ConferenciaTO conferenciaResultado = null;
		conferenciaResultado = (ConferenciaTO) useCase.ejecutar(conferenciaTO);
		return conferenciaJsonTool.mapearObjetoTOAJson(conferenciaResultado);
	}

	/*@Override
	@Path("/eventos")
	@POST
	@Consumes("application/json")
	@Produces("application/json")*/
	public JSONObject asignarEvento(JSONObject evento) throws ExceptionMiddleware,
			ClassNotFoundException, InstantiationException, 
			IllegalAccessException, ExcepcionValidacion, 
			ExcepcionTransferenciaDAO {
		EventoJsonTool eventoJsonTool = new EventoJsonTool();
		EventoTO eventoTO = (EventoTO) eventoJsonTool.mapearJsonAObjetoTO(evento);
		AsignarEventoUseCase useCase = new AsignarEventoUseCase();
		EventoTO eventoResultado = null;
		eventoResultado = (EventoTO) useCase.ejecutar(eventoTO);
		return eventoJsonTool.mapearObjetoTOAJson(eventoResultado);
	}

	/*@Override
	@Path("/conferencias")
	@GET
	@Consumes("application/json")
	@Produces("application/json")*/
	public JSONObject buscarConferencia(JSONObject conferencia)
			throws ExceptionMiddleware, ClassNotFoundException, 
			InstantiationException, IllegalAccessException, ExcepcionValidacion,
			ExcepcionTransferenciaDAO {
		ConferenciaJsonTool conferenciaJsonTool = new ConferenciaJsonTool();
		ConferenciaTO conferenciaTO = (ConferenciaTO) conferenciaJsonTool.mapearJsonAObjetoTO(conferencia);
		BuscarConferenciaUseCase useCase = new BuscarConferenciaUseCase();
		ConferenciaTO conferenciaResultado = null;
		conferenciaResultado = (ConferenciaTO) useCase.ejecutar(conferenciaTO);
		return conferenciaJsonTool.mapearObjetoTOAJson(conferenciaResultado);
	}

	/*@Override
	@Path("/sillas")
	@POST
	@Consumes("application/json")
	@Produces("application/json")*/
	public JSONObject elegirSillasDisponibles(JSONObject silla)
			throws ExceptionMiddleware, ClassNotFoundException, 
			InstantiationException, IllegalAccessException, ExcepcionValidacion, 
			ExcepcionTransferenciaDAO {
		SillaJsonTool sillaJsonTool = new SillaJsonTool();
		SillaTO sillaTO = (SillaTO) sillaJsonTool.mapearJsonAObjetoTO(silla);
		ElegirSillasDisponiblesUseCase useCase = new ElegirSillasDisponiblesUseCase();
		SillaTO sillaResultado = null;
		sillaResultado = (SillaTO) useCase.ejecutar(sillaTO);
		return sillaJsonTool.mapearObjetoTOAJson(sillaResultado);
	}

	/*@Override
	@Path("/eventos")
	@GET
	@Consumes("application/json")
	@Produces("application/json")*/
	public JSONObject mostrarEvento(JSONObject evento) throws ExceptionMiddleware, 
			ClassNotFoundException, InstantiationException, IllegalAccessException, 
			ExcepcionValidacion, ExcepcionTransferenciaDAO {
		EventoJsonTool eventoJsonTool = new EventoJsonTool();
		EventoTO eventoTO = (EventoTO) eventoJsonTool.mapearJsonAObjetoTO(evento);
		MostrarEventoUseCase useCase = new MostrarEventoUseCase();
		EventoTO eventoResulatdo = null;
		eventoResulatdo = (EventoTO) useCase.ejecutar(eventoTO);
		return eventoJsonTool.mapearObjetoTOAJson(eventoResulatdo);
	}

	/*@Override
	@Path("/sillas")
	@GET
	@Consumes("application/json")
	@Produces("application/json")*/
	public JSONObject mostrarSillasDisponibles(JSONObject evento)
			throws ExceptionMiddleware, ClassNotFoundException, 
			InstantiationException, IllegalAccessException, 
			ExcepcionValidacion, ExcepcionTransferenciaDAO {
		EventoJsonTool eventoJsonTool = new EventoJsonTool();
		SillaJsonTool sillaJsonTool = new SillaJsonTool();
		EventoTO eventoTO = (EventoTO) eventoJsonTool.mapearJsonAObjetoTO(evento);
		MostrarSillasDisponiblesUseCase useCase = new MostrarSillasDisponiblesUseCase();
		ArrayList<ObjetoTO> sillasResultado = null;
		ArrayList<SillaTO> sillasTOResultado = new ArrayList<SillaTO>();
		sillasResultado = useCase.elegirTodasLasSillas(eventoTO);
		for (ObjetoTO toSillaTO : sillasResultado) {
			sillasTOResultado.add((SillaTO)toSillaTO);
		}
		return sillaJsonTool.mapearArraylistObjetoTOAJson(sillasTOResultado);
	}

	/*@Override
	@Path("/pagar")
	@POST
	@Consumes("application/json")
	@Produces("application/json")*/
	public JSONObject pagar(JSONObject pagar)
			throws ExceptionMiddleware, ExcepcionValidacion {
		TransferenciaJsonTool transferenciaJsonTool = new TransferenciaJsonTool();
		TransferenciaTO transferenciaTO = (TransferenciaTO) transferenciaJsonTool.mapearJsonAObjetoTO(pagar);
		PagarUseCase useCase = new PagarUseCase();
		TransferenciaTO respuestaPago = null;
		respuestaPago = (TransferenciaTO)useCase.ejecutar(transferenciaTO);
		return transferenciaJsonTool.mapearObjetoTOAJson(respuestaPago);
	}
}
