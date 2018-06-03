package utilitarios;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import gerencia.atividade.Discente;

public class RHAComparador implements Comparator<String[]> {
	
	@Override
	public int compare(String[] s1, String[] s2)
	{
		Collator c = Collator.getInstance(new Locale("pt", "BR"));
		
		if(c.compare(s1[0], s2[0]) == 0) {
			if(c.compare(s1[1], s2[1]) == 0) {
				return c.compare(s1[3], s2[3]);
			}
			return c.compare(s1[1], s2[1]);
		}
		return c.compare(s1[0], s2[0]);
	}

}
