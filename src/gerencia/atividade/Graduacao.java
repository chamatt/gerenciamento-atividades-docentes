package gerencia.atividade;

import java.io.Serializable;

public class Graduacao extends Orientacao implements Serializable{

	private int codigoDoCurso;
	
	public Graduacao(int codigoDoDocente, int matriculaDoDiscente, int codigoDoCurso, int CHSemanal) 
	{
		this.codigoDoDocente = codigoDoDocente;
		this.matriculaDoDiscente = matriculaDoDiscente;
		this.codigoDoCurso = codigoDoCurso;
		this.CHSemanal = CHSemanal;
	}
	
	@Override
	public String toString()
	{
		return "Graduacao " + codigoDoDocente + " " + matriculaDoDiscente + " " + codigoDoCurso + 
				" " + CHSemanal;
	}
	
	public int getCodigoDoCurso()
	{
		return codigoDoCurso;
	}
}
