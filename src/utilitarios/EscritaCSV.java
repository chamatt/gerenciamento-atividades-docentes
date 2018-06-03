package utilitarios;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import gerencia.atividade.*;



public class EscritaCSV {
	
	public EscritaCSV() {}
	
	public void escreveLinha(String[] propriedades, PrintWriter printer) throws FileNotFoundException, IOException  {
		
		for(int i = 0; i < propriedades.length; i++) {
			printer.print(propriedades[i]);
			if(i < propriedades.length - 1) printer.print(";");
		}
		printer.print("\n");
		
	}
	
	public void escrevePAD(List<Docente> docentes) throws IOException {
		File pad = new File("1-pad.csv");
		FileWriter fwriter = new FileWriter(pad);
		PrintWriter printer = new PrintWriter(fwriter);
		
		String[] titulo = new String[] { 
			"Docente","Departamento","Horas Semanais Aula","Horas Semestrais Aula","Horas Semanais Orientação","Produções Qualificadas","Produções Não Qualificadas"
		};
		escreveLinha(titulo, printer);
		Collections.sort(docentes, new PADComparador());
		/*for(Docente c: docentes) {
			System.out.println(c);
		}*/
		
		for(Docente d : docentes) {
			String[] props = new String[] {
					d.getNome(), d.getDepartamento(), Integer.toString(d.getTotalHorasSemanaisAula()),
					Integer.toString(d.getTotalAulasSemestraisAula()), Integer.toString(d.getTotalAulasSemanaisOrientacao()),
					Integer.toString(d.getNumProducoesQualificadas()), Integer.toString(d.getNumProducoesNaoQualificadas()) 
			};
			
			escreveLinha(props, printer);
			
		}
		printer.close();
		
	}
	
	public void escreveRHA() throws IOException {
	
	}
	
	public void escreveAlocacao(List <DidaticoAula> discs) throws IOException 
	{
		File alocacao = new File("3-alocacao.csv");
		FileWriter fwriter = new FileWriter(alocacao);
		PrintWriter printer = new PrintWriter(fwriter);
		
		String[] titulo = new String[] { "Docente","Código","Nome","Carga Horária Semestral"};
		escreveLinha(titulo, printer);
		
		Collections.sort(discs, new AlocacaoComparador());
		
		for(DidaticoAula disc : discs)
		{
			String[] props = new String[] {
					disc.getDocente().getNome(),disc.getCodigo(),
					disc.getNome(),Integer.toString(disc.getCHSemestral())
			};
			
			escreveLinha(props, printer);
		}
		
		printer.close();
		
	}
	
	public void escreveDiscentesProGrad(List <Discente> discentes) throws IOException 
	{
		File alocacao = new File("4-ppg.csv");
		FileWriter fwriter = new FileWriter(alocacao);
		PrintWriter printer = new PrintWriter(fwriter);
		
		String[] titulo = new String[] { "Nome do Programa","Data de Ingresso","Matrícula","Nome"};
		escreveLinha(titulo, printer);
		
		Collections.sort(discentes,new PPGComparador());
		
		for(Discente discente : discentes)
		{
			String[] props = new String[] {
					discente.getPosGraduacao().getNomeDoPrograma(),
					new SimpleDateFormat("dd/MM/yyyy").format(discente.getPosGraduacao().getDataDeIngresso()),
					Long.toString(discente.getMatricula()),
					discente.getNome() 
			};
			escreveLinha(props, printer);
		}
		
		printer.close();
	}
	
}
