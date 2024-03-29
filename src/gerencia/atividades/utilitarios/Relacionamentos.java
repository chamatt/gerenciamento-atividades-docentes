package gerencia.atividades.utilitarios;

import java.util.List;
import gerencia.atividades.dominio.Curso;
import gerencia.atividades.dominio.DidaticoAula;
import gerencia.atividades.dominio.Discente;
import gerencia.atividades.dominio.Docente;
import gerencia.atividades.dominio.Graduacao;
import gerencia.atividades.dominio.PosGraduacao;
import gerencia.atividades.dominio.ProducaoCientifica;

public class Relacionamentos {
	public void ConectaInformacoesDocente(List<Docente> docentes, List<ProducaoCientifica> prods, List<Graduacao> grads,
			List<PosGraduacao> pgs, List<DidaticoAula> discs) {
		for (Docente docente : docentes) {
			for (ProducaoCientifica prod : prods) {
				if (prod.getCodigoDoDocente() == docente.getCodigo())
					docente.addListaProducao(prod);
			}
		}

		for (Docente docente : docentes) {
			for (Graduacao grad : grads) {
				if (docente.getCodigo() == grad.getCodigoDocente())
					docente.addListaGraduacao(grad);
			}
		}

		for (Docente docente : docentes) {
			for (DidaticoAula didaticoAula : discs) {
				if (docente.getCodigo() == didaticoAula.getCodigoDocente()) {
					docente.addListaDidaticoAula(didaticoAula);
					didaticoAula.setDocente(docente);
				}
			}
		}

		for (Docente docente : docentes) {
			for (PosGraduacao pg : pgs) {
				if (docente.getCodigo() == pg.getCodigoDocente())
					docente.addListaPosGraduacao(pg);
			}
		}

		for (Docente docente : docentes) {
			docente.calcularProducoesQualificadas();
			docente.calcularTotalHoras();
		}
	}

	public void ConectaInformacoesDiscente(List<Discente> discentes, List<PosGraduacao> pgs) {
		for (Discente discente : discentes) {
			for (PosGraduacao posGraduacao : pgs) {
				if (posGraduacao.getMatriculaDoDiscente() == discente.getMatricula())
					discente.setPosGraduacao(posGraduacao);
			}

		}

	}

	public void ConectaInformacoesCurso(List<Curso> cursos, List<DidaticoAula> didaticoAulas) {
		for (Curso curso : cursos) {
			for (DidaticoAula dA : didaticoAulas) {
				if (dA.getCodigoDoCurso() == curso.getCodigo())
					curso.addListaDocentes(dA.getDocente());
			}

		}

	}

}
