package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class MenuAdmin extends JFrame {

    private JPanel contentPane;


    public MenuAdmin() {
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 217);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Banir usuário");
        btnNewButton.setBounds(237, 37, 174, 23);
        contentPane.add(btnNewButton);

        JButton btnCadastrarCupom = new JButton("Cadastrar cupom");
        btnCadastrarCupom.setBounds(31, 37, 166, 23);
        contentPane.add(btnCadastrarCupom);

        JButton btnCadastrarLivro = new JButton("Cadastrar livro");
        btnCadastrarLivro.setBounds(234, 71, 177, 23);
        contentPane.add(btnCadastrarLivro);

        JButton btnListaEstadoDo = new JButton("Listar estado do sistema");
        btnListaEstadoDo.setBounds(31, 71, 166, 23);
        contentPane.add(btnListaEstadoDo);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(172, 130, 89, 23);
        contentPane.add(btnSair);
    }

}
