package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

    private JPanel contentPane;

    public TelaInicial() {
        setTitle("Biblioteca Virtual");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 198);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        contentPane.setLayout(null);

        JLabel lblBemvindoABiblioteca = new JLabel("Bem-Vindo!");
        lblBemvindoABiblioteca.setBounds(120, 24, 89, 14);
        contentPane.add(lblBemvindoABiblioteca);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
                TelaInicial.this.dispose();
            }
        });
        btnLogin.setBounds(27, 89, 89, 23);
        contentPane.add(btnLogin);

        JButton btnCadastro = new JButton("Cadastro");
        btnCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new Cadastro().setVisible(true);
            }
        });
        btnCadastro.setBounds(175, 89, 89, 23);
        contentPane.add(btnCadastro);
    }

}
