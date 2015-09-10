package asw.xadrez.versao3.aposdojo1;

import static asw.xadrez.versao3.aposdojo1.Cor.INDEFINIDO;
import static asw.xadrez.versao3.aposdojo1.TipoDePeca.NULO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

final class TratadorCliquesOffline extends MouseAdapter {
	private JLabel casaOrigem;
	
	Tabuleiro tabuleiro;
	public TratadorCliquesOffline (Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
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
		ConversorCoordenadas coordenadaDestino = new ConversorCoordenadas(casaDestino.getName());
		ConversorCoordenadas coordenadaOrigem = new ConversorCoordenadas(casaOrigem.getName());
		//System.out.println(casaDestino.getName() + coordenada.linha() + coordenada.coluna()); // debug retirar
		//System.out.println(casaOrigem.getName());
		
		tabuleiro.setPeca(coordenadaDestino.linha(), coordenadaDestino.coluna(), tabuleiro.getPeca(coordenadaOrigem.linha(),coordenadaOrigem.coluna()));
		tabuleiro.setPeca(coordenadaOrigem.linha(), coordenadaOrigem.coluna(), new Peca(NULO,INDEFINIDO));
		casaOrigem.setText(Main.CASA_VAZIA);
		
		casaOrigem.setBackground(Main.COR_CASA_NAO_SELECIONADA);

		casaDestino.setForeground(casaOrigem.getForeground());
		casaOrigem.setForeground(ConversorCores.deCorParaAwtColor(Cor.INDEFINIDO));

		casaOrigem = null;
	}
}