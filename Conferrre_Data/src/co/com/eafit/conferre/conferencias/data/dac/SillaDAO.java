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
import co.com.eafit.conferre.soporte.to.SillaTO;

public class SillaDAO implements DAOGenerico {
	
	java.sql.Connection conn;
	
	public SillaDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public ObjetoTO create(ObjetoTO parametro) {
		SillaTO conf = (SillaTO) parametro;
		try {
			PreparedStatement prep = conn.prepareStatement("INSERT INTO sillas "
					+ "values(?,?,?,?,?,?)");
			prep.setString(1, conf.getId());
			prep.setString(2, conf.getIdEspacio());
			prep.setInt(3, conf.getNumero());
			prep.setString(4, conf.getFila());
			prep.setString(5, conf.getTipo());
			prep.setBoolean(6, conf.getReservado());
			int respuesta = prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Este metodo recupera todas las sillas del espacio.
	@Override
	public List<ObjetoTO> recuperar(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		List<ObjetoTO> sillasRecuperadas = new ArrayList<ObjetoTO>();
		SillaTO conf = (SillaTO) parametro;
		try {
			PreparedStatement prep = conn.prepareStatement("SELECT * FROM "
												+ "sillas WHERE id_espacio=?");
			prep.setString(1, conf.getIdEspacio());
			ResultSet resultado = prep.executeQuery();
			while(resultado.next()){
				SillaTO silla = new SillaTO();
				silla.setId(resultado.getString("id"));
				silla.setIdEspacio(resultado.getString("id_espacio"));
				silla.setNumero(resultado.getInt("numero"));
				silla.setFila(resultado.getString("fila"));
				silla.setTipo(resultado.getString("tipo"));
				silla.setReservado(resultado.getBoolean("reservado"));
				sillasRecuperadas.add(silla);
			}
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return sillasRecuperadas;
	}
	
	//Este metodo retorna una silla segun su id.
	public ObjetoTO recuperarSilla(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		SillaTO silla = new SillaTO();
		SillaTO conf = (SillaTO) parametro;
		try {
			PreparedStatement prep = conn.prepareStatement("SELECT * FROM "
												+ "sillas WHERE id=?");
			prep.setString(1, conf.getId());
			ResultSet resultado = prep.executeQuery();
			while(resultado.next()){
				silla.setId(resultado.getString("id"));
				silla.setIdEspacio(resultado.getString("id_espacio"));
				silla.setNumero(resultado.getInt("numero"));
				silla.setFila(resultado.getString("fila"));
				silla.setTipo(resultado.getString("tipo"));
				silla.setReservado(resultado.getBoolean("reservado"));	
			}
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		if(silla == null) return null;
		return silla;
	}


	@Override
	public ObjetoTO update(ObjetoTO nuevoObjeto) throws ExcepcionTransferenciaDAO {
		SillaTO conf = (SillaTO) nuevoObjeto;
		try {
			PreparedStatement prep = conn.prepareStatement("UPDATE sillas "
					+ "SET id_espacio=?, numero=?, fila=?, tipo=?, "
					+ "reservado=? WHERE id=?");
			prep.setString(1, conf.getIdEspacio());
			prep.setInt(2, conf.getNumero());
			prep.setString(3, conf.getFila());
			prep.setString(4, conf.getTipo());
			prep.setBoolean(5, conf.getReservado());
			prep.setString(6, conf.getId());
			int resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return null;
	}

	@Override
	public int borrar(ObjetoTO objetoABorrar) throws ExcepcionTransferenciaDAO {
		SillaTO conf = (SillaTO) objetoABorrar;
		try {
			PreparedStatement prep = conn.prepareStatement("DELETE FROM sillas "
																+ "WHERE id=?");
			prep.setString(1, conf.getId());
			int resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return 0;
	}
}
