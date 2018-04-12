package trabalho1;

public enum Catalogo {
	BIOLOGIA (40),
	MATEMATICA (50),
	PORTUGUES (60);
	
	private final double valor;
	
	private Catalogo(double valor) {
		this.valor = valor;
	}
	
	public double getValor(Catalogo livro) {
		return livro.valor;
	}
	
}
