package entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.math3.distribution.UniformIntegerDistribution;

public class Processo {
	
	private String id;
	
	private Integer inicio;

	private EstadoProcesso estado;
	
	private Integer tarefaAtual = 0;
	
	private List<Tarefa> tarefas = new ArrayList<Tarefa>();
	
	public Processo(String id) {
		this.id = id;
		this.estado = EstadoProcesso.NOVO;
		UniformIntegerDistribution distribuicao = new UniformIntegerDistribution(5, 15);
		int numeroTarefasCPUBound = distribuicao.sample(); 
		
		for (int i=0; i<numeroTarefasCPUBound; i++) {
			this.tarefas.add( new Tarefa(id, TipoTarefa.CPU_BOUND) );
		}
		
		int numeroTarefasIOBound = numeroTarefasCPUBound/10;
		for (int j=numeroTarefasCPUBound; j<(numeroTarefasCPUBound+numeroTarefasIOBound); j++) {
			this.tarefas.add( new Tarefa(id, TipoTarefa.IO_BOUND) );
		}
		
		Collections.shuffle(this.tarefas);
		this.estado = EstadoProcesso.PRONTO;
		
	}
	
	public void executarProcesso(Integer ciclo){
		this.estado = EstadoProcesso.EXECUTANDO;
		System.out.println("Ciclo "+ciclo+"-Tarefa-"+this.tarefas.get(this.tarefaAtual));
		this.tarefas.get(this.tarefaAtual).executarTarefa(ciclo);
		this.tarefaAtual++;
		if (this.tarefaAtual >= this.tarefas.size()) {
			this.estado = EstadoProcesso.TERMINADO;
		}
	}

	public String getId() {
		return id;
	}

	public EstadoProcesso getEstado() {
		return estado;
	}
	
	public Integer getInicio() {
		return inicio;
	}
	
	public Integer getDuracao() {
		return this.tarefas.size();
	}
}
