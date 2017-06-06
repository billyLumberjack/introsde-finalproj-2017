package introsde.finalproj.spoonacular_client;


import java.awt.List;
import java.util.Arrays;

import org.json.JSONArray;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import introsde.finalproj.model.AdapterFood;
import introsde.finalproj.model.AdapterFoodDetails;
import introsde.finalproj.model.AdapterFoods;
import introsde.finalproj.model.Food;

public class MyClient {
	private static Client client = Client.create();
	private static String MASHAPE_KEY = "Odyp1zm5WGmshIw0Ka44at4upU9Ep1FQdXqjsn00uIfWcJk54K";
	private static String ENDPOINT = "https://spoonacular-recipe-food-nutrition-v1.p.mashape.com";

	public static AdapterFoods searchFood(String string) {
		try{
			int items_limit = 10;
			String url = ENDPOINT+"/food/ingredients/autocomplete?metaInformation=true&number="+items_limit+"&query="+string;
			WebResource wr = client.resource(url);
			
			ClientResponse response = wr.header("Accept", "application/json")
					.header("X-Mashape-Key", MASHAPE_KEY)
					.get(ClientResponse.class);
			if(response.getStatus() != 200)
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
			AdapterFood[] aff = response.getEntity(AdapterFood[].class);
			AdapterFoods af = new AdapterFoods();
			af.setFood(Arrays.asList(aff));
			
			return af;
			 
					
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static AdapterFoodDetails getFoodInfo(String id) {
		try{
			String url = ENDPOINT+"/food/ingredients/"+id+"/information?amount=100&unit=gram";
			WebResource wr = client.resource(url);
			
			ClientResponse response = wr.header("Accept", "application/json")
					.header("X-Mashape-Key", MASHAPE_KEY)
					.get(ClientResponse.class);
	
			if(response.getStatus() != 200)
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());		
			
			return response.getEntity(AdapterFoodDetails.class);
		}
		catch(Exception e){
			return null;
		}
	}
}
