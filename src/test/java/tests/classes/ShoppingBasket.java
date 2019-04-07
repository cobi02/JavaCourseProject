package tests.classes;
import java.util.*;

public class ShoppingBasket {
   public Map<Book, Integer> books = new HashMap<Book, Integer>() ;

    public Map<Book, Integer> getBooks() {
        return books;
    }

    public Map<Book, Integer> addBookInBasket(Book book, int count){
        books.put(book, count);

        return books;
    }

    public Map<Book, Integer> changeQuantity(Book book, int count){
        if( books.containsKey(book)){
            book.setDiscPrice(count * book.getDiscPrice());
            books.put(book, count);

        }

        return books;
    }
    public void printAllBooksInBasket() {

        for(Map.Entry<Book, Integer> item: books.entrySet()){

            System.out.println(item.getKey() + ": Count: " + item.getValue());

        }
    }

    public double getBasketTotalPrice() {
       double totalPrice = 0.0;

       for(Book item:books.keySet()){
           totalPrice += item.getDiscPrice();
        }
       return totalPrice;
        }
}
