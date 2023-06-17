package DTO;

public class UsuarioDTO {

    private  int id_ususario;
    private String nome_usuario, senha_ususario;

    public int getId_ususario() {
        return id_ususario;
    }

    public void setId_ususario(int id_ususario) {
        this.id_ususario = id_ususario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getSenha_ususario() {
        return senha_ususario;
    }
    
    public void setSenha_ususario(String senha_ususario) {
        this.senha_ususario = senha_ususario;
    }
}
