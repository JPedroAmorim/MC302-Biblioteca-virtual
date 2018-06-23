package telas;

import trabalho1.Usuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaEmprestimo extends JFrame {

    private JPanel contentPane;
    private JButton botaoUsuario, botaoBV;
    private JLabel pergunta;

    /**
     * Create the frame.
     */
    public TelaEmprestimo(Usuario usuarioAtual) {

        setTitle("Escolha uma opção");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 100);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 10));
        setContentPane(contentPane);

        pergunta = new JLabel("Você deseja fazer um empréstimo com:");

        botaoUsuario = new JButton("Usuário");
        botaoBV = new JButton("Biblioteca Virtual");

        ButtonListener buttonListener = new ButtonListener();

        botaoUsuario.addActionListener(buttonListener);
        botaoBV.addActionListener(buttonListener);

    }


    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


            if (e.getSource() == botaoUsuario) {

            } else {

            }

        }
    }
}