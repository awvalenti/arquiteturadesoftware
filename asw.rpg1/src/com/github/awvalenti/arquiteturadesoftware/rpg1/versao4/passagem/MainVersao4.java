package com.github.awvalenti.arquiteturadesoftware.rpg1.versao4.passagem;

import static com.github.awvalenti.arquiteturadesoftware.rpg1.versao4.passagem.Elemento.*;

public class MainVersao4 {

	public static void main(String[] args) {
		final Elemento[][] disposicaoInicial1 = {
				{GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, AGUA______, AGUA______, AGUA______, AGUA______},
				{GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, AGUA______, AGUA______, AGUA______, AGUA______, AGUA______},
				{GRAMA_____, GRAMA_____, GRAMA_____, MACA______, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, AGUA______, AGUA______, AGUA______, AGUA______, GRAMA_____, GRAMA_____, GRAMA_____},
				{PASSAGEM__, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, AGUA______, AGUA______, AGUA______, AGUA______, GRAMA_____, GRAMA_____, GRAMA_____},
				{GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, AGUA______, AGUA______, AGUA______, AGUA______, AGUA______, AGUA______, GRAMA_____, GRAMA_____, GRAMA_____},
				{GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, MACA______},
				{GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, AGUA______, AGUA______, AGUA______, AGUA______, AGUA______, AGUA______, AGUA______, AGUA______, AGUA______, AGUA______, GRAMA_____},
				{GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, AGUA______, AGUA______, GRAMA_____, GRAMA_____, AGUA______, AGUA______, AGUA______, AGUA______, AGUA______, AGUA______, GRAMA_____},
				{GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, MACA______, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____},
				{GRAMA_____, PERSONAGEM, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____, GRAMA_____},
		};

		new TelaInicialOO(disposicaoInicial1);
	}
}
