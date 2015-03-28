package co.com.eafit.conferre.conferencias.data.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.com.eafit.conferre.conferencias.data.dac.ApiTransferenciaDAO;
import co.com.eafit.conferre.conferencias.data.dac.AsistenteDAO;
import co.com.eafit.conferre.conferencias.data.dac.AsistenteEventoDAO;
import co.com.eafit.conferre.conferencias.data.dac.ClienteConferenciaDAO;
import co.com.eafit.conferre.conferencias.data.dac.ClienteDAO;
import co.com.eafit.conferre.conferencias.data.dac.ConferenciaDAO;
import co.com.eafit.conferre.conferencias.data.dac.ConferenciaEventoDAO;
import co.com.eafit.conferre.conferencias.data.dac.EspacioDAO;
import co.com.eafit.conferre.conferencias.data.dac.EventoDAO;
import co.com.eafit.conferre.conferencias.data.dac.EventoEspacioDAO;
import co.com.eafit.conferre.conferencias.data.dac.ListaDeEsperaDAO;
import co.com.eafit.conferre.conferencias.data.dac.SillaDAO;
import co.com.eafit.conferre.conferencias.data.dac.SillaEspacioDAO;


public class FabricaDAO {
	
	private static String nombreDB;
	private static String usuario;
	private static String contasena;
	private static Connection conn;
	
	public FabricaDAO(String nombreDB, String usuario, String contrasena){
		FabricaDAO.nombreDB = nombreDB;
		FabricaDAO.usuario = usuario;
		FabricaDAO.contasena = contrasena;
		FabricaDAO.conn = null;
	}
	
	/**
	 * @return the nombreDB
	 */
	public static String getNombreDB() {
		return nombreDB;
	}

	/**
	 * @param nombreDB the nombreDB to set
	 */
	public static void setNombreDB(String nombreDB) {
		FabricaDAO.nombreDB = nombreDB;
	}

	/**
	 * @return the usuario
	 */
	public static String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public static void setUsuario(String usuario) {
		FabricaDAO.usuario = usuario;
	}

	/**
	 * @return the contasena
	 */
	public static String getContasena() {
		return contasena;
	}

	/**
	 * @param contasena the contasena to set
	 */
	public static void setContasena(String contasena) {
		FabricaDAO.contasena = contasena;
	}

	public static AsistenteDAO createAsistenteDAO() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		return new AsistenteDAO(getConnection());
	}
	
	public static ClienteDAO createClienteDAO() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		return new ClienteDAO(getConnection());
	}
	
	public static ConferenciaDAO createConferenciaDAO() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		return new ConferenciaDAO(getConnection());
	}
	
	public static EspacioDAO createEspacioDAO() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		return new EspacioDAO(getConnection());
	}
	
	public static EventoDAO createEventoDAO() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		return new EventoDAO(getConnection());
	}
	
	public static ListaDeEsperaDAO createListaDeEspera() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		return new ListaDeEsperaDAO(getConnection());
	}
	
	public static SillaDAO createSillaDAO() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		return new SillaDAO(getConnection());
	}
	
	public static AsistenteEventoDAO createAsistenteEventoDAO() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		return new AsistenteEventoDAO(getConnection());
	}
	
	public static ClienteConferenciaDAO createClienteConferenciaDAO() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		return new ClienteConferenciaDAO(getConnection());
	}
	
	public static ConferenciaEventoDAO createConferenciaEventoDAO() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		return new ConferenciaEventoDAO(getConnection());
	}
	
	public static EventoEspacioDAO createEventoEspacioDAO() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		return new EventoEspacioDAO(getConnection());
	}
	
	public static SillaEspacioDAO createSillaEspacioDAO() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		return new SillaEspacioDAO(getConnection());
	}
	
	public static ApiTransferenciaDAO createApiTransferenciaDAO() {
		return new ApiTransferenciaDAO();
	}
	
	public static Connection getConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		if (conn == null) {
			crearConexion();			
		} 
		return conn;
	}

	public static void crearConexion() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.err.println("Error in driver: " + e.getMessage());
            System.exit(0);
        }
        try {
            conn = (Connection)DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + nombreDB, usuario, contasena);
        }
        catch (Exception e) {
            System.err.println("Error to connect to database: " 
                                + e.getMessage());
            System.exit(0);
        }
	}
	
	public static void cerrarConexion(){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
