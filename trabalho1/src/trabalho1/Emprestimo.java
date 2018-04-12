package trabalho1;

public class Emprestimo {
	
	private int idTransacao;
	private int idEstudante;
	private String dataEmprestimo;
	private String dataDevolucao;
	private int codigoLivro;
	private int valor;
	public Emprestimo(int idTransacao, int idEstudante, String dataEmprestimo, String dataDevolucao, int codigoLivro,
			int valor) {
		this.idTransacao = idTransacao;
		this.idEstudante = idEstudante;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.codigoLivro = codigoLivro;
		this.valor = valor;
	}
	public int getIdTransacao() {
		return idTransacao;
	}
	public void setIdTransacao(int idTransacao) {
		this.idTransacao = idTransacao;
	}
	public int getIdEstudante() {
		return idEstudante;
	}
	public void setIdEstudante(int idEstudante) {
		this.idEstudante = idEstudante;
	}
	public String getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public String getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public int getCodigoLivro() {
		return codigoLivro;
	}
	public void setCodigoLivro(int codigoLivro) {
		this.codigoLivro = codigoLivro;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public void atualizaSaldo(PessoaEstudante cliente) {
		cliente.setSaldoDisponivel(cliente.getSaldoDisponivel() - valor);
	}

}
