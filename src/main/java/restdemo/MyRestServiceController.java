package restdemo;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import restdemo.model.Entity;
 
/**
 * It is the controll
 * To access this functionality you can access by: 
 * - 'http://localhost:8080/<your_app_name>/rest' + <path_method>
 * - ex: http://localhost:8080/MyRestDemoApp/rest/users/1
 * */
@Path("/rest")
public class MyRestServiceController {
	
    @GET
    @Path("/users/{id}")
    public Response getAllUsers(@PathParam (value="id") String id)
    {
    		System.out.println("Start get with param and no return ... (no provider)");
        return Response.status(200).build();
    }
    
    @GET
    @Path("/users/")
    @Produces("text/html")
    public Response getAllUsers()
    {
    		System.out.println("Start get without param and an txt/html return... (Provider: MessageBodyWriterInterceptor)");
        String result = "<h1>My Rest Demo</h1> Some text to not say Hello world :D !!";
        return Response.status(200).entity(result).build();
    }
    
    @GET
    @Path("/users2/")
    public Response getAllUsers2()
    {
    		System.out.println("Start get with a entity return... (Providers: CustomerProviderMessageBodyWriter, CustomWriterInterceptor)");
        return Response.status(200).entity(new Entity()).build();
    }
    
    @POST
    @Path("/post/noreturn")
    @Consumes( MediaType.APPLICATION_JSON)
   public Response create(Entity entity) throws URISyntaxException{
    		System.out.println("Start post with a entity param and no return... (Providers: CustomerProviderMessageBodyReader, CustomReaderInterceptor)");
        System.out.print("POST Create ientity: ");
        System.out.print("id: " + entity.getId());
        System.out.println(", Name: " + entity.getName());
        return Response.ok().build();
   }
    
    @POST
    @Path("/post/withreturn")
    @Consumes( MediaType.APPLICATION_JSON)
   public Response create2(Entity entity) throws URISyntaxException{
        System.out.println("Start post with a entity param ... (Providers: CustomerProviderMessageBodyReader, CustomReaderInterceptor)");
        System.out.println("Start post with a entity param and no return... (Providers: CustomerProviderMessageBodyWriter, CustomWriterInterceptor)");
        System.out.print("POST Create ientity: ");
        System.out.print("id: " + entity.getId());
        System.out.println(", Name: " + entity.getName());
        return Response.ok(new Entity()).build();
   }
}
