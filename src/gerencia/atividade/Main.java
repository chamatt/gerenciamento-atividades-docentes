package gerencia.atividade;

import java.io.IOException;
import java.util.List;
import utilitarios.*;
import exceptions.*;

public class Main {

	public static void main(String[] args){
		try {
			Arquivos arquivos = new Arquivos(args);
			LeituraCSV leitor = new LeituraCSV(arquivos);
			List<Docente> docentes = leitor.leDocentes();
			List<Discente> discentes = leitor.leDiscentes();
			List<ProducaoCientifica> producoesCientificas = leitor.leProducoesCientificas(docentes);
			List<Curso> cursos = leitor.leCursos();
			List<DidaticoAula> didaticoAulas = leitor.leDidaticoAulas(docentes,cursos);
			List<Graduacao> graduacoes = leitor.leGraduacoes(docentes,discentes,cursos);
			List<PosGraduacao> posGraduacoes = leitor.lePosGraduacoes(docentes,discentes);
			
			/*System.out.println("DOCENTES:");
			for (Docente docente : docentes) {
				System.out.println(docente);
			}
			System.out.println("DISCENTES:");
			for (Discente discente : discentes) {
				System.out.println(discente);
			}
			System.out.println("PRODUCAOCIENTIFICA:");
			for (ProducaoCientifica p : producoesCientificas) {
				System.out.println(p);
			}
			System.out.println("CURSOS:");
			for (Curso c : cursos) {
				System.out.println(c);
			}
			System.out.println("DIDATICOAULA:");
			for (DidaticoAula d : didaticoAulas) {
				System.out.println(d);
			}
			System.out.println("GRADUACOES:");
			for (Graduacao g : graduacoes) {
				System.out.println(g);
			}
			System.out.println("POSGRADUACOES:");
			for (PosGraduacao p : posGraduacoes) {
				System.out.println(p);
			}*/
			
			Relacionamentos relacionamentos = new Relacionamentos();
			
			relacionamentos.ConectaInformacoesDocente(docentes, producoesCientificas, graduacoes
													, posGraduacoes, didaticoAulas);
			relacionamentos.ConectaInformacoesDiscente(discentes, posGraduacoes);
			relacionamentos.ConectaInformacoesCurso(cursos, didaticoAulas);
			EscritaCSV escritor = new EscritaCSV();
			escritor.escrevePAD(docentes);
			escritor.escreveAlocacao(didaticoAulas);
			escritor.escreveDiscentesProGrad(discentes);
			escritor.escreveRHA(cursos);
		}
		catch(IOException e)
		{
			System.out.println("Erro de I/O");
		}
		catch(java.text.ParseException p)
		{
			System.out.println("Erro de formatação");
		}
		catch(CodigoDocenteRepetidoException cd){}
		catch(MatriculaDiscenteRepetidaException md){}
		catch(CodigoCursoRepetidoException cr){}
		catch(CodigoDisciplinaRepetidoException cdr){}
		catch(CodigoDocenteEmDisciplinaInvalidoException cdi){}
		catch(CodigoDocenteEmOrientacaoInvalidoException oi){}
		catch(CodigoDocenteEmPublicacaoInvalidoException pi){}
		catch(CodigoCursoEmOrientacaoInvalidoException ci){}
		catch(CodigoCursoEmDisciplinaInvalidoException di){}
		catch(NivelCursoInconsistenteException ni){}
		catch(DataIngressoFuturaException df){}
	}

}
