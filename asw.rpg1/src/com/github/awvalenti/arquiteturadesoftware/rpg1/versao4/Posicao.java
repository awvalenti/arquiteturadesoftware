package com.github.awvalenti.arquiteturadesoftware.rpg1.versao4;

public class Posicao {

	private final int linha;
	private final int coluna;

	public Posicao(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

}
