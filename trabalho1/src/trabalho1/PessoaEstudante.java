package trabalho1;

import java.util.ArrayList;

public class PessoaEstudante extends Pessoa{
	
	private int instituicao;
	private int RA;
	private ArrayList<Livro> historicoLivros;
	private float saldoDisponivel;
	private boolean status;
	
	
	public PessoaEstudante(String nome, int idade, String email, int instituicao, int rA, float saldoDisponivel,
			boolean status) {
		
		super(nome, idade, email);
		this.instituicao = instituicao;
		RA = rA;
		this.saldoDisponivel = saldoDisponivel;
		this.status = status;
	}


	public int getInstituicao() {
		return instituicao;
	}


	public void setInstituicao(int instituicao) {
		this.instituicao = instituicao;
	}


	public int getRA() {
		return RA;
	}


	public void setRA(int rA) {
		RA = rA;
	}


	public ArrayList<Livro> getHistoricoLivros() {
		return historicoLivros;
	}


	public void setHistoricoLivros(ArrayList<Livro> historicoLivros) {
		this.historicoLivros = historicoLivros;
	}


	public float getSaldoDisponivel() {
		return saldoDisponivel;
	}


	public void setSaldoDisponivel(float saldoDisponivel) {
		this.saldoDisponivel = saldoDisponivel;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
