package gerencia.atividade;

import java.io.IOException;
import java.util.List;
import utilitarios.Arquivos;
import utilitarios.LeituraCSV;

public class Main {

	public static void main(String[] args){
		try {
			Arquivos arquivos = new Arquivos(args);
			LeituraCSV leitor = new LeituraCSV(arquivos);
			List<Docente> docentes = leitor.leDocentes();
			List<Discente> discentes = leitor.leDiscentes();
			List<ProducaoCientifica> producoesCientificas = leitor.leProducoesCientificas();
			List<Curso> cursos = leitor.leCursos();
			List<DidaticoAula> didaticoAulas = leitor.leDidaticoAulas();
			List<Graduacao> graduacoes = leitor.leGraduacoes();
			List<PosGraduacao> posGraduacoes = leitor.lePosGraduacoes();
			
			System.out.println("DOCENTES:");
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
			}
			
			
		}
		catch(IOException e){
			
		}
		catch(java.text.ParseException p)
		{
			
		}
	}

}
