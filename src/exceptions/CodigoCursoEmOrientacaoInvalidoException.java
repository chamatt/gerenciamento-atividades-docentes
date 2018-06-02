package exceptions;

public class CodigoCursoEmOrientacaoInvalidoException extends Exception {
	public CodigoCursoEmOrientacaoInvalidoException(String nome, int codigo) {
		System.out.println("Código de curso inválido na orientacão do aluno " + nome + ": " + codigo +".");	
	}
}
