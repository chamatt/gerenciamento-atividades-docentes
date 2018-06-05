package gerencia.atividades.dominio;

import java.io.Serializable;

public abstract class Orientacao extends Atividade implements Serializable {

	private static final long serialVersionUID = -8368703698176285579L;
	protected int matriculaDoDiscente;

	public int getMatriculaDoDiscente() {
		return matriculaDoDiscente;
	}
}
