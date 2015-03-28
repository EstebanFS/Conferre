package co.com.eafit.conferre.conferencias.data.base;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import co.com.eafit.conferre.conferencias.data.dac.ArchivoPlanoDAO;
import co.com.eafit.conferre.conferencias.data.dac.AsistenteDAO;
import co.com.eafit.conferre.conferencias.data.dac.ClienteDAO;
import co.com.eafit.conferre.conferencias.data.dac.ConferenciaDAO;
import co.com.eafit.conferre.conferencias.data.dac.EventoDAO;
import co.com.eafit.conferre.conferencias.data.dac.SillaDAO;
import co.com.eafit.conferre.conferencias.data.to.AsistenteTO;
import co.com.eafit.conferre.conferencias.data.to.ClienteTO;
import co.com.eafit.conferre.conferencias.data.to.ConferenciaTO;
import co.com.eafit.conferre.conferencias.data.to.EspacioTO;
import co.com.eafit.conferre.conferencias.data.to.EventoTO;
import co.com.eafit.conferre.conferencias.data.to.SillaTO;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		//FabricaDAO conexion = new FabricaDAO("conferre","root","");
		/*//----------------Evaluando Codigo Asistente---------------
		AsistenteDAO asistente = conexion.createAsistenteDAO();
		AsistenteTO objAsistente = new AsistenteTO();
		objAsistente.setIdentificacion(10);
		objAsistente.setCorreo("");
		//asistente.create(objAsistente);
		//asistente.update(objAsistente);
		ArrayList<ObjetoTO> retorno = (ArrayList<ObjetoTO>) asistente.recuperar(objAsistente);
		for (ObjetoTO objetoTO : retorno) {
			AsistenteTO aux = (AsistenteTO)objetoTO;
			System.out.println(aux.getNombre());
			System.out.println(aux.getNumeroCelular());
		}
		//asistente.borrar(objAsistente);
		*/
		/*//----------------Evaluando Codigo Cliente---------------
		ClienteDAO clienteDAO = conexion.createClienteDAO();
		ClienteTO cliente = new ClienteTO();
		cliente.setIdentificacion(1120);
		cliente.setNombre("chuchasfasfo");
		cliente.setNumeroCelular(20123);
		cliente.setCorreo("asfasf@asfasf.com");
		cliente.setContrasena("hoasfla");
		//clienteDAO.create(cliente);
		//clienteDAO.update(cliente);
		/*ArrayList<ObjetoTO> retorno = (ArrayList<ObjetoTO>) clienteDAO.recuperar(cliente);
		for (ObjetoTO objetoTO : retorno) {
			ClienteTO aux = (ClienteTO)objetoTO;
			System.out.println(aux.getNombre());
			System.out.println(aux.getNumeroCelular());
		}*/
		//clienteDAO.borrar(cliente);
		/*//----------------Evaluando Codigo Conferencia---------------
		ConferenciaDAO conferenciaDAO = conexion.createConferenciaDAO();
		ConferenciaTO conferencia = new ConferenciaTO();
		java.util.Date fecha = new java.util.Date();
		conferencia.setId(2);
		conferencia.setNombre("zxczxc");
		conferencia.setNombreConferencista("asfasfcczxc");
		conferencia.setTipo("");
		conferencia.setFecha(fecha);
		conferencia.setSillasDisponibles(2);
		conferencia.setDescripcion("Esta es la conferencia");
		//conferenciaDAO.create(conferencia);
		//conferenciaDAO.update(conferencia);
		/*ArrayList<ObjetoTO> retorno = (ArrayList<ObjetoTO>) conferenciaDAO.recuperar(conferencia);
		for (ObjetoTO objetoTO : retorno) {
			ConferenciaTO aux = (ConferenciaTO)objetoTO;
			System.out.println(aux.getNombre());
			System.out.println(aux.getNombreConferencista());
		}*/
		//conferenciaDAO.borrar(conferencia);*/
		/*//----------------Evaluando Codigo evento---------------
		EventoDAO eventoDAO = conexion.createEventoDAO();
		EventoTO evento = new EventoTO();
		java.util.Date fecha = new java.util.Date();
		evento.setId(2);
		evento.setNombre("Chucho");
		evento.setDescripcion("Esto es asfun evento");
		evento.setFecha(fecha);
		//eventoDAO.create(evento);
		//eventoDAO.update(evento);
		/*ArrayList<ObjetoTO> retorno = (ArrayList<ObjetoTO>) eventoDAO.recuperar(evento);
		for (ObjetoTO objetoTO : retorno) {
			EventoTO aux = (EventoTO)objetoTO;
			System.out.println(aux.getNombre());
			System.out.println(aux.getDescripcion());
		}*/
		//eventoDAO.borrar(evento);*/
		/*//----------------Evaluando Codigo Silla---------------
		SillaDAO sillaDAO = conexion.createSillaDAO();
		SillaTO silla = new SillaTO();
		silla.setId(1212);
		silla.setNumero(1);
		silla.setFila("AasfaA");
		silla.setTipo("Preferencial");
		silla.setReservado(false);
		//sillaDAO.create(silla);
		//sillaDAO.update(silla);
		/*ArrayList<ObjetoTO> retorno = (ArrayList<ObjetoTO>) sillaDAO.recuperar(silla);
		for (ObjetoTO objetoTO : retorno) {
			SillaTO aux = (SillaTO)objetoTO;
			System.out.println(aux.getNumero());
			System.out.println(aux.getFila());
		}*/
		//sillaDAO.borrar(silla);
		/*sillaDAO.recuperarSilla(silla);
		ArrayList<ObjetoTO> retorno = (ArrayList<ObjetoTO>) sillaDAO.recuperar(silla);
		for (ObjetoTO objetoTO : retorno) {
			SillaTO aux = (SillaTO)objetoTO;
			System.out.println(aux.getNumero());
			System.out.println(aux.getFila());
		}*/	
	}

}
