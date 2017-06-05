package introsde.finalproj.ws;

import javax.jws.WebService;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import introsde.finalproj.client.BlClient;
import introsde.finalproj.client.SsClient;
import introsde.finalproj.model.HealthData;
import introsde.finalproj.model.User;

@WebService(endpointInterface = "introsde.finalproj.ws.FoodWsInterface")
public class FoodWsImpl implements FoodWsInterface{
	
	private SsClient ssClient = new SsClient(); 

	public String searchFood(String str) {
		try{

			return ssClient.searchFood(str);
		}
		catch(WebApplicationException e){
			return null;    		
		} 
	}

	public String getFoodInfo(String id) {
		try{

			return ssClient.getFoodInfo(id);
		}
		catch(WebApplicationException e){
			return null;    		
		}   
	}

	
	
}
