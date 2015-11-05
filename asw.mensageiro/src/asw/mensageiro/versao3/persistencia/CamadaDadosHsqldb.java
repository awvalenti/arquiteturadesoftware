package asw.mensageiro.versao3.persistencia;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CamadaDadosHsqldb implements CamadaDados {

	private File diretorio;
	private Connection conexao;

	public CamadaDadosHsqldb() {
		try {
			conexao = DriverManager
					.getConnection("jdbc:hsqldb:hsql://localhost/");
		} catch (SQLException e) {
			System.err.println("ERRO NA CONEXÃO SQL");
			e.printStackTrace();
		}

	}

	public File getDiretorio() {
		diretorio = new File(System.getProperty("java.io.tmpdir"), "mensagens");
		diretorio.mkdir();

		return diretorio;

	}

	public boolean criarMensagem(String nomeMsg, String conteudo) {
		int ret;
		try {
			PreparedStatement pSt = conexao
					.prepareStatement("insert into mensagens (nome,mensagem) values (?, ?)");
			pSt.setString(1, nomeMsg);
			pSt.setString(2, conteudo);

			ret = pSt.executeUpdate();
		} catch (SQLException e) {

			return false;

		}

		if (ret == 1)
			return true;
		return false;
	}

	public void excluir(String nomeMsg) {

		try {
			PreparedStatement pSt = conexao
					.prepareStatement("DELETE FROM mensagens WHERE nome = ?");
			pSt.setString(1, nomeMsg);
			pSt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("ERRO NA CONEXÃO SQL");
			e.printStackTrace();
		}

	}

	public String lerMensagem(String nomeMsg)
			throws MensagemNaoEncontradaException {

		try {
			PreparedStatement pSt = conexao
					.prepareStatement("SELECT mensagem FROM MENSAGENS where nome = ?");
			pSt.setString(1, nomeMsg);
			ResultSet resultado = pSt.executeQuery();
			if (resultado.next())
				return resultado.getString("mensagem");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return "aconteceu algum erro no carregamento da mensagem ou mensagem não encontrada";
		// throw new RuntimeException(e);
	}

	@Override
	public List<String> listarMensagens() {
		List<String> a = new ArrayList<String>();

		PreparedStatement pSt;
		try {
			pSt = conexao.prepareStatement("SELECT nome FROM MENSAGENS");
			ResultSet resultado = pSt.executeQuery();
			while (resultado.next()) {
				a.add(resultado.getString("nome"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return a;
	}
}
