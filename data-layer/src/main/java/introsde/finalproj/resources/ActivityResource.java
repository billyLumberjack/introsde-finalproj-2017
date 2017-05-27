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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import introsde.finalproj.model.ActivityHistory;
import introsde.finalproj.model.FoodHistory;



@Path("/activity-history")
public class ActivityResource {

	/***************************************************************
	 * 		GET REQUESTS
	 ***************************************************************/    	
	// retrieve the daily activity from date A to date B
	@GET
	@Path("{historyId}")
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response getActivityHistoryFromInterval(
			@DefaultValue("-1") @QueryParam("from") int init,
			@DefaultValue("-1") @QueryParam("to") int end,
			@PathParam("historyId") String id){

		ActivityHistory ah = null;
		if(init == -1 && end == -1)
			ah = ActivityHistory.getOne(id);
		else
			ah = ActivityHistory.getFromIntervalDates(id, init, end);


		if (ah != null)
			return Response.status(Response.Status.OK).entity(ah).build();
		else
			return Response.status(Response.Status.NOT_FOUND).build();



	}

	@GET
	@Path("by-user-id/{userId}")
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response getActivityHistoryFromIntervalAndUserId(
			@DefaultValue("-1") @QueryParam("from") int init,
			@DefaultValue("-1") @QueryParam("to") int end,
			@PathParam("userId") String id){
		System.out.println("--> Getting ActivityHistory from interval and user Id");
		ActivityHistory fh = ActivityHistory.getFromIntervalDatesAndUserId(id, init, end);

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
	public Response postActivityHistory(ActivityHistory fh){
		System.out.println("--> Saving ActivityHistory");
		fh = ActivityHistory.saveActivityHistory(fh);
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
	public Response putActivityHistory(@PathParam("historyId") String id, ActivityHistory fh) {
		System.out.println("--> Updating ActivityHistory... " +id);
		fh = ActivityHistory.updateActivityHistory(fh);
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
	public Response deleteActivityHistory(@PathParam("historyId") String id)
	{
		System.out.println("--> Removing ActivityHistory... " +id);

		ActivityHistory data = ActivityHistory.getOne(id);

		if (data != null)
		{
			ActivityHistory.removeActivityHistory(data);
			return Response.status(Response.Status.OK).build();
		}
		else
			return Response.status(Response.Status.NOT_FOUND).build();
	}   


}