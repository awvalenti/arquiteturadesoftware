// Leia o código abaixo e responda às seguintes questões:
//
//
// 1) Do ponto de vista do usuário, que problemas existem no jogo?
//
//
// 2) Do ponto de vista do programador, que problemas existem no jogo?
//
//
// 3) Diga em que linhas do código está localizada a lógica que cuida de:
// 	a) Carregar as imagens usadas no jogos
// 	b) Definir a quantidade de linhas e colunas do tabuleiro
// 	c) Manipular o objeto JFrame, que representa a janela do jogo
// 	d) Verificar se o jogo já acabou
//
//
// 4) Deseja-se fazer algumas mudanças no jogo. Para fazê-las, é necessário alterar
//    o código de determinadas maneiras. Explique, com palavras, que alterações no código
//    são necessárias para cada mudança desejada.
// 	a) Adicionar um novo elemento: moeda
// 	b) Avançar duas casas por vez quando segurar a tecla SHIFT
// 	c) Controlar o personagem com o mouse, clicando nas casas adjacentes
// 	d) Criar novas fases, com mais maçãs
// 	e) Criar novas fases, com tamanho maior do que 10x15
//
package com.github.awvalenti.arquiteturadesoftware.rpg1;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Main {

	int coletados;

	public static void main(String[] args) throws IOException {
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(10, 15));

		final Main main = new Main();

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
					frame.add(new JLabel(new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/agua.png")))));
				}
				if (posicoes[i][j] == 1) {
					frame.add(new JLabel(new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/maca.png")))));
				}
				if (posicoes[i][j] == 2) {
					frame.add(new JLabel(new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/personagem.png")))));
				}
				if (posicoes[i][j] == 3) {
					frame.add(new JLabel(new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/grama.png")))));
				}
			}
		}

		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case 37:
					for (int i = 0; i < 10; i++) {
						for (int j = 0; j < 15; j++) {
							if (posicoes[i][j] == 2) {
								if (posicoes[i][j - 1] == 0) {
									JOptionPane.showMessageDialog(frame, "Perdeu!", "Perdeu!", JOptionPane.ERROR_MESSAGE);
									System.exit(0);
								}
								if (posicoes[i][j - 1] == 1) {
									++main.coletados;
									if (main.coletados == 3) {
										JOptionPane.showMessageDialog(frame, "Ganhou!", "Ganhou!", JOptionPane.INFORMATION_MESSAGE);
										System.exit(0);
									}
								}
								posicoes[i][j] = 3;
								((JLabel) frame.getContentPane().getComponent(i * 15 + j)).setIcon(icone(3));
								posicoes[i][j - 1] = 2;
								((JLabel) frame.getContentPane().getComponent(i * 15 + j - 1)).setIcon(icone(2));
							}
						}
					}
					break;
				case 38:
					for (int i = 0; i < 10; i++) {
						for (int j = 0; j < 15; j++) {
							if (posicoes[i][j] == 2) {
								if (posicoes[i - 1][j] == 0) {
									JOptionPane.showMessageDialog(frame, "Perdeu!", "Perdeu!", JOptionPane.ERROR_MESSAGE);
									System.exit(0);
								}
								if (posicoes[i - 1][j] == 1) {
									++main.coletados;
									if (main.coletados == 3) {
										JOptionPane.showMessageDialog(frame, "Ganhou!", "Ganhou!", JOptionPane.INFORMATION_MESSAGE);
										System.exit(0);
									}
								}
								posicoes[i][j] = 3;
								((JLabel) frame.getContentPane().getComponent(i * 15 + j)).setIcon(icone(3));
								posicoes[i - 1][j] = 2;
								((JLabel) frame.getContentPane().getComponent((i - 1) * 15 + j)).setIcon(icone(2));
							}
						}
					}
					break;
				case 39:
					for (int i = 0; i < 10; i++) {
						for (int j = 0; j < 15; j++) {
							if (posicoes[i][j] == 2) {
								if (posicoes[i][j + 1] == 0) {
									JOptionPane.showMessageDialog(frame, "Perdeu!", "Perdeu!", JOptionPane.ERROR_MESSAGE);
									System.exit(0);
								}
								if (posicoes[i][j + 1] == 1) {
									++main.coletados;
									if (main.coletados == 3) {
										JOptionPane.showMessageDialog(frame, "Ganhou!", "Ganhou!", JOptionPane.INFORMATION_MESSAGE);
										System.exit(0);
									}
								}
								posicoes[i][j] = 3;
								((JLabel) frame.getContentPane().getComponent(i * 15 + j)).setIcon(icone(3));
								posicoes[i][j + 1] = 2;
								((JLabel) frame.getContentPane().getComponent(i * 15 + j + 1)).setIcon(icone(2));
								break;
							}
						}
					}
					break;
				case 40:
					break;
				}
			}

			private Icon icone(int i) {
				try {
					switch (i) {
					case 0: return new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/agua.png")));
					case 1: return new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/maca.png")));
					case 2: return new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/personagem.png")));
					case 3: return new ImageIcon(ImageIO.read(Main.class.getResourceAsStream("/grama.png")));
					default: throw new IllegalArgumentException("" + i);
					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
