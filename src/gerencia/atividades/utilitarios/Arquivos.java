package gerencia.atividades.utilitarios;

import java.io.File;

public class Arquivos {
	protected File docentes;
	protected File discentes;
	protected File producaoCientifica;
	protected File cursos;
	protected File didaticoAulas;
	protected File orientacaoGraducao;
	protected File orientacaoPos;
	protected boolean writeOnly = false;
	protected boolean readOnly = false;
	protected String outputPath;

	public Arquivos(String[] args) {
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-d")) {
				docentes = new File(args[i + 1]);
			}
			if (args[i].equals("-a")) {
				discentes = new File(args[i + 1]);
			}
			if (args[i].equals("-p")) {
				producaoCientifica = new File(args[i + 1]);
			}
			if (args[i].equals("-c")) {
				cursos = new File(args[i + 1]);
			}
			if (args[i].equals("-r")) {
				didaticoAulas = new File(args[i + 1]);
			}
			if (args[i].equals("-og")) {
				orientacaoGraducao = new File(args[i + 1]);
			}
			if (args[i].equals("-op")) {
				orientacaoPos = new File(args[i + 1]);
			}
			if (args[i].equals("--read-only")) {
				readOnly = true;
			}
			if (args[i].equals("--write-only")) {
				writeOnly = true;
			}
			outputPath = "";
		}

	}

	public File getDocentes() {
		return docentes;
	}

	public File getDiscentes() {
		return discentes;
	}

	public File getProducaoCientifica() {
		return producaoCientifica;
	}

	public void setDocentes(File docentes) {
		this.docentes = docentes;
	}

	public void setDiscentes(File discentes) {
		this.discentes = discentes;
	}

	public void setProducaoCientifica(File producaoCientifica) {
		this.producaoCientifica = producaoCientifica;
	}

	public void setCursos(File cursos) {
		this.cursos = cursos;
	}

	public void setDidaticoAulas(File didaticoAulas) {
		this.didaticoAulas = didaticoAulas;
	}

	public void setOrientacaoGraducao(File orientacaoGraducao) {
		this.orientacaoGraducao = orientacaoGraducao;
	}

	public void setOrientacaoPos(File orientacaoPos) {
		this.orientacaoPos = orientacaoPos;
	}

	public void setWriteOnly(boolean writeOnly) {
		this.writeOnly = writeOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public File getCursos() {
		return cursos;
	}

	public File getDidaticoAulas() {
		return didaticoAulas;
	}

	public File getOrientacaoGraducao() {
		return orientacaoGraducao;
	}

	public File getOrientacaoPos() {
		return orientacaoPos;
	}

	public boolean isWriteOnly() {
		return writeOnly;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setOutputPath(String caminho) {
		outputPath = caminho;
		
	}

}
