package gerencia.atividades.dominio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PosGraduacao extends Orientacao implements Serializable {

	private static final long serialVersionUID = -8679884263918335652L;
	Date dataDeIngresso;
	String nomeDoPrograma;

	public PosGraduacao(int codigoDoDocente, int matriculaDoDiscente, Date dataDeIngresso, String nomeDoPrograma,
			int CHSemanal) {

		this.codigoDoDocente = codigoDoDocente;
		this.matriculaDoDiscente = matriculaDoDiscente;
		this.dataDeIngresso = dataDeIngresso;
		this.nomeDoPrograma = nomeDoPrograma;
		this.CHSemanal = CHSemanal;

	}

	@Override
	public String toString() {
		return "Graduacao " + nomeDoPrograma + " " + codigoDoDocente + " " + matriculaDoDiscente + " "
				+ new SimpleDateFormat("dd/MM/yyyy").format(dataDeIngresso) + " " + CHSemanal;
	}

	public Date getDataDeIngresso() {
		return dataDeIngresso;
	}

	public String getNomeDoPrograma() {
		return nomeDoPrograma;
	}
}
