package gerencia.atividade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import utilitarios.PADComparador;

public class Docente implements Serializable {

	private String nome;
	private int codigo;
	private String departamento;
	private List <DidaticoAula> disciplinas = new ArrayList<>();
	private List <Graduacao> graduacao = new ArrayList<>() ;
	private List <PosGraduacao> posGraduacao= new ArrayList<>() ;
	private List <ProducaoCientifica> producoes= new ArrayList<>();
	
	private int totalHorasSemanaisAula = 0;
	private int totalHorasSemestraisAula = 0;
	private int totalHorasSemanaisOrientacao = 0;
	private int numProdQualificadas = 0;
	private int numProdNaoQualificadas = 0;
	
	public Docente(int codigo,String nome,String departamento)
	{
		this.codigo = codigo;
		this.nome = nome;
		this.departamento = departamento;
	}
	
	@Override
	public String toString()
	{
		return "Docente " + nome + " " + codigo + " " + departamento;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public String getDepartamento()
	{
		return departamento;
	}
	
	public int getCodigo()
	{
		return codigo;
	}
	
	public void addListaProducao(ProducaoCientifica prod)
	{
		producoes.add(prod);
	}
	
	public void addListaGraduacao(Graduacao grad)
	{
		graduacao.add(grad);
	}
	
	public void addListaPosGraduacao(PosGraduacao pg)
	{
		posGraduacao.add(pg);
	}
	
	public void addListaDidaticoAula(DidaticoAula disc)
	{
		disciplinas.add(disc);
	}


	
	public List<DidaticoAula> getDisciplinas() {
		return disciplinas;
	}

	public List<Graduacao> getGraduacao() {
		return graduacao;
	}

	public List<PosGraduacao> getPosGraduacao() {
		return posGraduacao;
	}

	public List<ProducaoCientifica> getProducoes() {
		return producoes;
	}


	public void calcularTotalHoras()
	{
		totalHorasSemanaisAula = 0;
		totalHorasSemanaisOrientacao = 0;
		totalHorasSemestraisAula = 0;
		for(DidaticoAula d : disciplinas) 
		{
				totalHorasSemanaisAula += d.getCHSemanal();
				totalHorasSemestraisAula += d.getCHSemestral();
		}
		for(Graduacao g : graduacao) 
		{
				totalHorasSemanaisOrientacao += g.getCHSemanal();
		}
		for(PosGraduacao pg : posGraduacao) 
		{
			totalHorasSemanaisOrientacao += pg.getCHSemanal();
		}
	}
	
	public void calcularProducoesQualificadas()
	{
		numProdQualificadas = 0;
		numProdNaoQualificadas = 0;
		for(ProducaoCientifica prod: producoes)
		{
			if(prod.isQualificada()) numProdQualificadas++;
			else numProdNaoQualificadas++;
		}
	}

	public int getTotalHorasSemanaisAula() {
		return totalHorasSemanaisAula;
	}

	public int getTotalAulasSemestraisAula() {
		return totalHorasSemestraisAula;
	}

	public int getTotalAulasSemanaisOrientacao() {
		return totalHorasSemanaisOrientacao;
	}

	public int getNumProducoesQualificadas() {
		return numProdQualificadas;
	}

	public int getNumProducoesNaoQualificadas() {
		return numProdNaoQualificadas;
	}
}


