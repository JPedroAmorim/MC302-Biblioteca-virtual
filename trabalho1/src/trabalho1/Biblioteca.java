package trabalho1;

import java.io.*;
import java.util.ArrayList;

// Classe biblioteca: É o banco de dados onde estão armazenadas as AL necessárias do sistema.

public class Biblioteca implements SalvarLer {

    public static ArrayList<Livro> acervo = new ArrayList<Livro>();
    public static ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    public static ArrayList<Cupom> cupons = new ArrayList<Cupom>();
    
    public String toString() {
    	String out = "Banco de Dados da Biblioteca\n";

    	out = out + acervo.size() + "\n";
    	for(int i=0; i<acervo.size(); i++)
    		out = out + acervo.get(i).toString();

        out = out + usuarios.size() + "\n";
    	for(int i=0; i<usuarios .size(); i++)
    		out = out + usuarios .get(i).toString();

        out = out + emprestimos.size() + "\n";
    	for(int i=0; i<emprestimos.size(); i++)
    		out = out + emprestimos.get(i).toString();

        out = out + cupons.size() + "\n";
    	for(int i=0; i<cupons.size(); i++)
    		out = out + cupons.get(i).toString();

    	return out;
    }
	public void salvar() {
		try {
			FileWriter arq = new FileWriter("testeArquivos/Biblioteca.txt", true);
			BufferedWriter escrever = new BufferedWriter(arq);
			escrever.write(toString());
			escrever.close();
			arq.close();
		}catch(IOException e) {e.printStackTrace();}
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


