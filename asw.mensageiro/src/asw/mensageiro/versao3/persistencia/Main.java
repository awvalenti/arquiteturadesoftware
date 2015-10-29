package asw.mensageiro.versao3.persistencia;


public class Main {

	public static void main(String[] args) {
		CamadaDadosHsqldb dados = new CamadaDadosHsqldb();
		//CamadaDadosDiretorioTemp dados = new CamadaDadosDiretorioTemp();
		CamadaNegocio negocio = new CamadaNegocio(dados);
		CamadaApresentacao apresentacao = new CamadaApresentacao(negocio);
		
		
		apresentacao.menu();
	}

}
