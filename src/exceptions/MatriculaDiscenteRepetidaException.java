package exceptions;

public class MatriculaDiscenteRepetidaException extends Exception {
	public MatriculaDiscenteRepetidaException (int codigo) {
		System.out.println("Código repetido para discente: " + codigo + ".");
	}

}
