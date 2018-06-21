package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MenuEstudante extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuEstudante frame = new MenuEstudante();
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
	public MenuEstudante() {
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastar livro");
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
		btnAlterarDados.setBounds(217, 134, 187, 23);
		contentPane.add(btnAlterarDados);
		
		JButton btnVerMinhasInformacoes = new JButton("Ver minhas informacoes");
		btnVerMinhasInformacoes.setBounds(10, 134, 180, 23);
		contentPane.add(btnVerMinhasInformacoes);
		
		JButton btnEnviarMensagem = new JButton("Enviar mensagem");
		btnEnviarMensagem.setBounds(217, 287, 187, 23);
		contentPane.add(btnEnviarMensagem);
		
		JButton btnCaixaDeEntrada = new JButton("Caixa de entrada");
		btnCaixaDeEntrada.setBounds(10, 287, 180, 23);
		contentPane.add(btnCaixaDeEntrada);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSair.setBounds(158, 373, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnEmprstimoComCupom = new JButton("Emprestimo com cupom");
		btnEmprstimoComCupom.setBounds(216, 59, 188, 23);
		contentPane.add(btnEmprstimoComCupom);
		
		JButton btnUsuariosDaSua = new JButton("Usuarios da sua universidade");
		btnUsuariosDaSua.setBounds(10, 218, 180, 23);
		contentPane.add(btnUsuariosDaSua);
		
		JButton btnAdicionarSaldo = new JButton("Adicionar saldo");
		btnAdicionarSaldo.setBounds(10, 336, 180, 23);
		contentPane.add(btnAdicionarSaldo);
	}
}
