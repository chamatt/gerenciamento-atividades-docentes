package gerencia.atividades.exceptions;

public class CodigoDocenteEmOrientacaoInvalidoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 38985485346523604L;

	public CodigoDocenteEmOrientacaoInvalidoException(String nome, int codigo) {
		System.out.println("Código de docente inválido na orientação do aluno \"" + nome + "\": " + codigo + ".");
	}
}
