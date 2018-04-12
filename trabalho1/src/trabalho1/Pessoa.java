package trabalho1;

public class Pessoa {
	private static int id;
	private String nome;
	private int idade;
	private String email;
	
	public Pessoa(String nome, int idade, String email) {
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		id++;
		
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Pessoa.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
