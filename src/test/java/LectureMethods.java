import org.testng.annotations.Test;
import tests.classes.Book;
import tests.classes.ShoppingBasket;
import tests.classes.Store;
import tests.classes.Search;
import java.util.*;


public class LectureMethods {

    //Methods

    public Store createStore(){
        Store store = new Store("Amazon-Mentormate");
        return store;
    }
    public List<Book> getlistOfBooks(){
        List<Book> books = new ArrayList<Book>();
        Book b1 = new Book("Marvel",80.99, 3.99, true );
        Book b2 = new Book("Marvel Team-Up #1",6.99, 1.99, true );
        Book b3 = new Book("C#",42.99, 32.99, true );
        Book b4 = new Book("Major X #1",33.99, 23.59, true );
        Book b5 = new Book("Champions #4",55.99, 43.98, true );
        Book b6 = new Book("Solo: A Star Wars Story Adaptation #7",18.97, 12.29, true );
        Book b7 = new Book("Cosmic Ghost Rider Destroys Marvel History #2",12.99, 2.69, true );
        Book b8 = new Book("The Amazing Spider-Man #18.1",72.99, 55.59, true );
        Book b9 = new Book("Swift 3",52.49, 35.98, true );
        Book b10 = new Book("Agile 22",42.29, 26.19, true );


        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        books.add(b6);
        books.add(b7);
        books.add(b8);
        books.add(b9);
        books.add(b10);

        return books;
    }
    public Store addBooksInStore(Store store, List<Book> books){

        for(Book item:books){
            store.addBook(item);
        }
        return store;
    }




    // Tests
    @Test(priority=1)
    public void getSearchedBook() {

        Store store = createStore();
        addBooksInStore(store, getlistOfBooks());
        Search search = new Search();

        System.out.printf("%n----------test1 getLowestBookPrice-----------------%n");
        try {

            System.out.println(search.getBookWithLowestPriceById(0, store.getInStock()));
        }catch(IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.printf("%n----------test1 getBookByTitle--------------------%n");

                 search.printBookByTitle("Solo: A Star Wars Story Adaptation #7",store.getInStock());

        System.out.printf("%n----------test1 getThirdCheapestBookWithDiscountedPrice--------------------%n");

        try{

                System.out.println(search.getBookWithLowestDiscPriceByID(3, store.getInStock()));
        }catch(IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test(priority = 2)
    public void addBooksInBasket(){

        Store store = createStore();
        addBooksInStore(store, getlistOfBooks());
        Search search = new Search();
        ShoppingBasket basket = new ShoppingBasket();

        System.out.printf("%n----------test2 addBookWithShortestTitle-----------------%n");

        Book foundBook1 = search.getBookWithShortestTitle(search.sortBookListByTitleLength(store.getInStock()));
        basket.addBookInBasket(foundBook1, 1);

        System.out.printf("The book with shortest title is added in the basket  %nNow we have in the basket:  %n");

        basket.printAllBooksInBasket();

        System.out.printf("%n----------test2 addBookWithBiggestPrice -----------------%n");

        Book foundBook2 = search.getBookWithLowestDiscPriceByID(store.getInStock().size()-1, search.sortBookListByDiscPrice(store.getInStock()));
        basket.addBookInBasket(foundBook2, 1);

        System.out.printf("The book with biggest discounted price is added in the basket! %nNow we have in the basket:  %n");

        basket.printAllBooksInBasket();

        System.out.printf("%n----------test2 changeQuantity-----------------%n");

        basket.changeQuantity(foundBook2, 3);

        System.out.printf("The quantity for the last added book has been changed to 3! %nNow we have in the basket:  %n");

        basket.printAllBooksInBasket();

        System.out.printf("%n------------------------------%n");

    }
    }
