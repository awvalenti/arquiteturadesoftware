package asw.xadrez.versao3.aposdojo1;
// esta classe converte um texto no formato "i,j" para coordenadas numéricas
public class ConversorCoordenadas {
	private String coordenada;
	
	public ConversorCoordenadas (String coordenada) {
		this.coordenada = coordenada;
	}
	public int linha () {
		return Integer.parseInt(coordenada.substring(0, coordenada.indexOf(",")));
	}
	public int coluna () {
		return Integer.parseInt(coordenada.substring(coordenada.indexOf(",") + 1,coordenada.length()));
	}
}
