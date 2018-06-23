package telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaEmprestimo extends JFrame {

    private JPanel contentPane;
    JButton usuario;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaEmprestimo frame = new TelaEmprestimo();
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
    public TelaEmprestimo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 100);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 10));
        setContentPane(contentPane);

        JLabel pergunta = new JLabel("Você deseja fazer um empréstimo com:");

        JButton usuario = new JButton("Usuário");
        JButton bv = new JButton("Biblioteca Virtual");

        contentPane.add(pergunta);
        contentPane.add(usuario);
        contentPane.add(bv);

        ButtonListener bl = new ButtonListener();


    }


    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == usuario) {

            }


        }
    }

}