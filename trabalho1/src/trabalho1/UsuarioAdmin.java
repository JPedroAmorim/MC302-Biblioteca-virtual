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

    public void cadastrarLivro(String nome, String autor, int indice, int edicao, int ano, int livrosDisponiveis, double valor) {

         List<Genero> list = new ArrayList<Genero>(EnumSet.allOf(Genero.class));

         Livro livro = new Livro(nome, autor, list.get(indice), edicao, ano, livrosDisponiveis, valor);
         Biblioteca.acervo.add(livro); // Aqui está a justificativa de cadastrarLivro ser abstrato: Enquanto usuarioComum e usuarioEstudante adicionam livros em seus acervos, usuarioAdmin adiciona livros na AL acervo da Biblioteca.
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
