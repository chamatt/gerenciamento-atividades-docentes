package exceptions;

public class NivelCursoInconsistenteException extends Exception {
	public NivelCursoInconsistenteException(String nome, int codigo) {
		System.out.println("Inconsistência ao definir o nível do curso: " + codigo  + " - " + nome +".");	
	}
}
