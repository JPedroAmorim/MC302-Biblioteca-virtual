package trabalho1;
import java.util.Random; // Mesmo esquema de Usuario

public class Emprestimo {
	
	private int idEmprestimo;
	private static int geradorId = 0;
	private int idUsuario;
	private int idLivro;
	private String dataEmprestimo;
	private String dataDevolucao;
	private float valor;
	private boolean ativo; // Achei necessário saber se um empréstimo ainda está rolando ou não
	
	public Emprestimo(int idLivro ,int idUsuario, String dataEmprestimo, String dataDevolucao,
					  float valor){
	    Random geraIdRandom = new Random(geradorId);
	    this.idEmprestimo = geraIdRandom.nextInt();
	    geradorId++;
		this.idUsuario = idUsuario;
		this.idLivro = idLivro;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.valor = valor;
		this.ativo = true;
	}

	public int getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
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
	
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String toString() {
		String out = "Emprestimo: "+getIdEmprestimo()+"\n";
		out = out + "Data do empréstimo: " + getDataEmprestimo() + "\n";
		out = out + "Data de devolução: " + getDataDevolucao() + "\n";
		out = out + "Usuario: "+getIdUsuario()+"\n";
		out = out + "Livro: "+getIdLivro()+"\n";
		out = out + "Valor: R$"+getValor()+"\n";
		
		return out;
	}
}
