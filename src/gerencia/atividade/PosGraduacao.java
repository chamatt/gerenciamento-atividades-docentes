package gerencia.atividade;

import java.util.Date;

public class PosGraduacao extends Orientacao{
	
	Date dataDeIngresso;
	String nomeDoPrograma;
	
	public PosGraduacao(int codigoDoDocente,int matriculaDoDiscente,
						Date dataDeIngresso,String nomeDoPrograma,
						int CHSemanal) {
		
		this.codigoDoDocente = codigoDoDocente;
		this.matriculaDoDiscente = matriculaDoDiscente;
		this.dataDeIngresso = dataDeIngresso;
		this.nomeDoPrograma = nomeDoPrograma;
		this.CHSemanal = CHSemanal;
		
	}

	
}
