package co.com.eafit.conferre.soporte.excepcion;

import java.sql.SQLException;

public class ExcepcionTransferenciaDAO extends Exception {
	public ExcepcionTransferenciaDAO(SQLException e){
		super(e);
	}
}
