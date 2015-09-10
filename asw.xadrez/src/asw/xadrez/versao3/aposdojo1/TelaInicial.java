package asw.xadrez.versao3.aposdojo1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TelaInicial implements ActionListener {
	protected static JTextField textField;
	protected static JFrame telaInicial;
	public static void exibeTela() {

		telaInicial = new JFrame("Xadrez - Início");	
		telaInicial.setVisible(true);
		telaInicial.setLocationRelativeTo(null);
		telaInicial.setSize(500,100);
		telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painelTelaInicial = new JPanel();
		telaInicial.add(painelTelaInicial);
		
		JButton botaoJogoOffline = new JButton("Jogo Local");
		
		painelTelaInicial.add(botaoJogoOffline);
		botaoJogoOffline.addActionListener (new acaoJogoOffline());

		JButton botaoJogoServidor = new JButton("Jogo em Rede - Servidor");
		painelTelaInicial.add(botaoJogoServidor);
		botaoJogoServidor.addActionListener (new acaoIniciarServidor()); 

		
		
		JButton botaoJogoCliente = new JButton("Jogo em Rede - Cliente");
		painelTelaInicial.add(botaoJogoCliente);
		botaoJogoCliente.addActionListener (new acaoIniciarCliente()); 
		
	}
	public void actionPerformed(ActionEvent evt) {
		
		

		//Make sure the new text is visible, even if there
		//was a selection in the text area.
		
	}


	static class acaoJogoOffline implements ActionListener {        
		public void actionPerformed (ActionEvent e) {
			Main.jogoOffline();
			telaInicial.setVisible(false);
		}
	}
	static class acaoIniciarServidor implements ActionListener {        
		public void actionPerformed (ActionEvent e) {
			telaInicial.setVisible(false);
			Main.jogoServidor();
			
			
		}
	}
	static class acaoIniciarCliente implements ActionListener {        
		public void actionPerformed (ActionEvent e) {
			
			telaInicial.setVisible(false);
			Main.jogoCliente();
		}
	}

}