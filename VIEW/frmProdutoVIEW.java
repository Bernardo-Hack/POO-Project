package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.ProdutoDAO;
import DTO.ProdutoDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;

public class frmProdutoVIEW extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCusto;
	private JTextField txtQuantidade;
    private final JTable tabelaProduto = new JTable();
    private JTextField txtIngredientes;
    private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmProdutoVIEW frame = new frmProdutoVIEW();
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
	public frmProdutoVIEW() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
        listarValoresProdutos();
		
        // CADASTRO DE PRODUTOS FORM

		JLabel lblNewLabel_4 = new JLabel("Produtos");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(257, 11, 192, 28);
		contentPane.add(lblNewLabel_4);

		//btn cadastrar
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                cadastrarProduto();
                listarValoresProdutos();
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
                listarValoresProdutos();
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
                alterarProduto();
                listarValoresProdutos();
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
					excluirProduto();
					listarValoresProdutos();
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
		txtCusto = new JTextField();
		txtCusto.setBounds(158, 141, 215, 20);
		contentPane.add(txtCusto);
		txtCusto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Custo");
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
		
        //input ingredientes 
		txtIngredientes = new JTextField();
		txtIngredientes.setBounds(158, 191, 215, 20);
		contentPane.add(txtIngredientes);
		txtIngredientes.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ingredientes");
		lblNewLabel_2.setBounds(55, 193, 93, 14);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));

        //tabela
        tabelaProduto.setModel(new DefaultTableModel(
			new Object[][] {
				{},
			},
			new String[] {
				"id", "nome", "valor", "quantidade", "ingredientes"
			}
		));
		tabelaProduto.getColumnModel().getColumn(4).setPreferredWidth(150);
		tabelaProduto.setSurrendersFocusOnKeystroke(true);
		tabelaProduto.setCellSelectionEnabled(true);
		tabelaProduto.setColumnSelectionAllowed(true);
		tabelaProduto.setBounds(57, 431, 607, 188);
			getContentPane().add(tabelaProduto);
			
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
			
			JLabel lblNewLabel_9 = new JLabel("Ingredientes");
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

    private void listarValoresProdutos() {
        try {
            ProdutoDAO objprodutodao = new ProdutoDAO();

            DefaultTableModel model = (DefaultTableModel) tabelaProduto.getModel();
            model.setNumRows(0);

            ArrayList<ProdutoDTO> lista = objprodutodao.pesquisarFuncionario();

            for (int num = 0; num < lista.size(); num ++) {
                model.addRow(new Object[] {
                    lista.get(num).getId_produto(),
                    lista.get(num).getNome_produto(),
                    lista.get(num).getCusto_produto(),
                    lista.get(num).getQuantidade_produto(),
                    lista.get(num).getIngredientes_produto()
                });
            }

            
        } catch (Exception erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Listar Valores VIEW: " + erro);

        }
    }

    private void carregarCampos() {
        int setar = tabelaProduto.getSelectedRow();
        
        txtCodigo.setText(tabelaProduto.getModel().getValueAt(setar, 0).toString());
        txtNome.setText(tabelaProduto.getModel().getValueAt(setar, 1).toString());
        txtCusto.setText(tabelaProduto.getModel().getValueAt(setar, 2).toString());
        txtQuantidade.setText(tabelaProduto.getModel().getValueAt(setar, 3).toString());
        txtIngredientes.setText(tabelaProduto.getModel().getValueAt(setar, 4).toString());
    }   

    private void cadastrarProduto(){
        String nome_produto, ingredientes_produto;
        float custo_produto;
        int quantidade_produto;

        nome_produto = txtNome.getText();
        ingredientes_produto = txtIngredientes.getText();
        custo_produto = Float.parseFloat(txtCusto.getText());
        quantidade_produto = Integer.parseInt(txtQuantidade.getText());

        ProdutoDTO objprodutodto = new ProdutoDTO();
        objprodutodto.setNome_produto(nome_produto);
        objprodutodto.setIngredientes_produto(ingredientes_produto);
        objprodutodto.setCusto_produto(custo_produto);
        objprodutodto.setQuantidade_produto(quantidade_produto);

        ProdutoDAO objprodutodao = new ProdutoDAO();
        objprodutodao.cadastrarProduto(objprodutodto);
    }

    private void limparCampos() { 
        txtCodigo.setText("");
        txtNome.setText("");
        txtCusto.setText("");
        txtQuantidade.setText("");
        txtIngredientes.setText("");
        txtNome.requestFocus();
    }

    private void alterarProduto() {

        String nome_produto, ingredientes_produto;
        float custo_produto;
        int quantidade_produto, id_produto;

        id_produto = Integer.parseInt(txtCodigo.getText());
        nome_produto = txtNome.getText();
        ingredientes_produto = txtIngredientes.getText();
        custo_produto = Float.parseFloat(txtCusto.getText());
        quantidade_produto = Integer.parseInt(txtQuantidade.getText());

		ProdutoDTO objprodutodto = new ProdutoDTO();
		objprodutodto.setId_produto(id_produto);
		objprodutodto.setNome_produto(nome_produto);
		objprodutodto.setCusto_produto(custo_produto);
		objprodutodto.setQuantidade_produto(quantidade_produto);
		objprodutodto.setIngredientes_produto(ingredientes_produto);
        
        ProdutoDAO objprodutodao = new ProdutoDAO();
        objprodutodao.alterarProduto(objprodutodto);

    }

	private void excluirProduto() {
		int id_produto;

		id_produto = Integer.parseInt(txtCodigo.getText());

		ProdutoDTO objprodutodto = new ProdutoDTO();
		objprodutodto.setId_produto(id_produto);

		ProdutoDAO objprodutodao = new ProdutoDAO();
		objprodutodao.excluirProduto(objprodutodto);
	}
}

