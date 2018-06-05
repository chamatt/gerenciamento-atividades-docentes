package gerencia.atividades.exceptions;

public class NivelCursoInconsistenteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3124216457897339499L;

	public NivelCursoInconsistenteException(String nome, int codigo) {
		System.out.println("Inconsistência ao definir o nível do curso: " + codigo + " - " + nome + ".");
	}
}
