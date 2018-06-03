package gerencia.atividade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Curso {

		private int codigo;
		private String nome;
		private boolean graduacao;
		private List <Docente> docentes = new ArrayList<>();
		
		public Curso(int codigo,String nome,boolean graduacao) 
		{
			this.nome = nome;
			this.codigo = codigo;
			this.graduacao = graduacao;
		}
		
		@Override
		public String toString()
		{
			return "Curso " + nome + " " + codigo + " " + graduacao;
		}
		
		public int getCodigo()
		{
			return codigo;
		}
		
		public boolean getGraduacao()
		{
			return graduacao;
		}
		
		public String getNome()
		{
			return nome;
		}
		
		public void addListaDocentes(Docente docente)
		{
			if(!docentes.contains(docente))
				docentes.add(docente);
		}
		public List<Docente> getListaDocentes()
		{
			return docentes;
		}
		
}
