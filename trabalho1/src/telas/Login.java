package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.*;
import trabalho1.Biblioteca;
import trabalho1.Gerenciador;
import trabalho1.SistemaExcecao;
import java.awt.event.*;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Login();
	}

	/**
	 * Create the frame. sc.nextInt();
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 285, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtUsuario = new JLabel("Usuário");
		txtUsuario.setBounds(24, 28, 46, 14);
		contentPane.add(txtUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(24, 43, 139, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel txtSenha = new JLabel("Senha");
		txtSenha.setBounds(24, 74, 46, 14);
		contentPane.add(txtSenha);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(24, 90, 139, 20);
		contentPane.add(textSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String nome = textUsuario.getText();
				 String senha = textSenha.getText();
				
				try {
					MenuComum menu = new MenuComum(Biblioteca.usuarios.get(Gerenciador.login(nome, senha)));

				} catch (SistemaExcecao excecao) {
					JOptionPane.showMessageDialog(Login.this, excecao.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					Login.this.dispose();
				}
				
				
			}
		});
		btnEntrar.setBounds(84, 155, 89, 23);
		contentPane.add(btnEntrar);
	}
}
