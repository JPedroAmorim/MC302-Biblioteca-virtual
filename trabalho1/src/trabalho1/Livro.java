
public class Livro {
	
	private int id;
	private String nome;
	private String autor;
	private String genero;
	private short edicao;
	private short ano;
	private int disponibilidade;
	
	public Livro(int id, String nome, String autor, String genero, short edicao, short ano, int disponibilidade) {
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.genero = genero;
		this.edicao = edicao;
		this.ano = ano;
		this.disponibilidade = disponibilidade;
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

	public short getEdicao() {
		return edicao;
	}

	public void setEdicao(short edicao) {
		this.edicao = edicao;
	}

	public short getAno() {
		return ano;
	}

	public void setAno(short ano) {
		this.ano = ano;
	}

	public int getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(int disponibilidade) {
		this.disponibilidade = disponibilidade;
	}


	public String toString() {
		String out = "Nome: "+getNome()+"(ID: "+getId()+")\n";
		out = out + "Autor: "+getAutor()+"\n";
		out = out + "Ano: "+getAno()+"\n";
		out = out + "Edição: "+getEdicao()+"\n";
		out = out + "Gênero: "+getGenero()+"\n";
		out = out + "Livros disponiveis: "+getDisponibilidade()+"\n";
		
		return out;
	}
}
