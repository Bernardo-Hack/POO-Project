package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmInicioVIEW extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmInicioVIEW frame = new frmInicioVIEW();
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
	public frmInicioVIEW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem vindo a padaria da vovó");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 414, 16);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JButton btnLoginPadeiro = new JButton("Logar como padeiro");
		btnLoginPadeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                frmLoginPadeiroVIEW objloginview = new frmLoginPadeiroVIEW();
					objloginview.setVisible(true);

					dispose();
			}
		});
		btnLoginPadeiro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoginPadeiro.setBounds(122, 115, 194, 23);
		contentPane.add(btnLoginPadeiro);
		
		JButton btnLoginManager_1 = new JButton("Logar como gerente");
		btnLoginManager_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                frmLoginManagerVIEW objloginview = new frmLoginManagerVIEW();
					objloginview.setVisible(true);

					dispose();
			}
		});
		btnLoginManager_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoginManager_1.setBounds(122, 81, 194, 23);
		contentPane.add(btnLoginManager_1);
		
		JButton btnLoginAtendente = new JButton("Logar como atendente");
		btnLoginAtendente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                frmLoginAtendenteVIEW objloginview = new frmLoginAtendenteVIEW();
					objloginview.setVisible(true);

					dispose();
			}
		});
		btnLoginAtendente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoginAtendente.setBounds(122, 152, 194, 23);
		contentPane.add(btnLoginAtendente);
		
		JLabel lblNewLabel_1 = new JLabel("Escolha o tipo de login");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(116, 37, 211, 14);
		contentPane.add(lblNewLabel_1);
	}

}

