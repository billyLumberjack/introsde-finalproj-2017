package introsde.finalproj.resources;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import introsde.finalproj.model.ActivityHistory;
import introsde.finalproj.model.Exercises;

@Path("/activity-info")
public class ExerciseResource {

	/***************************************************************
	 * 		GET REQUESTS
	 * @return 
	 ***************************************************************/    	

	@GET
	@Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	public Response getExercises() {
		try{

			Exercises data = null;
			return Response.status(Response.Status.OK).entity(data).build();
		}
		catch(WebApplicationException e){
			return Response.status(Response.Status.NOT_FOUND).build();    		
		}   

	}   


}
