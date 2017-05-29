package introsde.finalproj.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import introsde.finalproj.client.SsClient;


@Path("/food-info")
public class FoodResource {
	
	/***************************************************************
	 * 		GET REQUESTS
	 ***************************************************************/    	
    @GET
    @Path("/search/{string}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response searchFood(@PathParam("string") String str) {
		try{

			String data = SsClient.searchFood(str);
			return Response.status(Response.Status.OK).entity(data).build();
		}
		catch(WebApplicationException e){
			return Response.status(Response.Status.NOT_FOUND).build();    		
		} 
    }   
          
    
    @GET
    @Path("{foodId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getFoodInfo(@PathParam("foodId") String id) {
		try{

			String data = SsClient.getFoodInfo(id);
			return Response.status(Response.Status.OK).entity(data).build();
		}
		catch(WebApplicationException e){
			return Response.status(Response.Status.NOT_FOUND).build();    		
		}     	
    }      
    
    
}