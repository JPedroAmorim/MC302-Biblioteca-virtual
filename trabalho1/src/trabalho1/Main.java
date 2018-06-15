// Alexandre Luciano Barbosa	165232
// João Pedro de Amorim 		176131
// Leonardo Rodrigues Marques	178610

package trabalho1;

import java.io.File;
import java.util.Scanner;

// Classe main: Ponto de partida do sistema. É responsável por chamar os métodos login e de opcoesUsuario, da classe Gerenciador. Contém testaSistema(), utilizado para demonstrar o sistema.

public class Main {

    public static int testMode = 0; // Variável que indica se o sistema está em modo de teste ou não.

    public static void main(String[] args) throws SistemaExcecao {

        Scanner sc = new Scanner(System.in);
        System.out.println("Você deseja testar a funcionalidade do sistema por testaSistema()? (Sim/Nao)");
        String testeSistema = sc.nextLine();
        
        if (testeSistema.equals("Sim")) {
            testMode = 1;
            testaSistema();
            return;
        }

        System.out.println("*************** BIBLIOTECA VIRTUAL  v 2.0 - CLOSED BETA ***************");
        System.out.println("*** Digite 1 para se cadastrar ou 2 se você já possui cadastro ***");

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
                 // Enquanto o método opcoesUsuario não retornar false, o usuário não optou por deslogar do sistema.

            System.out.print("\n");
            System.out.println("Obrigado por utilizar a biblioteca virtual!");
        }
    }

    public static void testaSistema() throws SistemaExcecao { // Testa as principais funcionalidades do sistema.

        Scanner sc = new Scanner(System.in);
        
       Biblioteca biblioteca = new Biblioteca();
       
        // Instanciamento de usuários teste de todas as classes de usuário: Usuario, UsuarioEstudante e UsuarioAdmin.
        UsuarioComum exemploUsuario = new UsuarioComum("João", "1234", "12/09/1998", "João@Email", true);
        UsuarioComum exemplo1Usuario = new UsuarioComum("Maria", "5678", "10/10/2000", "Maria@Email", true);

        UsuarioEstudante exemploUsuarioEstudante = new UsuarioEstudante("Carlos", "9101", "12/12/1990", "Carlos@Email", true, "Ufscar", 1234);
        UsuarioEstudante exemplo1UsuarioEstudante = new UsuarioEstudante("Renata", "1203", "10/01/2000", "Renata@Email", true, "Ufscar", 5678);

        UsuarioAdmin exemploUsuarioAdmin = new UsuarioAdmin("Felipe", "9223", "12/08/1970", "Felipe@Admin", true);

        // Instanciamento de livros de exemplo.

        Livro livroExemplo = new Livro("Fisica de Particulas", "Einstein", Genero.FISICA, 1, 1930, 10, 34);
        Livro livroExemplo1 = new Livro("Romeu e Julieta", "Shakespere", Genero.ROMANCE, 100, 2000, 10, 40);

        biblioteca.acervo.add(livroExemplo);
        biblioteca.acervo.add(livroExemplo1);

        exemplo1Usuario.setSaldo(1000);

        // Aqui, são feitos empréstimos: com a Biblioteca Virtual, entre usuários e com cupom de desconto.

        exemploUsuario.getLivrosDoUsuario().add(livroExemplo1);
        exemplo1Usuario.novoEmprestimo(exemploUsuario, null);
        exemplo1Usuario.novoEmprestimo(null, null);

        Cupom cupom = new Cupom("123", 20);

        exemplo1Usuario.novoEmprestimo(null, cupom);

        // Teste dos principais métodos de Usuario, UsuarioEstudante e UsuarioAdmin.

        exemplo1Usuario.adicionarAmigo();
        exemplo1Usuario.infoUsuario();
        exemplo1Usuario.adicionarSaldo();
        exemplo1Usuario.enviarMensagem();
        exemploUsuario.verMensagens();
        exemplo1UsuarioEstudante.buscaUsuarioUniversidade();
        exemploUsuarioAdmin.banirUsuario();
        
        File arq = new File("Biblioteca.txt");
        biblioteca.salvar(arq);
 
        System.out.print("\n");
        // Impressão da DB do programa para mostrar como ela está após a execução de testMode().
        System.out.println("Impressão da database (todas as AL de Biblioteca) do programa");
        System.out.print("\n");
        System.out.println(biblioteca.acervo);
        System.out.print("\n");
        System.out.println(biblioteca.usuarios);
        System.out.print("\n");
        System.out.println(biblioteca.emprestimos);
        System.out.print("\n");
        System.out.println(biblioteca.cupons);
        System.out.print("\n");
        System.out.println("FIM DO MODO TESTE");
        
    }
}


