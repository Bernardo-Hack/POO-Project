package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoDAO {

    public Connection conectaBD() {
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3307/bancoteste?user=eu&password=1234";
            conn = DriverManager.getConnection(url);

            
        } catch (SQLException erro) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "ConexaoDAO" + erro.getMessage()); 
        }
        return conn;
    }
    
}