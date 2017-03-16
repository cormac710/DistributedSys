package client;


import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class BookClient {
  public static void main(String[] args) {
    ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);
    WebResource service = client.resource(getBaseURI());

    // Get XML for books
    System.out.println(service.path("rest").path("books")
        .accept(MediaType.APPLICATION_XML).get(String.class));
    
    // Get JSON for boos
    System.out.println(service.path("rest").path("books")
            .accept(MediaType.APPLICATION_JSON).get(String.class));

    // Get XML for book 1
    System.out.println(service.path("rest").path("books").path("1")
        .accept(MediaType.APPLICATION_XML).get(String.class));

    // Get XML for book 2
    System.out.println(service.path("rest").path("books").path("2")
        .accept(MediaType.APPLICATION_XML).get(String.class));
    
    // Get JSON for book 2
    System.out.println(service.path("rest").path("books").path("2")
        .accept(MediaType.APPLICATION_JSON).get(String.class));
  }

  private static URI getBaseURI() {
    return UriBuilder.fromUri("http://localhost:8080/p1Books").build();
  }

}