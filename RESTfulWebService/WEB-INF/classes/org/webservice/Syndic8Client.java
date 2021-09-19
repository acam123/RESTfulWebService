package org.webservice;

/**
* @author Aidan Campbell
*/
 
import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.util.Scanner; 
 
public class Syndic8Client {
    static final String REST_URI = "http://localhost:8080/RESTfulWebService";
    static final String SERVER = "Syndic8";
 
    public static void main(String[] args) {
    	productCreate();
    	productRead();
    }
    
    public static void productCreate() {
    	Scanner scan = new Scanner(System.in);  
        System.out.println("Enter Product Name:");
        String name = scan.nextLine(); 

        System.out.println("Enter Product Description:");
        String desc = scan.nextLine(); 
        scan.close();
    	
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(REST_URI).path("rest").path(SERVER).path("product/create").path(name).path(desc);
        System.out.println("Response: " + postItem(service));
    }
    
    public static void productRead() {
    	Scanner scan = new Scanner(System.in);  
        System.out.println("Enter Product Name:");
        String name = scan.nextLine(); 
        scan.close();
        
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(REST_URI).path("rest").path(SERVER).path("product/read").path(name);
        System.out.println("JSON: " + getJSON(service));
    }
    
    private static String getJSON(WebResource service) {
        return service.accept(MediaType.APPLICATION_JSON).get(String.class);
    }
    
    private static ClientResponse postItem(WebResource service) {
    	 return service.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class);
    }
 
    
}