package mx.uam.is.practicadiseno.datos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapeadorDatosImpl implements MapeadorDatos {

	// La estructura que contiene los datos
	private List<String> datos = new ArrayList<String>();

	/**
	 * Constructor donde se agregan datos iniciales.
	 */
	public MapeadorDatosImpl() {
		agrega("Entrada 1");
		agrega("Entrada 2");
		agrega("Entrada 3");
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
			guardaDatosArchivo(datos);
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
		boolean resultadoElimina = datos.remove(dato);
		guardaDatosArchivo(datos);
		return resultadoElimina;
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

	/**
	 * Guarda la lissta d edatos en un archivo
	 * 
	 * @param datos lista de datos a guardar
	 */
	private void guardaDatosArchivo(List<String> datos) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			String ruta = "archivoEjemplo.txt";
			File file = new File(ruta);

			// Si el archivo no existe es creado
			if (!file.exists()) {
				file.createNewFile();
			}
			
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			for (String dato : datos) {
				bw.write(dato + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}