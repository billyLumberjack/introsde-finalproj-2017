package introsde.finalproj.resources;

import java.text.ParseException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import introsde.finalproj.spoonacular_client.MyClient;

@Path("/food-info")
public class FoodResource {
	
	/***************************************************************
	 * 		GET REQUESTS
	 ***************************************************************/    	
    @GET
    @Path("/search/{string}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response searchFood(@PathParam("string") String str) {
    	System.out.println("--> Looking for " + str);
    	String data = MyClient.searchFood(str); 
    	
    	if(data != null)
    		return Response.status(Response.Status.OK).entity(data).build();
    	else
    		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }   
          
    
    @GET
    @Path("{foodId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getFoodInfo(@PathParam("foodId") String id) {
    	System.out.println("--> Retrieving food with id " + id);
    	String data = MyClient.getFoodInfo(id);
    	
    	if(data != null)
    		return Response.status(Response.Status.OK).entity(data).build();
    	else
    		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();    	
    }      
    
    
}