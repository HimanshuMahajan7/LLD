package iteratordesignpattern.src;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> bookList = Arrays.asList(
                new Book(101, "Science"),
                new Book(102, "Math"),
                new Book(103, "GK"),
                new Book(104, "Computer"),
                new Book(105, "Hindi")
        );

        Library library = new Library(bookList);
        Iterator iterator = library.createIterator();

        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getBookName());
        }
    }
}
