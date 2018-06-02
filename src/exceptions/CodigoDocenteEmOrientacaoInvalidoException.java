package exceptions;

public class CodigoDocenteEmOrientacaoInvalidoException extends Exception {
	public CodigoDocenteEmOrientacaoInvalidoException(String nome, int codigo) {
		System.out.println("Código de docente inválido na orientaçao do aluno " + nome + ": " + codigo +".");	
	}
}
