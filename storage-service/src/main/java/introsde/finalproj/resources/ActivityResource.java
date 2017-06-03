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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import introsde.finalproj.client.DlClient;
import introsde.finalproj.model.ActivityHistory;



@Path("/activity-history")
public class ActivityResource {
	
	private DlClient dlClient = new DlClient();

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
		try
		{
			ActivityHistory fh = dlClient.getActivityHistoryFromInterval(init, end, id);
			return Response.status(Response.Status.OK).entity(fh).build();

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("by-user-id/{userId}")
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response getActivityHistoryFromIntervalAndUserId(
			@DefaultValue("-1") @QueryParam("from") int init,
			@DefaultValue("-1") @QueryParam("to") int end,
			@PathParam("userId") String id){

		ActivityHistory fh = dlClient.getActivityHistoryFromIntervalAndUserId(init, end, id);

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

		fh = dlClient.postActivityHistory(fh);

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

		fh = dlClient.putActivityHistory(id, fh);

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
	public Response deleteActivityHistory(@PathParam("historyId") String id) {
		try{
			dlClient.deleteActivityHistory(id);
			return Response.status(Response.Status.OK).build();
		}
		catch(WebApplicationException e){
			return Response.status(e.getResponse().getStatus()).build();
		}
	
		   	
	}   


}