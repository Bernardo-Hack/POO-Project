package VIEW;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import DAO.PadeiroDAO;
import DTO.PadeiroDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent; 

public class frmLoginPadeiroVIEW extends JFrame{
    
    private JPanel contentPane;
	private JTextField txtNomeUsuario;
	private JTextField txtSenhaUsuario;

    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLoginPadeiroVIEW frame = new frmLoginPadeiroVIEW();
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
	public frmLoginPadeiroVIEW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		//btn voltar
		JButton btnVoltar = new JButton("<-");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmInicioVIEW objfrminicioview = new frmInicioVIEW();
					objfrminicioview.setVisible(true);

					dispose();
			}
		});
		btnVoltar.setBounds(368, 11, 56, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("Nome de usuario (padeiro)");
		lblNewLabel.setBounds(10, 11, 180, 14);
		contentPane.add(lblNewLabel);
		
		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setBounds(10, 36, 227, 20);
		contentPane.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha de usuario");
		lblNewLabel_1.setBounds(10, 86, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		txtSenhaUsuario = new JPasswordField();
		txtSenhaUsuario.setBounds(10, 111, 227, 20);
		contentPane.add(txtSenhaUsuario);
		
		JButton btnEntrarSistema = new JButton("Login");
		btnEntrarSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logar();	                                
			}
		});
		btnEntrarSistema.setBounds(10, 179, 89, 23);
		contentPane.add(btnEntrarSistema);
	}

    private void Logar() {
		try {

			String nome_usuario, senha_ususario;

			nome_usuario = txtNomeUsuario.getText();
			senha_ususario = txtSenhaUsuario.getText();

			PadeiroDTO objpadeirodto = new PadeiroDTO();
			objpadeirodto.setName(nome_usuario);
			objpadeirodto.setSenha(senha_ususario);

			PadeiroDAO objpadeirodao = new PadeiroDAO();
			ResultSet rsusuariodao = objpadeirodao.autenticacaoPadeiro(objpadeirodto);

			if (rsusuariodao.next()) {
				//chamar tela que quero abrir
				frmPrincipalPadeiroVIEW  objfrmprincipalpadeiroview = new frmPrincipalPadeiroVIEW ();
				objfrmprincipalpadeiroview.setVisible(true);

				dispose();

			}else{
				//enviare mensagem dizendo incorreto
				JOptionPane.showMessageDialog(null, "Usuário ou senha inválida");

			}

		} catch (SQLException erro) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "FRMLOGINVIEW" + erro);
		}		
	}
}
