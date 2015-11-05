package asw.mensageiro.versao3.persistencia;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CamadaDados dados = null;
		System.out.println("Selecione o armazenamento desejado: \n 1 - diretorio temp \n 2 - HSQL");
		Scanner scanner = new Scanner(System.in);
		System.out.print("> ");
		String linhaLida = scanner.nextLine();
		
		switch (linhaLida) {
		case "1": {
			dados = new CamadaDadosDiretorioTemp();
			break;
		}
		case "2": {
			dados = new CamadaDadosHsqldb();
			break;
		}
		default: {
			System.err.println("Selecao Invalida. Saindo...");
			return;

		}
		}
		
		
		CamadaNegocio negocio = new CamadaNegocio(dados);
		CamadaApresentacao apresentacao = new CamadaApresentacao(negocio);

		apresentacao.menu();
		scanner.close();
	}

}
