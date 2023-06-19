package zoutros;
import java.util.ArrayList;

public class Order {
    private ArrayList<Product> products;
    private Cashier cashier;
    private Client client;
    private double price;

    public Order(Cashier v, Client c) {
        this.products = new ArrayList<Product>();
        this.cashier = v;
        this.client = c;
        this.price = 0.0;
    }

    public void addProduto(Product prod) {
        this.products.add(prod);
        this.price += prod.getCost();
    }

    public void removeProduct(Product prod) {
        this.products.remove(prod);
        this.price -= prod.getCost();
    }

    public void printOrder() {
        System.out.println("- Conteúdo do Pedido -\n"
                         + "\nCliente: " + this.client.getName()
                         + "\nVendedor: " + this.cashier.getName()
                         + "\n\n- Lista de Produtos -\n");

        for (Product prod : this.products) {
            System.out.println("Produto nº " + products.indexOf(prod));
            prod.printProduct();
            System.out.println("\n");
        }

        System.out.println("Custo total: R$" + this.price);
    }
}
