package gerencia.atividade;

import java.io.File;

public class Arquivos {
	protected File docentes;
	protected File discentes;
	protected File producaoCientifica;
	protected File cursos;
	protected File disciplinas;
	protected File orientacaoGraducao;
	protected File orientacaoPos;
	protected boolean writeOnly = false;
	protected boolean readOnly = false;
	
	
	public Arquivos(String[] args) {
		for(int i = 0; i < args.length; i++) {
			if(args[i] == "-d") {
				docentes = new File(args[i+1]);
			}
			if(args[i] == "-a") {
				discentes = new File(args[i+1]);
			}
			if(args[i] == "-p") {
				producaoCientifica = new File(args[i+1]);
			}
			if(args[i] == "-c") {
				cursos = new File(args[i+1]);
			}
			if(args[i] == "-r") {
				disciplinas = new File(args[i+1]);
			}
			if(args[i] == "-og") {
				orientacaoGraducao = new File(args[i+1]);
			}
			if(args[i] == "-op") {
				orientacaoPos = new File(args[i+1]);
			}
			if(args[i] == "--read-only") {
				orientacaoPos = new File(args[i+1]);
			}
			if(args[i] == "--write-only") {
				orientacaoPos = new File(args[i+1]);
			}
		}
		
	}
			
			
	public boolean isWriteOnly() {
		return writeOnly;
	}
	
	public boolean isReadOnly() {
		return readOnly;
	}
	
	
}
