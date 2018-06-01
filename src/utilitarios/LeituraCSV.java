package utilitarios;

import gerencia.atividade.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class LeituraCSV {
	Arquivos arquivos;
	
	
	public LeituraCSV(Arquivos arquivos) {
		this.arquivos = arquivos;
		
	}
	
	
	public String[] leLinha(Scanner sc) {
		String all = sc.nextLine();
		String[] propriedades = all.split(";");
		return propriedades;
	}

	//Docente(codigo:int, nome:String, departamento:String)
	public List<Docente> leDocentes() throws FileNotFoundException {
		
		Scanner scanner = null;
	
		scanner = new Scanner(new FileReader(arquivos.getDocentes()));
		List<Docente> docentes = new ArrayList<Docente>();
		while(scanner.hasNextLine()) {
			
			String[] propriedades = leLinha(scanner);
					
			int codigo = Integer.parseInt(propriedades[0]);
			String nome = propriedades[1];
			String departamento = propriedades[2];
					
			Docente docente = new Docente(codigo, nome, departamento);
			docentes.add(docente);
			
		}
				
		if (scanner != null) 
		{
			scanner.close();
		}	
			
			
		return docentes;
	}
	
	//Discente(<matricula>:int;<nome>:String;<c�digo do curso>:int)
	public List<Discente> leDiscentes() throws FileNotFoundException{
		Scanner scanner = new Scanner( new FileReader(arquivos.getDiscentes()));
		List<Discente> discentes = new ArrayList<Discente>();
		while(scanner.hasNextLine()) {
			String[] propriedades = leLinha(scanner);
			
			long matricula = Integer.parseInt(propriedades[0]);
			String nome = propriedades[1];
			int codigoCurso = Integer.parseInt(propriedades[2]);
			
			Discente discente = new Discente(matricula, nome, codigoCurso);
			discentes.add(discente);
		}
		scanner.close();
		return discentes;
	}
	
	// <c�digo docente>:int;<titulo da publicacao>:String;<qualificada?>:Boolean
	public List<ProducaoCientifica> leProducoesCientificas() throws FileNotFoundException{
		Scanner scanner = new Scanner( new FileReader(arquivos.getProducaoCientifica()));
		List<ProducaoCientifica> producoesCientificas = new ArrayList<ProducaoCientifica>();
		while(scanner.hasNextLine()) {
			String[] propriedades = leLinha(scanner);
			int codigoDocente = Integer.parseInt(propriedades[0]);
			String tituloDaPublicacao = propriedades[1];
			boolean qualificada = (propriedades[2] == "X") ? true : false;
			
			ProducaoCientifica producaoCientifica = new ProducaoCientifica(codigoDocente, tituloDaPublicacao, qualificada);
			producoesCientificas.add(producaoCientifica);
		}
		scanner.close();
		return producoesCientificas;
	}
	
	
	//<c�digo do curso>;<nome do curso>;<gradua��o?>;<p�s-gradua��o?> <- FIX THIS, ainda nao sei como sera tratado o construtor desse
	public List<Curso> leCursos() throws FileNotFoundException{
		Scanner scanner = new Scanner( new FileReader(arquivos.getCursos()));
		List<Curso> cursos = new ArrayList<Curso>();
		while(scanner.hasNextLine()) {
			String[] propriedades = leLinha(scanner);
			
			int codigo = Integer.parseInt(propriedades[0]);
			String nome = propriedades[1];
			boolean graduacao = (propriedades[2] == "X") ? true : false;
			boolean posGraduacao = (propriedades[3] == "X") ? true : false;
			
			Curso curso = new Curso(codigo, nome, graduacao);
			cursos.add(curso);
		}
		scanner.close();
		return cursos;
	}
	
	
	//<c�digo>:String;<nome>:String;<c�digo docente>:int;<carga hor�ria semanal>:int;<cargahoraria semestral>:int;<c�digo do curso>:int
	public List<DidaticoAula> leDidaticoAulas() throws FileNotFoundException{
		Scanner scanner = new Scanner(new FileReader(arquivos.getDidaticoAulas()));
		List<DidaticoAula> didaticoAulas = new ArrayList<DidaticoAula>();
		while(scanner.hasNextLine()) {
			String[] propriedades = leLinha(scanner);
			
			String codigo = propriedades[0];
			String nome = propriedades[1];
			int codigoDocente = Integer.parseInt(propriedades[2]);
			int cargaSemanal = Integer.parseInt(propriedades[3]);
			int cargaSemestral = Integer.parseInt(propriedades[4]);
			int codigoCurso = Integer.parseInt(propriedades[5]);
			
			
			DidaticoAula didaticoAula = new DidaticoAula(codigo, nome, codigoDocente, cargaSemanal, cargaSemestral, codigoCurso);
			didaticoAulas.add(didaticoAula);
		}
		scanner.close();
		return didaticoAulas;
	}
	
	//<c�digo do docente>:int;<matricula do discente>:int;<curso>:int;<carga horario semanal>:int
	public List<Graduacao> leGraduacoes() throws FileNotFoundException{
		Scanner scanner = new Scanner( new FileReader(arquivos.getOrientacaoGraducao()));
		List<Graduacao> graduacoes = new ArrayList<Graduacao>();
		while(scanner.hasNextLine()) {
			String[] propriedades = leLinha(scanner);
			
			int codigoDocente = Integer.parseInt(propriedades[0]);
			int matriculaDiscente = Integer.parseInt(propriedades[1]);
			int codigoCurso = Integer.parseInt(propriedades[2]);
			int cargaSemanal = Integer.parseInt(propriedades[3]);
			
			
			Graduacao graduacao = new Graduacao(codigoDocente, matriculaDiscente, codigoCurso, cargaSemanal);
			graduacoes.add(graduacao);
		}
		scanner.close();
		return graduacoes;
	}
	
	//<c�digo do docente>;<matricula do discente>;<data de ingresso do discente no programa>;<programa de p�s gradua��o>;<carga hor�riasemanal>
	public List<PosGraduacao> lePosGraduacoes() throws FileNotFoundException, ParseException{
		Scanner scanner = new Scanner( new FileReader(arquivos.getOrientacaoPos()));
		List<PosGraduacao> posGraduacoes = new ArrayList<PosGraduacao>();
		while(scanner.hasNextLine()) {
			String[] propriedades = leLinha(scanner);
			
			int codigoDocente = Integer.parseInt(propriedades[0]);
			int matriculaDiscente = Integer.parseInt(propriedades[1]);
			String sDate = propriedades[2];  
		    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);  
			String programa = propriedades[3];
		    int cargaSemanal = Integer.parseInt(propriedades[4]);
			
			
			PosGraduacao posGraduacao = new PosGraduacao(codigoDocente, matriculaDiscente, date, programa, cargaSemanal);
			posGraduacoes.add(posGraduacao);
		}
		scanner.close();
		return posGraduacoes;
	}
	
}
