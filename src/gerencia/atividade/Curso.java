package gerencia.atividade;

public class Curso {

		private int codigo;
		private String nome;
		private boolean graduacao;
		
		public Curso(String nome,int codigo,boolean graduacao) 
		{
			this.nome = nome;
			this.codigo = codigo;
			this.graduacao = graduacao;
		}
}
