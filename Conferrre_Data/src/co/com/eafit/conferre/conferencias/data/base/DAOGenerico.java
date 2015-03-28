package co.com.eafit.conferre.conferencias.data.base;

import java.util.List;

import co.com.eafit.conferre.soporte.ExcepcionTransferenciaDAO;

public interface DAOGenerico {

	public ObjetoTO create(ObjetoTO parametro) throws ExcepcionTransferenciaDAO;
	public List<ObjetoTO> recuperar(ObjetoTO parametro) throws ExcepcionTransferenciaDAO;
	public ObjetoTO update(ObjetoTO nuevoObjeto) throws ExcepcionTransferenciaDAO;
	public int borrar(ObjetoTO objetoABorrar) throws ExcepcionTransferenciaDAO;
	
}
