package VIEW;
 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmPrincipalManagerVIEW extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipalManagerVIEW frame = new frmPrincipalManagerVIEW();
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
	public frmPrincipalManagerVIEW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tela principal");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(172, 29, 84, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnDirecionaProduto = new JButton("Produtos");
		btnDirecionaProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDirecionaProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProdutoVIEW objfprodutoview = new frmProdutoVIEW();
					objfprodutoview.setVisible(true);

					dispose();
			}
		});
		btnDirecionaProduto.setBounds(121, 72, 193, 23);
		contentPane.add(btnDirecionaProduto);
		
		JButton btnTelaDeClientes = new JButton("Clientes");
		btnTelaDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmClienteVIEW objfclienteview = new frmClienteVIEW();
					objfclienteview.setVisible(true);

					dispose();
			}
		});
		btnTelaDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTelaDeClientes.setBounds(121, 174, 193, 23);
		contentPane.add(btnTelaDeClientes);
		
		JButton btnTelaDeIngredientes = new JButton("Ingredientes");
		btnTelaDeIngredientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmIngredienteVIEW objfingredienteview = new frmIngredienteVIEW();
					objfingredienteview.setVisible(true);

					dispose();
			}
		});
		btnTelaDeIngredientes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTelaDeIngredientes.setBounds(121, 106, 193, 23);
		contentPane.add(btnTelaDeIngredientes);
		
		JButton btnDirecionaPadeiro = new JButton("Padeiros");
		btnDirecionaPadeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPadeiroVIEW objfpadeiroview = new frmPadeiroVIEW();
					objfpadeiroview.setVisible(true);

					dispose();
			}
		});
		btnDirecionaPadeiro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDirecionaPadeiro.setBounds(121, 208, 193, 23);
		contentPane.add(btnDirecionaPadeiro);
		
		JButton btnTelaDeAtende = new JButton("Atendentes");
		btnTelaDeAtende.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAtendenteVIEW objfatendenteview = new frmAtendenteVIEW();
					objfatendenteview.setVisible(true);

					dispose();
			}
		});
		btnTelaDeAtende.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTelaDeAtende.setBounds(121, 140, 193, 23);
		contentPane.add(btnTelaDeAtende);

		//btn log out
		JButton btnLogout = new JButton("Log out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmInicioVIEW objfrminicioview = new frmInicioVIEW();
					objfrminicioview.setVisible(true);

					dispose();
			}
		});
		btnLogout.setBounds(331, 11, 93, 23);
		contentPane.add(btnLogout);
	}
}

