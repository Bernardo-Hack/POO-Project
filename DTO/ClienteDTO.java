package DTO;

public class ClienteDTO extends PersonDTO {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClienteDTO(String name, String cpf, String phone) {
        super(name, cpf, phone);
        //TODO Auto-generated constructor stub
    }
    
}
