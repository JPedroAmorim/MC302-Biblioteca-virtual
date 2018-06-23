package telas;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuComum extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuComum frame = new MenuComum();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    public MenuComum() {
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 432);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton btnNewButton = new JButton("Cadastrar livro");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBounds(10, 59, 180, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Emprestimo com a biblioteca");
        btnNewButton_1.setBounds(10, 25, 180, 23);
        contentPane.add(btnNewButton_1);

        JButton btnEmprestimoComUm = new JButton("Emprestimo com um usuario");
        btnEmprestimoComUm.setBounds(217, 25, 187, 23);
        contentPane.add(btnEmprestimoComUm);

        JButton btnAdicionarAmigo = new JButton("Adicionar amigo");
        btnAdicionarAmigo.setBounds(10, 189, 180, 23);
        contentPane.add(btnAdicionarAmigo);

        JButton btnInformacoesDeOutros = new JButton("Informacoes de outros usuarios");
        btnInformacoesDeOutros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnInformacoesDeOutros.setBounds(217, 189, 187, 23);
        contentPane.add(btnInformacoesDeOutros);

        JButton btnAlterarDados = new JButton("Alterar dados");
        btnAlterarDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaAlteraDados().setVisible(true);
            }
        });
        btnAlterarDados.setBounds(217, 134, 187, 23);
        contentPane.add(btnAlterarDados);

        JButton btnVerMinhasInformacoes = new JButton("Ver minhas informacoes");
        btnVerMinhasInformacoes.setBounds(10, 134, 180, 23);
        contentPane.add(btnVerMinhasInformacoes);

        JButton btnEnviarMensagem = new JButton("Enviar mensagem");
        btnEnviarMensagem.setBounds(217, 258, 187, 23);
        contentPane.add(btnEnviarMensagem);

        JButton btnCaixaDeEntrada = new JButton("Caixa de entrada");
        btnCaixaDeEntrada.setBounds(10, 258, 180, 23);
        contentPane.add(btnCaixaDeEntrada);

        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login().setVisible(true);
            }
        });
        btnSair.setBounds(163, 359, 89, 23);
        contentPane.add(btnSair);

        JButton btnAdicionarSaldo = new JButton("Adicionar Saldo");
        btnAdicionarSaldo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaAddSaldo().setVisible(true);
            }
        });
        btnAdicionarSaldo.setBounds(10, 310, 180, 23);
        contentPane.add(btnAdicionarSaldo);
    }

}
