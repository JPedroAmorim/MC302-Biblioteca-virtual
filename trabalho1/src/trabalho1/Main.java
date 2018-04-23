package trabalho1;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("*************** BIBLIOTECA VIRTUAL  v 1.0 - CLOSED BETA ***************");
        System.out.println("*** Pressione 1 para se cadastrar ou 2 se você já possui cadastro ***");

        Scanner sc = new Scanner(System.in);

        int opcao = sc.nextInt();

        if (opcao == 1) { 
            Gerenciador.geradorUsuario();
        }

        int resultado = Gerenciador.login();

        if (resultado == -1) { // Resultado == -1 significa que o usuario não está no AL da biblioteca

            while (resultado == -1) {
                System.out.println("Usuario ou senha incorretos!");
                resultado = Gerenciador.login();
            }

        } else {
           while (Gerenciador.opcoesUsuario(Biblioteca.usuarios.get(resultado)));

           System.out.println("Obrigado por utilizar a biblioteca virtual!");
        }
    }
}

