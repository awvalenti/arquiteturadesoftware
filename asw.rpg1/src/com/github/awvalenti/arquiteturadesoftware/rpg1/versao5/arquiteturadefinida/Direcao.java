package com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida;

public enum Direcao {

	ESQUERDA(37, 0, -1),
	CIMA(38, -1, 0),
	DIREITA(39, 0, 1),
	BAIXO(40, 1, 0),
	;

	private final int codigoTecla;
	private final int incrementoLinha;
	private final int incrementoColuna;

	private Direcao(int codigoTecla, int incrementoLinha, int incrementoColuna) {
		this.codigoTecla = codigoTecla;
		this.incrementoLinha = incrementoLinha;
		this.incrementoColuna = incrementoColuna;
	}

	public int getIncrementoLinha() {
		return incrementoLinha;
	}

	public int getIncrementoColuna() {
		return incrementoColuna;
	}

	public static Direcao comCodigo(int codigoTecla) {
		for (Direcao d : values()) {
			if (d.codigoTecla == codigoTecla) return d;
		}

		return null;
	}

}
