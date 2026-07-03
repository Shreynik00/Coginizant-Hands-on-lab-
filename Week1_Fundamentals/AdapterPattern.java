package Week1_Fundamentals;
interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Payment of Rs." + amount + " made using PayPal.");
    }
}

class StripeGateway {
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount + " made using Stripe.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPal;

    public PayPalAdapter(PayPalGateway payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.pay(amount);
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        PaymentProcessor p1 =
                new PayPalAdapter(new PayPalGateway());

        PaymentProcessor p2 =
                new StripeAdapter(new StripeGateway());

        p1.processPayment(500);
        p2.processPayment(1000);
    }
}