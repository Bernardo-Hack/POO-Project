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

public class frmPrincipalAtendenteVIEW extends JFrame{
    
    private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipalAtendenteVIEW frame = new frmPrincipalAtendenteVIEW();
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
	public frmPrincipalAtendenteVIEW() {
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

		//btn tela clientes
		JButton btnTelaDeClientes = new JButton("Clientes");
		btnTelaDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmClienteAtendenteVIEW objclienteatendenteview = new frmClienteAtendenteVIEW();
				objclienteatendenteview.setVisible(true);

				dispose();
			}
		});
        btnTelaDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTelaDeClientes.setBounds(121, 106, 193, 23);
		contentPane.add(btnTelaDeClientes);
	}

}
