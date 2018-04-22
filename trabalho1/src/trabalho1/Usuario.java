package trabalho1;

import java.util.ArrayList;
import java.util.Random; // Fiz um random com seed do geradorId para que cada Id seja um número único e 
//	aleatório, como nos sistemas reais

public class Usuario {

    private int id;
    private static int geradorId = 0;
    private String nome;
    private String senha;
    private String dataNasc;
    private String email;
    private boolean status;
    private float saldo;
    private String infoPagamento;
    private ArrayList<Mensagem> mensagens;
    private ArrayList<Livro> livrosDoUsuario;
    private ArrayList<Emprestimo> emprestimosAtivos;
    private ArrayList<Usuario> amigos; // Pode ser um amigo Usuario ou Usuario estudante, daí a AL heterogênea

    public Usuario(String nome, String senha, String dataNasc, String email, boolean status) {
        this.nome = nome;
        this.senha = senha;
        this.dataNasc = dataNasc;
        this.email = email;
        this.status = status;
        this.saldo = 0;
        this.infoPagamento = null;
        this.mensagens = new ArrayList<Mensagem>();
        this.livrosDoUsuario = new ArrayList<Livro>();
        this.emprestimosAtivos = new ArrayList<Emprestimo>();
        this.amigos = new ArrayList<Usuario>();
        Random geradorIdRandom = new Random(geradorId);
        this.id = geradorIdRandom.nextInt();
        geradorId++; // Precisa ser atualizado, se não sempre teremos o mesmo número aleatório de id p/ todos usuários -> porque a seed dele sempre será geradorId = 0.
        Biblioteca.usuarios.add(this);
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getInfoPagamento() {
        return infoPagamento;
    }

    public void setInfoPagamento(String infoPagamento) {
        this.infoPagamento = infoPagamento;
    }

    public ArrayList<Usuario> getAmigos() {
        return amigos;
    }

    public ArrayList<Emprestimo> getEmprestimosAtivos() {
        return emprestimosAtivos;
    }

    public ArrayList<Livro> getLivrosDoUsuario() {
        return livrosDoUsuario;
    }

    public ArrayList<Mensagem> getMensagens() {
        return mensagens;
    }



    // @Overrride
    public String toString() {
        String out = "Nome: " + getNome() + " (ID: " + getId() + ")\n";
        out = out + "Data de nascimento: " + getDataNasc() + "\n";
        out = out + "Email: " + getEmail() + "\n";

        if (getStatus()) {
            out = out + "Status: Positivo\n";
        } else {
            out = out + "Status: Negativo\n";
        }

        out = out + "Livros do Usuário\n";

        for (int i = 0; i < livrosDoUsuario.size(); i++) {
            out = out + livrosDoUsuario.get(i).getNome() + "\n";
        }

        out = out + "Empréstimos ativos\n";

        for (int i = 0; i < emprestimosAtivos.size(); i++) {
            out = out + "Id do empréstimo ativo número " + i + "é " + emprestimosAtivos.get(i).getIdEmprestimo() + "\n";
        }

        out = out + "Amigos do Usuario " + getNome() + "\n";

        for (int i = 0; i < amigos.size(); i++) {
            out = out + amigos.get(i).getNome() + "\n";
        }
        return out;
    }
}
	

