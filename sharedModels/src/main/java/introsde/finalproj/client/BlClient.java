package introsde.finalproj.client;

import javax.json.JsonObject;
import javax.ws.rs.WebApplicationException;
import introsde.finalproj.client.MyClient;
import introsde.finalproj.model.User;

public class BlClient extends MyClient{
	private static final String ENDPOINT = "http://localhost:8080/business-logic/rest";
	
	public static User computeHealthData(User u) throws WebApplicationException{
		String url = ENDPOINT + "/user/health-data";
		return finalMethod(url, HttpMethods.POST, u).getEntity(User.class);	
	}
	
	public static String computeCaloriesCountFromDates(String id, int init, int end){
		String url = ENDPOINT + "/user/"+id+"/calories-count";
		return finalMethod(url, HttpMethods.GET).getEntity(String.class);	
	}
	//ciccio
	public static String recommendActivities(){
		return null;
	}
	
	public static String recommendFoods(){
		return null;
	}
}
