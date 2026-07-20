public class PaypalGateway {
    public void sendPayment(String currency, double amount) {
        System.out.println("Processing payment of " + amount + " " + currency + " via PayPal.");
    }
}