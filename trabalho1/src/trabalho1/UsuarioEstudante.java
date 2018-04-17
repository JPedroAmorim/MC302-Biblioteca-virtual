package trabalho1;

public class UsuarioEstudante extends Usuario{
	
	private String instituicao;
	private int ra;
	
	public UsuarioEstudante(String nome, String dataNasc, String email, boolean status, String instituicao, int ra) {
		super(nome, dataNasc, email, status);
		this.instituicao = instituicao;
		this.ra = ra;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}
	
	public String toString() {
		String out = "Intituicao: "+getInstituicao()+"\n";
		out = out + "Ra: "+getRa()+"\n";
		
		return out;
	}	
}
