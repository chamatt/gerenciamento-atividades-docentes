package gerencia.atividade;

public class ProducaoCientifica {

	private String titulo;
	private int codigoDoDocente;
	private boolean qualificada;
	
	public ProducaoCientifica(int codigoDoDocente,String titulo,boolean qualificada) 
	{
		this.titulo = titulo;
		this.codigoDoDocente = codigoDoDocente;
		this.qualificada = qualificada;
	}
}
