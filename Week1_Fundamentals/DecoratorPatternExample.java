package Week1_Fundamentals;

// 2. Define Component Interface
interface Notifier {
    void send(String message);
}

// 3. Implement Concrete Component
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

// 4. Implement Decorator Classes
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack Message: " + message);
    }
}

// 5. Test the Decorator Implementation
public class DecoratorPatternExample {
    public static void main(String[] args) {
        System.out.println("--- Testing Decorator Pattern ---");
        
        // Base case: Only email
        Notifier emailNotifier = new EmailNotifier();
        
        // Wrap email with SMS functionality
        Notifier smsAndEmail = new SMSNotifierDecorator(emailNotifier);
        
        // Wrap SMS + Email with Slack functionality dynamically
        Notifier allChannels = new SlackNotifierDecorator(smsAndEmail);

        System.out.println("Sending system alert via all configured channels:");
        allChannels.send("Critical System Update Available!");
    }
}