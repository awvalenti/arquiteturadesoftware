

package asw.xadrez.versao3.aposdojo1;
import java.io.*;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ServidorXadrez{
	public PrintWriter saidaServidor;
	public BufferedReader entradaServidor;
	private static JFrame telaServidor;
	private int porta;
	private JLabel label;
	private ServerSocket socketServidor;
	private Socket clientSocket;
	boolean prontoParaJogar = false;
	
	public boolean isProntoParaJogar() {
		return prontoParaJogar;
	}
	public PrintWriter getSaida() {
		return saidaServidor;
	}
	public BufferedReader getEntrada() {
		return entradaServidor;
	}
	public ServidorXadrez(int porta) {
		this.porta = porta;

		telaServidor = new JFrame("Servidor");	
		telaServidor.setVisible(true);
		telaServidor.setLocationRelativeTo(null);
		telaServidor.setSize(500,200);
		telaServidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		label = new JLabel("Aguardando Conexão", JLabel.LEFT);

		//label.setOpaque(true);

		telaServidor.add(label);
		telaServidor.repaint();


	}
	public void encerraConexao() throws IOException{
		socketServidor.close();
	}
	public void aguardaConexao(){ 
	/*	Runnable runnable = new Runnable() {
			public void run() {*/
				try {
					socketServidor = new ServerSocket(porta);
					clientSocket = socketServidor.accept();
					
					System.out.println("Conectou!");
					saidaServidor = new PrintWriter(clientSocket.getOutputStream(), true);
					entradaServidor = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					
					prontoParaJogar = true;
					saidaServidor.println("Bem Vindo");
					// Initiate conversation with client

					//outputLine = kkp.processInput(null);
					//saidaServidor.println(outputLine);



				} catch (IOException e) {
					System.out.println("Exception caught when trying to listen on port "
							+ porta + " or listening for a connection");
					System.out.println(e.getMessage());
				}

			}



		//};
		//new Thread(runnable).start();
	//}
		

	//}
	public void trataConexao() throws IOException{
		String inputLine, outputLine;
		while ((inputLine = entradaServidor.readLine()) != null) {
			//outputLine = kkp.processInput(inputLine);
			//saidaServidor.println(outputLine);
			System.out.println(inputLine);
			if (inputLine.equals("Bye."))
				break;
		}
	}
}
