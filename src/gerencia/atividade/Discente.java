package gerencia.atividade;

public class Discente {
	
	private long matricula;
	private String nome;
	private int codigoDoCurso;
	
	public Discente(long matricula, String nome, int codigoDoCurso) 
	{
		this.matricula = matricula;
		this.nome = nome;
		this.codigoDoCurso = codigoDoCurso;
		
	}
	
	@Override
	public String toString()
	{
		return "Discente " + nome + " " + matricula + " " + codigoDoCurso;
	}

	public long getMatricula() 
	{
		return matricula;
	}
	
	public String getNome()
	{
		return nome;
	}
	

}
