package co.com.eafit.conferre.conferencias.business.base;


import org.json.simple.JSONObject;

import co.com.eafit.conferre.soporte.base.ObjetoTO;
import co.com.eafit.conferre.soporte.excepcion.ExcepcionJson;
public interface JsonTools {
		
		public ObjetoTO mapearJsonAObjetoTO(JSONObject json) throws ExcepcionJson;
		public JSONObject mapearObjetoTOAJson(ObjetoTO param) throws ExcepcionJson;


}
