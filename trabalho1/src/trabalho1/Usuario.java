package trabalho1;

import java.util.ArrayList;
import java.util.Random; // Fiz um random com seed do geradorId para que cada Id seja um número único e 
						//	aleatório, como nos sistemas reais

public class Usuario {

	private int id;
	private static int geradorId=0;
	private String nome;
	private String senha;
	private String dataNasc;
	private String email;
	private boolean status;
	private ArrayList<Livro> livrosEmprestados;
	private ArrayList<Emprestimo> emprestimosAtivos;
	private ArrayList<Object> amigos; // Pode ser um amigo Usuario ou Usuario estudante, daí a AL heterogênea
	
	public Usuario( String nome, String senha, String dataNasc, String email, boolean status) {
		this.nome = nome;
		this.senha = senha;
		this.dataNasc = dataNasc;
		this.email = email;
		this.status = status;
		this.livrosEmprestados = new ArrayList<Livro>();
		this.emprestimosAtivos = new ArrayList<Emprestimo>();
		this.amigos = new ArrayList<Object>();
		Random geradorIdRandom = new Random(geradorId);
		this.id = geradorIdRandom.nextInt();
		Biblioteca.usuarios.add(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() { return senha; }

	public void setSenha(String senha) { this.senha = senha; }

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	// @Overrride
	public String toString() { // Alterei o toString para os novos atributos adicionados...
		String out = "Nome: "+getNome()+" (ID: "+getId()+")\n";
		out = out + "Data de nascimento: "+getDataNasc()+"\n";
		out = out + "Email: "+getEmail()+"\n";

		if(getStatus()) {
			out = out + "Status: Positivo\n";
		} else {
			out = out + "Status: Negativo\n";
		}

		out = out + "Livros Emprestados\n";

		for(int i=0; i<livrosEmprestados.size(); i++) {
			out = out + livrosEmprestados.get(i).getNome() + "\n";
		}

		out = out + "Empréstimos ativos\n";

		for(int i = 0; i<emprestimosAtivos.size(); i++) {
			out = out + "Id do empréstimo ativo número " + i + "é " + emprestimosAtivos.get(i).getIdEmprestimo() + "\n";
		}

		out = out + "Amigos do Usuario " + getNome() + "\n";

		for(int i = 0; i<amigos.size(); i++) {
			if(amigos.get(i) instanceof Usuario) {
				out = out + ((Usuario) amigos.get(i)).getNome() + "\n";
			} else {
				out = out + ((UsuarioEstudante) amigos.get(i)).getNome() + "\n";
			}
		}
		return out;
	}
}
	

