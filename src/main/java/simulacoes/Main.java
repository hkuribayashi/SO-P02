package simulacoes;

import entidades.Processo;
import escalonador.EscalonadorFCFS;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		Processo p1 = new Processo("P1");
		Processo p2 = new Processo("P2");
		Processo p3 = new Processo("P3");
		
		EscalonadorFCFS eb = new EscalonadorFCFS();
		eb.adicionarProcessos(p1);
		eb.adicionarProcessos(p2);
		eb.adicionarProcessos(p3);
		
		Integer inicioCicloCPU = 0;
		Integer finalCicloCPU = 100;
		
		eb.executar(inicioCicloCPU, finalCicloCPU);

	}
}
