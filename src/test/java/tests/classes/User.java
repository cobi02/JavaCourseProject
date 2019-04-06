package tests.classes;
import java.util.*;

public class User {
    private String name;
    private String lastName;
    HashMap<Book, Integer> basket;

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.basket = new HashMap<Book, Integer>();
    }

}
