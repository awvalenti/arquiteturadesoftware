package com.github.awvalenti.arquiteturadesoftware.rpg1.versao4.passagem;

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

public class TelaInicialOO {

	private JFrame frame = new JFrame();
	private Elemento[][] tabuleiro;
	private int numeroLinhas;
	private int numeroColunas;
	private int linhaPersonagem;
	private int colunaPersonagem;
	private int linhaPassagem;
	private int colunaPassagem;
	private int macasRestantes;

	public TelaInicialOO(Elemento[][] disposicaoInicial) {
		tabuleiro = disposicaoInicial;
		numeroLinhas = disposicaoInicial.length;
		numeroColunas = disposicaoInicial[0].length;

		frame.setLayout(new GridLayout(numeroLinhas, numeroColunas));

		for (int i = 0; i < numeroLinhas; i++) {
			for (int j = 0; j < numeroColunas; j++) {
				Elemento elemento = disposicaoInicial[i][j];
				frame.add(new JLabel());
				alterarElemento(i, j, elemento);
				if (elemento == Elemento.PERSONAGEM) {
					linhaPersonagem = i;
					colunaPersonagem = j;

				} else if (elemento == Elemento.MACA______) {
					++macasRestantes;

				} else if (elemento == Elemento.PASSAGEM__) {
					linhaPassagem = i;
					colunaPassagem = j;
					// Vamos desenhar uma grama no lugar, por enquanto, ate pegar todas as macas
					alterarElemento(i, j, Elemento.GRAMA_____);
				}
			}
		}

		frame.addKeyListener(new TecladoListener());

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void alterarElemento(int linha, int coluna, Elemento novoElemento) {
		try {
			((JLabel) frame.getContentPane().getComponent(linha * numeroColunas + coluna)).setIcon(carregarIcone(novoElemento));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private Icon carregarIcone(Elemento elemento) throws IOException {
		return new ImageIcon(ImageIO.read(getClass().getResourceAsStream(elemento.getCaminhoImagem())));
	}

	private class TecladoListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int antigaLinha = linhaPersonagem;
			int antigaColuna = colunaPersonagem;

			int novaLinha = antigaLinha;
			int novaColuna = antigaColuna;

			final int ESQUERDA = 37, CIMA = 38, DIREITA = 39, BAIXO = 40;

			switch (e.getKeyCode()) {
			case ESQUERDA:
				novaColuna = antigaColuna - 1;
				break;
			case CIMA:
				novaLinha = antigaLinha - 1;
				break;
			case DIREITA:
				novaColuna = antigaColuna + 1;
				break;
			case BAIXO:
				novaLinha = antigaLinha + 1;
				break;
			default:
				return;
			}

			switch (tabuleiro[novaLinha][novaColuna]) {
			case AGUA______:
				JOptionPane.showMessageDialog(frame, "Perdeu!", "Perdeu!", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
				break;

			case MACA______:
				--macasRestantes;
				if (macasRestantes <= 0) {
					// Descobrir a casa da passagem
					alterarElemento(linhaPassagem, colunaPassagem, Elemento.PASSAGEM__);
				}
				break;

			case PASSAGEM__:
				if (macasRestantes <= 0) {
					JOptionPane.showMessageDialog(frame, "Ganhou!", "Ganhou!",
							JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
				break;

			default:
				break;
			}

			alterarElemento(antigaLinha, antigaColuna, Elemento.GRAMA_____);
			alterarElemento(novaLinha, novaColuna, Elemento.PERSONAGEM);

			linhaPersonagem = novaLinha;
			colunaPersonagem = novaColuna;
		}
	}

}
