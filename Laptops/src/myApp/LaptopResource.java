package myApp;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/laptops")
public class LaptopResource {
	// This method is called if XMLis request
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<Laptop> getlaptops() {
		return LaptopDao.instance.getLaptops();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	@Path("{id}")
	public Laptop getlaptop(@PathParam("id") String id) {
		return LaptopDao.instance.getLaptop(Integer.parseInt(id));
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void postlaptop(@FormParam("id") String id, @FormParam("make") String make,
			@FormParam("model") String model, @FormParam("price") String price,
			@Context HttpServletResponse servletResponse) throws IOException {
		System.out.println("Inside POST id = " + id);

		Laptop laptop = new Laptop();
		laptop.setId(Integer.parseInt(id));
		laptop.setMake(make);
		laptop.setModel(model);
		laptop.setPrice(Integer.parseInt(price));
		LaptopDao.instance.create(laptop);

		servletResponse.sendRedirect("../createLaptop.html");
	}

	@DELETE
	@Produces(MediaType.TEXT_HTML)
	@Path("{id}")
	public void deletelaptop(@PathParam("id") String id) throws IOException {
		System.out.println("Delete id = " + id);

		LaptopDao.instance.delete(Integer.parseInt(id));
	}

}