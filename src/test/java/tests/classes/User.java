package tests.classes;
import java.util.*;

public class User {
    private String name;
    private String lastName;
    private ShoppingBasket basket;

    public User(){

    }

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.basket = new ShoppingBasket();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ShoppingBasket getBasket() {
        return basket;
    }

    public void setBasket(ShoppingBasket basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        String userData = String.format("%nName: %s%nLast Name: %s%nBooks:",getName(), getLastName());
        for(Map.Entry<Book, Integer> item: getBasket().getBooks().entrySet()) {
            userData = userData + String.format("%nBook Name: %s, Price: %.2f, Discounted Price: %.2f, Prime: %b, Count: %d", item.getKey().getTitle(), item.getKey().getPrice(), item.getKey().getDiscPrice(), item.getKey().isPrime(), item.getValue());
        }

        return userData;
    }
}
