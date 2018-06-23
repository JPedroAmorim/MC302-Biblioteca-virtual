package trabalho1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;


// Classe UsuarioAdmin: Abstração de um administrador para os efeitos do sistema. Extende usuario.

public class UsuarioAdmin extends Usuario {

    // Construtor.

    public UsuarioAdmin(String nome, String senha, String dataNasc, String email, boolean status) {
        super(nome, senha, dataNasc, email, status);
    }

    // Métodos de usuarioAdmin.

    // Método cadastrarCupom: Permite ao Admin cadastrar um cupom no sistema.

    public void cadastrarCupom() throws SistemaExcecao {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código do cupom a ser adicionado: ");

        String codigo = sc.nextLine();

        if (Gerenciador.checaCupom(codigo) != -1) 
        	throw new SistemaExcecao("Esse cupom já existe!");

        System.out.println("Digite, em porcentagem, o desconto do cupom: ");

        double desconto = sc.nextDouble();
        Cupom cupom = new Cupom(codigo, desconto);
        Biblioteca.cupons.add(cupom);

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
         getLivrosDoUsuario().add(livro);
         System.out.println("Livro cadastrado com sucesso!");         
    }
    
    public void banirUsuario(String nome) throws SistemaExcecao {

        System.out.println("Digite o nome do usuário que você deseja banir: ");
        nome = "";
        
        if (Main.testMode == 1) {
            nome = "João";
        }

        int resultado = Gerenciador.checaUsuario(nome);

        if (resultado != -1) {
            Biblioteca.usuarios.remove(Biblioteca.usuarios.get(resultado));
            System.out.println("Usuário banido com sucesso!");
        } else 
        	throw new SistemaExcecao("Usuário não existe!");
    }

    public void salvar(File arquivo) {	
		try {
			FileWriter arq = new FileWriter("MensagensUsuarioAdmin.txt", true);
			BufferedWriter escrever = new BufferedWriter(arq);
			for(int i=0; i<getMensagens().size(); i++)
				escrever.write(getMensagens().get(i).toString());
			escrever.close();
			arq.close();
		}catch(IOException e) {
			
		}		
	}
    
    public void ler(File arquivo) {
    	try {
			FileReader arq = new FileReader(arquivo);
			BufferedReader ler = new BufferedReader(arq);
			String linha = ler.readLine();		
			while(linha != null) {
				System.out.println(linha);
				linha = ler.readLine();
			}
			ler.close();
			arq.close();	
		}catch(IOException e) {
			
		}	
	}
}
