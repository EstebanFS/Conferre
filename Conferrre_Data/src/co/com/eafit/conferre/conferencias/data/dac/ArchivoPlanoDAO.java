package co.com.eafit.conferre.conferencias.data.dac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.com.eafit.conferre.soporte.to.EspacioTO;

public class ArchivoPlanoDAO {
	
	public List<EspacioTO> leerArchivoPlano() throws FileNotFoundException{
		Scanner in = new Scanner(new File("lugares.txt"));
		List<EspacioTO> espacios = new ArrayList<EspacioTO>();
		while(in.hasNextLine()){
			EspacioTO actual = new EspacioTO();
			String lugar = in.nextLine();
			actual.setId(in.next());
			in.nextLine();
			actual.setNombre(in.nextLine());
			actual.setSillasDisponibles(in.nextInt());
			in.nextLine();
			actual.setDireccion(in.nextLine());
			actual.setReservado(in.nextBoolean());
			in.nextLine();
			espacios.add(actual);
		}
		return espacios;
	}

}
