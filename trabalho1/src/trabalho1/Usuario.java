package trabalho1;

import java.util.ArrayList;

public class Usuario {
	private int id;
	private static int geradorId=0;
	private String nome;
	private String dataNasc;
	private String email;
	private boolean status;
	private ArrayList<Livro> livrosEmprestados = new ArrayList<Livro>();
	
	public Usuario( String nome, String dataNasc, String email, boolean status) {
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.email = email;
		this.status = status;
		geradorId++;
		id = geradorId;
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

	public String toString() {
		String out = "Nome: "+getNome()+" (ID: "+getId()+")\n";
		out = out + "Data de nascimento: "+getDataNasc()+"\n";
		out = out + "Email: "+getEmail()+"\n";
		if(getStatus())
			out = out + "Status: Positivo\n";
		else
			out = out + "Status: Negativo\n";
		out = out + "Livros Emprestados";
		for(int i=0; i<livrosEmprestados.size(); i++)
			out = out + livrosEmprestados.get(i).getNome()+"\n";
		
		return out;
	}
}
	

