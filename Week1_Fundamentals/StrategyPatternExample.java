package Week1_Fundamentals;

interface PaymentStrategy {
void pay(double amount);
}

// 3. Implement Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
private String cardNumber;

public CreditCardPayment(String cardNumber) {
    this.cardNumber = cardNumber;
}

@Override
public void pay(double amount) {
    System.out.println("Paid $" + amount + " using Credit Card ending in " + cardNumber.substring(cardNumber.length() - 4));
}
}

class PayPalPayment implements PaymentStrategy {
private String email;

public PayPalPayment(String email) {
    this.email = email;
}

@Override
public void pay(double amount) {
    System.out.println("Paid $" + amount + " using PayPal account: " + email);
}
}

// 4. Implement Context Class
class PaymentContext {
private PaymentStrategy paymentStrategy;

public void setPaymentStrategy(PaymentStrategy strategy) {
    this.paymentStrategy = strategy;
}

public void executePayment(double amount) {
    if (paymentStrategy == null) {
        System.out.println("Please choose a payment strategy first!");
    } else {
        paymentStrategy.pay(amount);
    }
}
}

// 5. Test the Strategy Implementation
public class StrategyPatternExample {
public static void main(String[] args) {
System.out.println("--- Testing Strategy Pattern ---");

    PaymentContext context = new PaymentContext();

    // Pay using Credit Card
    context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
    context.executePayment(250.00);

    System.out.println();

    // Switch strategy dynamically to PayPal
    context.setPaymentStrategy(new PayPalPayment("user@example.com"));
    context.executePayment(45.50);
}
}