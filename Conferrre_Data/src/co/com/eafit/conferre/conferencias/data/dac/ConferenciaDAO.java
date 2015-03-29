package co.com.eafit.conferre.conferencias.data.dac;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.com.eafit.conferre.conferencias.data.base.DAOGenerico;
import co.com.eafit.conferre.soporte.base.ObjetoTO;
import co.com.eafit.conferre.soporte.excepcion.ExcepcionTransferenciaDAO;
import co.com.eafit.conferre.soporte.to.ConferenciaTO;

public class ConferenciaDAO implements DAOGenerico {

	java.sql.Connection conn;

	public ConferenciaDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public ObjetoTO create(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		try {
			ConferenciaTO conf = (ConferenciaTO) parametro;
			PreparedStatement prep = conn.prepareStatement("INSERT INTO "
										+ "conferencias values(?,?,?,?,?,?,?)");
			prep.setString(1, conf.getId());
			prep.setString(2, conf.getNombre());
			prep.setString(3, conf.getNombreConferencista());
			prep.setString(4, conf.getTipo());
			Date fecha = new Date (conf.getFecha().getTime());
			prep.setDate(5, fecha);
			prep.setInt(6, conf.getSillasDisponibles());
			prep.setString(7, conf.getDescripcion());
			int resultado = prep.executeUpdate();	
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return null;
	}

	@Override
	public List<ObjetoTO> recuperar(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {

		List<ObjetoTO> conferenciasRecuperadas = new ArrayList<ObjetoTO>();
		try {
			ConferenciaTO conf = (ConferenciaTO) parametro;
			PreparedStatement prep = conn.prepareStatement("SELECT * FROM "
					+ "conferencias WHERE id=? OR nombre=? OR "
					+ "nombre_conferencistas=? OR tipo=? OR fecha=?");
			prep.setString(1, conf.getId());
			prep.setString(2,conf.getNombre());
			prep.setString(3, conf.getNombreConferencista());
			prep.setString(4, conf.getTipo());
			Date fecha = new Date(conf.getFecha().getTime());
			prep.setDate(5, fecha);
			ResultSet resultado = prep.executeQuery();
			while(resultado.next()){
				ConferenciaTO conferencia = new ConferenciaTO();
				conferencia.setId(resultado.getString("id"));
				conferencia.setNombre(resultado.getString("nombre"));
				conferencia.setNombreConferencista(resultado.
											getString("nombre_conferencistas"));
				conferencia.setTipo(resultado.getString("tipo"));
				conferencia.setFecha(resultado.getTimestamp("fecha"));
				conferencia.setSillasDisponibles(resultado.
											getInt("sillas_disponibles"));
				conferencia.setDescripcion(resultado.getString("descripcion"));
				conferenciasRecuperadas.add(conferencia);
			}
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return conferenciasRecuperadas;
	}

	@Override
	public ObjetoTO update(ObjetoTO nuevoObjeto) throws ExcepcionTransferenciaDAO {
		ConferenciaTO conf = (ConferenciaTO) nuevoObjeto;
		try {
			PreparedStatement prep = conn.prepareStatement("UPDATE conferencias "
					+ "SET nombre=?, nombre_conferencistas=?, tipo=?, "
					+ "sillas_disponibles=?, descripcion=? "
					+ "WHERE id=?");
			prep.setString(1, conf.getNombre());
			prep.setString(2, conf.getNombreConferencista());
			prep.setString(3, conf.getTipo());
			//Date fecha = new Date(conf.getFecha().getTime());
			//prep.setDate(4, fecha);
			prep.setInt(4, conf.getSillasDisponibles());
			prep.setString(5, conf.getDescripcion());
			System.out.println(conf.getId());
			prep.setString(6, conf.getId());
			int resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return null;
	}

	@Override
	public int borrar(ObjetoTO objetoABorrar) throws ExcepcionTransferenciaDAO {
		ConferenciaTO conf = (ConferenciaTO) objetoABorrar;
		int resultado = -200;
		try {
			PreparedStatement prep = conn.prepareStatement("DELETE FROM "
												+ "conferencias WHERE id=?");
			prep.setString(1, conf.getId());
			resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		if(resultado<0) return -1;
		return 0;
	}

}
