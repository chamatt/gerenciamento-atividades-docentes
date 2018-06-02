package exceptions;

public class CodigoDocenteEmPublicacaoInvalidoException extends Exception {
	public CodigoDocenteEmPublicacaoInvalidoException(String nome, int codigo) {
		System.out.println("Código de docente inválido na publicação " + nome + ": " + codigo +".");	
	}
}
