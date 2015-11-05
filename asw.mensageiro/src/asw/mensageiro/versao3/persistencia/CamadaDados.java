package asw.mensageiro.versao3.persistencia;

import java.io.File;
import java.util.List;

public interface CamadaDados {

	public File getDiretorio();

	public boolean criarMensagem(String nomeMsg, String conteudo);

	public void excluir(String nomeMsg);

	public String lerMensagem(String nomeMsg)
			throws MensagemNaoEncontradaException;

	public List<String> listarMensagens();
}
