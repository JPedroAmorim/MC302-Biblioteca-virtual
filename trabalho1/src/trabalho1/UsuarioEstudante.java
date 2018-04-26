package trabalho1;

// Classe UsuarioEstudante: abstração de um usuário estudante para os efeitos do sistema. Extende Usuario.

public class UsuarioEstudante extends Usuario {

    // Atributos.

    private String instituicao;
    private int ra;

    // Construtor.

    public UsuarioEstudante(String nome, String senha, String dataNasc, String email, boolean status, String instituicao, int ra) {
        super(nome, senha, dataNasc, email, status);
        this.instituicao = instituicao;
        this.ra = ra;
    }

    // Getters & Setters.

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

    // Método buscaUsuarioUniversidade: Exclusivo de usuarioEstudante, é capaz de informar quais usuários do sistema estão na mesma instituição de ensino do usuário atual.

    public void buscaUsuarioUniversidade() {
        boolean flag = false;
        for (int i = 0; i < Biblioteca.usuarios.size(); i++) {
            if (Biblioteca.usuarios.get(i) instanceof UsuarioEstudante // Verifica se o usuário é um UsuarioEstudante
                    && instituicao.equals(((UsuarioEstudante) Biblioteca.usuarios.get(i)).getInstituicao()) // Verifica se ambos possuem a mesma instiuição de ensino
                    && !(this.getNome().equals(Biblioteca.usuarios.get(i).getNome()))) { // Verifica se não é o próprio usuário que chamou o método
                System.out.println("Usuário " + Biblioteca.usuarios.get(i).getNome() + " também pertence à " + instituicao);
                flag = true;
            }
        }
        if (!flag)
            System.out.println("Não encontramos nenhum usuário de sua instituição de ensino!");
    }

    // toString de UsuarioEstudante.

    // @Override

    public String toString() {
        String out = super.toString();
        out = out + "Instituicao: " + getInstituicao() + "\n";
        out = out + "Ra: " + getRa() + "\n";

        return out;
    }
}
