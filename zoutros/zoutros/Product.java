package zoutros;
import java.util.ArrayList;

public class Product {
    private String name;
    private double cost;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<Integer> quantIng;

    public Product(String name, double cost, String type, Ingredient[] ingredients, int[] quantIng) {
        this.name = name;
        this.cost = cost;
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
                             "\nQuantidade: " + quantIng.get(i) + ingredients.get(i).getMeasuringUnit() +
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
}
