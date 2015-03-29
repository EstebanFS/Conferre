package co.com.eafit.conferre.conferencias.data.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import co.com.eafit.conferre.conferencias.data.base.DAOGenerico;
import co.com.eafit.conferre.soporte.base.ObjetoTO;
import co.com.eafit.conferre.soporte.excepcion.ExcepcionTransferenciaDAO;
import co.com.eafit.conferre.soporte.to.ListaDeEsperaTO;

public class ListaDeEsperaDAO implements DAOGenerico {
	
	java.sql.Connection conn;
	
	public ListaDeEsperaDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public ObjetoTO create(ObjetoTO parametro) throws ExcepcionTransferenciaDAO {
		ListaDeEsperaTO conf = (ListaDeEsperaTO) parametro;
		try {
			PreparedStatement prep = conn.prepareStatement("INSERT INTO "
					+ "lista_de_espera values(?,?,?,?,?,?,?,?,?,?,?)");
		} catch (SQLException e) {
			throw new ExcepcionTransferenciaDAO(e);
		}
		return null;
	}

	@Override
	public List<ObjetoTO> recuperar(ObjetoTO parametro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjetoTO update(ObjetoTO nuevoObjeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int borrar(ObjetoTO objetoABorrar) {
		// TODO Auto-generated method stub
		return 0;
	}

}
