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
	private PrintWriter saidaCliente;
	private BufferedReader entradaCliente;
	private static JFrame telaCliente;
	private int porta;
	private JLabel label;
	private String host = "";
	private JPanel painelCliente;
	protected static JTextField textField;
	//private Socket socketCliente;

	public ClienteXadrez(int porta) {
		this.porta = porta;
		
		telaCliente = new JFrame("Cliente");	
		telaCliente.setVisible(true);
		telaCliente.setLocationRelativeTo(null);
		telaCliente.setSize(500,200);
		telaCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textField = new JTextField(20);
		painelCliente = new JPanel();
		label = new JLabel("Host:", JLabel.LEFT);
		
		//label.setOpaque(true);
		
		telaCliente.add(painelCliente);
		JButton botaoConecta = new JButton("Conectar");
		
		
		botaoConecta.addActionListener (new acaoBotaoConecta());
		painelCliente.add(label);
		painelCliente.add(textField);
		painelCliente.add(botaoConecta);
		
	}
	
	
	public void conectaCliente(){
		try (
				Socket socketCliente = new Socket(host, porta);
				
				) {
			saidaCliente = new PrintWriter(socketCliente.getOutputStream(), true);
			entradaCliente = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String fromServer;
			String fromUser;

			while ((fromServer = entradaCliente.readLine()) != null) {
				System.out.println("Server: " + fromServer);
				if (fromServer.equals("Bye."))
					break;

				fromUser = stdIn.readLine();
				if (fromUser != null) {
					System.out.println("Client: " + fromUser);
					saidaCliente.println(fromUser);
				}
			}
		} catch (UnknownHostException e) {
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
			
			
		}
	}
}
