package com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida;

public interface SaidaJogo {

	void alterarElemento(Posicao posicao, Elemento novo);

	void passarDeFase();

	void perderJogo();

}
