package telas;

import trabalho1.Emprestimo;
import trabalho1.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DadosDoEmprestimo extends JFrame {

    private JPanel contentPane;
    private JTextArea dados;
    private JLabel infoSaldo;
    private JScrollPane scrollbar;

    public DadosDoEmprestimo(Usuario usuarioAtual, Emprestimo emprestimoAtual) {

        // Definições de tamanho e criação do frame e painel.

        setTitle("Empréstimo realizado com sucesso!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 200, 330);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new WrapLayout(WrapLayout.LEFT, 0, 10));
        setContentPane(contentPane);

        // Labels de pergunta e seus JTextFields correspondentes (respostas).

        infoSaldo = new JLabel("Seu saldo agora é " + usuarioAtual.getSaldo());

        dados = new JTextArea(50, 50);

        dados.setLineWrap(true);

        dados.setWrapStyleWord(true);

        scrollbar = new JScrollPane(dados, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        dados.setText(emprestimoAtual.toString());

        contentPane.add(infoSaldo);
        contentPane.add(scrollbar);
    }
}
