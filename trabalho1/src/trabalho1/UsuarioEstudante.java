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

// Classe UsuarioEstudante: abstração de um usuário estudante para os efeitos do sistema. Extende Usuario.

public class UsuarioEstudante extends Usuario {

    // Atributos.

    private String instituicao;
    private int ra;

    // Construtor.

    public UsuarioEstudante(String nome, String senha, String dataNasc, String email, boolean status, String instituicao, int ra) {
        super(nome, senha, dataNasc, email, status);
        this.instituicao = instituicao;
        this.ra = ra;
    }

    // Getters & Setters.

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    // Método buscaUsuarioUniversidade: Exclusivo de usuarioEstudante, é capaz de informar quais usuários do sistema estão na mesma instituição de ensino do usuário atual.

    public void buscaUsuarioUniversidade() throws SistemaExcecao {
        boolean flag = false;
        for (int i = 0; i < Biblioteca.usuarios.size(); i++) {
            if (Biblioteca.usuarios.get(i) instanceof UsuarioEstudante // Verifica se o usuário é um UsuarioEstudante
                    && instituicao.equals(((UsuarioEstudante) Biblioteca.usuarios.get(i)).getInstituicao()) // Verifica se ambos possuem a mesma instiuição de ensino
                    && !(this.getNome().equals(Biblioteca.usuarios.get(i).getNome()))) { // Verifica se não é o próprio usuário que chamou o método
                System.out.println("Usuário " + Biblioteca.usuarios.get(i).getNome() + " também pertence à " + instituicao);
                flag = true;
            }
        }
        if (!flag)
        	throw new SistemaExcecao("Não encontramos nenhum usuário de sua instituição de ensino!");
    }
    
    public void cadastrarLivro() {
    	 Scanner sc = new Scanner(System.in);
    	
         System.out.println("Digite o nome do livro: ");
         String nome = sc.nextLine();

         for (int i = 0; i < getLivrosDoUsuario().size(); i++) {
        	 if (getLivrosDoUsuario().get(i).getNome().equals(nome)) {
        		System.out.println("Você já possui esse livro em seu acervo!");
        		sc.close();
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
         getLivrosDoUsuario().add(livro);
         System.out.println("Livro cadastrado com sucesso!");

	}

    // toString de UsuarioEstudante.
    // @Override
    public String toString() {
        String out = super.toString();
        out = out + "Instituicao: " + getInstituicao() + "\n";
        out = out + "Ra: " + getRa() + "\n";

        return out;
    }
    
    public void salvar(File arquivo) {	
		try {
			FileWriter arq = new FileWriter("UsuarioEstudante.txt", true);
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

