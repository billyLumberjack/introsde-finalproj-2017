package introsde.finalproj.spoonacular_client;


import org.json.JSONArray;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MyClient {
	private static Client client = Client.create();
	private static String MASHAPE_KEY = "Odyp1zm5WGmshIw0Ka44at4upU9Ep1FQdXqjsn00uIfWcJk54K";
	private static String ENDPOINT = "https://spoonacular-recipe-food-nutrition-v1.p.mashape.com";

	public static String searchFood(String string) {
		try{
			int items_limit = 10;
			String url = ENDPOINT+"/food/ingredients/autocomplete?metaInformation=true&number="+items_limit+"&query="+string;
			WebResource wr = client.resource(url);
			
			ClientResponse response = wr.header("Accept", "application/json")
					.header("X-Mashape-Key", MASHAPE_KEY)
					.get(ClientResponse.class);
			if(response.getStatus() != 200)
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
			
			JSONArray array = new JSONArray(response.getEntity(String.class));
	
			for(int c=0; c<array.length();c++){
				array.getJSONObject(c).remove("image");
			}
	
			return array.toString();
		}
		catch(Exception e){
			return null;
		}
	}
	
	
	public static String getFoodInfo(String id) {
		try{
			String url = ENDPOINT+"/food/ingredients/"+id+"/information?amount=100&unit=gram";
			WebResource wr = client.resource(url);
			
			ClientResponse response = wr.header("Accept", "application/json")
					.header("X-Mashape-Key", MASHAPE_KEY)
					.get(ClientResponse.class);
	
			if(response.getStatus() != 200)
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());		
			
			return response.getEntity(String.class);
		}
		catch(Exception e){
			return null;
		}
	}
}
