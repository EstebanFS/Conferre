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
import co.com.eafit.conferre.soporte.to.ClienteTO;

public class ClienteDAO implements DAOGenerico {

	java.sql.Connection conn;
	
	public ClienteDAO(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public ObjetoTO create(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		ClienteTO conf = (ClienteTO) parametro;
		try {
			PreparedStatement prep = conn.prepareStatement("INSERT INTO "
					+ "clientes values(?,?,?,?,?)");
			prep.setInt(1, conf.getIdentificacion());
			prep.setString(2, conf.getNombre());
			prep.setInt(3, conf.getNumeroCelular());
			prep.setString(4, conf.getCorreo());
			prep.setString(5, conf.getContrasena());
			int resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return null;
	}

	@Override
	public List<ObjetoTO> recuperar(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		
		List<ObjetoTO> clientesRecuperadas = new ArrayList<ObjetoTO>();
		ClienteTO conf = (ClienteTO) parametro;
		try {
			PreparedStatement prep = conn.prepareStatement("SELECT * FROM"
					+ " clientes WHERE identificacion=? OR "
					+ "numero_celular=? OR correo=?");
			prep.setInt(1, conf.getIdentificacion());
			prep.setInt(2, conf.getNumeroCelular());
			prep.setString(3, conf.getCorreo());
			ResultSet resultado = prep.executeQuery();
			while(resultado.next()){
				ClienteTO cliente = new ClienteTO();
				cliente.setIdentificacion(resultado.getInt("identificacion"));
				cliente.setNombre(resultado.getString("nombre"));
				cliente.setNumeroCelular(resultado.getInt("numero_celular"));
				cliente.setCorreo(resultado.getString("correo"));
				cliente.setContrasena(resultado.getString("contrasena"));
				clientesRecuperadas.add(cliente);
			}
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return clientesRecuperadas;
	}

	@Override
	public ObjetoTO update(ObjetoTO nuevoObjeto) throws ExcepcionTransferenciaDAO {
		ClienteTO conf = (ClienteTO) nuevoObjeto;
		try {
			PreparedStatement prep = conn.prepareStatement("UPDATE clientes"
					+ " SET identificacion=?, nombre=?, numero_celular=?,"
					+ " correo=?, contrasena=? WHERE identificacion=?");
			prep.setInt(1, conf.getIdentificacion());
			prep.setString(2, conf.getNombre());
			prep.setInt(3, conf.getNumeroCelular());
			prep.setString(4, conf.getCorreo());
			prep.setString(5, conf.getContrasena());
			prep.setInt(6, conf.getIdentificacion());
			int resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return null;
	}

	@Override
	public int borrar(ObjetoTO objetoABorrar) throws ExcepcionTransferenciaDAO {
		ClienteTO conf = (ClienteTO) objetoABorrar;
		int resultado = -200;
		try {
			PreparedStatement prep = conn.prepareStatement("DELETE FROM "
					+ "clientes WHERE identificacion=?");
			prep.setInt(1, conf.getIdentificacion());
			resultado = prep.executeUpdate();
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		if(resultado<0) return -1;
		return 0;
	}

}
