package trabalho1;

import java.io.*;
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

    public String buscaUsuarioUniversidade() throws SistemaExcecao {
        boolean flag = false;
        String out = "";

        for (int i = 0; i < Biblioteca.usuarios.size(); i++) {
            if (Biblioteca.usuarios.get(i) instanceof UsuarioEstudante // Verifica se o usuário é um UsuarioEstudante
                    && instituicao.equals(((UsuarioEstudante) Biblioteca.usuarios.get(i)).getInstituicao()) // Verifica se ambos possuem a mesma instiuição de ensino
                    && !(this.getNome().equals(Biblioteca.usuarios.get(i).getNome()))) { // Verifica se não é o próprio usuário que chamou o método
                out += "Usuário " + Biblioteca.usuarios.get(i).getNome() + " também pertence à " + instituicao + "\n";
                flag = true;
            }
        }
        if (!flag)
        	throw new SistemaExcecao("Não encontramos nenhum usuário de sua instituição de ensino!");
        return out;
    }

    public void alteraDados(String novoNome, String novaSenha, String novoEmail, String novoAniversario, int novoRA, String novaInstituicao) {
        this.setNome(novoNome);
        this.setSenha(novaSenha);
        this.setEmail(novoEmail);
        this.setDataNasc(novoAniversario);
        this.setRa(novoRA);
        this.setInstituicao(novaInstituicao);
    }

    public void cadastrarLivro(String nome, String autor, int indice, int edicao, int ano, int livrosDisponiveis, double valor) {

        List<Genero> list = new ArrayList<Genero>(EnumSet.allOf(Genero.class));

        Livro livro = new Livro(nome, autor, list.get(indice), edicao, ano, livrosDisponiveis, valor);
        this.getLivrosDoUsuario().add(livro);
    }


    @Override
    public String toString() {
        String out = super.toString();
        out = out + "Instituicao: " + getInstituicao() + "\n";
        out = out + "Ra: " + getRa() + "\n";

        return out;
    }

    public void salvar(Writer writer) {
        try {
            writer.write(this.getMensagens().toString());

            writer.flush();

        }catch(IOException e) {
            e.printStackTrace();
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

