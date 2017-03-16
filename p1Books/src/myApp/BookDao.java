package myApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum BookDao {
    instance;

    private Map<Integer, Book> booksMap = new HashMap<Integer, Book>();

    private BookDao() {

        Book book1 = new Book();
        book1.setId(1);
        book1.setTitle("RESTful Java with JAX-RS");
        book1.setAuthor("Bill Burke");
        book1.setYear(2009);

        booksMap.put(1, book1);

        Book book2 = new Book();
        book2.setId(2);
        book2.setTitle("Java Message Service");
        book2.setAuthor(" David A Chappell, Richard Monson-Haefel");
        book2.setYear(2000);

        booksMap.put(2, book2);
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<Book>();
        books.addAll(booksMap.values());
        return books;
    }

    public Book getBook(int id) {
        return booksMap.get(id);
    }

	public void create(Book book) {
		booksMap.put(3, book);
	}

}
