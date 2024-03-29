package gerencia.atividades.dominio;

import java.io.Serializable;

public class Discente implements Serializable {

	private static final long serialVersionUID = 2622587243642858002L;
	private long matricula;
	private String nome;
	private int codigoDoCurso;
	private PosGraduacao posGraduacao;

	public Discente(long matricula, String nome, int codigoDoCurso) {
		this.matricula = matricula;
		this.nome = nome;
		this.codigoDoCurso = codigoDoCurso;

	}

	@Override
	public String toString() {
		return "Discente " + nome + " " + matricula + " " + codigoDoCurso;
	}

	public long getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setPosGraduacao(PosGraduacao posGraduacao) {
		this.posGraduacao = posGraduacao;
	}

	public PosGraduacao getPosGraduacao() {
		return posGraduacao;
	}

}
