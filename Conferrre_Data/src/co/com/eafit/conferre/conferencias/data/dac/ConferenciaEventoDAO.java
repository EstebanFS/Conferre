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
import co.com.eafit.conferre.soporte.to.ClienteConferenciaTO;
import co.com.eafit.conferre.soporte.to.ConferenciaEventoTO;

public class ConferenciaEventoDAO implements DAOGenerico{
	
	java.sql.Connection conn;
	
	public ConferenciaEventoDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public ObjetoTO create(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		ConferenciaEventoTO conf = (ConferenciaEventoTO)parametro;
		try {
			PreparedStatement prep = conn.prepareStatement("INSERT INTO "
												+ "conference_event values(?,?)");
			prep.setString(1, conf.getIdConferencia());
			prep.setString(2, conf.getIdEvento());
			
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return null;
	}

	@Override
	public List<ObjetoTO> recuperar(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		
		List<ObjetoTO> conferenciaEventoRecuperadas = new ArrayList<ObjetoTO>();
		try {
			ConferenciaEventoTO conf = (ConferenciaEventoTO) parametro;
			PreparedStatement prep = conn.prepareStatement("SELECT * FROM "
					+ "conference_event WHERE id_conference=? "
					+ "OR id_event=?");
			prep.setString(1, conf.getIdConferencia());
			prep.setString(2, conf.getIdEvento());
			ResultSet resultado = prep.executeQuery();
			while(resultado.next()){
				ConferenciaEventoTO conferenciaEvento = new ConferenciaEventoTO();
				conferenciaEvento.setIdConferencia(resultado.getString("id_conference"));
				conferenciaEvento.setIdEvento(resultado.getString("id_event"));
				conferenciaEventoRecuperadas.add(conferenciaEvento);
			}
			
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return conferenciaEventoRecuperadas;
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
		
		ConferenciaEventoTO conf = (ConferenciaEventoTO) objetoABorrar;
		int resultado = -200;
		try {
			PreparedStatement prep = conn.prepareStatement("DELETE FROM "
					+ "conference_event WHERE id_conference=? AND id_event=?");
			prep.setString(1, conf.getIdConferencia());
			prep.setString(2, conf.getIdEvento());
			resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		if(resultado < 0) return -1;
		return 0;
	}
}
