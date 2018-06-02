package utilitarios;

import gerencia.atividade.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import exceptions.*;


public class LeituraCSV {
	Arquivos arquivos;
	
	
	public LeituraCSV(Arquivos arquivos) {
		this.arquivos = arquivos;
		
	}
	
	private String[] leLinha(Scanner sc) {
		String all = sc.nextLine();
		String[] propriedades = all.split(";");
		return propriedades;
	}
	
	private void checaCodigoDocenteRepetido(List <Docente> lista, Docente docente)
	throws CodigoDocenteRepetidoException
	{
		for (Docente d : lista) 
		{
			if(docente.getCodigo() == d.getCodigo())
				throw new CodigoDocenteRepetidoException(docente.getCodigo());
		}
	}
	
	private void checaMatriculaDiscenteRepetida(List <Discente> lista, Discente discente)
	throws MatriculaDiscenteRepetidaException
	{
		for (Discente d : lista) 
		{
			if(discente.getMatricula() == d.getMatricula())
				throw new MatriculaDiscenteRepetidaException(d.getMatricula());
		}
	}
	
	private void checaCodigoCursoRepetido(List <Curso> lista, Curso curso)
	throws CodigoCursoRepetidoException
	{
		for (Curso c : lista) 
		{
			if(c.getCodigo() == curso.getCodigo())
				throw new CodigoCursoRepetidoException(c.getCodigo());
		}
	}
	
	private void checaCodigoDisciplinaRepetido(List <DidaticoAula> lista,
			DidaticoAula disciplina) throws CodigoDisciplinaRepetidoException
	{
		for (DidaticoAula didaticoAula : lista) 
		{
			if(didaticoAula.getCodigo().equals(disciplina.getCodigo()))
				throw new CodigoDisciplinaRepetidoException(disciplina.getCodigo());	
		}
	}
	
	private void checaDocenteInvalidoEmDisciplina(DidaticoAula disc, List <Docente> lista)
	throws CodigoDocenteEmDisciplinaInvalidoException
	{
		for (Docente docente : lista) 
		{
			if(docente.getCodigo() == disc.getCodigoDocente()) return;
		}
		
		throw new CodigoDocenteEmDisciplinaInvalidoException(disc.getNome(), disc.getCodigoDocente());
	}
	
	private void checaDocenteEmOrientacao(List <Docente> docentes,
										  List <Discente> discentes,
										   Orientacao orientacao)
	throws CodigoDocenteEmOrientacaoInvalidoException
	{
		for (Docente docente : docentes) 
		{
			if(docente.getCodigo() == orientacao.getCodigoDocente()) return;
		}
		
		String nome = null;
		
		for (Discente discente : discentes) 
		{
			if(discente.getMatricula() == orientacao.getMatriculaDoDiscente())
			{
				nome = discente.getNome();
				break;
			}
		}
		
		throw new CodigoDocenteEmOrientacaoInvalidoException(nome,orientacao.getCodigoDocente());
	}
	
	private void checaDocenteEmProducaoCientifica(List <Docente> docentes,
												  ProducaoCientifica prod)
	throws CodigoDocenteEmPublicacaoInvalidoException
	{
		for (Docente docente : docentes) 
		{
			if(docente.getCodigo() == prod.getCodigoDoDocente()) return;
		}
		
		throw new CodigoDocenteEmPublicacaoInvalidoException(prod.getTitulo(), prod.getCodigoDoDocente());
	}
	
	private void checaCursoEmOrientacao(List <Curso> cursos,List <Discente> discentes,Graduacao grad)
	throws CodigoCursoEmOrientacaoInvalidoException
	{
		for (Curso curso : cursos) 
		{
			if(curso.getCodigo() == grad.getCodigoDoCurso()) return;
		}
			
		String nome = null;
			
		for (Discente discente : discentes) 
		{
			if(discente.getMatricula() == grad.getMatriculaDoDiscente())
			{
				nome = discente.getNome();
				break;
			}
		}
		
		throw new CodigoCursoEmOrientacaoInvalidoException(nome, grad.getCodigoDoCurso());
	}
	
	private void checaCursoEmDisciplina(List <Curso> cursos,DidaticoAula disc)
	throws CodigoCursoEmDisciplinaInvalidoException
	{
		for (Curso curso : cursos) 
		{
			if(curso.getCodigo() == disc.getCodigoDoCurso()) return;
		}
		
		throw new CodigoCursoEmDisciplinaInvalidoException(disc.getNome(), disc.getCodigoDoCurso());
	}
	
	private void checaCurso(Curso curso,boolean pg) throws NivelCursoInconsistenteException
	{
		if(curso.getGraduacao() == pg) 
			throw new NivelCursoInconsistenteException(curso.getNome(), curso.getCodigo());
	}
	
	private void checaData(List <Discente> discentes, PosGraduacao pg)
	throws DataIngressoFuturaException
	{
		Date dataAtual = new Date();
		String nome = null;
		
		if(dataAtual.before(pg.getDataDeIngresso()))
		{
			for (Discente discente : discentes) 
			{
				if(discente.getMatricula() == pg.getMatriculaDoDiscente())
				{
					nome = discente.getNome();
					break;
				}
			}
			
			throw new DataIngressoFuturaException(nome, pg.getDataDeIngresso());
		}
	}

	//Docente(codigo:int, nome:String, departamento:String)
	public List<Docente> leDocentes() throws FileNotFoundException, CodigoDocenteRepetidoException {
		
		Scanner scanner = null;
		
		scanner = new Scanner(new FileReader(arquivos.getDocentes()));
		scanner.nextLine();
		List<Docente> docentes = new ArrayList<Docente>();
		while(scanner.hasNextLine()) {
			
			String[] propriedades = leLinha(scanner);
					
			int codigo = Integer.parseInt(propriedades[0]);
			String nome = propriedades[1];
			String departamento = propriedades[2];
					
			Docente docente = new Docente(codigo, nome, departamento);
			checaCodigoDocenteRepetido(docentes, docente);
			docentes.add(docente);
			
		}
				
		if (scanner != null) 
		{
			scanner.close();
		}	
			
			
		return docentes;
	}
	
	
	public List<Discente> leDiscentes() throws FileNotFoundException,
	MatriculaDiscenteRepetidaException{
		Scanner scanner = new Scanner( new FileReader(arquivos.getDiscentes()));
		scanner.nextLine();
		List<Discente> discentes = new ArrayList<Discente>();
		while(scanner.hasNextLine()) {
			String[] propriedades = leLinha(scanner);
			
			long matricula = Integer.parseInt(propriedades[0]);
			String nome = propriedades[1];
			int codigoCurso = Integer.parseInt(propriedades[2]);
			
			Discente discente = new Discente(matricula, nome, codigoCurso);
			checaMatriculaDiscenteRepetida(discentes, discente);
			discentes.add(discente);
		}
		scanner.close();
		return discentes;
	}
	
	public List<ProducaoCientifica> leProducoesCientificas(List<Docente> docentes) throws FileNotFoundException,
	CodigoDocenteEmPublicacaoInvalidoException{
		Scanner scanner = new Scanner( new FileReader(arquivos.getProducaoCientifica()));
		scanner.nextLine();
		List<ProducaoCientifica> producoesCientificas = new ArrayList<ProducaoCientifica>();
		while(scanner.hasNextLine()) {
			String[] propriedades = leLinha(scanner);
			
			int codigoDocente = Integer.parseInt(propriedades[0]);
			String tituloDaPublicacao = propriedades[1];
			boolean qualificada = (propriedades.length > 2 && propriedades[2].equals("X")) ? true : false;
			
			ProducaoCientifica producaoCientifica = new ProducaoCientifica(codigoDocente, tituloDaPublicacao, qualificada);
			checaDocenteEmProducaoCientifica(docentes, producaoCientifica);
			producoesCientificas.add(producaoCientifica);
		}
		scanner.close();
		return producoesCientificas;
	}
	
	
	public List<Curso> leCursos() throws FileNotFoundException,
	CodigoCursoRepetidoException, NivelCursoInconsistenteException{
		Scanner scanner = new Scanner( new FileReader(arquivos.getCursos()));
		scanner.nextLine();

		List<Curso> cursos = new ArrayList<Curso>();
		while(scanner.hasNextLine()) {
			String[] propriedades = leLinha(scanner);
			int codigo = Integer.parseInt(propriedades[0]);
			String nome = propriedades[1];
			boolean graduacao = (propriedades.length > 2 && propriedades[2].equals("X")) ? true : false;
			boolean posGraduacao = (propriedades.length > 3 && propriedades[3].equals("X")) ? true : false;
			
			Curso curso = new Curso(codigo, nome, graduacao);
			checaCodigoCursoRepetido(cursos, curso);
			checaCurso(curso, posGraduacao);
			cursos.add(curso);
		}
		scanner.close();
		return cursos;
	}
	
	
	public List<DidaticoAula> leDidaticoAulas(List<Docente> docentes, List<Curso> cursos) throws FileNotFoundException,
	CodigoDisciplinaRepetidoException, CodigoDocenteEmDisciplinaInvalidoException,
	CodigoCursoEmDisciplinaInvalidoException{
		Scanner scanner = new Scanner(new FileReader(arquivos.getDidaticoAulas()));
		scanner.nextLine();
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
			checaCodigoDisciplinaRepetido(didaticoAulas, didaticoAula);
			checaDocenteInvalidoEmDisciplina(didaticoAula, docentes);
			checaCursoEmDisciplina(cursos, didaticoAula);
			didaticoAulas.add(didaticoAula);
		}
		scanner.close();
		return didaticoAulas;
	}
	
	//<c�digo do docente>:int;<matricula do discente>:int;<curso>:int;<carga horario semanal>:int
	public List<Graduacao> leGraduacoes(List<Docente> docentes, List<Discente> discentes, List<Curso> cursos) 
			throws FileNotFoundException, CodigoDocenteEmOrientacaoInvalidoException,
					CodigoCursoEmOrientacaoInvalidoException{
		Scanner scanner = new Scanner( new FileReader(arquivos.getOrientacaoGraducao()));
		scanner.nextLine();
		List<Graduacao> graduacoes = new ArrayList<Graduacao>();
		while(scanner.hasNextLine()) {
			String[] propriedades = leLinha(scanner);
			
			int codigoDocente = Integer.parseInt(propriedades[0]);
			int matriculaDiscente = Integer.parseInt(propriedades[1]);
			int codigoCurso = Integer.parseInt(propriedades[2]);
			int cargaSemanal = Integer.parseInt(propriedades[3]);
			
			
			Graduacao graduacao = new Graduacao(codigoDocente, matriculaDiscente, codigoCurso, cargaSemanal);
			checaDocenteEmOrientacao(docentes, discentes, graduacao);
			checaCursoEmOrientacao(cursos, discentes, graduacao);
			graduacoes.add(graduacao);
		}
		scanner.close();
		return graduacoes;
	}
	
	//<c�digo do docente>;<matricula do discente>;<data de ingresso do discente no programa>;<programa de p�s gradua��o>;<carga hor�riasemanal>
	public List<PosGraduacao> lePosGraduacoes(List<Docente> docentes, List<Discente> discentes) 
			throws FileNotFoundException, ParseException, 
			CodigoDocenteEmOrientacaoInvalidoException, DataIngressoFuturaException{
		Scanner scanner = new Scanner( new FileReader(arquivos.getOrientacaoPos()));
		scanner.nextLine();
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
			checaDocenteEmOrientacao(docentes, discentes, posGraduacao);
			checaData(discentes, posGraduacao);
			posGraduacoes.add(posGraduacao);
		}
		scanner.close();
		return posGraduacoes;
	}
	int teste;
}
