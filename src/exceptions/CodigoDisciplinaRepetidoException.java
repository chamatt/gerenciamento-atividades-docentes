package exceptions;

public class CodigoDisciplinaRepetidoException extends Exception {
	public CodigoDisciplinaRepetidoException (String codigo) {
		System.out.println("Código repetido para disciplina: " + codigo + ".");
	}
}
