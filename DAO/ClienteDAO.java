package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.ClienteDTO;
import DTO.PersonDTO;

public class ClienteDAO extends PersonDAO{

    Connection conn; 
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ClienteDTO> lista = new ArrayList<>();

    //pesquisar cliente
    public ArrayList<ClienteDTO> pesquisarCliente() {
        String sql = "select * from cliente";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                ClienteDTO objclienteDTO = new ClienteDTO(); //provavelmente vai dar erro
                objclienteDTO.setId(rs.getInt("id"));
                objclienteDTO.setName(rs.getString("nome"));
                objclienteDTO.setCpf(rs.getString("cpf"));
                objclienteDTO.setPhoneNumber(rs.getString("telefone"));
                objclienteDTO.setSenha(rs.getString("senha"));
                
                lista.add(objclienteDTO);
            }
            
        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "ClienteDAO Pesquisar" + erro);
        }
        return lista;
    }

    //cadastrar cliente
    @Override
    public void cadastrarPessoa(PersonDTO objpersondto) {

        String sql = "insert into cliente (nome, cpf, telefone, senha) values (?, ?, ?, ?)";

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

    //alterar cliente
    @Override
    public void alterarPessoa(PersonDTO objpersondto) {
        String sql = "update cliente set nome = ?, cpf = ?, telefone = ?, senha = ? where id = ?";
        
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

    //excluir cliente
    @Override
    public void excluirPessoa(PersonDTO objpersondto) {

        String sql = "delete from cliente where id = ?";

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
