package tests.classes;
import java.util.*;
import java.util.Map;
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
            books.put(book, count);
        }

        return books;
    }
    public void printAllBooksInBasket() {

        for(Map.Entry<Book, Integer> item: books.entrySet()){

            System.out.println(item.getKey() + ": Count: " + item.getValue());

        }
    }

//    public void printAllBooksInBasket() {
//        List<Book> listOfBooks = new ArrayList<Book>();
//        listOfBooks.addAll(books.keySet());
//
//        for(Book item: listOfBooks){
//            System.out.println(item);
//        }
//    }

    public double getBasketTotalPrice() {
       double totalPrice = 0.0;

       for(Book item:books.keySet()){
           totalPrice += item.getDiscPrice();
        }
       return totalPrice;
        }
}
