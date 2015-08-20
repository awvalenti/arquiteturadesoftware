package asw.xadrez.versao1.semestrutura;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	public static void main(String[] args) {

		// Matriz representando o tabuleiro
		char[][] tabuleiro = {
			{ 't', 'c', 'b', 'd', 'r', 'b', 'c', 't' },
			{ 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
			{ '_', '_', '_', '_', '_', '_', '_', '_' },
			{ '_', '_', '_', '_', '_', '_', '_', '_' },
			{ '_', '_', '_', '_', '_', '_', '_', '_' },
			{ '_', '_', '_', '_', '_', '_', '_', '_' },
			{ 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
			{ 't', 'c', 'b', 'd', 'r', 'b', 'c', 't' },
		};

		JFrame janela = new JFrame("Xadrez");
		// 8 linhas e 8 colunas
		janela.setLayout(new GridLayout(8, 8));
		// 8 * 32 = 256
		janela.setSize(256, 256);

		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j) {
				JLabel label = new JLabel(String.valueOf(tabuleiro[i][j]));
				label.setOpaque(true);
				label.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						// Quando botao do mouse for pressionado

						boolean selec = false;
						// janela.getContentPane().getComponentCount() obtem o numero de componentes
						for (int k = 0; k < janela.getContentPane().getComponentCount(); ++k) {
							// janela.getContentPane().getComponent(k) obtem o componente
							if (((JLabel) janela.getContentPane().getComponent(k)).getBackground()
									.equals(Color.CYAN)) {
								// Ja' tem uma casa selecionada; entao, vai tentar fazer o movimento
								selec = true;

								((JLabel) janela.getContentPane().getComponent(k))
										.setBackground(new Color(238, 238, 238));
								// setText define o texto que sera escrito no JLabel
								((JLabel) e.getSource()).setText(((JLabel) janela.getContentPane()
										.getComponent(k)).getText());
								((JLabel) janela.getContentPane().getComponent(k)).setText("_");
							}
						}
						if (!selec) {
							// Se nao havia casa selecionada, vai selecionar uma agora
							((JLabel) e.getSource()).setBackground(Color.CYAN);
						}
					}
				});
				// Acrescenta label 'a janela
				janela.add(label);
			}
		}

		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}

}
