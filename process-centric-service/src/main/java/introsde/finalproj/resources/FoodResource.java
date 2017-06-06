package introsde.finalproj.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import introsde.finalproj.client.SsClient;
import introsde.finalproj.model.AdapterFoodDetails;
import introsde.finalproj.model.AdapterFoods;


@Path("/food-info")
public class FoodResource {
	
	private SsClient ssClient = new SsClient(); 
	
	/***************************************************************
	 * 		GET REQUESTS
	 ***************************************************************/    	
    @GET
    @Path("/search/{string}")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public Response searchFood(@PathParam("string") String str) {
		try{

			AdapterFoods data = ssClient.searchFood(str);
			return Response.status(Response.Status.OK).entity(data).build();
		}
		catch(WebApplicationException e){
			return Response.status(Response.Status.NOT_FOUND).build();    		
		} 
    }   
          
    
    @GET
    @Path("{foodId}")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public Response getFoodInfo(@PathParam("foodId") String id) {
		try{

			AdapterFoodDetails data = ssClient.getFoodInfo(id);
			return Response.status(Response.Status.OK).entity(data).build();
		}
		catch(WebApplicationException e){
			return Response.status(Response.Status.NOT_FOUND).build();    		
		}     	
    }      
    
    
}