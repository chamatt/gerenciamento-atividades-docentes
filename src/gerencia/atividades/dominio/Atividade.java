package gerencia.atividades.dominio;

public abstract class Atividade {

	protected int codigoDoDocente;
	protected int CHSemanal;

	public int getCodigoDocente() {
		return codigoDoDocente;
	}

	public int getCHSemanal() {
		return CHSemanal;
	}
}
