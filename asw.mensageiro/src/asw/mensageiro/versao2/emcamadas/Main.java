package asw.mensageiro.versao2.emcamadas;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CamadaDados dados = new CamadaDados();
		CamadaNegocio negocio = new CamadaNegocio(dados);
		CamadaApresentacao apresentacao = new CamadaApresentacao(negocio);
		
		apresentacao.menu();
	}

}
