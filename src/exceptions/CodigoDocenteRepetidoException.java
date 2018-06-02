package exceptions;

public class CodigoDocenteRepetidoException extends Exception {
	public CodigoDocenteRepetidoException (int codigo) {
		System.out.println("Código repetido para docente: " + codigo + ".");
	}
}
