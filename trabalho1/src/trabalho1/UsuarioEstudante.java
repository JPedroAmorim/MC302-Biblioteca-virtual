package trabalho1;

public class UsuarioEstudante extends Usuario{
	
	private String instituicao;
	private int ra;
	
	public UsuarioEstudante(String nome, String senha, String dataNasc, String email, boolean status, String instituicao, int ra) {
		super(nome, senha, dataNasc, email, status);
		this.instituicao = instituicao;
		this.ra = ra;
		Biblioteca.usuarios.add(this);
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
		String out = super.toString();
		out = out + "Instituicao: "+getInstituicao()+"\n";
		out = out + "Ra: "+getRa()+"\n";
		
		return out;
	}	
}
