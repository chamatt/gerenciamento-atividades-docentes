package gerencia.atividades.exceptions;

public class CodigoCursoEmDisciplinaInvalidoException extends Exception {

	private static final long serialVersionUID = -5174626717663338237L;

	public CodigoCursoEmDisciplinaInvalidoException(String nome, int codigo) {
		System.out.println("Código de curso inválido na disciplina \"" + nome + "\": " + codigo + ".");
	}
}
