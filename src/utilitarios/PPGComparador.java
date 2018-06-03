package utilitarios;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import gerencia.atividade.Discente;

public class PPGComparador implements Comparator<Discente> {
	
	@Override
	public int compare(Discente d1, Discente d2)
	{
		Collator c = Collator.getInstance(new Locale("pt", "BR"));
		
		return c.compare(d1.getNome(), d2.getNome());
		/*if(c.compare(d1.getPosGraduacao().getNomeDoPrograma(),
					 d2.getPosGraduacao().getNomeDoPrograma()) == 0)
		{
			if(d1.getPosGraduacao().getDataDeIngresso().equals(
					d2.getPosGraduacao().getDataDeIngresso()))
			{
				return c.compare(d1.getNome(), d2.getNome());
			}
			
			if(d1.getPosGraduacao().getDataDeIngresso().before(
					d2.getPosGraduacao().getDataDeIngresso()))
					return 1;
			else return 0;
		}
		
		return c.compare(d1.getPosGraduacao().getNomeDoPrograma(),
				 d2.getPosGraduacao().getNomeDoPrograma());*/
		
	}

}
