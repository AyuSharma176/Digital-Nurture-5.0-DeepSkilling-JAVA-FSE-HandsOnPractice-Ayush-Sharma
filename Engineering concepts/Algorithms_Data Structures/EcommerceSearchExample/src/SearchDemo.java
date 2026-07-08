public class SearchDemo {
    public static void main(String[] args) {
        Product[] products = {
                new Product(1, "Headphones", "Electronics"),
                new Product(2, "Backpack", "Accessories"),
                new Product(3, "Sneakers", "Footwear"),
                new Product(4, "Charger", "Electronics"),
                new Product(5, "Wallet", "Accessories")
        };

        System.out.println("Linear search for 'Sneakers':");
        Product found = SearchUtil.linearSearch(products, "Sneakers");
        System.out.println(found != null ? found : "Not found");

        // Binary search requires sorted data
        SearchUtil.sortByName(products);
        System.out.println("\nSorted products:");
        for (Product p : products) System.out.println(p);

        System.out.println("\nBinary search for 'Wallet':");
        found = SearchUtil.binarySearch(products, "Wallet");
        System.out.println(found != null ? found : "Not found");
    }
}