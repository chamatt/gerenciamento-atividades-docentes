package gerencia.atividades.exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataIngressoFuturaException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -663368067216288611L;

	public DataIngressoFuturaException(String nome, Date data) {
		System.out.println("Data de ingresso do aluno \"" + nome + "\" está no futuro: "
				+ new SimpleDateFormat("dd/MM/yyyy").format(data) + ".");
	}
}
