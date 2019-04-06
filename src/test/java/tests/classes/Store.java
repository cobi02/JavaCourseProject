package tests.classes;
import java.util.*;

public class Store {
    private String brand;
    List<Book> inStock;

    public Store(String brand) {
        this.brand = brand;
        this.inStock = new ArrayList<Book>();
    }

    public String getBrand() {
        return brand;
    }

    public List<Book> getInStock() {
        return inStock;
    }
    public List<Book> addBook(Book book){
        this.inStock.add(book);
        return this.inStock;
    }
}
