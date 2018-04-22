package trabalho1;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

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

        do { // Enquanto o usuário não escolher um nome que não exista, o loop continua...
            if (contador > 0) System.out.println("Esse nome de usuário já existe! Por favor, digite outro nome");
            System.out.println("Digite o nome do usuário: ");
            nome = sc.next();
            i = checaUsuario(nome);
            contador++;
        } while (i != -1);

        System.out.println("Digite sua senha: ");

        String senha = sc.next();

        System.out.println("Digite sua data de nascimento: ");

        String dataNascimento = sc.next();

        System.out.println("Digite seu email: ");

        String email = sc.next();

        System.out.println("Você é estudante de alguma instituição de ensino superior? (Sim/Nao)");

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
        for (int i = 0; i < Biblioteca.usuarios.size(); i++) {
            if ((Biblioteca.usuarios.get(i)).getNome().equals(nome)) return i;
        }
        return -1; // Se não retornou no for, o usuário não existe
    }

    /* Método login: Retorna o índice do usuário na AL usuarios da Biblioteca caso encontrado (nome e senha batem com os dados na AL), e -1 se o usuário
       não existir. Recebe como parâmetro o nome e senha do usuário.  */

    private static boolean trataExcecao(Usuario usuarioAtual, Usuario usuarioAlvo) { // Tratar -> Usuário se adicionar e/ou adicionar alguém que já tá na sua lista de amigos
        for (int i = 0; i < usuarioAtual.getAmigos().size(); i++) {
            if (usuarioAlvo.getAmigos().get(i).getNome().equals(usuarioAlvo.getNome())) {
                System.out.println("O usuário já está adicionado na sua lista de amigos!");
                return true;
            }
        }
        if (usuarioAtual.getNome().equals(usuarioAlvo.getNome())) {
            System.out.println("Você não pode se adicionar na lista de amigos!");
            return true;
        }
        return false;
    }

    public static int login() { // TODO: Tratar o caso do UsuarioAdmin...
        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, digite seu usuário: ");

        String nome = sc.next();

        System.out.println("Por favor, digite sua senha: ");

        String senha = sc.next();

        for (int i = 0; i < Biblioteca.usuarios.size(); i++) {
            if (Biblioteca.usuarios.get(i).getNome().equals(nome) && Biblioteca.usuarios.get(i).getSenha().equals(senha))
                return i;
        }
        return -1;
    }

    // Método pagamentoVálido: "Checa" se as informações de pagamento dadas são válidas. Se houver 16 caracteres na string (como em um número de cartão da vida real), retorna true.

    private static boolean pagamentoValido(String infoPagamento) {
        return (infoPagamento.length() == 16);
    }

    /* Método opcoesUsuario: Recebe do usuário pela entrada padrão e realiza a opção desejada. Enquanto não retorna,
   ele continua a ser executado pela main em loop.  */

    public static boolean opcoesUsuario(Usuario usuarioAtual) {
        System.out.println("Olá " + usuarioAtual.getNome() + " !");


        Scanner sc = new Scanner(System.in);

        System.out.println(" ***** Pressione a tecla para executar a opção desejada... ***** ");


        if (usuarioAtual instanceof UsuarioAdmin) {

            System.out.println("1 - Cadastrar cupom de desconto");
            System.out.println("2 - Cadastrar um livro");
            System.out.println("3 - Banir um usuário");
            System.out.println("4 - Sair da Biblioteca Virtual");

            int opcaoAdmin = sc.nextInt();

            if (opcaoAdmin == 1) {
                 ((UsuarioAdmin) usuarioAtual).cadastrarCupom();
                 return true;

            } else if (opcaoAdmin == 2) {
                ((UsuarioAdmin) usuarioAtual).cadastrarLivro();
                return true;
            } else if (opcaoAdmin == 3) {
                ((UsuarioAdmin) usuarioAtual).banirUsuario();
                return true;
            } else if (opcaoAdmin == 4) {
                return false;
            } else {
                System.out.println("Por favor, digite uma opção válida!");
                return false;
            }
        }


        System.out.println("1 - Realizar um empréstimo com a Biblioteca Virtual");
        System.out.println("2 - Realizar um empréstimo com um usuário da Biblioteca Virtual");
        System.out.println("3 - Adicionar um amigo");
        System.out.println("4 - Buscar informações de um usuário");
        System.out.println("5 - Alterar seus dados");
        System.out.println("6 - Adicionar saldo");
        System.out.println("7 - Ver suas informações");
        System.out.println("8 - Enviar uma mensagem a um usuário");
        System.out.println("9 - Ver suas mensagens recebidas");

        if (usuarioAtual instanceof UsuarioEstudante) {
            System.out.println("10 - Realizar empréstimo com cupom de desconto (exclusivo para usuários estudantes)");
            System.out.println("11 - Mostrar usuários da mesma universidade");
            System.out.println("12 - Desconectar da Biblioteca Virtual");
        } else {
            System.out.println("10 - Desconectar da Biblioteca Virtual");
        }

        int opcao = sc.nextInt();

        if (opcao == 1) {
            novoEmprestimo(usuarioAtual, null, null);
            return true;

        } else if (opcao == 2) {
            System.out.println("Digite o nome do usuário com quem você quer fazer um empréstimo ");

            String nome = sc.next();
            int resultado = checaUsuario(nome);
            if (resultado != -1) {
                novoEmprestimo(usuarioAtual, Biblioteca.usuarios.get(resultado), null);
            } else {
                System.out.println("Usuário não existe");
            }
            return true;

        } else if (opcao == 3) {
            adicionarAmigo(usuarioAtual);
            return true;

        } else if (opcao == 4) {
            infoUsuario();
            return true;

        } else if (opcao == 5) {
            alteraDados(usuarioAtual);
            return true;

        } else if (opcao == 6) {
            adicionarSaldo(usuarioAtual);
            return true;

        } else if (opcao == 7) {
            System.out.println("**** Suas informações ****");
            System.out.println(usuarioAtual);
            return true;

        } else if (opcao == 8) {
            enviarMensagem(usuarioAtual);
            return true;

        } else if (opcao == 9) {
            verMensagens(usuarioAtual);
            return true;

        } else if (!(usuarioAtual instanceof UsuarioEstudante) && opcao == 10) {
            return false;

        } else if (usuarioAtual instanceof UsuarioEstudante && opcao == 10) {
            System.out.println("Por favor, digite o código do seu cupom");
            int i = checaCupom(sc.next());

            if (i != -1) {
                System.out.println("Digite a opção que você deseja: ");
                System.out.println("1 - Utilizar o cupom de desconto em um empréstimo com a Biblioteca Virtual");
                System.out.println("2 - Utilizar o cupom de desconto em um empréstimo com um Usuário");

                int opcao1 = sc.nextInt();

                if (opcao1 == 1) {
                    novoEmprestimo(usuarioAtual, null, Biblioteca.cupons.get(i));
                } else if (opcao1 == 2) {
                    System.out.println("Digite o nome do usuário com quem você quer fazer um empréstimo ");

                    String nome = sc.next();
                    int resultado = checaUsuario(nome);
                    if (resultado != -1) {
                        novoEmprestimo(usuarioAtual, Biblioteca.usuarios.get(resultado), Biblioteca.cupons.get(i));
                    } else {
                        System.out.println("Usuário não existe");
                    }
                } else {
                    System.out.println("Por favor, digite uma opção válida");
                }
            }
            return true;

        } else if (usuarioAtual instanceof UsuarioEstudante && opcao == 11) {
            buscaUsuarioUniversidade((UsuarioEstudante) usuarioAtual);
            return true;

        } else if (usuarioAtual instanceof UsuarioEstudante && opcao == 12) {
            return false;

        } else {
            System.out.println("Por favor, escolha uma opção válida");
            return true;
        }
    }

    /*  Método novoEmprestimo: Cria um novo empréstimo. Para conseguir as datas de entrega e devolucao do empréstimo, foi utilizado as classes Date e Calendar. Caso o empréstimo não possa ser realizado,
      mensagens de erro são impressas. */

    private static void novoEmprestimo(Usuario usuarioAtual, @Nullable Usuario usuarioEmprestador, @Nullable Cupom cupom) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, digite o nome do livro que você deseja fazer um empréstimo");
        String nome = sc.next(); // Caso queiram entender o que tá rolando aqui, a documentação do Oracle pra essas duas classes é bem show

        Calendar cal = Calendar.getInstance();

        Date data = cal.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy HH:mm:ss");

        String dataEmprestimo = sdf.format(data);

        cal.add(Calendar.WEEK_OF_YEAR, 1);

        data = cal.getTime();

        String dataDevolucao = sdf.format(data);

        if (usuarioEmprestador.equals(null)) {
            for (int i = 0; i < Biblioteca.acervo.size(); i++) {
                if (Biblioteca.acervo.get(i).getNome().equals(nome)) {
                    if (Biblioteca.acervo.get(i).getLivrosDisponiveis() > 0 && usuarioAtual.getSaldo() >= Biblioteca.acervo.get(i).getValorDeEmprestimo()) {

                        Biblioteca.acervo.get(i).setLivrosDisponiveis(Biblioteca.acervo.get(i).getLivrosDisponiveis() - 1); // Atualiza a quantidade de livros disponíveis

                        if (Biblioteca.acervo.get(i).getLivrosDisponiveis() == 0)
                            Biblioteca.acervo.remove(Biblioteca.acervo.get(i)); // Se agora temos 0 livros disponíveis, o livro deve ser retirado do acervo

                        if (cupom != null) {
                            usuarioAtual.setSaldo(usuarioAtual.getSaldo() - (1 - cupom.getDesconto() / 100) * usuarioEmprestador.getLivrosDoUsuario().get(i).getValorDeEmprestimo());
                        } else {
                            usuarioAtual.setSaldo(usuarioAtual.getSaldo() - usuarioEmprestador.getLivrosDoUsuario().get(i).getValorDeEmprestimo());
                        }

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
        } else {
            for (int i = 0; i < usuarioEmprestador.getLivrosDoUsuario().size(); i++) {
                if (usuarioEmprestador.getLivrosDoUsuario().get(i).getNome().equals(nome)) {
                    if (usuarioEmprestador.getLivrosDoUsuario().get(i).getLivrosDisponiveis() > 0 && usuarioAtual.getSaldo() >= usuarioEmprestador.getLivrosDoUsuario().get(i).getValorDeEmprestimo()) {

                        usuarioEmprestador.getLivrosDoUsuario().get(i).setLivrosDisponiveis(usuarioEmprestador.getLivrosDoUsuario().get(i).getLivrosDisponiveis() - 1);

                        if (usuarioEmprestador.getLivrosDoUsuario().get(i).getLivrosDisponiveis() == 0)
                            usuarioEmprestador.getLivrosDoUsuario().remove(usuarioEmprestador.getLivrosDoUsuario().get(i));

                        if (cupom != null) {
                            usuarioAtual.setSaldo(usuarioAtual.getSaldo() - (1 - cupom.getDesconto() / 100) * usuarioEmprestador.getLivrosDoUsuario().get(i).getValorDeEmprestimo());
                        } else {
                            usuarioAtual.setSaldo(usuarioAtual.getSaldo() - usuarioEmprestador.getLivrosDoUsuario().get(i).getValorDeEmprestimo());
                        }

                        usuarioEmprestador.setSaldo(usuarioEmprestador.getSaldo() + usuarioEmprestador.getLivrosDoUsuario().get(i).getValorDeEmprestimo());

                        EmprestimoEntreUsuarios emprestimoAtual = new EmprestimoEntreUsuarios(usuarioAtual.getId(), usuarioEmprestador.getId(), usuarioEmprestador.getLivrosDoUsuario().get(i).getId(), dataEmprestimo, dataDevolucao, usuarioEmprestador.getLivrosDoUsuario().get(i).getValorDeEmprestimo());

                        usuarioAtual.getEmprestimosAtivos().add(emprestimoAtual);

                        usuarioEmprestador.getEmprestimosAtivos().add(emprestimoAtual);

                        System.out.println("**** Dados do empréstimo ****");
                        System.out.println(emprestimoAtual);

                        System.out.println("Seu empréstimo foi realizado com sucesso! Seu saldo agora é: " + usuarioAtual.getSaldo());

                        return;
                    }
                } else {
                    System.out.println("Saldo insuficiente ou livro indisponível!");
                    return;
                }
            }
            System.out.println("Perdão, não encontramos um livro com esse nome");
        }
    }

    // Método adicionarAmigo: Adiciona um usuário na AL amigos do usuário atual. Caso o usuário a ser adicionado não exista, imprime uma mensagem de erro.

    private static void adicionarAmigo(Usuario usuarioAtual) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do usuário que você deseja adicionar");

        String nome = sc.next();

        int i = checaUsuario(nome);

        if (i != -1) { // i != -> Usuário existe
            if (trataExcecao(usuarioAtual, Biblioteca.usuarios.get(i))) return;
            usuarioAtual.getAmigos().add(Biblioteca.usuarios.get(i));
        } else { // i == -1 -> Usuário não existe
            System.out.println("Perdão, não conseguimos encontrar um usuário com esse nome");
        }
        
        //ADICIONAR: erros caso o usuario adicione um amigo que ja consta na sua lista ou adicione a si proprio
        
        System.out.println("Perdão, não conseguimos encontrar um usuário com esse nome"); // Se ele não retornou no for, é porque o usuário não existe

    }

    // Método infoUsuario: Imprime as informações de um usuário (toString dele). Caso o usuário procurado não exista, imprime uma mensagem de erro.

    private static void infoUsuario() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o usuário que você deseja saber suas informações: ");

        String nome = sc.next();

        int i = checaUsuario(nome);

        if (i != -1) { // i != -1 -> O usuário em questão existe

            System.out.println("**** Informações do usuário ****");
            System.out.println(Biblioteca.usuarios.get(i));

        } else { // i == -1 -> O usuário não existe
            System.out.println("Usuário não encontrado!");
        }
    }

    // Método alteraDados: Permite que o usuário altere seus dados pela entrada padrão.

    private static void alteraDados(Usuario usuarioAtual) {
        int i;
        int contador = 0;
        Scanner sc = new Scanner(System.in);
        String nome;

        do {
            if (contador > 0) System.out.println("Esse nome de usuário já existe! Por favor, digite outro nome");
            System.out.println("Digite o novo nome do usuário: ");
            nome = sc.next();
            i = checaUsuario(nome);
            contador++;
        } while (i != -1);

        usuarioAtual.setNome(nome);

        System.out.println("Digite a sua nova senha: ");

        usuarioAtual.setSenha(sc.next());

        System.out.println("Digite seu novo email: ");

        usuarioAtual.setEmail(sc.next());

        System.out.println("Digite sua nova data de Nascimento: ");

        usuarioAtual.setDataNasc(sc.next());

        if (usuarioAtual instanceof UsuarioEstudante) {
            System.out.println("Por favor, digite sua nova instituição: ");

            ((UsuarioEstudante) usuarioAtual).setInstituicao(sc.next());

            System.out.println("Por favor, digite seu novo RA: ");

            ((UsuarioEstudante) usuarioAtual).setRa(sc.nextInt());
        }

        System.out.println("Dados alterados com sucesso!");
    }

    // Método adicionarSaldo: Permite o usuário adicionar saldo.

    private static void adicionarSaldo(Usuario usuarioAtual) {
        Scanner sc = new Scanner(System.in);
        String infoPagamento;
        int contador = 0;

        do { // Enquanto o usuário não colocar um número válido, o loop continua...
            if (contador > 0) System.out.println("Por favor, insira um número válido de cartão de crédito");

            System.out.println("Digite o número do seu cartão de crédito");

            infoPagamento = sc.next();

            contador++;
        } while (!pagamentoValido(infoPagamento));

        System.out.println("Digite o valor a ser inserido em seu saldo: ");

        usuarioAtual.setSaldo(usuarioAtual.getSaldo() + sc.nextFloat());

        System.out.println("Saldo atualizado com sucesso! Seu saldo agora é: " + usuarioAtual.getSaldo());

    }

    private static void enviarMensagem(Usuario usuarioAtual) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do Usuário para quem você deseja enviar a mensagem: ");

        String nome = sc.next();

        int i = checaUsuario(nome);

        if (i != -1) {

            System.out.println("Digite o corpo de sua mensagem: ");

            String texto = sc.next();

            Mensagem mensagemAtual = new Mensagem(texto, nome);

            Biblioteca.usuarios.get(i).getMensagens().add(mensagemAtual);

            System.out.println("Mensagem enviada com sucesso!");
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }

    private static void verMensagens(Usuario usuarioAtual) {
        System.out.println("Pressione a tecla correspondente à opção desejada: ");
        System.out.println("1 - Exibir apenas as mensagens marcadas como não lidas");
        System.out.println("2 - Exibir todas as mensagens");

        Scanner sc = new Scanner(System.in);

        int opcao = sc.nextInt();

        if (opcao == 1) {
            for (int i = 0; i < usuarioAtual.getMensagens().size(); i++) {
                if (!usuarioAtual.getMensagens().get(i).isLido()) {
                    System.out.println(usuarioAtual.getMensagens().get(i));
                    usuarioAtual.getMensagens().get(i).setLido(true);
                }
            }
        } else if (opcao == 2) {
            for (int i = 0; i < usuarioAtual.getMensagens().size(); i++) {
                System.out.println(usuarioAtual.getMensagens().get(i));
                if (!usuarioAtual.getMensagens().get(i).isLido())
                    usuarioAtual.getMensagens().get(i).setLido(true);
            }
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private static void buscaUsuarioUniversidade(UsuarioEstudante usuarioAtual) {
        int flag = 0;
        for (int i = 0; i < Biblioteca.usuarios.size(); i++) {
            if (Biblioteca.usuarios.get(i) instanceof UsuarioEstudante) {
                if (usuarioAtual.getInstituicao().equals(((UsuarioEstudante) Biblioteca.usuarios.get(i)).getInstituicao())) {
                    System.out.println("Usuário " + Biblioteca.usuarios.get(i).getNome() + " Também pertence à " + usuarioAtual.getInstituicao());
                    flag++;
                }
            }
        }
        if (flag == 0)
            System.out.println("Não encontramos nenhum usuário de sua instituição de ensino!");
    }

    public static int checaCupom(String codigo) {
        for (int i = 0; i < Biblioteca.cupons.size(); i++) {
            if (Biblioteca.cupons.get(i).getCodigo().equals(codigo)) {
                if (!Biblioteca.cupons.get(i).isFoiUsado()) {
                    return i;
                } else {
                    System.out.println("Cupom já utilizado!");
                    return -1;
                }
            }
        }
        System.out.println("Código de cupom inválido!");
        return -1;
    }

}