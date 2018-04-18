package trabalho1;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("*************** BIBLIOTECA VIRTUAL  v 1.0 - CLOSED BETA ***************");
        System.out.println("*** Pressione 1 para se cadastrar ou 2 se você já possui cadastro ***");

        Scanner sc = new Scanner(System.in);

        int opcao = sc.nextInt();

        if (opcao == 1) { // Apenas importa se opcao for == 1, pra ser franco.
            Gerenciador.geradorUsuario();
        }

        int resultado = Gerenciador.checaUsuario();

        if (resultado == -1) { // Resultado == -1 significa que o usuario não está no AL da biblioteca...

            while (resultado == -1) {
                System.out.println("Usuario ou senha incorretos!");
                resultado = Gerenciador.checaUsuario();
            }

        } else {// Decidi diferenciar o tratamento de Usuario e UsuarioEstudante pois podemos adicionar métodos exclusivos à UsuarioEstudante no futuro...
            if (Biblioteca.usuarios.get(resultado) instanceof Usuario) { // TODO: Caso em que o objeto é um UsuarioEstudante ou o UsuarioAdmin, quando definirmos os métodos exclusivos desses
                Usuario usuarioAtual = ((Usuario) Biblioteca.usuarios.get(resultado));

                int opcao1 = Gerenciador.opcoesUsuario(usuarioAtual);

                while (opcao1 != 6) {
                    opcao1 = Gerenciador.opcoesUsuario(usuarioAtual);
                }

            }
        }
    }
}

