package co.com.eafit.conferre.conferencias.data.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.com.eafit.conferre.conferencias.data.base.DAOGenerico;
import co.com.eafit.conferre.soporte.base.ObjetoTO;
import co.com.eafit.conferre.soporte.excepcion.ExcepcionTransferenciaDAO;
import co.com.eafit.conferre.soporte.to.AsistenteTO;
import co.com.eafit.conferre.soporte.to.EventoEspacioTO;
import co.com.eafit.conferre.soporte.to.SillaEspacioTO;

public class SillaEspacioDAO implements DAOGenerico {
	
	java.sql.Connection conn;
	
	public SillaEspacioDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public ObjetoTO create(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		SillaEspacioTO conf = (SillaEspacioTO)parametro;
		try {
			PreparedStatement prep = conn.prepareStatement("INSERT INTO "
												+ "chair_space values(?,?)");
			prep.setString(1, conf.getIdSilla());
			prep.setString(2, conf.getIdEspacio());
			
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return null;
	}

	@Override
	public List<ObjetoTO> recuperar(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		
		List<ObjetoTO> eventoEspacioRecuperadas = new ArrayList<ObjetoTO>();
		try {
			SillaEspacioTO conf = (SillaEspacioTO) parametro;
			PreparedStatement prep = conn.prepareStatement("SELECT * FROM "
					+ "chair_space WHERE id_chair=? "
					+ "OR id_space=?");
			prep.setString(1, conf.getIdSilla());
			prep.setString(2, conf.getIdEspacio());
			ResultSet resultado = prep.executeQuery();
			while(resultado.next()){
				EventoEspacioTO eventoEspacio = new EventoEspacioTO();
				eventoEspacio.setIdEvento(resultado.getString("id_chair"));
				eventoEspacio.setIdEspacio(resultado.getString("id_space"));
				eventoEspacioRecuperadas.add(eventoEspacio);
			}
			
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return eventoEspacioRecuperadas;
	}

	@Override
	public ObjetoTO update(ObjetoTO viejoObjeto) {
	/*	
		try {
			AsistenteEventoTO conf = (AsistenteEventoTO) nuevoObjeto;
			PreparedStatement prep = conn.prepareStatement("UPDATE assistant_event"
					+ " SET id_assistant=?, id_event=? WHERE id_assistant=? "
					+ "AND id_event=?");
			prep.setInt(1, conf.get());
			prep.setString(2, conf.getNombre());
			prep.setInt(3, conf.getNumeroCelular());
			prep.setString(4, conf.getCorreo());
			int resultado = prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return null;
	}

	@Override
	public int borrar(ObjetoTO objetoABorrar) throws ExcepcionTransferenciaDAO {
		
		SillaEspacioTO conf = (SillaEspacioTO) objetoABorrar;
		int resultado = -200;
		try {
			PreparedStatement prep = conn.prepareStatement("DELETE FROM "
					+ "chair_space WHERE id_chair=? AND id_space=?");
			prep.setString(1, conf.getIdSilla());
			prep.setString(2, conf.getIdEspacio());
			resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		if(resultado < 0) return -1;
		return 0;
	}
}
