package asw.xadrez.versao3.aposdojo1;

import static asw.xadrez.versao3.aposdojo1.Cor.*;
import static asw.xadrez.versao3.aposdojo1.TipoDePeca.*;

public class Tabuleiro {
	Casa[][] casas;
	public Tabuleiro(){
	
		casas = new Casa[][] {
			{ new Casa(new Peca(TORRE,PRETO)), new Casa(new Peca(CAVALO,PRETO)), new Casa(new Peca(BISPO,PRETO)), new Casa(new Peca(RAINHA,PRETO)), new Casa(new Peca(REI,PRETO)), new Casa(new Peca(BISPO,PRETO)), new Casa(new Peca(CAVALO,PRETO)), new Casa(new Peca(TORRE,PRETO)) },
			{ new Casa(new Peca(PEAO,PRETO)), new Casa(new Peca(PEAO,PRETO)), new Casa(new Peca(PEAO,PRETO)), new Casa(new Peca(PEAO,PRETO)), new Casa(new Peca(PEAO,PRETO)), new Casa(new Peca(PEAO,PRETO)), new Casa(new Peca(PEAO,PRETO)), new Casa(new Peca(PEAO,PRETO)) },
			{ new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)) },
			{ new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)) },
			{ new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)) },
			{ new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)), new Casa(new Peca(NULO,INDEFINIDO)) },
			{ new Casa(new Peca(PEAO,BRANCO)), new Casa(new Peca(PEAO,BRANCO)), new Casa(new Peca(PEAO,BRANCO)), new Casa(new Peca(PEAO,BRANCO)), new Casa(new Peca(PEAO,BRANCO)), new Casa(new Peca(PEAO,BRANCO)), new Casa(new Peca(PEAO,BRANCO)), new Casa(new Peca(PEAO,BRANCO)) },
			{ new Casa(new Peca(TORRE,BRANCO)), new Casa(new Peca(CAVALO,BRANCO)), new Casa(new Peca(BISPO,BRANCO)), new Casa(new Peca(RAINHA,BRANCO)), new Casa(new Peca(REI,BRANCO)), new Casa(new Peca(BISPO,BRANCO)), new Casa(new Peca(CAVALO,BRANCO)), new Casa(new Peca(TORRE,BRANCO)) }
		};
	}
	
	public Peca getPeca (int linha, int coluna)
	{
		return casas[linha][coluna].getPeca();
	}
	
	public void setPeca (int linha, int coluna, Peca peca) {
		casas[linha][coluna].setPeca(peca);
	}
	
}