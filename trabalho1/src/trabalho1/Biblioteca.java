package trabalho1;

import java.util.ArrayList;


// Classe biblioteca: É o banco de dados onde estão armazenadas as AL necessárias do sistema.

public class Biblioteca {

    public static ArrayList<Livro> acervo = new ArrayList<Livro>();
    public static ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    public static ArrayList<Cupom> cupons = new ArrayList<Cupom>();

}


