public class Ingredient {
    private String name;
    private double value; // value se refere ao custo de compra do ingrediente(ex.: R$50/L ou R$50/Kg)
    private int quant;
    private String measuringUnit;

    public Ingredient(String name, double value, int quant, String measure) {
        this.name = name;
        this.value = value;
        this.quant = quant;
        this.measuringUnit = measure;
    }

    public void printIngredient() {
        System.out.println("Nome: " + this.getName() +
                         "\nValor: R$ " + this.getValue() +
                         "\nQuantidade: " + this.getQuant() + this.measuringUnit);
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

    public String getMeasuringUnit() {
        return this.measuringUnit;
    }
}
