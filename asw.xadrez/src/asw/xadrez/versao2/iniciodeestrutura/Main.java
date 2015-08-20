package asw.xadrez.versao2.iniciodeestrutura;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	private static final Color COR_CASA_SELECIONADA = Color.CYAN;
	private static final Color COR_CASA_NAO_SELECIONADA = new Color(238, 238, 238);

	private static final int NUMERO_LINHAS_TABULEIRO = 8;
	private static final int NUMERO_COLUNAS_TABULEIRO = 8;

	private static final int LARGURA_EM_PIXELS = 256;
	private static final int ALTURA_EM_PIXELS = 256;

	public static void main(String[] args) {
		char[][] tabuleiro = criarTabuleiro();

		JFrame janela = criarJanela();

		MouseAdapter tratadorCliques = new TratadorCliques();

		preencherJanelaComCasas(tabuleiro, janela, tratadorCliques);

		exibirJanela(janela);
	}

	private static char[][] criarTabuleiro() {
		return new char[][] {
			{ 't', 'c', 'b', 'd', 'r', 'b', 'c', 't' },
			{ 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
			{ '_', '_', '_', '_', '_', '_', '_', '_' },
			{ '_', '_', '_', '_', '_', '_', '_', '_' },
			{ '_', '_', '_', '_', '_', '_', '_', '_' },
			{ '_', '_', '_', '_', '_', '_', '_', '_' },
			{ 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
			{ 't', 'c', 'b', 'd', 'r', 'b', 'c', 't' },
		};
	}

	private static JFrame criarJanela() {
		JFrame janela = new JFrame("Xadrez");
		janela.setLayout(new GridLayout(NUMERO_LINHAS_TABULEIRO, NUMERO_COLUNAS_TABULEIRO));
		janela.setSize(LARGURA_EM_PIXELS, ALTURA_EM_PIXELS);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return janela;
	}

	private static void preencherJanelaComCasas(char[][] tabuleiro, JFrame janela,
			MouseAdapter tratadorCliques) {
		for (int i = 0; i < NUMERO_LINHAS_TABULEIRO; ++i) {
			for (int j = 0; j < NUMERO_COLUNAS_TABULEIRO; ++j) {
				JLabel label = new JLabel(converterDePecaParaTexto(tabuleiro[i][j]));
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setVerticalAlignment(JLabel.CENTER);
				label.setOpaque(true);
				label.addMouseListener(tratadorCliques);
				janela.add(label);
			}
		}
	}

	private static void exibirJanela(JFrame janela) {
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}

	private static String converterDePecaParaTexto(char peca) {
		return String.valueOf(peca);
	}

	private static final class TratadorCliques extends MouseAdapter {
		private JLabel casaSelecionada;

		@Override
		public void mousePressed(MouseEvent e) {
			JLabel casaClicada = (JLabel) e.getSource();

			if (nenhumaCasaSelecionada()) selecionarCasa(casaClicada);
			else moverPeca(casaClicada);
		}

		private boolean nenhumaCasaSelecionada() {
			return casaSelecionada == null;
		}

		private void selecionarCasa(JLabel casaClicada) {
			casaClicada.setBackground(COR_CASA_SELECIONADA);
			casaSelecionada = casaClicada;
		}

		private void moverPeca(JLabel casaClicada) {
			casaClicada.setText(casaSelecionada.getText());
			casaSelecionada.setBackground(COR_CASA_NAO_SELECIONADA);
			casaSelecionada = null;
		}
	}

}
