package gerencia.atividades.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Curso implements Serializable {

	private static final long serialVersionUID = -3939907167672282850L;
	private int codigo;
	private String nome;
	private boolean graduacao;
	private List<Docente> docentes = new ArrayList<>();

	public Curso(int codigo, String nome, boolean graduacao) {
		this.nome = nome;
		this.codigo = codigo;
		this.graduacao = graduacao;
	}

	@Override
	public String toString() {
		return "Curso " + nome + " " + codigo + " " + graduacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public boolean getGraduacao() {
		return graduacao;
	}

	public String getNome() {
		return nome;
	}

	public void addListaDocentes(Docente docente) {
		if (!docentes.contains(docente))
			docentes.add(docente);
	}

	public List<Docente> getListaDocentes() {
		return docentes;
	}

}
