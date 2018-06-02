package exceptions;

public class MatriculaDiscenteRepetidaException extends Exception {
	public MatriculaDiscenteRepetidaException (long codigo) {
		System.out.println("Código repetido para discente: " + codigo + ".");
	}

}
