package gerencia.atividades.exceptions;

public class CodigoCursoEmOrientacaoInvalidoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9210964494850463131L;

	public CodigoCursoEmOrientacaoInvalidoException(String nome, int codigo) {
		System.out.println("Código de curso inválido na orientação do aluno \"" + nome + "\": " + codigo + ".");
	}
}
