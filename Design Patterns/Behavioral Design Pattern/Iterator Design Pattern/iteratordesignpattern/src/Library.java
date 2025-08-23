package iteratordesignpattern.src;

import java.util.List;

public class Library implements Aggregate {

    List<Book> booksList;

    public Library(List<Book> booksList) {
        this.booksList = booksList;
    }

    @Override
    public Iterator createIterator() {
        return new BookIterator<>(booksList);
    }
}
