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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import introsde.finalproj.model.ActivityHistory;
import introsde.finalproj.model.DailyActivity;
import introsde.finalproj.model.DailyFood;
import introsde.finalproj.model.FoodHistory;

@Path("/food-history")
public class FoodHistoryResource {
	
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
    	System.out.println("--> Getting FoodHistory");
    	FoodHistory fh = null;
		if(init == -1 && end == -1)
			fh = FoodHistory.getOne(id);
		else
			fh = FoodHistory.getFromIntervalDates(id, init, end);
			
    	
        if (fh != null)
            return Response.status(Response.Status.OK).entity(fh).build();
        else
        	return Response.status(Response.Status.NOT_FOUND).build();
        }
    
    @GET
    @Path("by-user-id/{userId}")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public Response getFoodHistoryFromIntervalAndUserId(
    		@DefaultValue("-1") @QueryParam("from") int init,
    		@DefaultValue("-1") @QueryParam("to") int end,
    		@PathParam("userId") String id){
    	System.out.println("--> Getting FoodHistory from interval and user Id");
    	FoodHistory fh = null;
		if(init == -1 && end == -1)
			fh = FoodHistory.getFromUserId(id);
		else
			fh = FoodHistory.getFromIntervalDatesAndUserId(id, init, end);
			
    	
        if (fh != null)
            return Response.status(Response.Status.OK).entity(fh).build();
        else
        	return Response.status(Response.Status.NOT_FOUND).build();
        }    
    
	/***************************************************************
	 * 		POST REQUESTS
	 ***************************************************************/    	
	
	@POST
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	@Consumes({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response postFoodHistory(FoodHistory fh){
		System.out.println("--> Saving FoodHistory");
		fh = FoodHistory.saveFoodHistory(fh);
        if (fh != null)
            return Response.status(Response.Status.OK).entity(fh).build();
        else
        	return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	/***************************************************************
	 * 		PUT REQUESTS
	 ***************************************************************/    	
	
    @PUT
    @Path("{historyId}")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	@Consumes({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public Response putFoodHistory(@PathParam("historyId") String id, FoodHistory fh) {
        System.out.println("--> Updating FoodHistory... " +id);
        fh = FoodHistory.updateFoodHistory(fh);
        if (fh != null)
            return Response.status(Response.Status.OK).entity(fh).build();
        else
        	return Response.status(Response.Status.NOT_FOUND).build();
    } 	

	/***************************************************************
	 * 		DELETE REQUESTS
	 ***************************************************************/        
    
    @DELETE
    @Path("{historyId}")
    public Response deleteFoodHistory(@PathParam("historyId") String id) {
    	System.out.println("--> Removing FoodHistory... " +id);
		FoodHistory data = FoodHistory.getOne(id);

		if (data != null)
		{
			FoodHistory.removeFoodHistory(data);
			return Response.status(Response.Status.OK).build();
		}
		else
			return Response.status(Response.Status.NOT_FOUND).build();
    }   

}