package introsde.finalproj.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import introsde.finalproj.client.SsClient;
import introsde.finalproj.model.DailyActivity;
import introsde.finalproj.model.DailyFood;
import introsde.finalproj.model.Exercises;
import introsde.finalproj.model.FoodHistory;

@Path("/food-history")
public class FoodHistoryResource {
	
	private SsClient ssClient = new SsClient(); 

	/***************************************************************
	 * 		GET REQUESTS
	 ***************************************************************/    	

	// retrieve the daily food from date A to date B
	@GET
	@Path("{historyId}")
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response getFoodHistoryFromInterval(
			@DefaultValue("-1") @QueryParam("from") int init,
			@DefaultValue("-1") @QueryParam("to") int end,
			@PathParam("historyId") String id){
		try{

			FoodHistory data = ssClient.getFoodHistoryFromInterval(init, end, id);
			return Response.status(Response.Status.OK).entity(data).build();
		}
		catch(WebApplicationException e){
			return Response.status(Response.Status.NOT_FOUND).build();    		
		}   
	}

	@GET
	@Path("by-user-id/{userId}")
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response getFoodHistoryFromIntervalAndUserId(
			@DefaultValue("-1") @QueryParam("from") int init,
			@DefaultValue("-1") @QueryParam("to") int end,
			@PathParam("userId") String id){
		try{

			FoodHistory data = ssClient.getFoodHistoryFromIntervalAndUserId(init, end, id);
			return Response.status(Response.Status.OK).entity(data).build();
		}
		catch(WebApplicationException e){
			return Response.status(Response.Status.NOT_FOUND).build();    		
		}   
	}    

	/***************************************************************
	 * 		POST REQUESTS
	 ***************************************************************/    	

	@POST
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	@Consumes({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response postFoodHistory(FoodHistory fh){
		try{

			FoodHistory data = ssClient.postFoodHistory(fh);
			return Response.status(Response.Status.OK).entity(data).build();
		}
		catch(WebApplicationException e){
			return Response.status(Response.Status.NOT_FOUND).build();    		
		}   

	}

	/***************************************************************
	 * 		PUT REQUESTS
	 ***************************************************************/    	

	@PUT
	@Path("{historyId}")
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	@Consumes({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response putFoodHistory(@PathParam("historyId") String id, FoodHistory payload) {
		try{

			FoodHistory data = ssClient.putFoodHistory(id, payload);
			return Response.status(Response.Status.OK).entity(data).build();
		}
		catch(WebApplicationException e){
			return Response.status(Response.Status.NOT_FOUND).build();    		
		}   		
		
	} 	

	/***************************************************************
	 * 		DELETE REQUESTS
	 ***************************************************************/        

	@DELETE
	@Path("{historyId}")
	public Response deleteFoodHistory(@PathParam("historyId") String id) {
		try{

			ssClient.deleteFoodHistory(id);
			return Response.status(Response.Status.OK).build();
		}
		catch(WebApplicationException e){
			return Response.status(Response.Status.NOT_FOUND).build();    		
		}   	
	}   

}