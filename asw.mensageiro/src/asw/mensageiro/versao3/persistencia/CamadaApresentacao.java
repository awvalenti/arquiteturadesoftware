package asw.mensageiro.versao3.persistencia;

import java.util.List;
import java.util.Scanner;

public class CamadaApresentacao {

	private CamadaNegocio negocio;

	public CamadaApresentacao(CamadaNegocio negocio) {

		this.negocio = negocio;

	}

	public void menu() {
		try (Scanner scanner = new Scanner(System.in)) {

			listarOpcoes();
			String comando = null;
			do {
				// Apresentacao
				System.out.print("> ");
				String linhaLida = scanner.nextLine();
				String[] palavras = linhaLida.split(" ");
				comando = palavras[0];
				String nomeMsg = "";
				if (palavras.length > 1)
					nomeMsg = palavras[1];

				try {

					switch (/* Apresentacao */comando) {

					case "listar":

						exibirLista(negocio.listarMensagens());
						break;

					case "criar":
						
						negocio.criarMensagem(nomeMsg, lerMensagem(scanner));
						break;

					case "ler":
						mostrarConteudo(nomeMsg);
						break;

					case "excluir":

						negocio.excluir(nomeMsg);

						break;

					case "sair":
						break;

					default:
						// Apresentacao
						System.err.print("Comando invalido");
						System.out.println();
					}

				} catch (Exception e) {

					e.printStackTrace();
				}

			} while (comando == null || !comando.equals("sair"));
		}
	}

	public void listarOpcoes() {

		System.out.println("" + "Comandos validos:\n" + "\tsair\n"
				+ "\tlistar\n" + "\tcriar [nome-da-mensagem]\n"
				+ "\tler [nome-da-mensagem]\n"
				+ "\texcluir [nome-da-mensagem]\n" + "");
	}

	public String lerMensagem(Scanner scanner) {

		System.out.println("Digite a mensagem e termine com Enter");
		return scanner.nextLine();
	}

	public void mostrarConteudo(String nomeMsg) {

		// System.out.println("Digite o nome mensagem e termine com Enter");
		// String nomeMsg = scanner.nextLine();
		try {
			System.out.println(negocio.lerMensagem(nomeMsg));
		} catch (MensagemNaoEncontradaException e) {
			System.out.println("Mensagem Não encontrada");
		}
	}

	public void exibirLista(List<String> lista) {
		System.out.println(lista);
	}

}
