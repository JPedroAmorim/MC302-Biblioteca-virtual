package trabalho1;

import java.util.Scanner;


// Classe UsuarioAdmin: Abstração de um administrador para os efeitos do sistema. Extende usuario.

public class UsuarioAdmin extends Usuario {

    // Construtor.

    public UsuarioAdmin(String nome, String senha, String dataNasc, String email, boolean status) {
        super(nome, senha, dataNasc, email, status);
    }

    // Métodos de usuarioAdmin.

    // Método cadastrarCupom: Permite ao Admin cadastrar um cupom no sistema.

    public void cadastrarCupom() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o código do cupom a ser adicionado: ");

        String codigo = sc.nextLine();

        if (Gerenciador.checaCupom(codigo) != -1) {
            System.out.println("Esse cupom já existe!");
            return;
        }

        System.out.println("Digite, em porcentagem, o desconto do cupom: ");

        double desconto = sc.nextDouble();

        Cupom cupom = new Cupom(codigo, desconto);

        System.out.println("Cupom cadastrado com sucesso!");
    }

    // Método listaDados: Permite ao Admin listar o conteúdo de cada uma das AL de Biblioteca.

    public void listaDados() {

        System.out.println("Digite a opcao desejada: ");
        System.out.println("1 - Listar os livros no acervo da Biblioteca Virtual");
        System.out.println("2 - Listar os empréstimos do sistema");
        System.out.println("3 - Listar os usuários do sistema");
        System.out.println("4 - Listar os cupons do sistema");

        Scanner sc = new Scanner(System.in);

        int opcao = sc.nextInt();

        if(opcao == 1) {
            System.out.println(Biblioteca.acervo);
        } else if (opcao == 2) {
            System.out.println(Biblioteca.emprestimos);
        } else if (opcao == 3) {
            System.out.println(Biblioteca.usuarios);
        } else if (opcao == 4) {
            System.out.println(Biblioteca.cupons);
        } else {
            System.out.println("Por favor, digite uma opcao válida!");
        }

    }

    // Método banirUsuário: Permite ao Admin remover (banir) um usuário do sistema.

    public void banirUsuario() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do usuário que você deseja banir: ");

        String nome = "";

        if (Main.testMode == 0) {
            nome = sc.nextLine();
        } else if (Main.testMode == 1) {
            nome = "João";
        }

        int resultado = Gerenciador.checaUsuario(nome);

        if (resultado != -1) {
            Biblioteca.usuarios.remove(Biblioteca.usuarios.get(resultado));
            System.out.println("Usuário banido com sucesso!");
        } else {
            System.out.println("Usuário não existe!");
        }

    }
}
