package gerencia.atividade;

import java.util.List;

public class Docente {

	private String nome;
	private int codigo;
	private String departamento;
	private int totalHorasSemanaisAula = 0;
	private int totalHorasSemestraisAula = 0;
	private int totalHorasSemanaisOrientacao = 0;
	
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
	
	public int getCodigo()
	{
		return codigo;
	}
	
	public void calcularTotalHoras(List<DidaticoAula> aulas, List<Orientacao> graduacoes, List<Orientacao> posgraduacoes)
	{
		for(DidaticoAula d : aulas) {
			if(codigo == d.getCodigoDocente()) {
				totalHorasSemanaisAula += d.getCHSemanal();
				totalHorasSemestraisAula += d.getCHSemestral();
			}
		}
		for(Orientacao o : graduacoes) {
			if(codigo == o.getCodigoDocente()) {
				totalHorasSemanaisOrientacao += o.getCHSemanal();
			}
		}
		for(Orientacao o : posgraduacoes) {
			if(codigo == o.getCodigoDocente()) {
				totalHorasSemanaisOrientacao += o.getCHSemanal();
			}
		}
	}
}
