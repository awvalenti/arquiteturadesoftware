package com.github.awvalenti.arquiteturadesoftware.rpg1.versao3.telainicialoo;

import static com.github.awvalenti.arquiteturadesoftware.rpg1.versao3.telainicialoo.Elemento.AGUA;
import static com.github.awvalenti.arquiteturadesoftware.rpg1.versao3.telainicialoo.Elemento.GRAMA;
import static com.github.awvalenti.arquiteturadesoftware.rpg1.versao3.telainicialoo.Elemento.MACA;
import static com.github.awvalenti.arquiteturadesoftware.rpg1.versao3.telainicialoo.Elemento.PERSONAGEM;

import java.io.IOException;

public class MainOO {

	public static void main(String[] args) throws IOException {
	/*	final Elemento[][] disposicaoInicial1 = {
				{GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, AGUA, AGUA, AGUA, AGUA},
				{GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, AGUA, AGUA, AGUA, AGUA, AGUA},
				{GRAMA, GRAMA, GRAMA, MACA, GRAMA, GRAMA, GRAMA, GRAMA, AGUA, AGUA, AGUA, AGUA, GRAMA, GRAMA, GRAMA},
				{GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, AGUA, AGUA, AGUA, AGUA, GRAMA, GRAMA, GRAMA},
				{GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, AGUA, AGUA, AGUA, AGUA, AGUA, AGUA, GRAMA, GRAMA, GRAMA},
				{GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, MACA},
				{GRAMA, GRAMA, GRAMA, GRAMA, AGUA, AGUA, AGUA, AGUA, AGUA, AGUA, AGUA, AGUA, AGUA, AGUA, GRAMA},
				{GRAMA, GRAMA, GRAMA, GRAMA, AGUA, AGUA, GRAMA, GRAMA, AGUA, AGUA, AGUA, AGUA, AGUA, AGUA, GRAMA},
				{GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, MACA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA},
				{GRAMA, PERSONAGEM, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA},
		};

		TelaInicialOO tela1 = new TelaInicialOO(disposicaoInicial1);
*/

		final Elemento[][] disposicaoInicial2 = {
				{GRAMA, GRAMA, GRAMA, GRAMA, AGUA, AGUA, AGUA, AGUA},
				{GRAMA, GRAMA, GRAMA, GRAMA, AGUA, AGUA, GRAMA, GRAMA},
				{GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, MACA, GRAMA, GRAMA},
				{GRAMA, PERSONAGEM, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA, GRAMA},
		};

		TelaInicialOO tela2 = new TelaInicialOO(disposicaoInicial2);
		
		tela2.alterarElemento(3, 1, MACA);
	}

}
