package zoutros;
public abstract class Person {
    private String name;
    private String cpf;
    private String phoneNumber;

    public Person(String name, String cpf, String phone) {
        this.name = name;
        this.cpf = cpf;
        this.phoneNumber = phone;
    }

    public void changeNumber(String num) {
        this.phoneNumber = num;
    }

    public String getName() {
        return this.name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getTelefone() {
        return this.phoneNumber;
    }
}
