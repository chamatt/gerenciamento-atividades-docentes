package exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataIngressoFuturaException extends Exception {
	public DataIngressoFuturaException(String nome, Date data) {
		System.out.println("Data de ingresso do aluno \""+ nome + "\" está no futuro: " + 
		new SimpleDateFormat("dd/MM/yyyy").format(data) + ".");	
	}
}
