package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.ClienteDAO;
import DTO.ClienteDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;

public class frmClienteAtendenteVIEW extends JFrame{

    private JPanel contentPane;
	private JTextField txtNome;
    private JTextField txtSenha;
	private JTextField txtCpf;
	private JTextField txtTelefone;
    private final JTable tabelaCliente = new JTable();
    private JTextField txtCodigo; 

    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmClienteAtendenteVIEW frame = new frmClienteAtendenteVIEW();
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

    public frmClienteAtendenteVIEW() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
		contentPane.setLayout(null);
		
        // CADASTRO DE PRODUTOS FORM

		JLabel lblNewLabel_4 = new JLabel("Clientes");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(257, 11, 192, 28);
		contentPane.add(lblNewLabel_4);
 
        //btn voltar
		JButton btnVoltar = new JButton("<-");
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmPrincipalManagerVIEW objfrmprincipalview = new frmPrincipalManagerVIEW();
					objfrmprincipalview.setVisible(true);

					dispose();
				}
			});
			btnVoltar.setBounds(10, 11, 46, 23);
			contentPane.add(btnVoltar);

        
        //btn cadastrar
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
                listarValoresClientes();
                limparCampos();
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar.setBounds(55, 265, 155, 23);
		contentPane.add(btnCadastrar);

        //btn listar
		JButton btnPesquisar = new JButton("Listar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                listarValoresClientes();
			}
		});
		btnPesquisar.setBounds(57, 371, 106, 23);
		contentPane.add(btnPesquisar);

        //btn carregar campos
        JButton btnCarregarCampos = new JButton("Carregar Campos");
        btnCarregarCampos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                carregarCampos();
            }
        });
        btnCarregarCampos.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnCarregarCampos.setBounds(517, 630, 147, 23);
        contentPane.add(btnCarregarCampos);

        //btn limpar campos
        JButton btnNewButton = new JButton("Limpar campos");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton.setBounds(220, 266, 153, 23);
        contentPane.add(btnNewButton);
     
        //input nome
		txtNome = new JTextField();
		txtNome.setBounds(158, 116, 215, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(56, 118, 46, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
        //input valor
		txtCpf = new JTextField();
		txtCpf.setBounds(158, 141, 215, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(56, 143, 46, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
        //input quantidade
		txtTelefone = new JTextField();
		txtTelefone.setBounds(158, 166, 215, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone");
		lblNewLabel_3.setBounds(56, 168, 93, 14);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));

        txtSenha = new JTextField();
        txtSenha.setColumns(10);
        txtSenha.setBounds(158, 217, 215, 20);
        contentPane.add(txtSenha);
        
        JLabel lblNewLabel_2_1 = new JLabel("Senha");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_2_1.setBounds(55, 218, 93, 14);
        contentPane.add(lblNewLabel_2_1);
		
        //tabela
        tabelaCliente.setModel(new DefaultTableModel(
			new Object[][] {
				{},
			},
			new String[] {
				"id", "nome", "cpf", "telefone", "senha"
			}
		));
		tabelaCliente.getColumnModel().getColumn(4).setPreferredWidth(150);
		tabelaCliente.setSurrendersFocusOnKeystroke(true);
		tabelaCliente.setCellSelectionEnabled(true);
		tabelaCliente.setColumnSelectionAllowed(true);
		tabelaCliente.setBounds(57, 431, 607, 188);
			getContentPane().add(tabelaCliente);
			
            //titulos acima da tabela
			JLabel lblNewLabel_5 = new JLabel("Codigo");
			lblNewLabel_5.setBounds(57, 406, 61, 14);
			contentPane.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("Nome");
			lblNewLabel_6.setBounds(162, 406, 61, 14);
			contentPane.add(lblNewLabel_6);
			
			JLabel lblNewLabel_7 = new JLabel("Cpf");
			lblNewLabel_7.setBounds(268, 406, 51, 14);
			contentPane.add(lblNewLabel_7);
			
			JLabel lblNewLabel_8 = new JLabel("Telefone");
			lblNewLabel_8.setBounds(375, 406, 77, 14);
			contentPane.add(lblNewLabel_8);
			
			JLabel lblNewLabel_9 = new JLabel("Senha");
			lblNewLabel_9.setBounds(484, 406, 95, 14);
			contentPane.add(lblNewLabel_9);

        }    

        private void listarValoresClientes() {
            try {
            ClienteDAO objclientedao = new ClienteDAO();

            DefaultTableModel model = (DefaultTableModel) tabelaCliente.getModel();
            model.setNumRows(0);

            ArrayList<ClienteDTO> lista = objclientedao.pesquisarCliente();

            for (int num = 0; num < lista.size(); num ++) {
                model.addRow(new Object[] {
                    lista.get(num).getId(),
                    lista.get(num).getName(),
                    lista.get(num).getCpf(),
                    lista.get(num).getPhoneNumber(),
                    lista.get(num).getSenha()
                });
            }

            
        } catch (Exception erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Listar Valores VIEW: " + erro);

        }
    }

        private void carregarCampos() {
            int setar = tabelaCliente.getSelectedRow();
        
        txtCodigo.setText(tabelaCliente.getModel().getValueAt(setar, 0).toString());
        txtNome.setText(tabelaCliente.getModel().getValueAt(setar, 1).toString());
        txtCpf.setText(tabelaCliente.getModel().getValueAt(setar, 2).toString());
        txtTelefone.setText(tabelaCliente.getModel().getValueAt(setar, 3).toString());
        txtSenha.setText(tabelaCliente.getModel().getValueAt(setar, 4).toString());
        }

        private void cadastrarCliente() {
            String nome, cpf, telefone, senha;

            nome = txtNome.getText();
            cpf = txtCpf.getText();
            telefone = txtTelefone.getText();
            senha = txtSenha.getText();

            ClienteDTO objclientedto = new ClienteDTO();
            objclientedto.setName(nome);
            objclientedto.setCpf(cpf);
            objclientedto.setPhoneNumber(telefone);
            objclientedto.setSenha(senha);

            ClienteDAO objclientedao = new ClienteDAO();
            objclientedao.cadastrarPessoa(objclientedto);
        }

        private void limparCampos() {
            txtCodigo.setText("");
            txtNome.setText("");
            txtCpf.setText("");
            txtTelefone.setText("");
            txtSenha.setText("");
            txtNome.requestFocus();
        }
    }