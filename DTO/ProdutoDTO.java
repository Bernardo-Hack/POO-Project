package DTO;

public class ProdutoDTO {
    
    private String nome_produto, ingredientes_produto;
    private float custo_produto;
    private int quantidade_produto, id_produto;


    public int getId_produto() {
        return id_produto;
    }
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }
    public String getNome_produto() {
        return nome_produto;
    }
    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }
    public String getIngredientes_produto() {
        return ingredientes_produto;
    }
    public void setIngredientes_produto(String ingredientes_produto) {
        this.ingredientes_produto = ingredientes_produto;
    }
    public float getCusto_produto() {
        return custo_produto;
    }
    public void setCusto_produto(float custo_produto) {
        this.custo_produto = custo_produto;
    }
    public int getQuantidade_produto() {
        return quantidade_produto;
    }
    public void setQuantidade_produto(int quantidade_produto) {
        this.quantidade_produto = quantidade_produto;
    }

    
}
