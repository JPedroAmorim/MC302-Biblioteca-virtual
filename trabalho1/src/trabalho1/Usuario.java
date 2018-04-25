package trabalho1;

import com.sun.istack.internal.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

// Classe Usuário: Abstração de um usuário para os efeitos do sistema. É a classe mãe de UsuarioAdmin e UsuarioEstudante.

public class Usuario {

    // Atributos.

    private int id;
    private static int geradorId = 0;
    private final int idMax = 100;
    private String nome;
    private String senha;
    private String dataNasc;
    private String email;
    private boolean status;
    private double saldo;
    private String infoPagamento;
    private ArrayList<Mensagem> mensagens;
    private ArrayList<Livro> livrosDoUsuario;
    private ArrayList<Emprestimo> emprestimosAtivos;
    private ArrayList<Usuario> amigos;

    // Construtor.

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
        Random geradorIdRandom = new Random(geradorId); // Aqui, há um processo de geração de id com auxílio da classe Random. Para cada usuário gerado, seu id é um número aleatório com seed geradorId.
        this.id = geradorIdRandom.nextInt(idMax);
        geradorId++;
        Biblioteca.usuarios.add(this);
    }

    // Getters & Setters.

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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
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

    // Métodos da classe Usuário. São herdados pelas classes UsuarioEstudante e UsuarioAdmin.

    // Método adicionarSaldo: Permite que o usuário adicione um valor(float) à seu seu saldo se a forma de pagamento provida pelo usuário for válida.

    public void adicionarSaldo() {
        Scanner sc = new Scanner(System.in);
        String infoPagamento = "";

        System.out.println("Por favor, digite o número do seu cartão de crédito: ");

        if (Main.testMode == 0) {
            infoPagamento = sc.nextLine();
        } else if (Main.testMode == 1) {
            infoPagamento = "1234567891234567";
        }


        if (!(Gerenciador.pagamentoValido(infoPagamento))) { // Verifica se pagamentoValido retornou false.
            System.out.println("Por favor, digite um número válido de cartão de crédito.");
            return;
        }

        System.out.println("Digite o valor a ser inserido em seu saldo: ");

        double valor = 0;

        if (Main.testMode == 0) {
            valor = sc.nextDouble();
        } else if (Main.testMode == 1) {
            valor = 30.40;
        }

        if (valor > 0) {
            saldo = saldo + valor;
        } else {
            System.out.println("Por favor, digite um número positivo e maior que zero à ser inserido em seu saldo");
            return;
        }

        System.out.println("Saldo atualizado com sucesso! Seu saldo agora é: " + saldo);

    }

    // Método verMensagem: Permite o usuário ler o contéudo das mensagens de seu atributo AL<Mensagem> mensagens. Ele pode optar por ler todas as mensagens ou apenas as não lidas.

    public void verMensagens() {

        System.out.println("Pressione a tecla correspondente à opção desejada: ");
        System.out.println("1 - Exibir apenas as mensagens marcadas como não lidas");
        System.out.println("2 - Exibir todas as mensagens");

        Scanner sc = new Scanner(System.in);

        int opcao = 0;

        if (Main.testMode == 0) {
            opcao = sc.nextInt();
        } else if (Main.testMode == 1) {
            opcao = 1;
        }


        if (opcao == 1) {
            for (int i = 0; i < mensagens.size(); i++) {
                if (!(mensagens.get(i).getLido())) { // Caso o atributo lido da mensagem seja false.
                    System.out.println(mensagens.get(i));
                    mensagens.get(i).setLido(true);
                }
            }
        } else if (opcao == 2) {
            for (int i = 0; i < mensagens.size(); i++) {
                System.out.println(mensagens.get(i));
                if (!(mensagens.get(i).getLido())) // Caso o atributo lido da mensagem seja false.
                    mensagens.get(i).setLido(true);
            }
        } else {
            System.out.println("Opção inválida!");
        }
    }

    // Método enviarMensagem: Permite o usuário enviar uma mensagem à outro usuário do sistema.

    public void enviarMensagem() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do Usuário para quem você deseja enviar a mensagem: ");

        String nome = "";

        if (Main.testMode == 0) {
            nome = sc.nextLine();
        } else {
            nome = "João";
        }

        int resultado = Gerenciador.checaUsuario(nome);

        if (resultado != -1) {

            System.out.println("Digite o corpo de sua mensagem: ");

            String texto = "";

            if (Main.testMode == 0) {
                texto = sc.nextLine();
            } else {
                texto = "Esta é uma mensagem de teste!";
            }

            Mensagem mensagemAtual = new Mensagem(texto, nome);

            Biblioteca.usuarios.get(resultado).getMensagens().add(mensagemAtual);

            System.out.println("Mensagem enviada com sucesso!");
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }

    // Metódo alteraDados : Permite o usuário alterar seus atributos pessoais (nome, senha, email...) pela entrada padrão.

    public void alteraDados() {
        int resultado;
        int contador = 0;
        Scanner sc = new Scanner(System.in);
        String nome;

        do {
            if (contador > 0) System.out.println("Esse nome de usuário já existe! Por favor, digite outro nome");
            System.out.println("Digite o novo nome do usuário: ");
            nome = sc.nextLine();
            resultado = Gerenciador.checaUsuario(nome);
            contador++;
        } while (resultado != -1); // Enquanto o usuário não digitar um nome válido, o loop continua...

        this.nome = nome;

        System.out.println("Digite a sua nova senha: ");

        senha = sc.nextLine();

        System.out.println("Digite seu novo email: ");

        email = sc.nextLine();

        System.out.println("Digite sua nova data de Nascimento: ");

        dataNasc = sc.nextLine();

        if (this instanceof UsuarioEstudante) { // Verifica se é uma instância de UsuarioEstudante.
            System.out.println("Por favor, digite sua nova instituição: ");

            ((UsuarioEstudante) this).setInstituicao(sc.nextLine());

            System.out.println("Por favor, digite seu novo RA: ");

            ((UsuarioEstudante) this).setRa(sc.nextInt());
        }

        System.out.println("Dados alterados com sucesso!");
    }

    // Metódo infoUsuario: Permite o usuário atual buscar outro usuário do sistema e caso ele exista, imprimir as informações dele.

    public void infoUsuario() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o usuário que você deseja saber suas informações: ");

        String nome = "";

        if (Main.testMode == 0) {
            nome = sc.nextLine();
        } else if (Main.testMode == 1) {
            nome = "João";
        }

        int resultado = Gerenciador.checaUsuario(nome);

        if (resultado != -1) { // resultado != -1 -> O usuário em questão existe.

            System.out.println("**** Informações do usuário ****");
            System.out.println(Biblioteca.usuarios.get(resultado));

        } else { // resultado == -1 -> O usuário não existe.
            System.out.println("Usuário não encontrado!");
        }
    }

    // Método adicionarAmigo: Permite o usuário atual adicionar outro usuário do sistema à sua lista de amigos.

    public void adicionarAmigo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do usuário que você deseja adicionar");

        String nomeAlvo = "";

        if (Main.testMode == 0) {
            nomeAlvo = sc.nextLine();
        } else if (Main.testMode == 1) {
            nomeAlvo = "João";
        }

        int resultado = Gerenciador.checaUsuario(nomeAlvo);

        // A chamada de tratarExcecao ocorre para impedir o usuário de se adicionar ou adicionar um usuário que já consta em sua lista de amigos.

        if (resultado != -1) { // resultado != -> Usuário existe
            if (Gerenciador.trataExcecao(this, Biblioteca.usuarios.get(resultado)))
                return; // Se houve uma exceção, é para o método parar sua execução.
            amigos.add(Biblioteca.usuarios.get(resultado));
            System.out.println("Usuário adicionado com sucesso!");
        } else { // resultado == -1 -> Usuário não existe
            System.out.println("Perdão, não conseguimos encontrar um usuário com esse nome");
        }

    }

    /*
       Método novoEmprestimo: Provavelmente o método mais complexo e importante do sistema. Ele recebe dois parâmetros: usuarioEmprestador
       e cupom, e ambos podem ou não ser nulos (null). A partir desse método, um usuário é capaz de realizar um empréstimo com o acervo
       da biblioteca ou com o acervo de outro usuário do sistema (usuarioEmprestador). No caso de usuarioEstudante, é possível realizar
       ambos tipos de empréstimo com um cupom de desconto.
     */

    public void novoEmprestimo(@Nullable Usuario usuarioEmprestador, @Nullable Cupom cupom) {
        Scanner sc = new Scanner(System.in);

        // Para determinar a data de empréstimo e devolução, foram utilizadas as classes Data e Calendar.


        System.out.println("Por favor, digite o nome do livro que você deseja fazer um empréstimo");

        String nome = "";

        if (Main.testMode == 0) {
            nome = sc.nextLine();
        } else if (Main.testMode == 1) {
            nome = "Romeu e Julieta";
        }

        Calendar cal = Calendar.getInstance();

        Date data = cal.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy HH:mm:ss");

        String dataEmprestimo = sdf.format(data);

        cal.add(Calendar.WEEK_OF_YEAR, 1);

        data = cal.getTime();

        String dataDevolucao = sdf.format(data);

        if (usuarioEmprestador == null) { // Caso em que o empréstimo é com o acervo da biblioteca virtual
            for (int i = 0; i < Biblioteca.acervo.size(); i++) {
                if (Biblioteca.acervo.get(i).getNome().equals(nome)) {
                    if (Biblioteca.acervo.get(i).getLivrosDisponiveis() > 0 && saldo >= Biblioteca.acervo.get(i).getValorDeEmprestimo()) { // Verifica se existem livros disponíveis para aquele livro e se o saldo é suficiente para o empréstimo.

                        double valorNormal = Biblioteca.acervo.get(i).getValorDeEmprestimo();

                        double valorComDesconto = (cupom != null) ? (1 - (cupom.getDesconto() / 100)) * valorNormal : 0;

                        Biblioteca.acervo.get(i).setLivrosDisponiveis(Biblioteca.acervo.get(i).getLivrosDisponiveis() - 1); // Atualiza a quantidade de livros disponíveis.

                        if (Biblioteca.acervo.get(i).getLivrosDisponiveis() <= 0)
                            Biblioteca.acervo.remove(Biblioteca.acervo.get(i)); // Se agora temos 0 livros disponíveis, o livro deve ser retirado do acervo.

                        if (cupom != null) { // Se há um cupom de desconto, devemos aplicá-lo no saldo do usuário e defini-lo como usado.
                            saldo = saldo - valorComDesconto;
                            cupom.setFoiUsado(true);
                        } else {
                            saldo = saldo - valorNormal;
                        }

                        Emprestimo emprestimoAtual = new Emprestimo(Biblioteca.acervo.get(i).getId(), id, dataEmprestimo, dataDevolucao, ((cupom != null) ? valorComDesconto : valorNormal)); // Instanciamento do empréstimo.

                        emprestimosAtivos.add(emprestimoAtual);

                        System.out.println("**** Dados do empréstimo ****");
                        System.out.println(emprestimoAtual);

                        System.out.println("Seu empréstimo foi realizado com sucesso! Seu saldo agora é: " + saldo);

                        return;

                    } else { // Se a condição acima não foi satisfeita, um ou ambos dos critérios não foi satisfeito.
                        System.out.println("Saldo insuficiente e/ou livro indisponível!");
                        return;
                    }
                }
            }
            System.out.println("Perdão, não encontramos um livro com esse nome!"); // Se não retornou no for, o livro não existe.
        } else { // Caso em que o empréstimo é realizado com um usuário do sistema.
            for (int i = 0; i < usuarioEmprestador.getLivrosDoUsuario().size(); i++) {
                if (usuarioEmprestador.getLivrosDoUsuario().get(i).getNome().equals(nome)) {
                    if (usuarioEmprestador.getLivrosDoUsuario().get(i).getLivrosDisponiveis() > 0 && saldo >= usuarioEmprestador.getLivrosDoUsuario().get(i).getValorDeEmprestimo()) { // Verifica se existem livros disponíveis para aquele livro e se o saldo é suficiente para o empréstimo.

                        double valorNormal = usuarioEmprestador.getLivrosDoUsuario().get(i).getValorDeEmprestimo();

                        double valorComDesconto = (cupom != null) ? (1 - (cupom.getDesconto() / 100)) * valorNormal : 0;

                        usuarioEmprestador.getLivrosDoUsuario().get(i).setLivrosDisponiveis(usuarioEmprestador.getLivrosDoUsuario().get(i).getLivrosDisponiveis() - 1); // Atualiza a quantidade de livros disponíveis.

                        if (usuarioEmprestador.getLivrosDoUsuario().get(i).getLivrosDisponiveis() <= 0)
                            usuarioEmprestador.getLivrosDoUsuario().remove(usuarioEmprestador.getLivrosDoUsuario().get(i)); // Se agora temos 0 livros disponíveis, o livro deve ser retirado do acervo do usuário.

                        if (cupom != null) { // // Se há um cupom de desconto, devemos aplicá-lo no saldo do usuário e defini-lo como usado.
                            saldo = saldo - valorComDesconto;
                            cupom.setFoiUsado(true);
                        } else {
                            saldo = saldo - usuarioEmprestador.getLivrosDoUsuario().get(i).getValorDeEmprestimo();
                        }

                        usuarioEmprestador.setSaldo(usuarioEmprestador.getSaldo() + usuarioEmprestador.getLivrosDoUsuario().get(i).getValorDeEmprestimo()); // Atualiza o saldo do usuário emprestador com o valor do livro emprestado.


                        EmprestimoEntreUsuarios emprestimoAtual = new EmprestimoEntreUsuarios(id, usuarioEmprestador.getId(), usuarioEmprestador.getLivrosDoUsuario().get(i).getId(), dataEmprestimo, dataDevolucao, ((cupom != null) ? valorComDesconto : valorNormal));

                        emprestimosAtivos.add(emprestimoAtual);

                        usuarioEmprestador.getEmprestimosAtivos().add(emprestimoAtual);

                        System.out.println("**** Dados do empréstimo ****");
                        System.out.println(emprestimoAtual);

                        System.out.println("Seu empréstimo foi realizado com sucesso! Seu saldo agora é: " + saldo);

                        return;
                    }
                } else { // Se a condição acima não foi satisfeita, um ou ambos dos critérios não foi satisfeito.
                    System.out.println("Saldo insuficiente ou livro indisponível!");
                    return;
                }
            }
            System.out.println("Perdão, não encontramos um livro com esse nome!"); // Se não retornou no for, o livro não existe.
        }
    }

    // toString de Usuário.

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
        out = out + "Saldo R$: " + getSaldo() + "\n";
        out = out + "Livros Emprestados:\n";

        for (int i = 0; i < livrosDoUsuario.size(); i++) {
            out = out + livrosDoUsuario.get(i).getNome() + "\n";
        }

        out = out + "Empréstimos ativos:\n";

        for (int i = 0; i < emprestimosAtivos.size(); i++) {
            out = out + "Id do empréstimo ativo número " + i + " é " + emprestimosAtivos.get(i).getIdEmprestimo() + "\n";
        }

        out = out + "Amigos do Usuario " + getNome() + "\n";
        out = out + "Seus amigos:\n";
        for (int i = 0; i < amigos.size(); i++) {
            out = out + amigos.get(i).getNome() + "\n";
        }
        return out;
    }
}
