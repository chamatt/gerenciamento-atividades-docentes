package gerencia.atividade;

public class Docente {

	private String nome;
	private int codigo;
	private String departamento;
	
	public Docente(int codigo,String nome,String departamento)
	{
		this.codigo = codigo;
		this.nome = nome;
		this.departamento = departamento;
	}
}
