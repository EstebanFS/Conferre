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
import co.com.eafit.conferre.soporte.to.EspacioTO;

public class EspacioDAO implements DAOGenerico {
	
	java.sql.Connection conn;
	
	public EspacioDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public ObjetoTO create(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		try {
			EspacioTO conf = (EspacioTO) parametro;
			PreparedStatement prep = conn.prepareStatement("INSERT INTO "
										+ "espacios values(?,?,?,?,?)");
			prep.setString(1, conf.getId());
			prep.setString(2, conf.getNombre());
			prep.setInt(3, conf.getSillasDisponibles());
			prep.setString(4, conf.getDireccion());
			prep.setBoolean(5, conf.isReservado());
			int resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return null;
	}

	@Override
	public List<ObjetoTO> recuperar(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		List<ObjetoTO> espaciossRecuperadas = new ArrayList<ObjetoTO>();
		try {
			EspacioTO conf = (EspacioTO) parametro;
			PreparedStatement prep = conn.prepareStatement("SELECT * FROM "
					+ "espacios WHERE id=? OR nombre=? OR direccion=?");
			prep.setString(1, conf.getId());
			prep.setString(2, conf.getNombre());
			prep.setString(3, conf.getDireccion());
			ResultSet resultado = prep.executeQuery();
			while(resultado.next()){
				EspacioTO espacio = new EspacioTO();
				espacio.setId(resultado.getString("id"));
				espacio.setNombre(resultado.getString("nombre"));
				espacio.setSillasDisponibles(resultado.
												getInt("sillas_disponibles"));
				espacio.setDireccion(resultado.getString("direccion"));
				espacio.setReservado(resultado.getBoolean("reservado"));
				espaciossRecuperadas.add(espacio);
			}
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return espaciossRecuperadas;
	}

	@Override
	public ObjetoTO update(ObjetoTO nuevoObjeto) throws ExcepcionTransferenciaDAO {
		EspacioTO conf = (EspacioTO) nuevoObjeto;
		try {
			PreparedStatement prep = conn.prepareStatement("UPDATE espacios "
					+ "SET nombre=?, sillas_disponibles=?, direccion=?, "
					+ "reservado=? WHERE id=?");
			prep.setString(1, conf.getNombre());
			prep.setInt(2, conf.getSillasDisponibles());
			prep.setString(3, conf.getDireccion());
			prep.setBoolean(4, conf.isReservado());
			prep.setString(5, conf.getId());
			int resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return null;
	}

	@Override
	public int borrar(ObjetoTO objetoABorrar) throws ExcepcionTransferenciaDAO {
		EspacioTO conf = (EspacioTO) objetoABorrar;
		int resultado = -200;
		try {
			PreparedStatement prep = conn.prepareStatement("DELETE FROM "
													+ "espacios WHERE id=?");
			prep.setString(1, conf.getId());
			resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		if(resultado<0) return -1;
		return 0;
	}
}
