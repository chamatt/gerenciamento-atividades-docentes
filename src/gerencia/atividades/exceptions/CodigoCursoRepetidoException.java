package gerencia.atividades.exceptions;

public class CodigoCursoRepetidoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6279356300981500703L;

	public CodigoCursoRepetidoException(int codigo) {
		System.out.println("Código repetido para curso: " + codigo + ".");
	}
}
