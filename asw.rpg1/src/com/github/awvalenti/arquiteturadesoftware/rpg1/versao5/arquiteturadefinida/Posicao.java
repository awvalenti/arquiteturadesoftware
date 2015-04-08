package com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coluna;
		result = prime * result + linha;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Posicao)) {
			return false;
		}
		Posicao other = (Posicao) obj;
		if (coluna != other.coluna) {
			return false;
		}
		if (linha != other.linha) {
			return false;
		}
		return true;
	}

	public Posicao somar(Direcao d) {
		return new Posicao(linha + d.getIncrementoLinha(), coluna + d.getIncrementoColuna());
	}

}
