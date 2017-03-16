package Server;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/laptops")
public class LaptopResource {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<Laptop> getBooks() {
		return LaptopDao.instance.getAllLaptop();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	@Path("{id}")
	public Laptop getBook(@PathParam("id") String id) throws NumberFormatException, SQLException {
		return LaptopDao.instance.getLaptop(Integer.parseInt(id));
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void postBook(@FormParam("id") String id, @FormParam("make") String make, @FormParam("model") String model,
			@FormParam("ram") String ram, @FormParam("price") String price, @FormParam("hardDrive") String hardDrive,
			@FormParam("processor") String processor, @Context HttpServletResponse servletResponse) throws IOException {
		Laptop laptop = new Laptop();
		laptop.setId(Integer.parseInt(id));
		laptop.setMake(make);
		laptop.setModel(model);
		laptop.setPrice(Integer.parseInt(price));
		laptop.setRam(Integer.parseInt(ram));
		laptop.setProcessor(processor);
		LaptopDao.instance.create(laptop);
		servletResponse.sendRedirect("../create.html");
	}

	@DELETE
	@Produces(MediaType.TEXT_HTML)
	@Path("{id}")
	public void deleteBook(@PathParam("id") String id) throws IOException {
		LaptopDao.instance.delete(Integer.parseInt(id));
	}

}