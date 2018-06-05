package gerencia.atividades.exceptions;

public class MatriculaDiscenteRepetidaException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7272093916218293583L;

	public MatriculaDiscenteRepetidaException(long codigo) {
		System.out.println("Código repetido para discente: " + codigo + ".");
	}

}
