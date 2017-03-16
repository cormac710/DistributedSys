package Client;



import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

public class Client2POST {

  public static void main(String[] args) {
    ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);
    WebResource service = client.resource(getBaseURI());

    System.out.println(service.path("rest").path("laptops")
        .accept(MediaType.APPLICATION_XML).get(String.class));

    // POST
    Form form = new Form();
    form.add("id", "5");
    form.add("make", "MacBook");
    form.add("model", "Pro");
    form.add("price", "1250");
    form.add("ram", "8");
    form.add("processor", "intel core i5");
    service.path("rest").path("laptops")
        .type(MediaType.APPLICATION_FORM_URLENCODED)
        .post(ClientResponse.class, form);

    System.out.println(service.path("rest").path("laptops")
        .accept(MediaType.APPLICATION_XML).get(String.class));

  }

  private static URI getBaseURI() {
    return UriBuilder.fromUri("http://localhost:8080/LaptopAssignment")
        .build();
  }
}
