import java.util.ArrayList;

public class Product {
    private String name;
    private double cost;
    private String type;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<Integer> quantIng;

    public Product(String name, double cost, String type, Ingredient[] ingredients, int[] quantIng) {
        this.name = name;
        this.cost = cost;
        this.type = type;
        this.ingredients = new ArrayList<Ingredient>();
        for (Ingredient ing : ingredients) {
            this.ingredients.add(ing);
        }
        this.quantIng = new ArrayList<Integer>();
        for (int quant : quantIng) {
            this.quantIng.add(quant);
        }
    }
    
    public void printIngredients() {
        System.out.println("- Lista de Ingredientes -");
        for (int i = 0; i > ingredients.size(); i++) {
            System.out.println("Ingrediente: " + ingredients.get(i).getName() + 
                             "\nQuantidade: " + quantIng.get(i) + ingredients.get(i).getMed() +
                             "\n- = - = - = - = - = - = -");
        }
    }

    public void printProduct() {
        System.out.println("Nome: " + this.name +
                         "\nCusto: R$" + this.cost);
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

    public String getType() {
        return this.type;
    }

    public Ingredient getIngrediente(int index) {
        return this.ingredients.get(index);
    }

    public int getQuantIng(int index) {
        return this.quantIng.get(index);
    }
}
