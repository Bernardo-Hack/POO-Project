package VIEW;
 
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmPrincipalVIEW extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipalVIEW frame = new frmPrincipalVIEW();
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
	public frmPrincipalVIEW() {
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

		//btn tela produtos
		JButton btnDirecionaProduto = new JButton("Tela de produtos");
		btnDirecionaProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProdutoVIEW objfrmpodutoview = new frmProdutoVIEW();
				objfrmpodutoview.setVisible(true);

				dispose();
			}
		});
		btnDirecionaProduto.setBounds(10, 73, 167, 23);
		contentPane.add(btnDirecionaProduto);

		//btn tela clientes
		JButton btnTelaDeClientes = new JButton("Tela de clientes");
		btnTelaDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmClienteVIEW objclienteview = new frmClienteVIEW();
				objclienteview.setVisible(true);

				dispose();
			}
		});
		btnTelaDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTelaDeClientes.setBounds(10, 107, 167, 23);
		contentPane.add(btnTelaDeClientes);

		//btn tela ingredientes
		JButton btnTelaDeIngredientes = new JButton("Tela de ingredientes");
		btnTelaDeIngredientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmIngredienteVIEW objfringredienteview = new frmIngredienteVIEW();
				objfringredienteview.setVisible(true);

				dispose();
			}
		});
		btnTelaDeIngredientes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTelaDeIngredientes.setBounds(10, 141, 167, 23);
		contentPane.add(btnTelaDeIngredientes);
	}

}
