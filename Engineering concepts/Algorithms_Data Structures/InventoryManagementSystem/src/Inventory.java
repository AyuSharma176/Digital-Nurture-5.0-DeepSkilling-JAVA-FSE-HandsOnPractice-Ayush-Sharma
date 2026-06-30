import java.util.HashMap;
import java.util.Map;

public class Inventory {
    // HashMap chosen for O(1) average-case add/update/delete/lookup by productId
    private final Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, int newQuantity, double newPrice) {
        Product product = products.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
        } else {
            System.out.println("Product not found: " + productId);
        }
    }

    public void deleteProduct(String productId) {
        if (products.remove(productId) == null) {
            System.out.println("Product not found: " + productId);
        }
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }

    public void displayAll() {
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }
}