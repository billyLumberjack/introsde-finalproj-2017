package introsde.finalproj.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/hello-world")
public class HelloWorld {
	
	/***************************************************************
	 * 		GET REQUESTS
	 ***************************************************************/    	
    @GET
    
    @Produces({MediaType.APPLICATION_JSON})
    public Response helloWorld() {
    	return Response.status(Response.Status.OK).entity("{\"data\":\"hello world\"}").build();
    }      
    
    
}