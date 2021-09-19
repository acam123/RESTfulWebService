package org.webservice;
 
/**
* @author Aidan Campbell
*/
 
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import java.util.Scanner; 
import java.util.ArrayList;
import javax.ws.rs.core.Response;

 
@Path("Syndic8")
public class Syndic8Server {
	
	public static ArrayList<Product> products = new ArrayList<Product>();
	public static ArrayList<Album> albums = new ArrayList<Album>();
	public static ArrayList<Image> images = new ArrayList<Image>();
	
	@POST 
	@Path("product/test/{d}")
	//@Consumes(MediaType.APPLICATION_JSON)
	public Response productTest(@PathParam("d") String d) {
		Product obj = new Product();
		obj.create("test-name",d);
		products.add(obj);
		return Response.status(201).entity("").build(); 
	}
	
	@POST 
	@Path("product/create/{n}/{d}")
	//@Produces(MediaType.APPLICATION_JSON)
	public Response productCreate(@PathParam("n") String n, @PathParam("d") String d) {
		Product obj = new Product();
		obj.create(n,d);
		products.add(obj);
		String json = new Gson().toJson(obj);
		return Response.status(201).entity(json).build(); 
	}
	
	
	@GET 
	@Path("product/read/{n}")
	@Produces(MediaType.APPLICATION_JSON)
	public String productRead(@PathParam("n") String n) {
		Product product;
		for (int i = 0; i < products.size(); i++) {
			product = products.get(i);
			if (product.getName().equals(n)) {
				String json = new Gson().toJson(product);
				return json;
			}
		}
		String json = new Gson().toJson(null);
		return json;
	}
	
	@GET 
	@Path("album/create/{n}/{d}")
	@Produces(MediaType.APPLICATION_JSON)
	public String albumCreate(@PathParam("n") String n, @PathParam("d") String d) {
		Product obj = new Product();
		obj.create(n,d);
		String json = new Gson().toJson(obj);
		return json;
	}
	
	@GET 
	@Path("album/read/{n}/{d}")
	@Produces(MediaType.APPLICATION_JSON)
	public String albumRead(@PathParam("n") String n, @PathParam("d") String d) {
		Product obj = new Product();
		obj.create(n,d);
		String json = new Gson().toJson(obj);
		return json;
	}
	
	@GET 
	@Path("image/create/{n}/{d}")
	@Produces(MediaType.APPLICATION_JSON)
	public String imageCreate(@PathParam("n") String n, @PathParam("d") String d) {
		Product obj = new Product();
		obj.create(n,d);
		String json = new Gson().toJson(obj);
		return json;
	}
	
	@GET 
	@Path("image/read/{n}/{d}")
	@Produces(MediaType.APPLICATION_JSON)
	public String imageRead(@PathParam("n") String n, @PathParam("d") String d) {
		Product obj = new Product();
		obj.create(n,d);
		String json = new Gson().toJson(obj);
		return json;
	}
	

}