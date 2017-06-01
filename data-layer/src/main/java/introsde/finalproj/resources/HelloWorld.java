package introsde.finalproj.resources;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.persistence.internal.nosql.adapters.mongo.MongoJCAConnectionSpec;
import org.eclipse.persistence.nosql.adapters.mongo.MongoConnectionSpec;

import introsde.finalproj.model.User;
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