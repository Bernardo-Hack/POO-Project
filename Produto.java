public class Produto {
    private String name;
    private double cost;
    private String type;
    private Ingrediente[] ingredientes;
    private int[] quantIng;

    public Produto(String name, double cost, String type, Ingrediente[] ingredientes, int[] quantIng) {
        this.name = name;
        this.cost = cost;
        this.type = type;
        this.ingredientes = ingredientes;
        this.quantIng = quantIng;
    }
    
    public void printIngredients() {
        System.out.println("- Lista de Ingredientes -");
        for (int i = 0; i > ingredientes.length; i++) {
            System.out.println("Ingrediente: " + ingredientes[i].getName() + 
                             "\nQuantidade: " + quantIng[i] + ingredientes[i].getMed() +
                             "\n- = - = - = - = - = - = -");
        }
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

    public Ingrediente[] getIngredientes() {
        return this.ingredientes;
    }

    public int[] getQuantIng() {
        return this.quantIng;
    }
}
