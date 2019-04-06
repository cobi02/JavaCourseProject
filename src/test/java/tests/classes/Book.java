package tests.classes;
import java.util.*;

public class Book {
    private String title;
    private double price;
    private double discPrice;
    private boolean isPrime;

    public Book(String title, double price, double discPrice, boolean isPrime) {
        this.title = title;
        this.price = price;
        this.discPrice = discPrice;
        this.isPrime = isPrime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscPrice() {
        return discPrice;
    }

    public void setDiscPrice(double discPrice) {
        this.discPrice = discPrice;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public void setPrime(boolean prime) {
        isPrime = prime;
    }

    @Override
    public String toString() {
       return String.format("Book Name: %s, Price: %.2f, Discounted Price: %.2f, Prime: %b",this.getTitle(), this.getPrice(), this.getDiscPrice(), this.isPrime());
    }
}
