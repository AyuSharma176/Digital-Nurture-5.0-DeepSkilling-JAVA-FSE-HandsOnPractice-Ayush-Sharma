public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");

        System.out.println("First call:");
        image1.display(); // loads + displays

        System.out.println("\nSecond call:");
        image1.display(); // uses cached image, no reload
    }
}