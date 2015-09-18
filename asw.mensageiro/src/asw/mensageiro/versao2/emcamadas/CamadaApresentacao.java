package asw.mensageiro.versao2.emcamadas;

import java.util.Scanner;

public class CamadaApresentacao {

	private CamadaNegocio negocio;
	private Scanner scanner;

	public CamadaApresentacao(CamadaNegocio negocio,Scanner scanner) {
		this.negocio = negocio;
		this.scanner = scanner;
	}

	public void listarOpcoes() {
		System.out.println(""
				+ "Comandos validos:\n"
				+ "\tsair\n"
				+ "\tlistar\n"
				+ "\tcriar [nome-da-mensagem]\n"
				+ "\tler [nome-da-mensagem]\n"
				+ "\texcluir [nome-da-mensagem]\n"
				+ "");
	}

	public String lerMensagem() {
	System.out.println("Digite a mensagem e termine com Enter");

	return scanner.nextLine();
	}



}
