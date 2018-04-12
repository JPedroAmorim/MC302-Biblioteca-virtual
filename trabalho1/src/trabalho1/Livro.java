package trabalho1;

public class Livro {
	
	private int codigo;
	private String nome;
	private String descricao;
	private int anoFabricacao;
	private int anoValidade;
	private int numeroEmprestimos;
	
	public Livro(int codigo, String nome, String descricao, int anoFabricacao, int anoValidade, int numeroEmprestimos) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.anoFabricacao = anoFabricacao;
		this.anoValidade = anoValidade;
		this.numeroEmprestimos = numeroEmprestimos;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public int getAnoValidade() {
		return anoValidade;
	}

	public int getNumeroEmprestimos() {
		return numeroEmprestimos;
	}

	public void setNumeroEmprestimos(int numeroEmprestimos) {
		this.numeroEmprestimos = numeroEmprestimos;
	}

	@Override
	public String toString() {
		return "Livro [codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", anoFabricacao="
				+ anoFabricacao + ", anoValidade=" + anoValidade + ", numeroEmprestimos=" + numeroEmprestimos + "]";
	}	
} // kjkjkjk
