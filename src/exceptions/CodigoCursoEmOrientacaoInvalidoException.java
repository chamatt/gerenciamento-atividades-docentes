package exceptions;

public class CodigoCursoEmOrientacaoInvalidoException extends Exception {
	public CodigoCursoEmOrientacaoInvalidoException(String nome, int codigo) {
		System.out.println("Código de curso inválido na orientação do aluno \"" + nome + "\": " + codigo +".");	
	}
}
