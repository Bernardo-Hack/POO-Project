package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.IngredienteDAO;
import DTO.IngredienteDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;

public class frmIngredienteVIEW extends JFrame{

    private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtValor;
	private JTextField txtQuantidade;
    private final JTable tabelaIngrediente = new JTable();
    private JTextField txtUnidade;
    private JTextField txtCodigo;
    
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmIngredienteVIEW frame = new frmIngredienteVIEW();
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

     public frmIngredienteVIEW() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
        // CADASTRO DE PRODUTOS FORM

		JLabel lblNewLabel_4 = new JLabel("Ingredientes");
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
                cadastrarIngrediente();
                listarValoresIngredientes();
                limparCampos();
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar.setBounds(55, 222, 155, 23);
		contentPane.add(btnCadastrar);
		
		//btn listar
		JButton btnPesquisar = new JButton("Listar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                listarValoresIngredientes();
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
        btnNewButton.setBounds(220, 257, 155, 23);
        contentPane.add(btnNewButton);

        //btn alterar
        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alterarIngrediente();
                listarValoresIngredientes();
                limparCampos();
            }
        });
        btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnAlterar.setBounds(220, 223, 153, 23);
        contentPane.add(btnAlterar);

		//btn deletar
		JButton btnDeletar = new JButton("Deletar");
        btnDeletar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excluirIngrediente();
                listarValoresIngredientes();
                limparCampos();
            }
        });
        btnDeletar.setBounds(55, 256, 155, 23);
        contentPane.add(btnDeletar);

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
		txtValor = new JTextField();
		txtValor.setBounds(158, 141, 215, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Valor");
		lblNewLabel_1.setBounds(56, 143, 46, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
        //input quantidade
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(158, 166, 215, 20);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade");
		lblNewLabel_3.setBounds(56, 168, 93, 14);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		
        //input unidade 
		txtUnidade = new JTextField();
		txtUnidade.setBounds(158, 191, 215, 20);
		contentPane.add(txtUnidade);
		txtUnidade.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Unidade");
		lblNewLabel_2.setBounds(55, 193, 93, 14);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));

        //tabela
        tabelaIngrediente.setModel(new DefaultTableModel(
			new Object[][] {
				{},
			},
			new String[] {
				"id", "nome", "valor", "quantidade", "ingredientes"
			}
		));
		tabelaIngrediente.getColumnModel().getColumn(4).setPreferredWidth(150);
		tabelaIngrediente.setSurrendersFocusOnKeystroke(true);
		tabelaIngrediente.setCellSelectionEnabled(true);
		tabelaIngrediente.setColumnSelectionAllowed(true);
		tabelaIngrediente.setBounds(57, 431, 607, 188);
			getContentPane().add(tabelaIngrediente);
			
            //titulos acima da tabela
			JLabel lblNewLabel_5 = new JLabel("Codigo");
			lblNewLabel_5.setBounds(57, 406, 61, 14);
			contentPane.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("Nome");
			lblNewLabel_6.setBounds(162, 406, 61, 14);
			contentPane.add(lblNewLabel_6);
			
			JLabel lblNewLabel_7 = new JLabel("Valor");
			lblNewLabel_7.setBounds(268, 406, 51, 14);
			contentPane.add(lblNewLabel_7);
			
			JLabel lblNewLabel_8 = new JLabel("Quantidade");
			lblNewLabel_8.setBounds(375, 406, 77, 14);
			contentPane.add(lblNewLabel_8);
			
			JLabel lblNewLabel_9 = new JLabel("Unidade");
			lblNewLabel_9.setBounds(484, 406, 95, 14);
			contentPane.add(lblNewLabel_9);

            JLabel lblNewLabel_10 = new JLabel("Código");
			lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_10.setBounds(57, 67, 61, 14);
			contentPane.add(lblNewLabel_10);
			
			txtCodigo = new JTextField();
            txtCodigo.setEnabled(false);
			txtCodigo.setBounds(160, 65, 215, 20);
			contentPane.add(txtCodigo);
			txtCodigo.setColumns(10);
    }

    private void listarValoresIngredientes(){
        try {
            IngredienteDAO objingredientedao = new IngredienteDAO();

            DefaultTableModel model = (DefaultTableModel) tabelaIngrediente.getModel();
            model.setNumRows(0);
            
            ArrayList<IngredienteDTO> lista = objingredientedao.pesquisarIngrediente();

            for (int num = 0; num < lista.size(); num ++) {
                model.addRow(new Object[] {
                    lista.get(num).getId(),
                    lista.get(num).getName(),
                    lista.get(num).getValue(),
                    lista.get(num).getQuant(),
                    lista.get(num).getMeasuringUnit()
                });
            }
        } catch (Exception erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Listar Valores VIEW: " + erro);
        }
    }

    private void carregarCampos(){
        int setar = tabelaIngrediente.getSelectedRow();

        txtCodigo.setText(tabelaIngrediente.getModel().getValueAt(setar, 0).toString());
        txtNome.setText(tabelaIngrediente.getModel().getValueAt(setar, 1).toString());
        txtValor.setText(tabelaIngrediente.getModel().getValueAt(setar, 2).toString());
        txtQuantidade.setText(tabelaIngrediente.getModel().getValueAt(setar, 3).toString());
        txtUnidade.setText(tabelaIngrediente.getModel().getValueAt(setar, 4).toString());
    }

    private void cadastrarIngrediente() {
        int quantidade;
        String nome, unidade;
        double value; 

        nome = txtNome.getText();
        value = Double.parseDouble(txtValor.getText());
        quantidade = Integer.parseInt(txtQuantidade.getText());
        unidade = txtUnidade.getText();

        IngredienteDTO objingredientedto = new IngredienteDTO();
        objingredientedto.setName(nome);
        objingredientedto.setValue(value);
        objingredientedto.setQuant(quantidade);
        objingredientedto.setMeasuringUnit(unidade);

        IngredienteDAO objingredientedao = new IngredienteDAO();
        objingredientedao.cadastrarIngrediente(objingredientedto);
    }

    private void limparCampos() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtValor.setText("");
        txtQuantidade.setText("");
        txtUnidade.setText("");
    }

    private void alterarIngrediente() {
        int quantidade, id;
        String nome, unidade;
        double value; 

        id = Integer.parseInt(txtCodigo.getText());
        nome = txtNome.getText();
        value = Double.parseDouble(txtValor.getText());
        quantidade = Integer.parseInt(txtQuantidade.getText());
        unidade = txtUnidade.getText();
        
        IngredienteDTO objingredientedto = new IngredienteDTO();
        objingredientedto.setId(id);
        objingredientedto.setName(nome);
        objingredientedto.setValue(value);
        objingredientedto.setQuant(quantidade);
        objingredientedto.setMeasuringUnit(unidade);

        IngredienteDAO objingredientedao = new IngredienteDAO();
        objingredientedao.alterarIngrediente(objingredientedto);
    }

    private void excluirIngrediente() {
        int id;

        id = Integer.parseInt(txtCodigo.getText());

        IngredienteDTO objingredientedto = new IngredienteDTO();
        objingredientedto.setId(id);

        IngredienteDAO objingredientedao = new IngredienteDAO();
        objingredientedao.excluirIngrediente(objingredientedto);
    }
}
