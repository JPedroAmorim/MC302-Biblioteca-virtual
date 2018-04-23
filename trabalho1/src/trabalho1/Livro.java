package trabalho1;

import java.util.Random;

public class Livro {

	private int id;
	private static int geradorId=0;
	private String nome;
	private String autor;
	private Genero genero;
	private int edicao;
	private int ano;
	private int livrosDisponiveis;
	private float valorDeEmprestimo;

	public Livro(String nome, String autor, Genero genero, int edicao, int ano, int livrosDisponiveis, float valorDeEmprestimo) {
		this.nome = nome;
		this.autor = autor;
		this.genero = genero;
		this.edicao = edicao;
		this.ano = ano;
		this.livrosDisponiveis = livrosDisponiveis;
		this.valorDeEmprestimo = valorDeEmprestimo;
		Random geradorIdRandom = new Random(geradorId); 
		this.id = geradorIdRandom.nextInt();
		geradorId++;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(short edicao) {
		this.edicao = edicao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(short ano) {
		this.ano = ano;
	}

	public int getLivrosDisponiveis() {
		return livrosDisponiveis;
	}

	public void setLivrosDisponiveis(int livrosDisponiveis) {
		this.livrosDisponiveis = livrosDisponiveis;
	}

	public float getValorDeEmprestimo () {
		return valorDeEmprestimo; 
	}

    public void setValorDeEmprestimo(int valorDeEmprestimo) {
    	this.valorDeEmprestimo = valorDeEmprestimo; 
    }

    public boolean disponibilidade(int id_livro){
		if(livrosDisponiveis >= 1)
			return true;
		else
			return false;
	}

	public String toString() {
		String out = "Nome: "+getNome()+"(ID: "+getId()+")\n";
		out = out + "Autor: "+getAutor()+"\n";
		out = out + "Ano: "+getAno()+"\n";
		out = out + "Edição: "+getEdicao()+"\n";
		out = out + "Gênero: "+getGenero()+"\n";
		out = out + "Livros disponiveis: "+getLivrosDisponiveis()+"\n";

		return out;
	}
}