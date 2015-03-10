package com.github.awvalenti.arquiteturadesoftware.rpg1.versao3.telainicialoo;

public enum Elemento {

	AGUA("/agua.png"),
	MACA("/maca.png"),
	PERSONAGEM("/personagem.png"),
	GRAMA("/grama.png"),
	;

	private final String caminhoImagem;

	Elemento(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

}
