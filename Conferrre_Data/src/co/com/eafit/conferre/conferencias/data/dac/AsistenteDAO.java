package co.com.eafit.conferre.conferencias.data.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.com.eafit.conferre.conferencias.data.base.DAOGenerico;
import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.conferencias.data.to.AsistenteTO;
import co.com.eafit.conferre.soporte.ExcepcionTransferenciaDAO;

public class AsistenteDAO implements DAOGenerico {
	
	java.sql.Connection conn;
	
	public AsistenteDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public ObjetoTO create(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		AsistenteTO conf = (AsistenteTO)parametro;
		try {
			PreparedStatement prep = conn.prepareStatement("INSERT INTO "
												+ "asistentes values(?,?,?,?)");
			prep.setInt(1, conf.getIdentificacion());
			prep.setString(2, conf.getNombre());
			prep.setInt(3, conf.getNumeroCelular());
			prep.setString(4, conf.getCorreo());
			int resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return null;
	}

	@Override
	public List<ObjetoTO> recuperar(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		
		List<ObjetoTO> asistentesRecuperadas = new ArrayList<ObjetoTO>();
		try {
			AsistenteTO conf = (AsistenteTO) parametro;
			PreparedStatement prep = conn.prepareStatement("SELECT * FROM "
					+ "asistentes WHERE identificacion=? "
					+ "OR numero_celular=? OR correo=?");
			prep.setInt(1, conf.getIdentificacion());
			prep.setInt(2, conf.getNumeroCelular());
			prep.setString(3, conf.getCorreo());
			ResultSet resultado = prep.executeQuery();
			while(resultado.next()){
				AsistenteTO asistente = new AsistenteTO();
				asistente.setIdentificacion(resultado.getInt("identificacion"));
				asistente.setNombre(resultado.getString("nombre"));
				asistente.setNumeroCelular(resultado.getInt("numero_celular"));
				asistente.setCorreo(resultado.getString("correo"));
				asistentesRecuperadas.add(asistente);
			}
			
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return asistentesRecuperadas;
	}

	@Override
	public ObjetoTO update(ObjetoTO nuevoObjeto) throws ExcepcionTransferenciaDAO {
		
		try {
			AsistenteTO conf = (AsistenteTO) nuevoObjeto;
			PreparedStatement prep = conn.prepareStatement("UPDATE asistentes"
					+ " SET identificacion=?, nombre=?, numero_celular=?, "
					+ "correo=? WHERE identificacion=?");
			prep.setInt(1, conf.getIdentificacion());
			prep.setString(2, conf.getNombre());
			prep.setInt(3, conf.getNumeroCelular());
			prep.setString(4, conf.getCorreo());
			prep.setInt(5, conf.getIdentificacion());
			int resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return null;
	}

	@Override
	public int borrar(ObjetoTO objetoABorrar) throws ExcepcionTransferenciaDAO {
		
		AsistenteTO conf = (AsistenteTO) objetoABorrar;
		int resultado = -200;
		try {
			PreparedStatement prep = conn.prepareStatement("DELETE FROM "
					+ "asistentes WHERE identificacion=?");
			prep.setInt(1, conf.getIdentificacion());
			resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		if(resultado < 0) return -1;
		return 0;
	}
}
