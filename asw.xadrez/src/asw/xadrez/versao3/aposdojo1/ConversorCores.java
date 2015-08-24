package asw.xadrez.versao3.aposdojo1;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class ConversorCores {
	
	private static final Map<Cor, Color> mapa;
	
	static {
		mapa = new HashMap<>();
		mapa.put(Cor.BRANCO, Color.WHITE);
		mapa.put(Cor.PRETO, Color.BLACK);
		mapa.put(Cor.INDEFINIDO, Color.CYAN);
	}
	
	public static Color deCorParaAwtColor(Cor cor) {
		return mapa.get(cor);
	}
}
