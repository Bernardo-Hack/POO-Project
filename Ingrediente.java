public class Ingrediente {
    private String name;
    private double value;
    private int quant;
    private String medida;

    public Ingrediente(String name, double value, int quant, String medida) {
        this.name = name;
        this.value = value;
        this.quant = quant;
        this.medida = medida;
    }

    public void printIngredient() {
        System.out.println("Nome: " + this.getName() +
                         "\nValor: R$ " + this.getValue() +
                         "\nQuantidade: " + this.getQuant() + this.medida);
    }

    public String getName() {
        return this.name;
    }
    
    public double getValue() {
        return this.value;
    }
    
    public int getQuant() {
        return this.quant;
    }

    public String getMed() {
        return this.medida;
    }
}
