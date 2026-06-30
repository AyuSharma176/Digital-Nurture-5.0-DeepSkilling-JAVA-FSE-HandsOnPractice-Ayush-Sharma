public class AdapterPatternDemo {
    public static void main(String[] args) {

        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(150.00);

        PaymentProcessor paypalProcessor = new PaypalAdapter(new PaypalGateway());
        paypalProcessor.processPayment(75.50);

        // Demonstrating uniform usage regardless of gateway
        PaymentProcessor[] gateways = { stripeProcessor, paypalProcessor };
        for (PaymentProcessor gateway : gateways) {
            gateway.processPayment(20.00);
        }
    }
}