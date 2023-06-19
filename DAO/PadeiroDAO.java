package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.PadeiroDTO;
import DTO.PersonDTO;

public class PadeiroDAO extends PersonDAO{

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<PadeiroDTO> lista = new ArrayList<>();

    public ResultSet autenticacaoPadeiro(PadeiroDTO objpadeirodto) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "select * from padeiros where nome_usuario = ? and senha_usuario = ?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objpadeirodto.getName());
            pstm.setString(2, objpadeirodto.getSenha());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            

        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "PadeiroDAO: " + erro);
            return null;
        }
    }

    public ArrayList<PadeiroDTO> pesquisarPadeiro() {
        String sql = "select * from padeiros";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                PadeiroDTO objpadeiroeDTO = new PadeiroDTO(); //provavelmente vai dar erro
                objpadeiroeDTO.setId(rs.getInt("id"));
                objpadeiroeDTO.setName(rs.getString("nome_usuario"));
                objpadeiroeDTO.setCpf(rs.getString("cpf"));
                objpadeiroeDTO.setPhoneNumber(rs.getString("telefone"));
                objpadeiroeDTO.setSenha(rs.getString("senha_usuario"));
                
                lista.add(objpadeiroeDTO);
            }
            
        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "ClienteDAO Pesquisar" + erro);
        }
        return lista;
    } 

    @Override
    public void cadastrarPessoa(PersonDTO objpersondto) {
        String sql = "insert into padeiros (nome_usuario, cpf, telefone, senha_usuario) values (?, ?, ?, ?)";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objpersondto.getName());
            pstm.setString(2, objpersondto.getCpf());
            pstm.setString(3, objpersondto.getPhoneNumber());
            pstm.setString(4, objpersondto.getSenha());

            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "ClienteDAO Cadastrar" + erro);
        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrarPessoa'");
    }


    @Override
    public void alterarPessoa(PersonDTO objpersondto) {
        String sql = "update padeiros set nome_usuario = ?, cpf = ?, telefone = ?, senha_usuario = ? where id = ?";
        
        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objpersondto.getName());
            pstm.setString(2, objpersondto.getCpf());
            pstm.setString(3, objpersondto.getPhoneNumber());
            pstm.setString(4, objpersondto.getSenha());
            pstm.setInt(5, objpersondto.getId());

            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "ClienteDAO Alterar" + erro);
        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterarPessoa'");
    }


    @Override
    public void excluirPessoa(PersonDTO objpersondto) {
        String sql = "delete from padeiros where id = ?";
        
        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objpersondto.getId());

            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "ClienteDAO Alterar" + erro);
        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluirPessoa'");
    }
    
}
