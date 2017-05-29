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
import introsde.finalproj.client.DlClient;
import introsde.finalproj.model.HealthData;
import introsde.finalproj.model.User;

@Path("/user")
public class UserResource {

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
			User data = DlClient.getUserById(id, init, end);
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
			User data = DlClient.getUserByIdWithoutDailyDetails(id);
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
			HealthData data = DlClient.getHealthDataByUserId(id);
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
			u = BlClient.computeHealthData(u);
			u = DlClient.postUser(u);
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
			User data = DlClient.putUser(id, u);
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
			DlClient.deleteUser(id);
			return Response.status(Response.Status.OK).build();

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}   
	
	//////////////////////////
	
	@GET
	@Path("{userId}/calories-count")
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response computeCaloriesCountFromDates(@PathParam("userId") String id,
			@DefaultValue("-1") @QueryParam("from") int init,
			@DefaultValue("-1") @QueryParam("to") int end
			){
		try{

			String data = BlClient.computeCaloriesCountFromDates(id, init, end);
			
			System.out.println(data);
			
			return Response.status(Response.Status.OK).entity(data).build();
		}
		catch(WebApplicationException e){
			return Response.status(Response.Status.NOT_FOUND).build();    		
		}     	
	}   

	@POST
	@Path("health-data")
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	@Consumes({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response computeUserHealthData(User user){
		try{

			user = BlClient.computeHealthData(user);
			return Response.status(Response.Status.OK).entity(user).build();
		}
		catch(WebApplicationException e){
			return Response.status(Response.Status.NOT_FOUND).build();    		
		}  
	}    

	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	@Consumes({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public void recommendActivities(){
		// look for similar users and suggest their activities
	}

	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	@Consumes({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public void recommendFoods(){
		// look for similar users and suggest their food
	}	
	

}