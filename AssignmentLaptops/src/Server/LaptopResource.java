package Server;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/books")
public class LaptopResource {
	// This method is called if XMLis request
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<Laptop> getBooks() {
		return LaptopDao.instance.getAllLaptop();
	}

	// @GET
	// @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON,
	// MediaType.TEXT_XML })
	// @Path("{laptopId}")
	// public Laptop getBook(@PathParam("bookId") String id) {
	// return LaptopDao.instance.getLaptop(Integer.parseInt(id));
	// }

	// @POST
	// @Produces(MediaType.TEXT_HTML)
	// @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// public void postBook(@FormParam("id") String id,
	// @FormParam("title") String title,
	// @FormParam("author") String author,
	// @FormParam("year") String year,
	// @Context HttpServletResponse servletResponse) throws IOException {
	// System.out.println("Inside POST id = " + id);
	// System.out.println("title = " + title);
	//
	// Book book = new Book();
	// book.setId(Integer.parseInt(id));
	// book.setTitle(title);
	// book.setAuthor(author);
	// book.setYear(Integer.parseInt(year));
	// BookDao.instance.create(book);
	//
	// servletResponse.sendRedirect("../createBook.html");
	// }
	//
	// @DELETE
	// @Produces(MediaType.TEXT_HTML)
	// @Path("{bookId}")
	// public void deleteBook(@PathParam("bookId") String id) throws IOException
	// {
	// System.out.println("Delete id = " + id);
	//
	// BookDao.instance.delete(Integer.parseInt(id));
	// }

}