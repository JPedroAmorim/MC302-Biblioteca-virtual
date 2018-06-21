package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAddSaldo extends JFrame {

	private JPanel contentPane;
	private JTextField textCartao;
	private JTextField textValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAddSaldo frame = new TelaAddSaldo();
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
	public TelaAddSaldo() {
		setTitle("Adicionar saldo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 305, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textCartao = new JTextField();
		textCartao.setBounds(10, 39, 232, 20);
		contentPane.add(textCartao);
		textCartao.setColumns(10);
		
		JLabel lblNumeroDoCartao = new JLabel("Numero do cartao de credito");
		lblNumeroDoCartao.setBounds(10, 21, 187, 14);
		contentPane.add(lblNumeroDoCartao);
		
		JLabel lblValorr = new JLabel("Valor (R$)");
		lblValorr.setBounds(10, 70, 187, 14);
		contentPane.add(lblValorr);
		
		textValor = new JTextField();
		textValor.setBounds(10, 93, 86, 20);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cartao = textCartao.getText();
				float valor = Integer.parseInt(textValor.getText());				
				
			
			}
		});
		btnConfirmar.setBounds(10, 145, 89, 23);
		contentPane.add(btnConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(153, 145, 89, 23);
		contentPane.add(btnVoltar);
	}

}
