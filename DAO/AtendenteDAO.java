package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import DTO.AtendenteDTO;
import DTO.PersonDTO;

public class AtendenteDAO extends PersonDAO{

    Connection conn; 
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<AtendenteDTO> lista = new ArrayList<>();

    public ResultSet autenticacaoUsuario(AtendenteDTO objatendentedto) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "select * from atendentes where nome = ? and senha = ?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objatendentedto.getName());
            pstm.setString(2, objatendentedto.getSenha());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            

        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "AtendenteDAO: " + erro);
            return null;
        }
    }


    public ArrayList<AtendenteDTO> pesquisarAtendente() {
        String sql = "select * from atendentes";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                AtendenteDTO objatendenteDTO = new AtendenteDTO(); //provavelmente vai dar erro
                objatendenteDTO.setId(rs.getInt("id"));
                objatendenteDTO.setName(rs.getString("nome"));
                objatendenteDTO.setCpf(rs.getString("cpf"));
                objatendenteDTO.setPhoneNumber(rs.getString("telefone"));
                objatendenteDTO.setSenha(rs.getString("senha"));
                
                lista.add(objatendenteDTO);
            }
            
        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "AtendenteDAO Pesquisar" + erro);
        }
        return lista;
    }

    @Override
    public void cadastrarPessoa(PersonDTO objpersondto) {
        String sql = "insert into atendentes (nome, cpf, telefone, senha) values (?, ?, ?, ?)";

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
            JOptionPane.showMessageDialog(null, "AtendenteDAO Cadastrar" + erro);
        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrarPessoa'");
    }


    @Override
    public void alterarPessoa(PersonDTO objpersondto) {
        String sql = "update atendentes set nome = ?, cpf = ?, telefone = ?, senha = ? where id = ?";
        
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
        String sql = "delete from atendentes where id = ?";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objpersondto.getId());

            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "ClienteDAO Excluir" + erro);
        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluirPessoa'");
    }
    
}
