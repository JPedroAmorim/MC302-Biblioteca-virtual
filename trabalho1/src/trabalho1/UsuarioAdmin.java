package trabalho1;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.EnumSet;

public class UsuarioAdmin extends Usuario {

    public UsuarioAdmin(String nome, String senha, String dataNasc, String email, boolean status) {
        super(nome, senha, dataNasc, email, status);
    }

    public void cadastrarCupom() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o código do cupom a ser adicionado: ");

        String codigo = sc.next();

        if(Gerenciador.checaCupom(codigo) != -1) {
            System.out.println("Esse cupom já existe!");
            return;
        }

        System.out.println("Digite, em porcentagem, o desconto do cupom: ");

        Float desconto = sc.nextFloat();

        Cupom cupom = new Cupom(codigo, desconto);

        Biblioteca.cupons.add(cupom);

        System.out.println("Cupom cadastrado com sucesso!");
    }

    public void cadastrarLivro() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do livro: ");

        String nome = sc.next();

        for(int i = 0; i < Biblioteca.acervo.size(); i++) {
            if(Biblioteca.acervo.get(i).getNome().equals(nome)) {
                System.out.println("O livro já existe no acervo!");
                return;
            }
        }

        System.out.println("Digite o nome do autor: ");

        String autor = sc.next();

        System.out.println("Digite o gênero do livro: ");

        String nomeGenero = sc.next();

        int flag = 0;
        int indice = 0;

        List<Genero> list = new ArrayList<Genero>(EnumSet.allOf(Genero.class));

        for(int i = 0; i<list.size(); i++)  {
            if(list.get(i).getTipo().equals(nomeGenero)) {
                flag++;
                indice = i;
            }
        }

        if(flag == 0) {
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

        float valor = sc.nextFloat();

        Livro livro = new Livro(nome, autor, list.get(indice), edicao, ano, livrosDisponiveis, valor);

        Biblioteca.acervo.add(livro);

        System.out.println("Livro adicionado com sucesso!");
    }

    public void banirUsuario() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do usuário que você deseja banir: ");

        String nome = sc.next();

        int resultado = Gerenciador.checaUsuario(nome);

        if (resultado != -1) {
            Biblioteca.usuarios.remove(Biblioteca.usuarios.get(resultado));
            System.out.println("Usuário banido com sucesso!");
        } else {
            System.out.println("Usuário não existe!");
        }

    }


}
