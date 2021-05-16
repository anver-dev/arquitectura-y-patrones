package mx.uam.is.practicadiseno.datos;

import java.util.ArrayList;
import java.util.List;

public class MapeadorDatosImpl implements MapeadorDatos {

	// La estructura que contiene los datos
	private List<String> datos = new ArrayList<String>();

	/**
	 * Constructor donde se agregan datos iniciales.
	 */
	public MapeadorDatosImpl() {
		datos.add("Entrada 1");
		datos.add("Entrada 2");
		datos.add("Entrada 3");
	}

	/**
	 * Agrega una dato
	 * 
	 * @param dato que se agrega
	 * @return true si el dato es agregado, false si no
	 */
	public boolean agrega(String dato) {
		if (!dato.equals("") && !datos.contains(dato)) {
			datos.add(dato);
			return true;
		}
		return false;
	}

	/**
	 * Borra un dato de la lista de objetos
	 * 
	 * @param dato a borrar
	 * @return true si el dato es eliminado false si no
	 */
	public boolean borra(String dato) {
		return datos.remove(dato);
	}

	/**
	 * Recupera los datos
	 *
	 * @return la lista de datos
	 */
	public String[] dameDatos() {
		// Convierte la lista a un arreglo de cadenas y lo regresa
		String arregloDatos[] = new String[datos.size()];
		datos.toArray(arregloDatos);
		return arregloDatos;
	}

	@Override
	public boolean contiene(String dato) {
		// TODO Auto-generated method stub
		return false;
	}

}
