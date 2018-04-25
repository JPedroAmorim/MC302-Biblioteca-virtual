package trabalho1;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.EnumSet;


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

    // Método cadastrarLivro: Permite ao Admin cadastrar um livro no sistema.

    public void cadastrarLivro() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do livro: ");

        String nome = sc.nextLine();

        for (int i = 0; i < Biblioteca.acervo.size(); i++) {
            if (Biblioteca.acervo.get(i).getNome().equals(nome)) {
                System.out.println("O livro já existe no acervo!");
                return;
            }
        }

        System.out.println("Digite o nome do autor: ");

        String autor = sc.nextLine();

        System.out.println("Digite o gênero do livro: ");

        String nomeGenero = sc.nextLine();

        boolean flag = false;
        int indice = 0;

        // "Gambiarra" para lidar com o Genero.

        List<Genero> list = new ArrayList<Genero>(EnumSet.allOf(Genero.class));

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTipo().equals(nomeGenero)) {
                flag = true;
                indice = i;
            }
        }

        if (!flag) {
            System.out.println("Por favor, digite um gênero válido");
            return;
        }

        System.out.println("Digite a edição do livro: ");

        int edicao = sc.nextInt();

        System.out.println("Digite o ano do livro: ");

        int ano = sc.nextInt();

        System.out.println("Digite quantos exemplares estão disponíveis desse livro: ");

        int livrosDisponiveis = sc.nextInt();

        System.out.println("Digite o valor de empréstimo do livro: ");

        double valor = sc.nextDouble();

        Livro livro = new Livro(nome, autor, list.get(indice), edicao, ano, livrosDisponiveis, valor);

        System.out.println("Livro adicionado com sucesso!");
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
