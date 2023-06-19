package DAO;

import java.sql.Connection;

import DTO.PersonDTO;

public abstract class PersonDAO {

    Connection conn;

    public abstract void cadastrarPessoa(PersonDTO objpersondto);

    public abstract void alterarPessoa(PersonDTO objpersondto);

    public abstract void excluirPessoa(PersonDTO objpersondto);

}
