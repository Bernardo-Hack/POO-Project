package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.PersonDTO;

public abstract class PersonDAO {

    Connection conn;

    public abstract void cadastrarPessoa(PersonDTO objpersondto);

    public abstract void alterarPessoa(PersonDTO objpersondto);

    public abstract void excluirPessoa(PersonDTO objpersondto);

}
