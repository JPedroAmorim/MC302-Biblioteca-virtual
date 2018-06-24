package telas;

import trabalho1.SistemaExcecao;
import trabalho1.UsuarioEstudante;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.security.SignatureException;

public class TelaMesmaUniversidade extends JFrame {

    private JPanel contentPane;
    private JTextArea info;
    private JScrollPane scrollbar;


    public TelaMesmaUniversidade(UsuarioEstudante usuarioAtual) {

        // Definições de tamanho e criação do frame e painel.

        setTitle("Usuários da mesma universidade");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 200, 330);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new WrapLayout(WrapLayout.LEFT, 0, 10));
        setContentPane(contentPane);

        // Labels de pergunta e seus JTextFields correspondentes (respostas).

        info = new JTextArea(50, 50);

        info.setLineWrap(true);

        info.setWrapStyleWord(true);

        scrollbar = new JScrollPane(info, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        try {
            info.setText(usuarioAtual.buscaUsuarioUniversidade());
        } catch (SistemaExcecao excecao) {
            JOptionPane.showMessageDialog(TelaMesmaUniversidade.this, excecao.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            TelaMesmaUniversidade.this.dispose();
        }


        contentPane.add(scrollbar);
    }
}
