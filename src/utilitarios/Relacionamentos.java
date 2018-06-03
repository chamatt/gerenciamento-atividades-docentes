package utilitarios;

import java.util.List;
import gerencia.atividade.*;


public class Relacionamentos 
{
	public void ConectaInformacoesDocente(List <Docente> docentes,
										  List <ProducaoCientifica> prods,
										  List <Graduacao> grads,
										  List <PosGraduacao> pgs,
										  List <DidaticoAula> discs)
	{
		for(Docente docente : docentes)
		{
			for(ProducaoCientifica prod : prods)
			{
				if(prod.getCodigoDoDocente() == docente.getCodigo())
					docente.addListaProducao(prod);
			}
		}
		
		for(Docente docente : docentes)
		{
			for(Graduacao grad : grads)
			{
				if(docente.getCodigo() == grad.getCodigoDocente())
					docente.addListaGraduacao(grad);
			}
		}
		
		for(Docente docente : docentes)
		{
			for (DidaticoAula didaticoAula : discs) 
			{
				if(docente.getCodigo() == didaticoAula.getCodigoDocente())
					docente.addListaDidaticoAula(didaticoAula);
			}
		}
		
		for(Docente docente : docentes)
		{
			for(PosGraduacao pg : pgs)
			{
				if(docente.getCodigo() == pg.getCodigoDocente())
					docente.addListaPosGraduacao(pg);
			}
		}
		
		for(Docente docente : docentes)
		{
			docente.calcularProducoesQualificadas();
			docente.calcularTotalHoras();
		}
	}
	
	public void ConectaInformacoesDiscente(List <Discente> discentes,List <PosGraduacao> pgs)
	{
		for(Discente discente : discentes)
		{
			for (PosGraduacao posGraduacao : pgs) 
			{
				if(posGraduacao.getMatriculaDoDiscente() == discente.getMatricula());
			}
			
					
		}
		
	}
}
