package gerencia.atividades.dominio;

import java.io.Serializable;

public class Graduacao extends Orientacao implements Serializable {

	private static final long serialVersionUID = 6332831191246184512L;
	private int codigoDoCurso;

	public Graduacao(int codigoDoDocente, int matriculaDoDiscente, int codigoDoCurso, int CHSemanal) {
		this.codigoDoDocente = codigoDoDocente;
		this.matriculaDoDiscente = matriculaDoDiscente;
		this.codigoDoCurso = codigoDoCurso;
		this.CHSemanal = CHSemanal;
	}

	@Override
	public String toString() {
		return "Graduacao " + codigoDoDocente + " " + matriculaDoDiscente + " " + codigoDoCurso + " " + CHSemanal;
	}

	public int getCodigoDoCurso() {
		return codigoDoCurso;
	}
}
