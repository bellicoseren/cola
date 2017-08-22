package excepcion;

public class Desbordamiento extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Desbordamiento(String mensaje){
		super(mensaje);
	}
}
