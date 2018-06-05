package gerencia.atividades.utilitarios;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

import gerencia.atividades.dominio.DidaticoAula;

public class AlocacaoComparador implements Comparator<DidaticoAula> {

	@Override
	public int compare(DidaticoAula d1, DidaticoAula d2) {
		Collator c = Collator.getInstance(new Locale("pt", "BR"));
		if (c.compare(d1.getDocente().getNome(), d2.getDocente().getNome()) == 0)
			return c.compare(d1.getCodigo(), d2.getCodigo());

		return c.compare(d1.getDocente().getNome(), d2.getDocente().getNome());
	}

}
