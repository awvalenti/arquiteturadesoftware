package com.github.awvalenti.arquiteturadesoftware.rpg1.versao4.passagem;

public enum Elemento {

	AGUA______("/agua.png"),
	MACA______("/maca.png"),
	PERSONAGEM("/personagem.png"),
	GRAMA_____("/grama.png"),
	PASSAGEM__("/passagem.png"),
	;

	private final String caminhoImagem;

	Elemento(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

}
