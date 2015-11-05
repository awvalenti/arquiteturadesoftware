package asw.xadrez.versao3.aposdojo1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

final class TratadorCliques extends MouseAdapter {
	private JLabel casaOrigem;
	

	@Override
	public void mousePressed(MouseEvent e) {
		JLabel casaClicada = (JLabel) e.getSource();

		if (nenhumaCasaSelecionada()) {
			if (casaClicada.getText().equals(Main.CASA_VAZIA)) return;
			selecionarCasa(casaClicada);
		} else {
			if (casaClicada != casaOrigem) moverPeca(casaClicada);
			if (casaClicada == casaOrigem) deselecionarCasa(casaClicada);
		}
	}
	private void deselecionarCasa(JLabel casaClicada){
		casaClicada.setBackground(Main.COR_CASA_NAO_SELECIONADA);
		casaOrigem = null;
	}
	private boolean nenhumaCasaSelecionada() {
		return casaOrigem == null;
	}

	private void selecionarCasa(JLabel casaClicada) {
		casaClicada.setBackground(Main.COR_CASA_SELECIONADA);
		casaOrigem = casaClicada;
	}

	private void moverPeca(JLabel casaDestino) {
		casaDestino.setText(casaOrigem.getText());
		casaOrigem.setText(Main.CASA_VAZIA);
		casaOrigem.setBackground(Main.COR_CASA_NAO_SELECIONADA);

		casaDestino.setForeground(casaOrigem.getForeground());
		casaOrigem.setForeground(ConversorCores.deCorParaAwtColor(Cor.INDEFINIDO));

		casaOrigem = null;
	}
}