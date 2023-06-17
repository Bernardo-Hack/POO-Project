package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class frmLoginVIEW extends JFrame {

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
					frmLoginVIEW frame = new frmLoginVIEW();
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
	public frmLoginVIEW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome de ususario");
		lblNewLabel.setBounds(10, 11, 122, 14);
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

			UsuarioDTO objusuariodto = new UsuarioDTO();
			objusuariodto.setNome_usuario(nome_usuario);
			objusuariodto.setSenha_ususario(senha_ususario);

			UsuarioDAO objusuariodao = new UsuarioDAO();
			ResultSet rsusuariodao = objusuariodao.autenticacaoUsuario(objusuariodto);

			if (rsusuariodao.next()) {
				//chamar tela que quero abrir
				frmPrincipalVIEW objfrmprincipalview = new frmPrincipalVIEW();
				objfrmprincipalview.setVisible(true);

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
