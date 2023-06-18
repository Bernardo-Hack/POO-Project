package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.ProdutoDTO;

public class ProdutoDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ProdutoDTO> lista = new ArrayList<>();

    public void cadastrarProduto(ProdutoDTO objprodutodto) {
        String sql = "insert into produtos (nome, valor, quantidade, ingredientes) values (?, ?, ?, ?)";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objprodutodto.getNome_produto());
            pstm.setFloat(2, objprodutodto.getCusto_produto());
            pstm.setInt(3, objprodutodto.getQuantidade_produto());
            pstm.setString(4, objprodutodto.getIngredientes_produto());

            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "ProdutoDAO Cadastrar" + erro);
        }
    }

    public ArrayList<ProdutoDTO> pesquisarProduto() {
        String sql = "select * from produtos";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                ProdutoDTO objprodutoDTO = new ProdutoDTO();
                objprodutoDTO.setId_produto(rs.getInt("id"));
                objprodutoDTO.setNome_produto(rs.getString("nome"));
                objprodutoDTO.setCusto_produto(rs.getFloat("valor"));
                objprodutoDTO.setQuantidade_produto(rs.getInt("quantidade"));
                objprodutoDTO.setIngredientes_produto(rs.getString("ingredientes"));

                lista.add(objprodutoDTO);
            }
            
        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "ProdutoDAO Pesquisar" + erro);
        }
        return lista;
    }

    public void alterarProduto(ProdutoDTO objprodutodto) {
        String sql = "update produtos set nome = ?, valor = ?, quantidade = ?, ingredientes = ? where id = ?";
        
        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objprodutodto.getNome_produto());
            pstm.setFloat(2, objprodutodto.getCusto_produto());
            pstm.setInt(3, objprodutodto.getQuantidade_produto());
            pstm.setString(4, objprodutodto.getIngredientes_produto());
            pstm.setInt(5, objprodutodto.getId_produto());

            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "ProdutoDAO Alterar" + erro);
        }
    }

    public void excluirProduto (ProdutoDTO objprodutodto) {
        String sql = "delete from produtos where id = ?";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objprodutodto.getId_produto());

            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "ProdutoDAO Excluir" + erro);
        }

    }
}
