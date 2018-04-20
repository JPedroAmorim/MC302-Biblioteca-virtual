package trabalho1;

public enum Genero {
	MATEMATICA("Matemetica"), 
	BIOLOGIA("Biologia"),
	PORTUGUES("Portugues"), 
	HISTORIA("Historia"),
	GEOGRAFIA("Geografia"), 
	FISICA("Fisica"),
	QUIMICA("Quimica");
	
	private String tipo;

	private Genero(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
}
