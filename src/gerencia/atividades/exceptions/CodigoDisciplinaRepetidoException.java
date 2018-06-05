package gerencia.atividades.exceptions;

public class CodigoDisciplinaRepetidoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1494987195269748977L;

	public CodigoDisciplinaRepetidoException(String codigo) {
		System.out.println("Código repetido para disciplina: " + codigo + ".");
	}
}
