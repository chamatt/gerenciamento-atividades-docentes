package gerencia.atividades.exceptions;

public class CodigoDocenteRepetidoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2408073136608738459L;

	public CodigoDocenteRepetidoException(int codigo) {
		System.out.println("Código repetido para docente: " + codigo + ".");
	}
}
