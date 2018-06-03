package utilitarios;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

import gerencia.atividade.Docente;

public class PADComparador implements Comparator<Docente> { 
	@Override
	public int compare(Docente d1, Docente d2){
		Collator c = Collator.getInstance(new Locale("pt", "BR"));
		return c.compare(d1.getNome(), d2.getNome());
	}
}


