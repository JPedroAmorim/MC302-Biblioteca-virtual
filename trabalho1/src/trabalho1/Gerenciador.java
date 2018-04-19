package trabalho1;
import java.util.Scanner;

public class Gerenciador { // Essa classe basicamente deixa a main mais enxuta e legível -
							// IMPORTANTE: todos seus métodos são estáticos e ela não possui atributos

    // Metódo geradorUsuario: Gera um um objeto Usuario ou UsuarioEstudante com os dados fornecidos pela entrada

    public static void geradorUsuario() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do seu usuário: ");

        String nome = sc.next();

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


    /* Método checaUsuario: Retorna o índice do usuário na AL usuarios da Biblioteca caso encontrado, e -1 se o usuário
       não existir. Recebe como parâmetro o nome e senha do usuário.  */
    

    public static int checaUsuario() { // TODO: Tratar o caso do UsuarioAdmin...
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


   /* Método opcoesUsuario: Recebe do usuário pela entrada padrão e realiza a opção desejada. Enquanto não retorna 6,
   ele continua a ser executado pela main em loop.  */

    public static int opcoesUsuario(Usuario usuarioAtual){ // TODO: método opcoesUsuarioEstudante, após definirmos métodos exclusivos para esse tipo de Usuário
        System.out.println("Olá " + usuarioAtual.getNome() + " !");

        Scanner sc = new Scanner(System.in);

        System.out.println(" ***** Pressione a tecla para executar a opção desejada... ***** ");

        System.out.println("1 - Realizar um empréstimo");
        System.out.println("2 - Adicionar um amigo");
        System.out.println("3 - Buscar informações de um usuário");
        System.out.println("4 - Alterar seus dados");
        System.out.println("5 - Finalizar um empréstimo");
        System.out.println("6 - Desconectar da Biblioteca Virtual");

        int opcao = sc.nextInt();

        if (opcao == 1) { // TODO: Todos esses métodos aqui
            Gerenciador.novoEmprestimo();
            return 1;

        } else if (opcao == 2) {
            Gerenciador.addAmigo();
            return 2;

        } else if (opcao == 3) {
            Gerenciador.infoUsuario();
            return 3;

        } else if (opcao == 4) {
            Gerenciador.alteraDados();
            return 4;

        } else if (opcao == 5) {
            Gerenciador.finalizaEmprestimo();
            return 5;

        } else {
            return 6;
        }
    }

    public static void novoEmprestimo () {
        Scanner sc = new Scanner(System.in);


    }

}