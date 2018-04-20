package trabalho1;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;

public class Gerenciador { // Essa classe basicamente deixa a main mais enxuta e legível -
							// IMPORTANTE: todos seus métodos são estáticos e ela não possui atributos

    // Metódo geradorUsuario: Gera um um objeto Usuario ou UsuarioEstudante com os dados fornecidos pela entrada

    public static void geradorUsuario() {
        Scanner sc = new Scanner(System.in);
        String nome;
        int i;
        int contador = 0;

        do{ // Enquanto o usuário não escolher um nome que não exista, o loop continua...
            if (contador > 0) System.out.println("Esse nome de usuário já existe! Por favor, digite outro nome");
            System.out.println("Digite o nome do usuário: ");
            nome = sc.next();
            i = checaUsuario(nome);
            contador++;
        }while (i != -1);

        System.out.println("Digite sua senha: ");

        String senha = sc.next();

        System.out.println("Digite sua data de nascimento: ");

        String dataNascimento = sc.next();

        System.out.println("Digite seu email: ");

        String email = sc.next();

        System.out.println("Você é estudante de alguma instituição de ensino superior?");

        if (sc.next().equals("Sim")) {

            System.out.println("Digite sua instituição: ");

            String instituicao = sc.next();

            System.out.println("Digite seu registro academico (RA):  ");

            int ra = sc.nextInt();

            UsuarioEstudante novoUsuarioEstudante = new UsuarioEstudante(nome, senha, dataNascimento, email, true,
                    instituicao, ra);

            System.out.println("Obrigado " + novoUsuarioEstudante.getNome() + " ! Você foi cadastrado!");

        } else {

            Usuario novoUsuario = new Usuario(nome, senha, dataNascimento, email, true);

            System.out.println("Obrigado " + novoUsuario.getNome() + " !  Você foi cadastrado!");
        }
    }

    // Método checaUsuário: Retorna o índice de um usuário caso ele exista (nome consta na AL usuarios). Caso contrário, retorna -1.

    public static int checaUsuario(String nome) {

        for (int i = 0; i < Biblioteca.usuarios.size(); i++) { // Talvez seja possível verificar isso fazendo o cast explícito apenas para Usuario, mas não sei se isso vai cagar a referência
            if (Biblioteca.usuarios.get(i) instanceof Usuario) {
                if (((Usuario) Biblioteca.usuarios.get(i)).getNome().equals(nome)) {
                    return i;
                } else if (Biblioteca.usuarios.get(i) instanceof UsuarioEstudante) {
                    if (((UsuarioEstudante) Biblioteca.usuarios.get(i)).getNome().equals(nome)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    /* Método login: Retorna o índice do usuário na AL usuarios da Biblioteca caso encontrado (nome e senha batem com os dados na AL), e -1 se o usuário
       não existir. Recebe como parâmetro o nome e senha do usuário.  */
    

    public static int login() { // TODO: Tratar o caso do UsuarioAdmin...
        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, digite seu usuário: ");

        String nome = sc.next();

        System.out.println("Por favor, digite sua senha: ");

        String senha = sc.next();

        for (int i = 0; i < Biblioteca.usuarios.size(); i++) { // Talvez seja possível verificar isso fazendo o cast explícito apenas para Usuario, mas não sei se isso vai cagar a referência
            if (Biblioteca.usuarios.get(i) instanceof Usuario) {
                if (((Usuario) Biblioteca.usuarios.get(i)).getNome().equals(nome) && ((Usuario) Biblioteca.usuarios.get(i)).getSenha().equals(senha)) {
                    return i;
                } else if (Biblioteca.usuarios.get(i) instanceof UsuarioEstudante) {
                    if (((UsuarioEstudante) Biblioteca.usuarios.get(i)).getNome().equals(nome) && ((UsuarioEstudante) Biblioteca.usuarios.get(i)).getSenha().equals(senha)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    // Método pagamentoVálido: "Checa" se as informações de pagamento dadas são válidas. Se houver 16 caracteres na string (como em um número de cartão da vida real), retorna true.

    public static boolean pagamentoValido(String infoPagamento) {
       return(infoPagamento.length() == 16);
    }

    /* Método opcoesUsuario: Recebe do usuário pela entrada padrão e realiza a opção desejada. Enquanto não retorna 6,
   ele continua a ser executado pela main em loop.  */

    public static int opcoesUsuario(Usuario usuarioAtual) { // TODO: método opcoesUsuarioEstudante, após definirmos métodos exclusivos para esse tipo de Usuário
        System.out.println("Olá " + usuarioAtual.getNome() + " !");

        Scanner sc = new Scanner(System.in);

        System.out.println(" ***** Pressione a tecla para executar a opção desejada... ***** ");

        System.out.println("1 - Realizar um empréstimo");
        System.out.println("2 - Adicionar um amigo");
        System.out.println("3 - Buscar informações de um usuário");
        System.out.println("4 - Alterar seus dados");
        System.out.println("5 - Adicionar saldo");
        System.out.println("6 - Ver suas informações");
        System.out.println("7 - Desconectar da Biblioteca Virtual");

        int opcao = sc.nextInt();

        if (opcao == 1) { // TODO: Todos esses métodos aqui
            Gerenciador.novoEmprestimo(usuarioAtual);
            return 1;

        } else if (opcao == 2) {
            Gerenciador.adicionarAmigo(usuarioAtual);
            return 2;

        } else if (opcao == 3) {
            Gerenciador.infoUsuario();
            return 3;

        } else if (opcao == 4) {
            Gerenciador.alteraDados(usuarioAtual);
            return 4;

        } else if (opcao == 5) {
            Gerenciador.adicionarSaldo(usuarioAtual);
            return 5;

        } else if (opcao == 6){
            System.out.println("**** Suas informações ****");
            System.out.println(usuarioAtual);
            return 6;
        } else {
            return 7;
        }
    }

    /*  Método novoEmprestimo: Cria um novo empréstimo. Para conseguir as datas de entrega e devolucao do empréstimo, foi utilizado as classes Date e Calendar. Caso o empréstimo não possa ser realizado,
      mensagens de erro são impressas. */

    public static void novoEmprestimo(Usuario usuarioAtual) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, digite o nome do livro que você deseja fazer um empréstimo"); // TODO: Testar se deu certo mexer com Date e Calendar

        String nome = sc.next(); // Caso queiram entender o que tá rolando aqui, a documentação do Oracle pra essas duas classes é bem show

        Calendar cal = Calendar.getInstance();

        Date data = cal.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy HH:mm:ss");

        String dataEmprestimo = sdf.format(data);

        cal.add(Calendar.WEEK_OF_YEAR, 1);

        data = cal.getTime();

        String dataDevolucao = sdf.format(data);

        for(int i = 0; i< Biblioteca.acervo.size(); i++) {
            if (Biblioteca.acervo.get(i).getNome().equals(nome)) {
                if (Biblioteca.acervo.get(i).getLivrosDisponiveis() > 0 && usuarioAtual.getSaldo() >= Biblioteca.acervo.get(i).getValorDeEmprestimo()) {

                    Biblioteca.acervo.get(i).setLivrosDisponiveis(Biblioteca.acervo.get(i).getLivrosDisponiveis() - 1); // Atualiza a quantidade de livros disponíveis

                    usuarioAtual.setSaldo(usuarioAtual.getSaldo() - Biblioteca.acervo.get(i).getValorDeEmprestimo()); // Atualiza o saldo do usuário

                    Emprestimo emprestimoAtual = new Emprestimo(Biblioteca.acervo.get(i).getId(), usuarioAtual.getId(), dataEmprestimo, dataDevolucao, Biblioteca.acervo.get(i).getValorDeEmprestimo());

                    usuarioAtual.getEmprestimosAtivos().add(emprestimoAtual);

                    System.out.println("**** Dados do empréstimo ****");
                    System.out.println(emprestimoAtual);

                    System.out.println("Seu empréstimo foi realizado com sucesso! Seu saldo agora é: " + usuarioAtual.getSaldo());

                    return;

                } else {
                    System.out.println("Saldo insuficiente ou livro indisponível!");
                    return;
                }
            }
        }
            System.out.println("Perdão, não encontramos um livro com esse nome"); // Se não retornou no for, o livro não existe
    }

    // Método adicionarAmigo: Adiciona um usuário na AL amigos do usuário atual. Caso o usuário a ser adicionado não exista, imprime uma mensagem de erro.

    public static void adicionarAmigo(Usuario usuarioAtual) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do usuário que você deseja adicionar");

        String nome = sc.next();

        for (int i = 0; i < Biblioteca.usuarios.size(); i++) { // Mesmo esquema do checaUsuario, só que apenas o nome é verificado e não retornamos índice
            if (Biblioteca.usuarios.get(i) instanceof Usuario) {
                if (((Usuario) Biblioteca.usuarios.get(i)).getNome().equals(nome)) {
                    usuarioAtual.getAmigos().add(Biblioteca.usuarios.get(i));
                    System.out.println("Usuario adicionado na sua lista de amigos!");
                    return;
                } else if (Biblioteca.usuarios.get(i) instanceof UsuarioEstudante) {
                    if (((UsuarioEstudante) Biblioteca.usuarios.get(i)).getNome().equals(nome)) {
                        usuarioAtual.getAmigos().add(Biblioteca.usuarios.get(i));
                        System.out.println("Usuario adicionado na sua lista de amigos!");
                        return;
                    }
                }
            }
        }
        System.out.println("Perdão, não conseguimos encontrar um usuário com esse nome"); // Se ele não retornou no for, é porque o usuário não existe
    }

    // Método infoUsuario: Imprime as informações de um usuário (toString dele). Caso o usuário procurado não exista, imprime uma mensagem de erro.

    public static void infoUsuario () {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o usuário que você deseja saber suas informações: ");

        String nome = sc.next();

        int i = checaUsuario(nome);

        if (i != -1) { // i != -1 -> O usuário em questão existe
            if (Biblioteca.usuarios.get(i) instanceof Usuario) {
                System.out.println("**** Informações do usuário ****");
                System.out.println((Usuario) Biblioteca.usuarios.get(i));
                return;
            } else {
                System.out.println("**** Informações do usuário ****");
                System.out.println((UsuarioEstudante) Biblioteca.usuarios.get(i));
                return;
            }
        } else { // i == -1 -> O usuário não existe
            System.out.println("Usuário não encontrado!");
        }
    }

    // Método alteraDados: Permite que o usuário altere seus dados pela entrada padrão.

    public static void alteraDados (Usuario usuarioAtual) {
        int i;
        int contador = 0;
        Scanner sc = new Scanner(System.in);
        String nome;

        do{
            if (contador > 0) System.out.println("Esse nome de usuário já existe! Por favor, digite outro nome");
            System.out.println("Digite o novo nome do usuário: ");
            nome = sc.next();
            i = checaUsuario(nome);
            contador++;
        }while (i != -1);

        usuarioAtual.setNome(nome);

        System.out.println("Digite a sua nova senha: ");

        usuarioAtual.setSenha(sc.next());

        System.out.println("Digite seu novo email: ");

        usuarioAtual.setEmail(sc.next());

        System.out.println("Digite sua nova data de Nascimento: ");

        usuarioAtual.setDataNasc(sc.next());
    }

    // Método adicionarSaldo: Permite o usuário adicionar saldo.
    public static void adicionarSaldo(Usuario usuarioAtual) {
        Scanner sc = new Scanner(System.in);
        String infoPagamento;
        int contador = 0;

        do{ // Enquanto o usuário não colocar um número válido, o loop continua...
            if(contador > 0) System.out.println("Por favor, insira um número válido de cartão de crédito");

            System.out.println("Digite o número do seu cartão de crédito");

            infoPagamento = sc.next();

            contador++;
        }while(!pagamentoValido(infoPagamento));

       System.out.println("Digite o valor a ser inserido em seu saldo: ");

       usuarioAtual.setSaldo(usuarioAtual.getSaldo() + sc.nextFloat());

       System.out.println("Saldo atualizado com sucesso! Seu saldo agora é: " + usuarioAtual.getSaldo());

    }
}