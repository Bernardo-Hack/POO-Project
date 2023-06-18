package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.ClienteDTO;
import DTO.PersonDTO;
import DTO.ProdutoDTO;

public class ClienteDAO {

    Connection conn; 
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ClienteDTO> lista = new ArrayList<>();

    //cadastrar cliente
    public void cadastrarCliente(ClienteDTO objcleintedto) {
        String sql = "insert into cliente (nome, cpf, telefone) values (?, ?, ?,)";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objcleintedto.getName());
            pstm.setString(2, objcleintedto.getCpf());
            pstm.setString(3, objcleintedto.getPhoneNumber());

            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "ClienteDAO Cadastrar" + erro);
        }
    }

    //pesquisar cliente
    public ArrayList<ClienteDTO> pesquisarCliente() {
        String sql = "select * from cliente";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                ClienteDTO objclienteDTO = new ClienteDTO("", "", ""); //provavelmente vai dar erro
                objclienteDTO.setId(rs.getInt("id"));
                objclienteDTO.setName(rs.getString("nome"));
                objclienteDTO.setCpf(rs.getString("cpf"));
                objclienteDTO.setPhoneNumber(rs.getString("telefone"));;
                
                lista.add(objclienteDTO);
            }
            
        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "ClienteDAO Pesquisar" + erro);
        }
        return lista;
    }

    public void alterarCliente(ClienteDTO objclientedto) {
        String sql = "update cliente set nome = ?, cpf = ?, telefone = ? where id = ?";
        
        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objclientedto.getName());
            pstm.setString(2, objclientedto.getCpf());
            pstm.setString(3, objclientedto.getPhoneNumber());
            pstm.setInt(5, objclientedto.getId());

            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "ClienteDAO Alterar" + erro);
        }
    }

    public void excluirCliente (ClienteDTO objclientedto) {
        String sql = "delete from cliente where id = ?";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objclientedto.getId());

            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "ClienteDAO Excluir" + erro);
        }

    }
    
}
