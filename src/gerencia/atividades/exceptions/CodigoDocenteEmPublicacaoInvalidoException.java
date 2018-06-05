package gerencia.atividades.exceptions;

public class CodigoDocenteEmPublicacaoInvalidoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1509082744617938269L;

	public CodigoDocenteEmPublicacaoInvalidoException(String nome, int codigo) {
		System.out.println("Código de docente inválido na publicação \"" + nome + "\": " + codigo + ".");
	}
}
