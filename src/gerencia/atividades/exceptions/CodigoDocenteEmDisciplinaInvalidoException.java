package gerencia.atividades.exceptions;

public class CodigoDocenteEmDisciplinaInvalidoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2350940417794588676L;

	public CodigoDocenteEmDisciplinaInvalidoException(String nome, int codigo) {
		System.out.println("Código de docente inválido na disciplina \"" + nome + "\": " + codigo + ".");
	}
}
