package entidades;

import org.apache.commons.math3.distribution.UniformIntegerDistribution;

import utils.Util;

public class Tarefa {
	
	private String nome;

	private Boolean terminada;
	
	private Integer duracao;
	
	public Tarefa(String nome, TipoTarefa tipo) {
		this.nome = nome + "-" + Util.getStringAleatoria();
		UniformIntegerDistribution distribuicao = new UniformIntegerDistribution(10, 100);
		this.duracao = distribuicao.sample();
		this.terminada = false;
	}

	public Boolean executarTarefa(Integer ciclo) {
		if (!terminada) {
			try {
				Thread.sleep(this.duracao * 10);
				this.terminada = true;
				return true;
			} catch (InterruptedException e) {
				return false;
			}
		} else return false;
	}
	
	public String toString() {
		return this.nome;
	}
}
