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
import co.com.eafit.conferre.soporte.to.AsistenteEventoTO;
import co.com.eafit.conferre.soporte.to.AsistenteTO;
import co.com.eafit.conferre.soporte.to.ClienteConferenciaTO;

public class ClienteConferenciaDAO implements DAOGenerico{
	
	java.sql.Connection conn;
	
	public ClienteConferenciaDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public ObjetoTO create(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		ClienteConferenciaTO conf = (ClienteConferenciaTO)parametro;
		try {
			PreparedStatement prep = conn.prepareStatement("INSERT INTO "
												+ "client_conference values(?,?)");
			prep.setInt(1, conf.getIdCliente());
			prep.setString(2, conf.getIdConferencia());
			
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return null;
	}

	@Override
	public List<ObjetoTO> recuperar(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		
		List<ObjetoTO> clientesConferenciasRecuperadas = new ArrayList<ObjetoTO>();
		try {
			ClienteConferenciaTO conf = (ClienteConferenciaTO) parametro;
			PreparedStatement prep = conn.prepareStatement("SELECT * FROM "
					+ "client_conference WHERE id_client=? "
					+ "OR id_conference=?");
			prep.setInt(1, conf.getIdCliente());
			prep.setString(2, conf.getIdConferencia());
			ResultSet resultado = prep.executeQuery();
			while(resultado.next()){
				ClienteConferenciaTO clienteConferencia = new ClienteConferenciaTO();
				clienteConferencia.setIdCliente(resultado.getInt("id_client"));
				clienteConferencia.setIdConferencia(resultado.getString("id_conference"));
				clientesConferenciasRecuperadas.add(clienteConferencia);
			}
			
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return clientesConferenciasRecuperadas;
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
		
		ClienteConferenciaTO conf = (ClienteConferenciaTO) objetoABorrar;
		int resultado = -200;
		try {
			PreparedStatement prep = conn.prepareStatement("DELETE FROM "
					+ "client_conference WHERE id_client=? AND id_conference=?");
			prep.setInt(1, conf.getIdCliente());
			prep.setString(2, conf.getIdConferencia());
			resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		if(resultado < 0) return -1;
		return 0;
	}
}
