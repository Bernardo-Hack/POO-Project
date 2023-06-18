package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.IngredienteDTO;

public class IngredienteDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<IngredienteDTO> lista = new ArrayList<>();

    public void cadastrarIngrediente(IngredienteDTO objingredientedto) {
        String sql = "insert into ingrediente (nome, valor, quantidade, unidade) values (?, ?, ?, ?)";
        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objingredientedto.getName());
            pstm.setDouble(2, objingredientedto.getValue());
            pstm.setInt(3, objingredientedto.getQuant());
            pstm.setString(4, objingredientedto.getMeasuringUnit());

            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "IngredienteDAO Cadastrar" + erro);
        }
    }

    public ArrayList<IngredienteDTO> pesquisarIngrediente () {
        String sql = "select * from ingrediente";
        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                IngredienteDTO objingredientedto = new IngredienteDTO();
                objingredientedto.setId(rs.getInt("id"));
                objingredientedto.setName(rs.getString("nome"));
                objingredientedto.setValue(rs.getDouble("valor"));
                objingredientedto.setQuant(rs.getInt("quantidade"));
                objingredientedto.setMeasuringUnit(rs.getString("unidade"));

                lista.add(objingredientedto);
            }
        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "IngredienteDAO Pesquisar" + erro);
        }
        return lista;
    }

    public void alterarIngrediente(IngredienteDTO objingredientedto) {
        String sql = "update ingrediente set nome = ?, valor = ?, quantidade = ?, unidade = ? where id = ?";
        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objingredientedto.getName());
            pstm.setDouble(2, objingredientedto.getValue());
            pstm.setInt(3, objingredientedto.getQuant());
            pstm.setString(4, objingredientedto.getMeasuringUnit());
            pstm.setInt(5, objingredientedto.getId());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "IngredienteDAO Alterar" + erro);
        }
    }

    public void excluirIngrediente (IngredienteDTO objingredientedto) {
        String sql = "delete from ingrediente where id = ?";
        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objingredientedto.getId());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "IngredienteDAO Excluir" + erro);
        }
    }
    
}
