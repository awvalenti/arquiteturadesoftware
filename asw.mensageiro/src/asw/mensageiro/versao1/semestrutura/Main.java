package asw.mensageiro.versao1.semestrutura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println(""
				+ "Comandos validos:\n"
				+ "\tsair\n"
				+ "\tlistar\n"
				+ "\tcriar [nome-da-mensagem]\n"
				+ "\tler [nome-da-mensagem]\n"
				+ "\texcluir [nome-da-mensagem]\n"
				+ "");

		File diretorio;
		if (args.length == 0) {
			diretorio = new File(System.getProperty("java.io.tmpdir"), "mensagens");
			diretorio.mkdir();
		} else {
			diretorio = new File(args[0]);
		}

		try (Scanner scanner = new Scanner(System.in)) {
			String comando = null;
			do {
				System.out.print("> ");
				String linhaLida = scanner.nextLine();

				String[] palavras = linhaLida.split(" ");
				comando = palavras[0];
				String nomeMsg = null;
				if (palavras.length > 1) nomeMsg = palavras[1];

				try {

					switch (comando) {
					case "listar":
						for (String mensagem : diretorio.list()) {
							System.out.println(mensagem);
						}
						break;

					case "criar":
						File arquivo = new File(diretorio, nomeMsg);
						arquivo.createNewFile();
						System.out.println("Digite a mensagem e termine com Enter");
						String conteudo = scanner.nextLine();
						try (FileWriter writer = new FileWriter(arquivo)) {
							writer.append(conteudo);
						}
						break;

					case "ler":
						arquivo = new File(diretorio, nomeMsg);
						try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
							System.out.println(leitor.readLine());
						}
						break;

					case "excluir":
						new File(diretorio, nomeMsg).delete();
						break;

					case "sair":
						break;

					default:
						System.err.print("Comando invalido");
						System.out.println();
					}

				} catch (IOException e) {
					e.printStackTrace();
				}

			} while (comando == null || !comando.equals("sair"));
		}
	}

}
