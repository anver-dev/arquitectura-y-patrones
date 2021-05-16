package mx.uam.is.practicadiseno.negocio;

public class ManejadorProxy implements Manejador {

	private Manejador manejador;

	public ManejadorProxy(Manejador manejador) {
		super();
		this.manejador = manejador;
	}

	@Override
	public String[] dameDatos() {
		System.out.println("Se invoco el metodo dameDatos()");
		return this.manejador.dameDatos();
	}

	@Override
	public boolean agrega(String dato) {
		System.out.println("Se invoco el metodo agrega()");
		return this.manejador.agrega(dato);
	}

	@Override
	public boolean borra(String dato) {
		System.out.println("Se invoco el metodo borra()");
		return this.manejador.borra(dato);
	}

	@Override
	public boolean agregaObservador(Observador o) {
		System.out.println("Se invoco el metodo agregaObservador()");
		return this.manejador.agregaObservador(o);
	}

	@Override
	public boolean quitaObservador(Observador o) {
		System.out.println("Se invoco el metodo quitaObservador()");
		return this.manejador.quitaObservador(o);
	}

}
