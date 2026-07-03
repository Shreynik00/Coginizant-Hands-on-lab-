package Week1_Fundamentals;

import java.util.ArrayList;
import java.util.List;

// 4. Define Observer Interface
interface Observer {
    void update(String stockName, double price);
}

// 2. Define Subject Interface
interface Stock {
    void registerObserver(Observer o);
    void deregisterObserver(Observer o);
    void notifyObservers();
}

// 3. Implement Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public void setStockData(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        notifyObservers(); // Notify whenever prices change
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deregisterObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }
}

// 5. Implement Concrete Observers
class MobileApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("Mobile App Notification -> " + stockName + " is now $" + price);
    }
}

class WebApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("Web Dashboard Update -> " + stockName + " price shifted to $" + price);
    }
}

// 6. Test the Observer Implementation
public class ObserverPatternExample {
    public static void main(String[] args) {
        System.out.println("--- Testing Observer Pattern ---");

        StockMarket stockMarket = new StockMarket();

        Observer mobileClient = new MobileApp();
        Observer webClient = new WebApp();

        // Register both platforms
        stockMarket.registerObserver(mobileClient);
        stockMarket.registerObserver(webClient);

        System.out.println("Updating Market Price...");
        stockMarket.setStockData("AAPL", 175.50);

        System.out.println("\nDeregistering Web Dashboard...");
        stockMarket.deregisterObserver(webClient);

        System.out.println("\nUpdating Market Price Again...");
        stockMarket.setStockData("AAPL", 178.20);
    }
}