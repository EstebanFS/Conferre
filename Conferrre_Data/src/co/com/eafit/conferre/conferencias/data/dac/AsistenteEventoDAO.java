package co.com.eafit.conferre.conferencias.data.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.com.eafit.conferre.conferencias.data.base.DAOGenerico;
import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.conferencias.data.to.AsistenteEventoTO;
import co.com.eafit.conferre.conferencias.data.to.AsistenteTO;
import co.com.eafit.conferre.soporte.ExcepcionTransferenciaDAO;

public class AsistenteEventoDAO implements DAOGenerico {
	
	java.sql.Connection conn;
	
	public AsistenteEventoDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public ObjetoTO create(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		AsistenteEventoTO conf = (AsistenteEventoTO)parametro;
		try {
			PreparedStatement prep = conn.prepareStatement("INSERT INTO "
												+ "assistant_event values(?,?)");
			prep.setInt(1, conf.getIdAsistente());
			prep.setString(2, conf.getIdEvento());
			
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return null;
	}

	@Override
	public List<ObjetoTO> recuperar(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		
		List<ObjetoTO> asistentesEventosRecuperadas = new ArrayList<ObjetoTO>();
		try {
			AsistenteEventoTO conf = (AsistenteEventoTO) parametro;
			PreparedStatement prep = conn.prepareStatement("SELECT * FROM "
					+ "assistant_event WHERE id_assistant=? "
					+ "OR id_event=?");
			prep.setInt(1, conf.getIdAsistente());
			prep.setString(2, conf.getIdEvento());
			ResultSet resultado = prep.executeQuery();
			while(resultado.next()){
				AsistenteEventoTO asistenteEvento = new AsistenteEventoTO();
				asistenteEvento.setIdAsistente(resultado.getInt("id_assistant"));
				asistenteEvento.setIdEvento(resultado.getString("id_event"));
				asistentesEventosRecuperadas.add(asistenteEvento);
			}
			
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return asistentesEventosRecuperadas;
	}

	@Override
	public ObjetoTO update(ObjetoTO param) {
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
		
		AsistenteEventoTO conf = (AsistenteEventoTO) objetoABorrar;
		int resultado = -200;
		try {
			PreparedStatement prep = conn.prepareStatement("DELETE FROM "
					+ "assistant_event WHERE id_assistant=? AND id_event=?");
			prep.setInt(1, conf.getIdAsistente());
			prep.setString(2, conf.getIdEvento());
			resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		if(resultado < 0) return -1;
		return 0;
	}
}
