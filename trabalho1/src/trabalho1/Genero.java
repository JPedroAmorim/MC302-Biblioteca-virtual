package trabalho1;

// Classe enum Genero: abstração do gênero de um livro para os efeitos do sistema.

public enum Genero {

    // Constantes.

    MATEMATICA("Matemetica"),
    BIOLOGIA("Biologia"),
    PORTUGUES("Portugues"),
    HISTORIA("Historia"),
    GEOGRAFIA("Geografia"),
    FISICA("Fisica"),
    QUIMICA("Quimica"),
    ROMANCE("Romance"),
    DRAMA("Drama"),
    RELIGIOSO("Religioso"),
    AVENTURA("Aventura"),
    TRAGEDIA("Tragedia");

    // Atributo.

    private String tipo;

    // Construtor.

    private Genero(String tipo) {
        this.tipo = tipo;
    }

    // Getter.

    public String getTipo() {
        return tipo;
    }


    // toString de Genero.

    // @Override

    public String toString() {
        return ("Gênero: " + getTipo() + "\n");
    }
}
