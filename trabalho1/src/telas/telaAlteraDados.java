package telas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaAlteraDados extends JFrame {

    private JPanel contentPane;
    private JButton botaoProcurar;
    private  JButton botaoConfirmar;
    private  JLabel perguntaUsuario, perguntaEmail, perguntaAniversario, perguntaRA;
    private JTextField novoUsuario, novoEmail, novoAniversario, novoRA;


    public telaAlteraDados() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new WrapLayout(WrapLayout.LEFT, 0, 10));
        setContentPane(contentPane);

        perguntaUsuario = new JLabel("Digite o novo nome de usuário: ");

        JTextField usuarionome = new JTextField("", 40);


        JLabel perguntaSenha = new JLabel("Digite a sua nova senha: ");

        JTextField novasenha = new JTextField("", 40);

       // JLabel pergunta = new JTextField("", 40);

        //Botao
        botaoConfirmar = new JButton();
        botaoProcurar.setText("Confirmar Alteracao");
        botaoProcurar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);

            }
        });

        contentPane.add(perguntaUsuario);
        contentPane.add(usuarionome);
        contentPane.add(botaoConfirmar);

    }

    public static void main(String[] args){
        new telaAlteraDados();
    }
}