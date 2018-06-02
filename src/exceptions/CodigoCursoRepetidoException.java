package exceptions;

public class CodigoCursoRepetidoException extends Exception {
	public CodigoCursoRepetidoException (int codigo) {
		System.out.println("Código repetido para curso: " + codigo + ".");
	}
}
