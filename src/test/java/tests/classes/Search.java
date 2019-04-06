package tests.classes;
import java.util.*;

public class Search {

    public void printBookByTitle(String title, List<Book> books) {
        HashMap<String, Book> sortedMap = new HashMap<String, Book>();
        for (Book item : books) {
            sortedMap.put(item.getTitle(), item);
        }
        if (sortedMap.containsKey(title)) {
            System.out.println(sortedMap.get(title));
        } else {
            System.out.println("Book with title: " + title + " is not found");
        }

    }

    public List<Book> sortBookListByTitleLength(List<Book> books) {
        TreeMap<Integer, Book> sortedMap = new TreeMap<Integer, Book>();
        for (Book item : books) {
            if(!sortedMap.containsKey(item.getTitle().length())){
            sortedMap.put(item.getTitle().length(), item);
        }else{
                sortedMap.put(item.getTitle().length()+1, item);
            }
            }
        List<Book> result = new ArrayList<Book>();

        for(Book item:sortedMap.values()) {
      //      System.out.println(item);
            result.add(item);
        }
        return result;
    }

    public List<Book> sortBookListByPrice(List<Book> books) {
        TreeMap<Double, Book> sortedMap = new TreeMap<Double, Book>();
        for (Book item : books) {
            if (!sortedMap.containsKey(item.getPrice())) {
                sortedMap.put(item.getPrice(), item);
            }
        }
        List<Book> result = new ArrayList<Book>();

        for(Book item:sortedMap.values()) {
        //    System.out.println(item);
            result.add(item);
        }
        return result;
    }

    public List<Book> sortBookListByDiscPrice(List<Book> books) {
        TreeMap<Double, Book> sortedMap = new TreeMap<Double, Book>();
        for (Book item : books) {
            if (!sortedMap.containsKey(item.getDiscPrice())) {
                sortedMap.put(item.getDiscPrice(), item);
            }
        }
        List<Book> result = new ArrayList<Book>();

        for(Book item:sortedMap.values()) {
   //         System.out.println(item);
            result.add(item);
        }
        return result;
    }

    public List<Book> sortBookListByTitleWordsCount(List<Book> books) {
        TreeMap<Integer, Book> sortedMap = new TreeMap<Integer, Book>();
        for (Book item : books) {
            if (!sortedMap.containsKey(item.getTitle().split(" ").length)) {
                sortedMap.put(item.getTitle().split(" ").length, item);
            }
        }
        List<Book> result = new ArrayList<Book>();

        for(Book item:sortedMap.values()) {
 //           System.out.println(item);
            result.add(item);
        }
        return result;
    }

    public Book getBookWithShortestTitle(List<Book> books){
        return books.get(0);
    }

    public Book getBookWithLowestPriceById(int id, List<Book> books){
        if(id < books.size()) {
            return books.get(id);
        }else{
            throw new IndexOutOfBoundsException("The index is out of the range (0-9)");
        }
    }

    public Book getBookWithLowestDiscPriceByID(int id, List<Book> books){
        if(id < books.size()) {
            return books.get(id);
        }else{
            throw new IndexOutOfBoundsException("The index is out of the range (0-9)");
        }
    }

    public Book getBookWithLessTitleWords(List<Book> books){
        return books.get(0);
    }



}

