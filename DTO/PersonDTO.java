package DTO;

public abstract class PersonDTO {
    protected String name;
    protected String cpf;
    protected String phoneNumber;


    public PersonDTO(String name, String cpf, String phone) {
        this.name = name;
        this.cpf = cpf;
        this.phoneNumber = phone;

    }

    public String getName() {
        return this.name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
