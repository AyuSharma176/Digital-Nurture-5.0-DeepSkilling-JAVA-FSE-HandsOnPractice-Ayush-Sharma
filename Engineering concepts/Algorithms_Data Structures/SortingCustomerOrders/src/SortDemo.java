public class SortDemo {
    public static void main(String[] args) {
        Order[] bubbleOrders = {
                new Order("O1", "Alice", 250.00),
                new Order("O2", "Bob", 75.50),
                new Order("O3", "Carol", 430.25),
                new Order("O4", "Dave", 120.00),
                new Order("O5", "Eve", 60.75)
        };

        Order[] quickOrders = bubbleOrders.clone();

        System.out.println("Before sorting:");
        for (Order o : bubbleOrders) System.out.println(o);

        SortUtil.bubbleSort(bubbleOrders);
        System.out.println("\nAfter Bubble Sort:");
        for (Order o : bubbleOrders) System.out.println(o);

        SortUtil.quickSort(quickOrders, 0, quickOrders.length - 1);
        System.out.println("\nAfter Quick Sort:");
        for (Order o : quickOrders) System.out.println(o);
    }
}