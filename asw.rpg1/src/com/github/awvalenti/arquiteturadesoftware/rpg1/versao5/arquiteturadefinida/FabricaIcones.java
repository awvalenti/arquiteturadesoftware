package com.github.awvalenti.arquiteturadesoftware.rpg1.versao5.arquiteturadefinida;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class FabricaIcones {

	public Icon obterIcone(Elemento elemento) {
		try {
			return new ImageIcon(ImageIO.read(getClass().getResourceAsStream(elemento.getCaminhoImagem())));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
