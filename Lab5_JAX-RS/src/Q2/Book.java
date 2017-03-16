package Q2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "book")
// Optional
@XmlType(propOrder = { "id", "author", "name", "year" })
public class Book {
  private int id ;
  private String name;
  private String author;
  private int year;

  // change the XML element from name to title
  @XmlElement(name = "title")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }
}
