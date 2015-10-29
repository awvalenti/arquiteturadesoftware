package asw.mensageiro.versao3.persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CamadaNegocio {

	private CamadaDados dados;

	public CamadaNegocio(CamadaDados dados) {
		this.dados = dados;
	}
	public List<String> listarMensagens(){
		
		return dados.listarMensagens();
		
	}
	
	public String lerMensagem(String nomeMsg) throws MensagemNaoEncontradaException {
		return dados.lerMensagem(nomeMsg);		
	}
	public boolean criarMensagem(String nomeMsg, String conteudo) {
		return dados.criarMensagem(nomeMsg, conteudo);
	}
	public void excluir (String nomeMsg) {
		dados.excluir(nomeMsg);
	}
}
