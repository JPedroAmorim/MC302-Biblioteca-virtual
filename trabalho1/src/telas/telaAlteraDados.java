package telas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaAlteraDados extends JFrame {

    private JPanel contentPane;
    JButton usuario;

        /**
         * Launch the application.
         */
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        telaAlteraDados tela = new telaAlteraDados();
                        tela.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        /**
         * Create the frame.
         */
        public telaAlteraDados() {

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 800, 400);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(new WrapLayout(WrapLayout.LEFT, 0, 10));
            setContentPane(contentPane);

            JLabel perguntaUsuario = new JLabel("Digite o novo nome de usuário: ");

            JTextField usuarionome = new JTextField("", 40);


            JLabel perguntaSenha = new JLabel("Digite a sua nova senha: ");

            JTextField novasenha = new JTextField("", 40);

            JLabel pergunta = new JTextField("", 40);



            contentPane.add(perguntaUsuario);
            contentPane.add(usuarionome);




        }



}