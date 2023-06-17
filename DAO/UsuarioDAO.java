package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.UsuarioDTO;

public class UsuarioDAO {
    
    Connection conn;

    public ResultSet autenticacaoUsuario(UsuarioDTO objusuariodto) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "select * from usuario where nome_usuario = ? and senha_usuario = ?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome_usuario());
            pstm.setString(2, objusuariodto.getSenha_ususario());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            

        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
            return null;
        }
    }

}
