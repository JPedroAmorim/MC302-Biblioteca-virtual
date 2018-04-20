package trabalho1;

public class Livro {

	private int id;
	private static int geradorId=0;
	private String nome;
	private String autor;
	private String genero;
	private int edicao;
	private int ano;
	private int quantLivros;
	private int livrosDisponiveis;
	private int valorDeEmprestimo;

	public Livro(String nome, String autor, String genero, int edicao, int ano, int quantLivros) {
		this.nome = nome;
		this.autor = autor;
		this.genero = genero;
		this.edicao = edicao;
		this.ano = ano;
		this.quantLivros = quantLivros;
		this.livrosDisponiveis = quantLivros;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
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

	public int getQuantLivros() {
		return quantLivros;
	}

	public void setQuantLivros(int quantLivros) {
		this.quantLivros = quantLivros;
	}

	public int getLivrosDisponiveis() {
		return livrosDisponiveis;
	}

	public void setLivrosDisponiveis(int livrosDisponiveis) {
		this.livrosDisponiveis = livrosDisponiveis;
	}

	public int getValorDeEmprestimo () { return valorDeEmprestimo; }

    public void setValorDeEmprestimo(int valorDeEmprestimo) { this.valorDeEmprestimo = valorDeEmprestimo; }

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