package telas;

import trabalho1.Usuario;
import trabalho1.UsuarioComum;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuComum extends JFrame {

    private JPanel contentPane;
    private JButton btnCadastrarLivro, btnEmprestimoBV, btnEmprestimoComUm, btnAdicionarAmigo, btnInformacoesDeOutros,
            btnAlterarDados, btnVerMinhasInformacoes, btnEnviarMensagem, btnCaixaDeEntrada, btnAdicionarSaldo, btnSair;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuComum frame = new MenuComum(null);
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
    public MenuComum(Usuario usuario) {

        setTitle("Menu Principal");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 432);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

        btnCadastrarLivro = new JButton("Cadastrar livro");
        btnCadastrarLivro.setBounds(10, 59, 180, 23);
        contentPane.add(btnCadastrarLivro);

        btnEmprestimoBV = new JButton("Emprestimo com a biblioteca");
        btnEmprestimoBV.setBounds(10, 25, 180, 23);
        contentPane.add(btnEmprestimoBV);

        btnEmprestimoComUm = new JButton("Emprestimo com um usuario");
        btnEmprestimoComUm.setBounds(217, 25, 187, 23);
        contentPane.add(btnEmprestimoComUm);

        btnAdicionarAmigo = new JButton("Adicionar amigo");
        btnAdicionarAmigo.setBounds(10, 189, 180, 23);
        contentPane.add(btnAdicionarAmigo);

        btnInformacoesDeOutros = new JButton("Informacoes de outros usuarios");
        btnInformacoesDeOutros.setBounds(217, 189, 187, 23);
        contentPane.add(btnInformacoesDeOutros);


        btnAlterarDados = new JButton("Alterar dados");
        btnAlterarDados.setBounds(217, 134, 187, 23);
        btnAlterarDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TelaAlteraDados(usuario).setVisible(true);
            }
        });
        contentPane.add(btnAlterarDados);

        btnVerMinhasInformacoes = new JButton("Ver minhas informacoes");
        btnVerMinhasInformacoes.setBounds(10, 134, 180, 23);
        contentPane.add(btnVerMinhasInformacoes);

        btnEnviarMensagem = new JButton("Enviar mensagem");
        btnEnviarMensagem.setBounds(217, 258, 187, 23);
        contentPane.add(btnEnviarMensagem);

        btnCaixaDeEntrada = new JButton("Caixa de entrada");
        btnCaixaDeEntrada.setBounds(10, 258, 180, 23);
        contentPane.add(btnCaixaDeEntrada);

        btnAdicionarSaldo = new JButton("Adicionar Saldo");
        btnAdicionarSaldo.setBounds(10, 310, 180, 23);
        contentPane.add(btnAdicionarSaldo);

        btnSair = new JButton("Sair");
        btnSair.setBounds(163, 359, 89, 23);
        contentPane.add(btnSair);

        btnAdicionarSaldo = new JButton("Adicionar Saldo");
        btnAdicionarSaldo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaAddSaldo(usuario).setVisible(true);
            }
        });
        btnAdicionarSaldo.setBounds(10, 310, 180, 23);
        contentPane.add(btnAdicionarSaldo);
    }
}
