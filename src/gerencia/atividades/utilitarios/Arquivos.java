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

	@Override
	public String toString() {
		return "Hello";

	}

}
