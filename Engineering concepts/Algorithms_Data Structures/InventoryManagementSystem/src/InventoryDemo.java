public class InventoryDemo {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addProduct(new Product("P001", "Laptop", 50, 899.99));
        inventory.addProduct(new Product("P002", "Mouse", 200, 19.99));
        inventory.addProduct(new Product("P003", "Keyboard", 150, 49.99));

        System.out.println("All products:");
        inventory.displayAll();

        System.out.println("\nUpdating P002...");
        inventory.updateProduct("P002", 180, 17.99);
        System.out.println(inventory.getProduct("P002"));

        System.out.println("\nDeleting P003...");
        inventory.deleteProduct("P003");
        inventory.displayAll();
    }
}