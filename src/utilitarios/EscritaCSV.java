package utilitarios;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import gerencia.atividade.*;



public class EscritaCSV {
	
	public EscritaCSV() {}
	
	public void escreveLinha(String[] propriedades, File arquivo) throws FileNotFoundException, IOException  {
		FileWriter fwriter = new FileWriter(arquivo);
		PrintWriter printer = new PrintWriter(fwriter);
		for(int i = 0; i < propriedades.length; i++) {
			printer.print(propriedades[i]);
			if(i < propriedades.length - 1) printer.print(";");
		}
		printer.close();
	}
	
	public void escrevePAD(List<Docente> docentes, Arquivos arquivos) throws IOException {
		File pad = new File("1-pad.csv");
		String[] titulo = new String[] { 
			"Docente","Departamento","Horas Semanais Aula","Horas Semestrais Aula","Horas Semanais Orientação","Produções Qualificadas","Produções Não Qualificadas"
		};
		escreveLinha(titulo, pad);
		List<String[]> objs = new ArrayList<String>();
		for(Docente d : docentes) {
			
			String[] props = new String[] {
					d.getNome(), d.getDepartamento(), d.getTotalHorasSemanaisAulas().toString, d.getTotalHorasSemestraisAulas().toString,  d.getTotalHorasSemanaisOrientacao().toString,  d.numProducoesCientificaQualificadas().toString(),  d.numProducoesCientificaNaoQualificadas().toString()
			}
			objs.add(props);
		}
		Collections.sort(objs, new PADComparador());
	}
	
	public void escreveRHA(Arquivos arquivos) throws IOException {
	
	}
	
	public void escreveAlocacao() throws IOException {
		
	}
	
	public void escreveDiscentesProGrad() throws IOException {
		
	}
	
}
