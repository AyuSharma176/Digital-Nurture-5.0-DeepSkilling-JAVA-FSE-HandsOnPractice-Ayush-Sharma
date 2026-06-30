public class PaypalAdapter implements PaymentProcessor {
    private final PaypalGateway paypalGateway;

    public PaypalAdapter(PaypalGateway paypalGateway) {
        this.paypalGateway = paypalGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Translates the standard call into PayPal's specific method
        paypalGateway.sendPayment("USD", amount);
    }
}