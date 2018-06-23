package telas;

import trabalho1.SistemaExcecao;
import trabalho1.Usuario;
import trabalho1.UsuarioAdmin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaBanirUsuario extends JFrame {

    JFrame janelaBanirUsuario;
    JPanel painelBanirUsuario;
    JButton botaoProcurar;
    JTextField usuarioBanido;
    JLabel texto;

    public TelaBanirUsuario() {

        //Pegar dimensões da Tela
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        //Janela
        janelaBanirUsuario =  new JFrame("Banir Usuario");
        janelaBanirUsuario.setSize(400, 200);
        janelaBanirUsuario.setLocation((int)(dimension.getWidth() - janelaBanirUsuario.getWidth()) / 2, (int)(dimension.getHeight() - janelaBanirUsuario.getHeight())/2);
        janelaBanirUsuario.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Painel
        painelBanirUsuario = new JPanel();

        //Botao
        botaoProcurar =  new JButton("Procurar");
        botaoProcurar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = texto.getText();
                

            }
        });

        //Texto
        texto = new JLabel("Digite o nome do usuario: ");

        //Campo do texto
        usuarioBanido = new JTextField(30);

        painelBanirUsuario.add(texto);
        painelBanirUsuario.add(usuarioBanido);
        painelBanirUsuario.add(botaoProcurar);
        janelaBanirUsuario.getContentPane().add(painelBanirUsuario);

        janelaBanirUsuario.setVisible(true);

    }

    public static void main(String[] args){
        new TelaBanirUsuario();
    }
}
