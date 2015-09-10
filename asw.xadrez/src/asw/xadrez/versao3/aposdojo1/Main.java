package asw.xadrez.versao3.aposdojo1;


import java.awt.Color;

import java.awt.GridLayout;

import java.awt.event.MouseAdapter;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Main {

	static final Color COR_CASA_SELECIONADA = Color.CYAN;
	static final Color COR_CASA_NAO_SELECIONADA = new Color(120, 120, 120);
	static final int PORTA_ENET = 666;
	private static final int LARGURA_EM_PIXELS = 256;
	private static final int ALTURA_EM_PIXELS = 256;
	static HashMap<String, JLabel> labels = new HashMap<String,JLabel>();

	static final String CASA_VAZIA = "_";

	public static void main(String[] args) {

		TelaInicial.exibeTela();

	} 

	public static void jogoOffline(){
		Tabuleiro tabuleiro = new Tabuleiro();			
		JFrame janela = criarJanela();

		TratadorCliquesOffline tratadorCliques = new TratadorCliquesOffline(tabuleiro);
		tratadorCliques.setHabilita(true);
		preencherJanelaComCasas(tabuleiro, janela, tratadorCliques);

		exibirJanela(janela);
		Runnable runnable = new Runnable() {
			public void run() {
				while (true) {
					tratadorCliques.setHabilita(true);
				}
			}	
		};
		new Thread(runnable).start();
	}

	public static void jogoServidor(){
		ServidorXadrez servidor = new ServidorXadrez(PORTA_ENET);

		Tabuleiro tabuleiro = new Tabuleiro();			
		JFrame janela = criarJanela();		
		MouseAdapter tratadorCliques = new TratadorCliquesOffline(tabuleiro);		
		preencherJanelaComCasas(tabuleiro, janela, tratadorCliques);		
		exibirJanela(janela);
		servidor.aguardaConexao();
		
	}
	public static void jogoCliente(){
		ClienteXadrez cliente = new ClienteXadrez(PORTA_ENET);
		//cliente.aguardaConexao();
		Tabuleiro tabuleiro = new Tabuleiro();			
		JFrame janela = criarJanela();		
		MouseAdapter tratadorCliques = new TratadorCliquesOffline(tabuleiro);		
		preencherJanelaComCasas(tabuleiro, janela, tratadorCliques);		
		exibirJanela(janela);

	}



	public static void atualizaJanela(Tabuleiro tabuleiro, JFrame janela,
			MouseAdapter tratadorCliques){
		janela.dispose();
		preencherJanelaComCasas(tabuleiro, janela, tratadorCliques);

	}

	private static JFrame criarJanela() {
		JFrame janela = new JFrame("Xadrez");
		janela.setLayout(new GridLayout(Constantes.NUMERO_LINHAS_TABULEIRO, Constantes.NUMERO_COLUNAS_TABULEIRO));
		janela.setSize(LARGURA_EM_PIXELS, ALTURA_EM_PIXELS);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return janela;
	}

	private static void preencherJanelaComCasas(Tabuleiro tabuleiro, JFrame janela,
			MouseAdapter tratadorCliques) {
		for (int i = 0; i < Constantes.NUMERO_LINHAS_TABULEIRO; ++i) {
			for (int j = 0; j < Constantes.NUMERO_COLUNAS_TABULEIRO; ++j) {
				Peca peca = tabuleiro.getPeca(i, j);
				labels.put(i + "," + j, new JLabel(peca.toString()));
				JLabel label = labels.get(i + "," + j);
				label.setForeground(peca.getCor() == Cor.INDEFINIDO ? Color.CYAN:peca.getCor() == Cor.PRETO ? Color.BLACK : Color.WHITE);
				label.setBackground(COR_CASA_NAO_SELECIONADA);
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setVerticalAlignment(JLabel.CENTER);
				label.setOpaque(true);
				label.addMouseListener(tratadorCliques);
				label.setName(i + "," + j); // possibilita nomear cada label com sua posição no grid
				
				janela.add(label);
			}
		}
	}

	private static void exibirJanela(JFrame janela) {
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}
}