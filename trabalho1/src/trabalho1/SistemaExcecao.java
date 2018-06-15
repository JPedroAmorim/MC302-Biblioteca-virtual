package trabalho1;

public class SistemaExcecao extends Exception {

	private static final long serialVersionUID = 1L;
	
	public SistemaExcecao(String mensagem) {
		super(mensagem);
	}
}
