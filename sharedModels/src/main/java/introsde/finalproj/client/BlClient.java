package introsde.finalproj.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.json.JsonObject;
import javax.ws.rs.WebApplicationException;
import introsde.finalproj.client.MyClient;
import introsde.finalproj.model.User;

public class BlClient extends MyClient{
	private String ENDPOINT = null;
	
	public BlClient(){
		
		Properties prop = new Properties();
		InputStream input = null;

		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			input = classLoader.getResourceAsStream("/config.properties");

			// load a properties file
			prop.load(input);
			
			ENDPOINT = prop.getProperty("business-logic-url") + "/rest";

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public  User computeHealthData(User u) throws WebApplicationException{
		String url = ENDPOINT + "/user/health-data";
		return finalMethod(url, HttpMethods.POST, u).getEntity(User.class);	
	}
	
	public  String computeCaloriesCountFromDates(String id, int init, int end){
		String url = ENDPOINT + "/user/"+id+"/calories-count?from="+init+"&to=" + end;
		return finalMethod(url, HttpMethods.GET).getEntity(String.class);	
	}
	//ciccio
	public  String recommendActivities(){
		return null;
	}
	
	public  String recommendFoods(){
		return null;
	}
}
