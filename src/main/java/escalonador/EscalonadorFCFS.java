package escalonador;

import entidades.EstadoProcesso;
import entidades.Processo;

public class EscalonadorFCFS extends Escalonador{

	@Override
	protected Processo selecionarProximoProcesso() {
		//Pega o primeiro processo da fila
		if (this.processos.size() > 0)
			return this.processos.get(0);
		else return null;
	}

	@Override
	public void executar(Integer inicio, Integer fim){
		Processo p = this.selecionarProximoProcesso();
		System.out.println("Executando Processo "+p.getId()+" Duração: "+p.getDuracao()+" ciclos");
		for (int ciclo=inicio; ciclo<=fim; ciclo++) {
			
			p.executarProcesso(ciclo);
			if (!(p.getEstado() == EstadoProcesso.EXECUTANDO)) {
				if (p.getEstado() == EstadoProcesso.TERMINADO) {
					this.processos.remove(p);
					System.out.println();
				}
				p = this.selecionarProximoProcesso();
				if (p == null)
					break;
				System.out.println("Executando Processo "+p.getId()+" Duração: "+p.getDuracao()+" ciclos");
			}
		}
	}

	@Override
	public void adicionarProcessos(Processo p) {
		// Adiciona os processos numa lista de Processos
		this.processos.add(p);
	}
	
}