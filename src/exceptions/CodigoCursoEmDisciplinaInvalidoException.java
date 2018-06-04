package exceptions;

public class CodigoCursoEmDisciplinaInvalidoException extends Exception {
	public CodigoCursoEmDisciplinaInvalidoException(String nome, int codigo) {
		System.out.println("Código de curso inválido na disciplina \"" + nome + "\": " + codigo +".");	
	}
}
