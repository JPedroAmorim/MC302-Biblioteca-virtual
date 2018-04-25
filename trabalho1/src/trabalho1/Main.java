package trabalho1;

import java.util.Scanner;

// Classe main: Ponto de partida do sistema. É responsável por chamar os métodos login e de opcoesUsuario, da classe Gerenciador. Contém testaSistema(), utilizado para demonstrar o sistema.

public class Main {

    public static int testMode = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Você deseja testar a funcionalidade do sistema por testaSistema()? (Sim/Nao)");

        String testeSistema = sc.nextLine();


        if (testeSistema.equals("Sim")) {
            testMode = 1;
            testaSistema();
            return;
        }

        System.out.println("*************** BIBLIOTECA VIRTUAL  v 1.0 - CLOSED BETA ***************");
        System.out.println("*** Pressione 1 para se cadastrar ou 2 se você já possui cadastro ***");


        int opcao = sc.nextInt();

        if (opcao == 1) {
            Gerenciador.geradorUsuario();
        }

        int resultado = Gerenciador.login();

        if (resultado == -1) { // Resultado == -1 significa que o usuario não está na AL usuários da biblioteca.

            while (resultado == -1) {
                System.out.println("Usuario ou senha incorretos!");
                resultado = Gerenciador.login();
            }

        } else {
            while (Gerenciador.opcoesUsuario(Biblioteca.usuarios.get(resultado)))
                ; // Enquanto o método opcoesUsuario não retornar false, o usuário não optou por deslogar do sistema.

            System.out.print("\n");

            System.out.println("Obrigado por utilizar a biblioteca virtual!");
        }
    }

    public static void testaSistema() { // Testa as principais funcionalidades do sistema.

        Scanner sc = new Scanner(System.in);

        Usuario exemploUsuario = new Usuario("João", "1234", "12/09/1998", "João@Email", true);

        Usuario exemplo1Usuario = new Usuario("Maria", "5678", "10/10/2000", "Maria@Email", true);

        UsuarioEstudante exemploUsuarioEstudante = new UsuarioEstudante("Carlos", "9101", "12/12/1990", "Carlos@Email", true, "Ufscar", 1234);

        UsuarioEstudante exemplo1UsuarioEstudante = new UsuarioEstudante("Renata", "1203", "10/01/2000", "Renata@Email", true, "Ufscar", 5678);

        UsuarioAdmin exemploUsuarioAdmin = new UsuarioAdmin("Felipe", "9223", "12/08/1970", "Felipe@Admin", true);

        Livro livroExemplo = new Livro("Fisica de Particulas", "Einstein", Genero.FISICA, 1, 1930, 10, 34);

        Livro livroExemplo1 = new Livro("Romeu e Julieta", "Shakespere", Genero.ROMANCE, 100, 2000, 10, 40);

        exemplo1Usuario.setSaldo(1000);

        exemploUsuario.getLivrosDoUsuario().add(livroExemplo1);

        exemplo1Usuario.novoEmprestimo(exemploUsuario, null);

        exemplo1Usuario.novoEmprestimo(null, null);

        Cupom cupom = new Cupom("123", 20);

        exemplo1Usuario.novoEmprestimo(null, cupom);

        exemplo1Usuario.adicionarAmigo();

        exemplo1Usuario.infoUsuario();

        exemplo1Usuario.adicionarSaldo();

        exemplo1Usuario.enviarMensagem();

        exemploUsuario.verMensagens();

        exemplo1UsuarioEstudante.buscaUsuarioUniversidade();

        exemploUsuarioAdmin.banirUsuario();

        System.out.print("\n");

        System.out.println("Impressão da database (todas as AL de Biblioteca) do programa");

        System.out.print("\n");

        System.out.println(Biblioteca.acervo);

        System.out.print("\n");

        System.out.println(Biblioteca.usuarios);

        System.out.print("\n");

        System.out.println(Biblioteca.emprestimos);

        System.out.print("\n");

        System.out.println(Biblioteca.cupons);

        System.out.print("\n");

        System.out.println("FIM DO MODO TESTE");
        
    }
}


