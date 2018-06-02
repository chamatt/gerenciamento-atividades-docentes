package exceptions;

public class CodigoDocenteEmDisciplinaInvalidoException extends Exception {
	public CodigoDocenteEmDisciplinaInvalidoException(String nome, int codigo) {
		System.out.println("Código de docente inválido na disciplina " + nome + ":" + codigo +".");	
	}
}
