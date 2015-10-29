package asw.mensageiro.versao3.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CamadaDadosDiretorioTemp implements CamadaDados {

	private final File diretorio;

	public CamadaDadosDiretorioTemp() {
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

		} catch (IOException e) {
			return false;
		}

		return true;
	}
	public void excluir (String nomeMsg) {
		new File(getDiretorio(), nomeMsg).delete();
	}
	public String lerMensagem(String nomeMsg)
			throws MensagemNaoEncontradaException {

		File arquivo;
		arquivo = new File(getDiretorio(), nomeMsg);
		try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {

			// Apresentacao
			return leitor.readLine();

		} catch (FileNotFoundException e) {

			throw new MensagemNaoEncontradaException();
			// throw new RuntimeException(e);

		} catch (IOException e) {

			return "aconteceu algum erro no carregamento do arquivo";
			// throw new RuntimeException(e);
		}
	}

}
