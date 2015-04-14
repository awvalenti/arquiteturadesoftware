package com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida.logicajogo;

public interface SaidaJogo {

	void iniciarJogo();

	void alterarElemento(Posicao posicao, Elemento novo);

	void passarDeFase();

	void perderJogo();

}
