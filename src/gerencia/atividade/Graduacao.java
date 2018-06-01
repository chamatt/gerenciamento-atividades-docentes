package gerencia.atividade;

public class Graduacao extends Orientacao{

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
}
