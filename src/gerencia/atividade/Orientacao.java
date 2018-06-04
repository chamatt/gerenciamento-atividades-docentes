package gerencia.atividade;

import java.io.Serializable;

public abstract class Orientacao extends Atividade implements Serializable{

	protected int matriculaDoDiscente;
	
	public int getMatriculaDoDiscente()
	{
		return matriculaDoDiscente;
	}
}
