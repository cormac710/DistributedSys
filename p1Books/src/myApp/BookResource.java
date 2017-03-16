package myApp;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/books")
public class BookResource {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<Book> getBooks() {
		return BookDao.instance.getBooks();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	@Path("{bookId}")
	public Book getBook(@PathParam("bookId") String id) {
		return BookDao.instance.getBook(Integer.parseInt(id));
	}

	@PUT
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("{bookId}")
	public void putBook(@PathParam("bookId") String id, @FormParam("name") String name,
			@FormParam("author") String author, @FormParam("year") String year,
			@Context HttpServletResponse servletResponse) throws IOException {
		System.out.println("PUT id = " + id);
		Book book = new Book();
		book.setId(Integer.parseInt(id));
		book.setTitle(name);
		book.setAuthor(author);
		book.setYear(Integer.parseInt(year));
		BookDao.instance.create(book);
	}
}