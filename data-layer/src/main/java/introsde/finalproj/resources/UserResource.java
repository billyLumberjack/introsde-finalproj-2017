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

import introsde.finalproj.client.BlClient;
import introsde.finalproj.model.User;

@Path("/user")
public class UserResource {

	/***************************************************************
	 * 		GET REQUESTS
	 ***************************************************************/
	@GET
	@Path("test")
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response test() {
		System.out.println("--> Testing User");
		User u = User.getOne("58F909C8014E958A6F63F9F9");
		if (u != null)
		{
			//to return just the last measure for each type
			return Response.status(Response.Status.OK).entity(u).build();
		}
		else
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}  

	// retrieve the activity resource whose id matches the given one
	@GET
	@Path("{userId}")
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response getUserById(@PathParam("userId") String id,
			@DefaultValue("-1") @QueryParam("from") int init,
			@DefaultValue("-1") @QueryParam("to") int end) {
		System.out.println("--> Getting User");
		User u;
		if(init == -1 && end == -1)
			u = User.getOne(id);
		else
			u = User.getFromIntervalDatesAndId(id, init, end);

		if (u != null)
			return Response.status(Response.Status.OK).entity(u).build();
		else
			return Response.status(Response.Status.NOT_FOUND).build();

	}   
	@GET
	@Path("light/{userId}")
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response getUserByIdWithoutDailyDetails(@PathParam("userId") String id) {
		System.out.println("--> Getting User (LIGHT)");
		User u = User.getOneWithoutDailyDetails(id);
		if (u != null)
		{
			//to return just the last measure for each type
			return Response.status(Response.Status.OK).entity(u).build();
		}
		else
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}     

	@GET
	@Path("{userId}/health-data")
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response getHealthDataByUserId(@PathParam("userId") String id) {
		System.out.println("--> getHealthDataByUserId");
		User u = User.getOneWithoutDailyDetails(id);
		if (u != null)
		{
			//to return just the last measure for each type
			return Response.status(Response.Status.OK).entity(u.getHealthData()).build();
		}
		else
		{
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
		try{
			System.out.println("--> Saving User");
			u = User.saveUser(u);
			return Response.status(Response.Status.OK).entity(u).build();
		}
		catch(WebApplicationException e){
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
	public User putUser(@PathParam("UserId") String id, User User) {
		System.out.println("--> Updating User... " +id);
		return User.updateUser(User);
	} 	

	/***************************************************************
	 * 		DELETE REQUESTS
	 ***************************************************************/        

	@DELETE
	@Path("{UserId}")
	public Response deleteUser(@PathParam("UserId") String id) {
		System.out.println("--> Removing User... " +id);
		User data = User.getOne(id);

		if (data != null)
		{
			User.removeUser(data);
			return Response.status(Response.Status.OK).build();
		}
		else
			return Response.status(Response.Status.NOT_FOUND).build();

	}   

}