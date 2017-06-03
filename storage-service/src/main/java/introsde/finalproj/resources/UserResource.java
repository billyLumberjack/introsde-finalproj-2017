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

import introsde.finalproj.client.BlClient;
import introsde.finalproj.client.DlClient;
import introsde.finalproj.model.HealthData;
import introsde.finalproj.model.User;

@Path("/user")
public class UserResource {
	
	private DlClient dlClient = new DlClient();
	private BlClient blClient = new BlClient();

	/***************************************************************
	 * 		GET REQUESTS
	 ***************************************************************/

	// retrieve the activity resource whose id matches the given one
	@GET
	@Path("{userId}")
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response getUserById(@PathParam("userId") String id,
			@DefaultValue("-1") @QueryParam("from") int init,
			@DefaultValue("-1") @QueryParam("to") int end) {
		try
		{
			User data = dlClient.getUserById(id, init, end);
			return Response.status(Response.Status.OK).entity(data).build();

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}   
	@GET
	@Path("light/{userId}")
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response getUserByIdWithoutDailyDetails(@PathParam("userId") String id) {
		try
		{
			User data = dlClient.getUserByIdWithoutDailyDetails(id);
			return Response.status(Response.Status.OK).entity(data).build();

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}     

	@GET
	@Path("{userId}/health-data")
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response getHealthDataByUserId(@PathParam("userId") String id) {
		try
		{
			HealthData data = dlClient.getHealthDataByUserId(id);
			return Response.status(Response.Status.OK).entity(data).build();

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}      

	/***************************************************************
	 * 		POST REQUESTS
	 ***************************************************************/    	

	@POST
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	@Consumes({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response postUser(User u){
		try
		{
			u = blClient.computeHealthData(u);
			u = dlClient.postUser(u);
			return Response.status(Response.Status.OK).entity(u).build();

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}

	/***************************************************************
	 * 		PUT REQUESTS
	 ***************************************************************/    	

	@PUT
	@Path("{UserId}")
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	@Consumes({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response putUser(@PathParam("UserId") String id, User u) {
		try
		{
			User data = dlClient.putUser(id, u);
			return Response.status(Response.Status.OK).entity(data).build();

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	} 	

	/***************************************************************
	 * 		DELETE REQUESTS
	 ***************************************************************/        

	@DELETE
	@Path("{UserId}")
	public Response deleteUser(@PathParam("UserId") String id) {
		try
		{
			dlClient.deleteUser(id);
			return Response.status(Response.Status.OK).build();

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}   

}