package mx.uam.is.practicadiseno.negocio;

import java.util.ArrayList;
import java.util.List;

import mx.uam.is.practicadiseno.datos.MapeadorDatos;

public class ManejadorImpl implements Manejador {

	private MapeadorDatos mapeador;
	private List<Observador> listaObservadores = new ArrayList<Observador>();

	/**
	 * Constructor que inicializa el mapeador
	 * 
	 * @param mapeador
	 *
	 */
	public ManejadorImpl(MapeadorDatos mapeador) {
		this.mapeador = mapeador;
	}

	/**
	 * Recupera los datos
	 *
	 * @return la lista de datos
	 */
	public String[] dameDatos() {
		return this.mapeador.dameDatos();
	}

	/**
	 * Agrega un dato mientras no este vacio y no este ya en la lista
	 *
	 * @param dato el dato a agregar
	 * @return true si se agrego exitosamente false sino
	 */
	public boolean agrega(String dato) {
		boolean resultadoAgregar = this.mapeador.agrega(dato);
		if (resultadoAgregar) {
			notifica();
			return true;
		}
		return false;
	}

	/**
	 * Borra un dato de la list
	 *
	 * @param dato el dato a borrar
	 * @return true si se borro exitosamente, false sino
	 */
	public boolean borra(String dato) {
		boolean resultadoBorrar = this.mapeador.borra(dato);
		if (resultadoBorrar) {
			notifica();
			return true;
		}
		return false;
	}

	/**
	 * Agrega un observador a la lista de observadores
	 * 
	 * @param o observador que se agrega
	 * @return true si se agrega, false si no
	 */
	public boolean agregaObservador(Observador o) {
		if (o != null && !listaObservadores.contains(o)) {
			listaObservadores.add(o);
			notifica();
			return true;
		}
		return false;
	}

	/**
	 * Quita un observador de la lista de observadores
	 * 
	 * @param o observador a quitar
	 * @return true si se elimina, false si no.
	 */
	public boolean quitaObservador(Observador o) {
		boolean resultadoQuitarObservador = listaObservadores.remove(o);
		if (listaObservadores.isEmpty())
			finaliza();
		return resultadoQuitarObservador;
	}

	/**
	 * Se encarga de actualizar a los observadores
	 */
	private void notifica() {
		for (Observador observador : listaObservadores) {
			observador.actualiza();
		}
	}

	/**
	 * Se encarga de finalizar el programa
	 *
	 */
	public void finaliza() {
		System.exit(0);
	}
}
