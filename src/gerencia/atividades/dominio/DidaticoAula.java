package gerencia.atividades.dominio;

import java.io.Serializable;

public class DidaticoAula extends Atividade implements Serializable {

	private static final long serialVersionUID = -626474807503235303L;
	private String codigo;
	private String nome;
	private int CHSemestral;
	private int codigoDoCurso;
	private Docente docente;

	public DidaticoAula(String codigo, String nome, int codigoDoDocente, int CHSemanal, int CHSemestral,
			int codigoDoCurso) {

		this.codigo = codigo;
		this.nome = nome;
		this.CHSemestral = CHSemestral;
		this.codigoDoCurso = codigoDoCurso;
		this.codigoDoDocente = codigoDoDocente;
		this.CHSemanal = CHSemanal;

	}

	@Override
	public String toString() {
		return "Didatico-Aula " + nome + " " + codigo + " " + codigoDoDocente + " " + CHSemanal + " " + CHSemestral
				+ " " + codigoDoCurso;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public int getCodigoDoCurso() {
		return codigoDoCurso;
	}

	public int getCHSemestral() {
		return CHSemestral;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Docente getDocente() {
		return docente;
	}
}
