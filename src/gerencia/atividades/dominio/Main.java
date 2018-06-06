package gerencia.atividades.dominio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import gerencia.atividades.exceptions.CodigoCursoEmDisciplinaInvalidoException;
import gerencia.atividades.exceptions.CodigoCursoEmOrientacaoInvalidoException;
import gerencia.atividades.exceptions.CodigoCursoRepetidoException;
import gerencia.atividades.exceptions.CodigoDisciplinaRepetidoException;
import gerencia.atividades.exceptions.CodigoDocenteEmDisciplinaInvalidoException;
import gerencia.atividades.exceptions.CodigoDocenteEmOrientacaoInvalidoException;
import gerencia.atividades.exceptions.CodigoDocenteEmPublicacaoInvalidoException;
import gerencia.atividades.exceptions.CodigoDocenteRepetidoException;
import gerencia.atividades.exceptions.DataIngressoFuturaException;
import gerencia.atividades.exceptions.MatriculaDiscenteRepetidaException;
import gerencia.atividades.exceptions.NivelCursoInconsistenteException;
import gerencia.atividades.utilitarios.Arquivos;
import gerencia.atividades.utilitarios.EscritaCSV;
import gerencia.atividades.utilitarios.LeituraCSV;
import gerencia.atividades.utilitarios.Relacionamentos;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			Arquivos arquivos = new Arquivos(args);

			LeituraCSV leitor;
			List<Docente> docentes;
			List<Discente> discentes;
			List<ProducaoCientifica> producoesCientificas;
			List<Curso> cursos;
			List<DidaticoAula> didaticoAulas;
			List<Graduacao> graduacoes;
			List<PosGraduacao> posGraduacoes;

			if (arquivos.isWriteOnly()) {
				try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("dados.dat"));){
					docentes = (List<Docente>) in.readObject();
					discentes = (List<Discente>) in.readObject();
					producoesCientificas = (List<ProducaoCientifica>) in.readObject();
					cursos = (List<Curso>) in.readObject();
					didaticoAulas = (List<DidaticoAula>) in.readObject();
					graduacoes = (List<Graduacao>) in.readObject();
					posGraduacoes = (List<PosGraduacao>) in.readObject();
				}
				
			} else {
				leitor = new LeituraCSV(arquivos);
				docentes = leitor.leDocentes();
				discentes = leitor.leDiscentes();
				producoesCientificas = leitor.leProducoesCientificas(docentes);
				cursos = leitor.leCursos();
				didaticoAulas = leitor.leDidaticoAulas(docentes, cursos);
				graduacoes = leitor.leGraduacoes(docentes, discentes, cursos);
				posGraduacoes = leitor.lePosGraduacoes(docentes, discentes);

				Relacionamentos relacionamentos = new Relacionamentos();

				relacionamentos.ConectaInformacoesDocente(docentes, producoesCientificas, graduacoes, posGraduacoes,
						didaticoAulas);
				relacionamentos.ConectaInformacoesDiscente(discentes, posGraduacoes);
				relacionamentos.ConectaInformacoesCurso(cursos, didaticoAulas);

			}

			if (arquivos.isReadOnly()) {
				try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("dados.dat"));){
					out.writeObject(docentes);
					out.writeObject(discentes);
					out.writeObject(producoesCientificas);
					out.writeObject(cursos);
					out.writeObject(didaticoAulas);
					out.writeObject(graduacoes);
					out.writeObject(posGraduacoes);
				}
				
			} else {

				EscritaCSV escritor = new EscritaCSV();
				escritor.escrevePAD(docentes);
				escritor.escreveAlocacao(didaticoAulas);
				escritor.escreveDiscentesProGrad(discentes);
				escritor.escreveRHA(cursos);
			}
		} catch (IOException e) {
			System.out.println("Erro de I/O");
		} catch (java.text.ParseException p) {
			System.out.println("Erro de formatação");
		} catch (ClassNotFoundException cn) {
			System.out.println("Classe não encontrada");
		} catch (CodigoDocenteRepetidoException cd) {
		} catch (MatriculaDiscenteRepetidaException md) {
		} catch (CodigoCursoRepetidoException cr) {
		} catch (CodigoDisciplinaRepetidoException cdr) {
		} catch (CodigoDocenteEmDisciplinaInvalidoException cdi) {
		} catch (CodigoDocenteEmOrientacaoInvalidoException oi) {
		} catch (CodigoDocenteEmPublicacaoInvalidoException pi) {
		} catch (CodigoCursoEmOrientacaoInvalidoException ci) {
		} catch (CodigoCursoEmDisciplinaInvalidoException di) {
		} catch (NivelCursoInconsistenteException ni) {
		} catch (DataIngressoFuturaException df) {
		}
	}

}
