package com.github.awvalenti.arquiteturadesoftware.rpg1.versao2.telainicialprocedimental;

import java.awt.GridLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaInicialProcedimental {

	int coletados;

	public static void main(String[] args) throws IOException {
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(10, 15));

		final int[][] posicoes = {
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0},
				{3, 3, 3, 1, 3, 3, 3, 3, 0, 0, 0, 0, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 3, 3, 3},
				{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1},
				{3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
				{3, 3, 3, 3, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 3},
				{3, 3, 3, 3, 3, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3},
				{3, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
		};

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 15; j++) {
				if (posicoes[i][j] == 0) {
					frame.add(new JLabel(new ImageIcon(ImageIO.read(TelaInicialProcedimental.class.getResourceAsStream("/agua.png")))));
				}
				if (posicoes[i][j] == 1) {
					frame.add(new JLabel(new ImageIcon(ImageIO.read(TelaInicialProcedimental.class.getResourceAsStream("/maca.png")))));
				}
				if (posicoes[i][j] == 2) {
					frame.add(new JLabel(new ImageIcon(ImageIO.read(TelaInicialProcedimental.class.getResourceAsStream("/personagem.png")))));
				}
				if (posicoes[i][j] == 3) {
					frame.add(new JLabel(new ImageIcon(ImageIO.read(TelaInicialProcedimental.class.getResourceAsStream("/grama.png")))));
				}
			}
		}

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
