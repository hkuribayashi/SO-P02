package escalonador;

import java.util.ArrayList;
import java.util.List;

import entidades.Processo;

public abstract class Escalonador {
	
	protected List<Processo> processos = new ArrayList<Processo>();
	
	public abstract void adicionarProcessos(Processo p);
	
	protected abstract Processo selecionarProximoProcesso();
		
	protected abstract void executar(Integer inicio, Integer fim);

}
