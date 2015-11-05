package asw.xadrez.versao3.aposdojo1;

import static asw.xadrez.versao3.aposdojo1.Cor.INDEFINIDO;
import static asw.xadrez.versao3.aposdojo1.TipoDePeca.NULO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.swing.JLabel;

final class TratadorCliquesOffline extends MouseAdapter {
	private JLabel casaOrigem;
	public boolean habilitaJogadaLocal = false;
	private PrintWriter saidaTratador;
	private BufferedReader entradaTratador;
	static HashMap<String, JLabel> labels;

	Tabuleiro tabuleiro;
	public TratadorCliquesOffline (Tabuleiro tabuleiro, BufferedReader entradaTratador, PrintWriter saidaTratador,HashMap<String, JLabel> labels) {
		this.tabuleiro = tabuleiro;
		this.saidaTratador = saidaTratador;
		this.entradaTratador = entradaTratador;
		this.labels = labels ;
	}
	public boolean isHabilita() {
		return habilitaJogadaLocal;
	}
	public void setHabilita(boolean habilita) {
		this.habilitaJogadaLocal = habilita;
	}
	public void moverPecaPorTexto (String comando) {
		final String casaOrigemTexto = comando.substring(0, comando.indexOf(" "));
		final String casaDestinoTexto = comando.substring(comando.indexOf(" para ") + 6, comando.length());
		System.out.println("Casa Origem " + casaOrigemTexto + "-");
		System.out.println("Casa Destino " + casaDestinoTexto + "-");
		casaOrigem = labels.get(casaOrigemTexto);
		moverPeca(labels.get(casaDestinoTexto));
		System.out.println("Peça movida comando:"+ comando);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if (habilitaJogadaLocal){
			JLabel casaClicada = (JLabel) e.getSource();

			if (nenhumaCasaSelecionada()) {
				if (casaClicada.getText().equals(Main.CASA_VAZIA)) return;
				selecionarCasa(casaClicada);
			} else {

				if (casaClicada != casaOrigem) {
					moverPeca(casaClicada);
					this.setHabilita(false);					
					recebeJogada();
					this.setHabilita(true);
				}
				if (casaClicada == casaOrigem) deselecionarCasa(casaClicada);

			}
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
		String jogadaParaTexto = casaOrigem.getName() + " para " + casaDestino.getName(); // jogada para texto

		saidaTratador.println(jogadaParaTexto);
		saidaTratador.flush();

		tabuleiro.setPeca(coordenadaDestino.linha(), coordenadaDestino.coluna(), tabuleiro.getPeca(coordenadaOrigem.linha(),coordenadaOrigem.coluna()));
		tabuleiro.setPeca(coordenadaOrigem.linha(), coordenadaOrigem.coluna(), new Peca(NULO,INDEFINIDO));
		casaOrigem.setText(Main.CASA_VAZIA);

		casaOrigem.setBackground(Main.COR_CASA_NAO_SELECIONADA);

		casaDestino.setForeground(casaOrigem.getForeground());
		casaOrigem.setForeground(ConversorCores.deCorParaAwtColor(Cor.INDEFINIDO));

		casaOrigem = null;
		
		
		
	}
	private void recebeJogada() {
		Runnable runnable = new Runnable() {
			public void run() {
				try {
					System.out.println("Entre comando:");
					String comandoEntrada = entradaTratador.readLine();
					System.out.println("comando recebido, movendo");
					moverPecaPorTexto(comandoEntrada);
				} catch (IOException e) {			
					e.printStackTrace();
				}
			}
		};
		new Thread(runnable).start();
	}
}