public abstract class Funcionario {
    private String name;
    private String cpf;
    private String phoneNumber;

    public Funcionario(String name, String cpf, String telefone) {
        this.name = name;
        this.cpf = cpf;
        this.phoneNumber = telefone;
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
