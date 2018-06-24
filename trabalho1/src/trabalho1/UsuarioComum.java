package trabalho1;

import java.io.*;
import java.util.*;

public class UsuarioComum extends Usuario {

    public UsuarioComum(String nome, String senha, String dataNasc, String email, boolean status) {
        super(nome, senha, dataNasc, email, status);

    }
    public void alteraDados(String novoNome, String novaSenha, String novoEmail, String novoAniversario) {
        this.setNome(novoNome);
        this.setSenha(novaSenha);
        this.setEmail(novoEmail);
        this.setDataNasc(novoAniversario);
    }
    public void cadastrarLivro(String nome, String autor, int indice, int edicao, int ano, int livrosDisponiveis, double valor) {

        List<Genero> list = new ArrayList<Genero>(EnumSet.allOf(Genero.class));

        Livro livro = new Livro(nome, autor, list.get(indice), edicao, ano, livrosDisponiveis, valor);
        this.getLivrosDoUsuario().add(livro);
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
            while (linha != null) {
                System.out.println(linha);
                linha = ler.readLine();
            }
            ler.close();
            arq.close();
        } catch (IOException e) {

        }
    }
}
