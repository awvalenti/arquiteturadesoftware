package asw.mensageiro.versao2.emcamadas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CamadaDados dados = new CamadaDados();
		CamadaNegocio negocio = new CamadaNegocio(dados);


		try (/* Apresentacao */ Scanner scanner = new Scanner(System.in)) {
			CamadaApresentacao apresentacao = new CamadaApresentacao(negocio,scanner);
			apresentacao.listarOpcoes();
			String comando = null;
			do {
				// Apresentacao
				System.out.print("> ");
				String linhaLida = scanner.nextLine();
				String[] palavras = linhaLida.split(" ");
				comando = palavras[0];
				String nomeMsg = null;
				if (palavras.length > 1) nomeMsg = palavras[1];
				try {


					File arquivo;
					switch (/* Apresentacao */ comando) {

					case "listar":
						// <Negocio>
						for (String mensagem : /* Dados */ dados.getDiretorio().list()) {
							// Apresentacao
							System.out.println(mensagem);
						}
						break;
						// </Negocio>

					case "criar":

						// Apresentacao
						dados.criarMensagem(nomeMsg, apresentacao.lerMensagem());
						// Dados
						break;

					case "ler":
						// Dados
						System.out.println(dados.lerMensagem(nomeMsg));
						//arquivo = new File(dados.getDiretorio(), nomeMsg);
						//try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {

							// Apresentacao
						//	System.out.println(/* Dados */ leitor.readLine());
						//}
						break;

					case "excluir":
						// Dados
						new File(dados.getDiretorio(), nomeMsg).delete();
						break;

					case "sair":
						break;

					default:
						// Apresentacao
						System.err.print("Comando invalido");
						System.out.println();
					}

				} catch (Exception e) {
					// Apresentacao
					e.printStackTrace();
				}

			} while (/* Apresentacao */ comando == null || !comando.equals("sair"));
		}
	}

}
