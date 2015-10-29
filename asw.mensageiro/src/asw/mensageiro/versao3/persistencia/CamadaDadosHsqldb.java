package asw.mensageiro.versao3.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CamadaDadosHsqldb implements CamadaDados {

	private File diretorio;
	private Connection conexao;

	public CamadaDadosHsqldb() {
		try {
			conexao = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/");
		} catch (SQLException e) {
			System.err.println("ERRO NA CONEX�O SQL");
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
			PreparedStatement pSt = conexao.prepareStatement(
					"insert into mensagens (nome,mensagem) values ('" + nomeMsg + "', '" + conteudo + "')");
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
			PreparedStatement pSt = conexao.prepareStatement("DELETE FROM mensagens WHERE nome = '" + nomeMsg + "'");
			pSt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("ERRO NA CONEX�O SQL");
			e.printStackTrace();
		}

	}

	public String lerMensagem(String nomeMsg) throws MensagemNaoEncontradaException {

		
		
		
		try {
			PreparedStatement pSt = conexao
					.prepareStatement("SELECT mensagem FROM MENSAGENS where nome = '" + nomeMsg + "'");
			ResultSet resultado = pSt.executeQuery();
			if (resultado.next()) return resultado.getString("mensagem");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

			return "aconteceu algum erro no carregamento da mensagem ou mensagem n�o encontrada";
			// throw new RuntimeException(e);
		}
	}


