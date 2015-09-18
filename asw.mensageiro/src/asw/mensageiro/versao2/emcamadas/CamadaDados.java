package asw.mensageiro.versao2.emcamadas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CamadaDados {

	private final File diretorio;

	public CamadaDados() {
		diretorio = new File(System.getProperty("java.io.tmpdir"), "mensagens");
		diretorio.mkdir();
	}

	public File getDiretorio() {
		return diretorio;
	}
	public File criarArquivo(String nomeMsg) throws IOException {
		File arquivo = new File(getDiretorio(), nomeMsg);
		arquivo.createNewFile();
		return arquivo;
	}

	public boolean criarMensagem(String nomeMsg, String conteudo) {
		try {
			File arquivo = criarArquivo(nomeMsg);
			FileWriter writer = new FileWriter(arquivo);
			writer.append(conteudo);
			writer.close();

		}catch (IOException e) {
			return false;
		}

		return true;
	}
	public String lerMensagem(String nomeMsg) {

		File arquivo;
		arquivo = new File(getDiretorio(), nomeMsg);
		try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {

			// Apresentacao
			return leitor.readLine();

		} catch (FileNotFoundException e) {

			throw new RuntimeException(e);

		} catch (IOException e) {

			throw new RuntimeException(e);
		}
	}

}
