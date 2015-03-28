package co.com.eafit.conferre.conferencias.data.dac;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.com.eafit.conferre.conferencias.data.base.DAOGenerico;
import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.conferencias.data.to.EspacioTO;
import co.com.eafit.conferre.conferencias.data.to.EventoTO;
import co.com.eafit.conferre.soporte.ExcepcionTransferenciaDAO;

public class EventoDAO implements DAOGenerico {
	
	java.sql.Connection conn;
	
	public EventoDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public ObjetoTO create(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		try {
			EventoTO conf = (EventoTO) parametro;
			PreparedStatement prep = conn.prepareStatement("INSERT INTO "
										+ "eventos values(?,?,?,?)");
			prep.setString(1, conf.getId());
			prep.setString(2, conf.getNombre());
			prep.setString(3, conf.getDescripcion());
			Date fecha = new Date(conf.getFecha().getTime());
			prep.setDate(4, fecha);
			int resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return null;
	}

	@Override
	public List<ObjetoTO> recuperar(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		List<ObjetoTO> eventosRecuperados = new ArrayList<ObjetoTO>();
		EventoTO conf = (EventoTO) parametro;
		try {
			PreparedStatement prep = conn.prepareStatement("SELECT * FROM "
					+ "eventos WHERE id=? OR nombre=? OR fecha=?");
			prep.setString(1, conf.getId());
			prep.setString(2, conf.getNombre());
			Date fecha = new Date(conf.getFecha().getTime());
			prep.setDate(3, fecha);
			ResultSet resultado = prep.executeQuery();
			while(resultado.next()){
				EventoTO evento = new EventoTO();
				evento.setId(resultado.getString("id"));
				evento.setNombre(resultado.getString("nombre"));
				evento.setDescripcion(resultado.getString("descripcion"));
				evento.setFecha(resultado.getTimestamp("fecha"));
				eventosRecuperados.add(evento);
			}
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return eventosRecuperados;
	}

	@Override
	public ObjetoTO update(ObjetoTO nuevoObjeto) throws ExcepcionTransferenciaDAO {
		EventoTO conf = (EventoTO) nuevoObjeto;
		int resultado = -200;
		try {
			PreparedStatement prep = conn.prepareStatement("UPDATE eventos SET "
												+ "nombre=?, "
												+ "descripcion=?, fecha=?"
												+ " WHERE id=?");
			prep.setString(1, conf.getNombre());
			prep.setString(2, conf.getDescripcion());
			Date fecha = new Date(conf.getFecha().getTime());
			prep.setDate(3, fecha);
			prep.setString(4, conf.getId());
			resultado = prep.executeUpdate();	
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return null;
	}

	@Override
	public int borrar(ObjetoTO objetoABorrar) throws ExcepcionTransferenciaDAO {
		EventoTO conf = (EventoTO) objetoABorrar;
		int resultado = -200;
		try {
			PreparedStatement prep = conn.prepareStatement("DELETE FROM eventos "
															+ "WHERE id=?");
			prep.setString(1, conf.getId());
			resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		if(resultado<0) return -1;
		return 0;
	}
}
