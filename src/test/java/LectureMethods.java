import org.testng.annotations.Test;
import tests.classes.*;

import java.util.*;


public class LectureMethods {

    //Methods

    public Store createStore(){
        Store store = new Store("Amazon-Mentormate");
        return store;
    }
    public List<Book> getlistOfBooks(){
        List<Book> books = new ArrayList<Book>();
        Book b1 = new Book("Marvel Forever",80.99, 3.99, true );
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

            System.out.println(search.getBookWithLowestPriceById(0, search.sortBookListByPrice(store.getInStock())));
        }catch(IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.printf("%n----------test1 getBookByTitle--------------------%n");

                 search.printBookByTitle("Solo: A Star Wars Story Adaptation #7",store.getInStock());

        System.out.printf("%n----------test1 getThirdCheapestBookWithDiscountedPrice--------------------%n");

        try{

                System.out.println(search.getBookWithLowestDiscPriceByID(2, search.sortBookListByDiscPrice(store.getInStock())));
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

        System.out.printf("%n----------test2 TotalPriceInBasket-----------------%n");

        double totalPrice = basket.getBasketTotalPrice();
        System.out.printf("The total price in the basket is: %.2f", totalPrice);

        System.out.printf("%n------------------------------%n");

    }

    @Test(priority = 3)
    public void addUsersAndBooksInBaskets(){
        Store store = createStore();
        addBooksInStore(store, getlistOfBooks());
        Search search = new Search();

        // create users
        User user1 = new User("John", "Smith");

        User user2 = new User();
        user2.setName("David");
        user2.setLastName("Murphy");
        user2.setBasket(new ShoppingBasket());

        System.out.printf("%n-----------test3 addBooksForUser1-------------------%n");

        // book with lowest original price
        Book foundBook1 = search.getBookWithLowestPriceById(0, search.sortBookListByPrice(store.getInStock()));
        System.out.println("The book with lowest original price is: ");
        System.out.println(foundBook1);

        System.out.printf("%n------------------------------%n");

        user1.getBasket().getBooks().put(foundBook1, 1);
        System.out.printf("%nThe book with lowest original price was added in User1's basket %n");
        user1.getBasket().printAllBooksInBasket();

        System.out.printf("%n------------------------------%n");

        // book with biggest discounted price
        Book foundBook2 = search.getBookWithLowestDiscPriceByID(store.getInStock().size()-1, search.sortBookListByDiscPrice(store.getInStock()));
        System.out.println("The book with biggest discounted price is: ");
        System.out.println(foundBook2);

        System.out.printf("%n------------------------------%n");

        user1.getBasket().getBooks().put(foundBook2, 1);
        System.out.printf("%nThe book with biggest discounted price was added in User1's basket%n");
        user1.getBasket().printAllBooksInBasket();

        System.out.printf("%n------------------------------%n");

        System.out.println("User1 has in the basket: ");
        user1.getBasket().printAllBooksInBasket();

        System.out.printf("%n-----------test3 addBooksForUser2-------------------%n");

        //book with lowest title words count
        Book foundBook3 = search.getBookWithLessTitleWords(search.sortBookListByTitleWordsCount(store.getInStock()));

        System.out.printf("%nBook list sorted by title words count:%n");
        System.out.println(search.sortBookListByTitleWordsCount(store.getInStock()));

        System.out.printf("%n------------------------------%n");

        System.out.println("The book with lowest title words count is: ");
        System.out.println(foundBook3);

        System.out.printf("%n------------------------------%n");

        user2.getBasket().getBooks().put(foundBook3, 1);
        System.out.printf("The book with lowest title words was added in User2 basket%n");
        user2.getBasket().printAllBooksInBasket();

        System.out.printf("%n------------------------------%n");

        user2.getBasket().changeQuantity(foundBook3, 5);
        System.out.printf("The quantity for the lowest title words book was changed to 5 in the User2 basket%n");
        user2.getBasket().printAllBooksInBasket();

        System.out.printf("%n------------------------------%n");

        System.out.println("User2 has in the basket: ");
        user2.getBasket().printAllBooksInBasket();

        System.out.printf("%n------------------------------%n");

        System.out.printf("%n--------------Print users----------------%n");

        System.out.println(user1);
        System.out.println(user2);


    }
    }
