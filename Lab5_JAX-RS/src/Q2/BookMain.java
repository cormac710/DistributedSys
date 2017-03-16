package Q2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class BookMain {

  private static final String BOOKSTORE_XML = "bookstore.xml";

  public static void main(String[] args) throws JAXBException, IOException {

    ArrayList<Book> bookList = new ArrayList<Book>();

    // create books
    Book book1 = new Book();
    book1.setId(1) ;
    book1.setName("RESTful Java with JAX-RS");
    book1.setAuthor("Bill Burke");
    book1.setYear(2009) ;
   
    bookList.add(book1);

    Book book2 = new Book();  
    book2.setId(2) ;
    book2.setName("Java Message Service");
    book2.setAuthor(" David A Chappell, Richard Monson-Haefel");
    book2.setYear(2000) ;
    
    bookList.add(book2);
    
 // create bookstore, assigning book
    Bookstore bookstore = new Bookstore();
    bookstore.setName("AIT Bookstore");
    bookstore.setLocation("AIT");
    bookstore.setBookList(bookList);

    // create JAXB context and instantiate marshaller
    JAXBContext context = JAXBContext.newInstance(Bookstore.class);
    Marshaller m = context.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    // Write to System.out
    m.marshal(bookstore, System.out);

    // Write to File
    m.marshal(bookstore, new File(BOOKSTORE_XML));

    // get variables from our xml file, created before
    System.out.println();
    System.out.println("Output from our XML File: ");
    Unmarshaller um = context.createUnmarshaller();
    Bookstore bookstore2 = (Bookstore) um.unmarshal(new FileReader(BOOKSTORE_XML));
    List<Book> list = bookstore2.getBookList();
    for (Book book : list) {
      System.out.println("Book: " + book.getName() + " from "
          + book.getAuthor());
    }
  }
} 