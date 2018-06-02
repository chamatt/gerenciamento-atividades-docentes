package gerencia.atividade;

public class DidaticoAula extends Atividade {
	
		private String codigo;
		private String nome;
		private int CHSemestral;
		private int codigoDoCurso;
		
		public DidaticoAula(String codigo,String nome,int codigoDoDocente, 
							int CHSemanal,int CHSemestral, int codigoDoCurso) {
							 
			this.codigo = codigo;
			this.nome = nome;
			this.CHSemestral = CHSemestral;
			this.codigoDoCurso = codigoDoCurso;
			this.codigoDoDocente = codigoDoDocente;
			this.CHSemanal = CHSemanal;
			
		}
		
		@Override
		public String toString()
		{
			return "Didatico-Aula " + nome + " " + codigo + " " +
					codigoDoDocente + " " + CHSemanal + " " + CHSemestral + " " + codigoDoCurso;
		}
		
		public String getCodigo()
		{
			return codigo;
		}
		
		public String getNome()
		{
			return nome;
		}

		public int getCodigoDoCurso() 
		{
			return codigoDoCurso;
		}
		
		public int getCHSemestral() 
		{
			return CHSemestral;
		}
}
