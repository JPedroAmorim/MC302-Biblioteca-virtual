package trabalho1;

public class UsuarioAdmin extends Usuario {

	public UsuarioAdmin(String nome, String senha, String dataNasc, String email, boolean status) {
		super(nome, senha, dataNasc, email, status);
	}

    public void cadastrarLivro(Livro livro) {
	    Biblioteca.acervo.add(livro);
    }

    public void adicionarUsuario(Usuario usuario) {
	    Biblioteca.usuarios.add(usuario);
    }
}
