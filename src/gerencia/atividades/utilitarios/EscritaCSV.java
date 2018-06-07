package gerencia.atividades.utilitarios;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import gerencia.atividades.dominio.Curso;
import gerencia.atividades.dominio.DidaticoAula;
import gerencia.atividades.dominio.Discente;
import gerencia.atividades.dominio.Docente;

public class EscritaCSV {

	public EscritaCSV() {
	}

	public void escreveLinha(String[] propriedades, PrintWriter printer) throws FileNotFoundException, IOException {

		for (int i = 0; i < propriedades.length; i++) {
			propriedades[i] = propriedades[i].trim();
			printer.print(propriedades[i]);
			if (i < propriedades.length - 1)
				printer.print(";");
		}
		printer.print("\n");

	}

	public void escrevePAD(List<Docente> docentes) throws IOException {
		File pad = new File("1-pad.csv");

		try (FileWriter fwriter = new FileWriter(pad); PrintWriter printer = new PrintWriter(fwriter);) {
			String[] titulo = new String[] { "Docente", "Departamento", "Horas Semanais Aula", "Horas Semestrais Aula",
					"Horas Semanais Orientação", "Produções Qualificadas", "Produções Não Qualificadas" };
			escreveLinha(titulo, printer);
			Collections.sort(docentes, new PADComparador());

			for (Docente d : docentes) {
				String[] props = new String[] { d.getNome(), d.getDepartamento(),
						Integer.toString(d.getTotalHorasSemanaisAula()),
						Integer.toString(d.getTotalAulasSemestraisAula()),
						Integer.toString(d.getTotalAulasSemanaisOrientacao()),
						Integer.toString(d.getNumProducoesQualificadas()),
						Integer.toString(d.getNumProducoesNaoQualificadas()) };

				escreveLinha(props, printer);

			}
		}

	}

	public void escreveRHA(List<Curso> cursos) throws IOException {
		File rha = new File("2-rha.csv");
		try (FileWriter fwriter = new FileWriter(rha); PrintWriter printer = new PrintWriter(fwriter);) {
			String[] titulo = new String[] { "Departamento", "Docente", "Cód. Curso", "Curso",
					"Horas Semestrais Aula" };
			escreveLinha(titulo, printer);

			List<String[]> itensRelatorio = new ArrayList<>();

			for (Curso curso : cursos) {
				List<Docente> listaDocentes = curso.getListaDocentes();
				for (Docente d : listaDocentes) {

					String nomeDoDepartamento = null;
					String nomeDoDocente = null;
					int totalHoras = 0;
					String codigoDoCurso = Integer.toString(curso.getCodigo());
					String nomeDoCurso = curso.getNome();

					for (DidaticoAula dA : d.getDisciplinas()) {
						if (dA.getCodigoDoCurso() == curso.getCodigo()) {
							totalHoras += dA.getCHSemestral();
							nomeDoDepartamento = dA.getDocente().getDepartamento();
							nomeDoDocente = dA.getDocente().getNome();
						}
					}
					String[] props = new String[] { nomeDoDepartamento, nomeDoDocente, codigoDoCurso, nomeDoCurso,
							Integer.toString(totalHoras) };

					itensRelatorio.add(props);
				}

			}
			Collections.sort(itensRelatorio, new RHAComparador());
			for (String[] item : itensRelatorio) {
				escreveLinha(item, printer);
			}
		}

	}

	public void escreveAlocacao(List<DidaticoAula> discs) throws IOException {
		File alocacao = new File("3-alocacao.csv");
		try (FileWriter fwriter = new FileWriter(alocacao); PrintWriter printer = new PrintWriter(fwriter);) {
			String[] titulo = new String[] { "Docente", "Código", "Nome", "Carga Horária Semestral" };
			escreveLinha(titulo, printer);

			Collections.sort(discs, new AlocacaoComparador());

			for (DidaticoAula disc : discs) {
				String[] props = new String[] { disc.getDocente().getNome(), disc.getCodigo(), disc.getNome(),
						Integer.toString(disc.getCHSemestral()) };

				escreveLinha(props, printer);
			}
		}

	}

	public void escreveDiscentesProGrad(List<Discente> discentes) throws IOException {
		File alocacao = new File("4-ppg.csv");
		try (FileWriter fwriter = new FileWriter(alocacao); PrintWriter printer = new PrintWriter(fwriter);) {
			String[] titulo = new String[] { "Nome do Programa", "Data de Ingresso", "Matrícula", "Nome" };
			escreveLinha(titulo, printer);

			List<Discente> discentesPPG = new ArrayList<Discente>();
			for (Discente d : discentes) {
				if (d.getPosGraduacao() != null)
					discentesPPG.add(d);
			}

			Collections.sort(discentesPPG, new PPGComparador());

			for (Discente discente : discentesPPG) {
				String[] props = new String[] { discente.getPosGraduacao().getNomeDoPrograma(),
						new SimpleDateFormat("dd/MM/yyyy").format(discente.getPosGraduacao().getDataDeIngresso()),
						Long.toString(discente.getMatricula()), discente.getNome() };
				escreveLinha(props, printer);
			}
		}

	}

}
