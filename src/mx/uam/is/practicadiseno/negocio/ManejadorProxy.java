package mx.uam.is.practicadiseno.negocio;

public class ManejadorProxy implements Manejador {

	private Manejador manejador;
	
	/**
	 * Constructor que inicializa el manejador
	 * 
	 * @param manejador
	 *
	 */
	public ManejadorProxy(Manejador manejador) {
		super();
		this.manejador = manejador;
	}
	
	/**
	 * Recupera los datos
	 *
	 * @return la lista de datos
	 */
	@Override
	public String[] dameDatos() {
		System.out.println("Se invoco el metodo dameDatos()");
		return this.manejador.dameDatos();
	}
	
	/**
	 * Agrega un dato mientras no este vacio y no este ya en la lista
	 *
	 * @param dato el dato a agregar
	 * @return true si se agrego exitosamente false sino
	 */
	@Override
	public boolean agrega(String dato) {
		System.out.println("Se invoco el metodo agrega()");
		return this.manejador.agrega(dato);
	}
	
	/**
	 * Borra un dato de la list
	 *
	 * @param dato el dato a borrar
	 * @return true si se borro exitosamente, false sino
	 */
	@Override
	public boolean borra(String dato) {
		System.out.println("Se invoco el metodo borra()");
		return this.manejador.borra(dato);
	}
	
	/**
	 * Agrega un observador a la lista de observadores
	 * 
	 * @param o observador que se agrega
	 * @return true si se agrega, false si no
	 */
	@Override
	public boolean agregaObservador(Observador o) {
		System.out.println("Se invoco el metodo agregaObservador()");
		return this.manejador.agregaObservador(o);
	}
	
	/**
	 * Quita un observador de la lista de observadores
	 * 
	 * @param o observador a quitar
	 * @return true si se elimina, false si no.
	 */
	@Override
	public boolean quitaObservador(Observador o) {
		System.out.println("Se invoco el metodo quitaObservador()");
		return this.manejador.quitaObservador(o);
	}
	
	/**
	 * Finaliza una ventana, si no hay ventanas finaliza el programa
	 * @return alse si aun hay observadores
	 */
	@Override
	public boolean finaliza() {
		System.out.println("El programa finalizo");
		return this.manejador.finaliza();
	}

}
