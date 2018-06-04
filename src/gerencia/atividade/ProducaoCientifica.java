package gerencia.atividade;

import java.io.Serializable;

public class ProducaoCientifica implements Serializable {
 
	private String titulo;
	private int codigoDoDocente;
	private boolean qualificada;
	
	public ProducaoCientifica(int codigoDoDocente,String titulo,boolean qualificada) 
	{
		this.titulo = titulo;
		this.codigoDoDocente = codigoDoDocente;
		this.qualificada = qualificada;
	}
	
	@Override
	public String toString()
	{
		return "Produção Científica " + titulo + " " + codigoDoDocente + " " +
				qualificada;
	}
	
	public String getTitulo()
	{
		return titulo;
	}
	
	public int getCodigoDoDocente()
	{
		return codigoDoDocente;
	}
	
	public boolean isQualificada()
	{
		return qualificada;
	}
}
