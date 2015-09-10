package asw.xadrez.versao3.aposdojo1;

import java.io.BufferedReader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import asw.xadrez.versao3.aposdojo1.TelaInicial.acaoJogoOffline;

public class ClienteXadrez {
	public static PrintWriter saidaCliente;
	public static BufferedReader entradaCliente;
	private static JFrame telaCliente;
	private static int porta;
	private JLabel label;
	private static JButton botaoConecta = new JButton("Conectar");
	//private String host = "";
	private JPanel painelCliente;
	protected static JTextField hostServidor;
	//private Socket socketCliente;
	private static boolean prontoParaJogar = false;

	public boolean isProntoParaJogar() {
		return prontoParaJogar;
	}
	public PrintWriter getSaida() {
		return saidaCliente;
	}
	public BufferedReader getEntrada() {
		return entradaCliente;
	}

	public ClienteXadrez(int porta1) {
		porta = porta1;

		telaCliente = new JFrame("Cliente");	
		telaCliente.setVisible(true);
		telaCliente.setLocationRelativeTo(null);
		telaCliente.setSize(500,200);
		telaCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hostServidor = new JTextField(30);
		painelCliente = new JPanel();
		label = new JLabel("Host:", JLabel.LEFT);

		//label.setOpaque(true);

		telaCliente.add(painelCliente);



		botaoConecta.addActionListener (new acaoBotaoConecta());
		painelCliente.add(label);
		painelCliente.add(hostServidor);
		painelCliente.add(botaoConecta);

	}


	public static void conectaCliente(String host){


		try {

			Socket socketCliente = new Socket(host, porta);


			saidaCliente = new PrintWriter(socketCliente.getOutputStream(), true);
			entradaCliente = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

			prontoParaJogar = true;



		}
		catch (UnknownHostException e) {
			System.err.println("Don't know about host " + host);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " +
					host);
			System.exit(1);
		}	
	}



	static class acaoBotaoConecta implements ActionListener {        
		public void actionPerformed (ActionEvent e) {
			botaoConecta.setText("Conectando.");
			conectaCliente(hostServidor.getText());

		}
	}
}
