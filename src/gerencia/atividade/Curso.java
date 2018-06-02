package gerencia.atividade;

public class Curso {

		private int codigo;
		private String nome;
		private boolean graduacao;
		
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
}
