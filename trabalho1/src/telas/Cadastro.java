package telas;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import trabalho1.Gerenciador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtEmail;
    private JTextField txtData;
    private JTextField txtSenha;
    private JTextField txtInst;
    private JTextField txtRA;
    private boolean ehEstudante;
    private String nome, senha, email, instituicao, data;
    private int ra;


    public Cadastro() {
        setTitle("Cadastro");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 454);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nome de usuário");
        lblNewLabel.setBounds(26, 23, 110, 14);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Senha");
        lblNewLabel_1.setBounds(26, 80, 46, 14);
        contentPane.add(lblNewLabel_1);

        txtNome = new JTextField();
        txtNome.setBounds(26, 47, 161, 20);
        contentPane.add(txtNome);
        txtNome.setColumns(10);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(26, 131, 46, 14);
        contentPane.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(26, 146, 161, 20);
        contentPane.add(txtEmail);
        txtEmail.setColumns(10);

        JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
        lblDataDeNascimento.setBounds(26, 177, 161, 14);
        contentPane.add(lblDataDeNascimento);

        txtData = new JTextField();
        txtData.setBounds(26, 193, 86, 20);
        contentPane.add(txtData);
        txtData.setColumns(10);

        JLabel lblEstudante = new JLabel("Estudante?");
        lblEstudante.setBounds(26, 224, 110, 14);
        contentPane.add(lblEstudante);

        JRadioButton rdbtnSim = new JRadioButton("Sim");
        rdbtnSim.setBounds(26, 245, 61, 23);
        contentPane.add(rdbtnSim);

        JRadioButton rdbtnNao = new JRadioButton("Não");
        rdbtnNao.setBounds(91, 245, 109, 23);
        contentPane.add(rdbtnNao);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rdbtnSim);
        grupo.add(rdbtnNao);

        txtSenha = new JTextField();
        txtSenha.setBounds(26, 94, 134, 20);
        contentPane.add(txtSenha);
        txtSenha.setColumns(10);

        JLabel lblIntuicao = new JLabel("Instituição de Ensino");
        lblIntuicao.setBounds(26, 275, 200, 14);
        contentPane.add(lblIntuicao);

        JLabel lblRegistroAcademico = new JLabel("Registro Acadêmico");
        lblRegistroAcademico.setBounds(26, 320, 134, 14);
        contentPane.add(lblRegistroAcademico);

        txtInst = new JTextField();
        txtInst.setBounds(26, 289, 161, 20);
        contentPane.add(txtInst);
        txtInst.setColumns(10);

        txtRA = new JTextField();
        txtRA.setBounds(26, 335, 86, 20);
        contentPane.add(txtRA);
        txtRA.setColumns(10);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                nome = txtNome.getText();
                senha = txtSenha.getText();
                email = txtEmail.getText();
                data = txtData.getText();
                ehEstudante = rdbtnSim.isSelected();

                if (ehEstudante) {
                    try {

                        instituicao = txtInst.getText();

                        ra = Integer.parseInt(txtRA.getText());
                    } catch (NumberFormatException excecao) {
                        JOptionPane.showMessageDialog(Cadastro.this, "Entre com um número de ra válido", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                Gerenciador.geradorUsuario(nome, senha, data, email, instituicao, ra, ehEstudante);
                Cadastro.this.dispose();

            }
        });


        btnCadastrar.setBounds(85, 376, 102, 23);
        contentPane.add(btnCadastrar);
    }
}
