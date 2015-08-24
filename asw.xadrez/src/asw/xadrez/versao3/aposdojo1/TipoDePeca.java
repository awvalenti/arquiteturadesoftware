package asw.xadrez.versao3.aposdojo1;

enum TipoDePeca {
	TORRE('t'), CAVALO('c'), BISPO('b'), RAINHA('d'), REI('r'), PEAO('p'),NULO('_');
	
	private final char caractere;
	
	public char getCaractere() {
		return caractere;
	}

	private TipoDePeca(char caractere) {
		this.caractere = caractere;
	}
	
}