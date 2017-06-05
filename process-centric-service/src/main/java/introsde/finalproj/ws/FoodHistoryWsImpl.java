package introsde.finalproj.ws;

import javax.jws.WebService;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import introsde.finalproj.client.BlClient;
import introsde.finalproj.client.SsClient;
import introsde.finalproj.model.FoodHistory;
import introsde.finalproj.model.HealthData;
import introsde.finalproj.model.User;

@WebService(endpointInterface = "introsde.finalproj.ws.FoodHistoryWsInterface")
public class FoodHistoryWsImpl implements FoodHistoryWsInterface{
	
	private SsClient ssClient = new SsClient(); 

	public FoodHistory getFoodHistoryFromInterval(int init, int end, String id) {
		try{

			return ssClient.getFoodHistoryFromInterval(init, end, id);
		}
		catch(WebApplicationException e){
			return null;    		
		}   
	}

	public FoodHistory getFoodHistoryFromIntervalAndUserId(int init, int end, String id) {
		try{

			return ssClient.getFoodHistoryFromIntervalAndUserId(init, end, id);
		}
		catch(WebApplicationException e){
			return null;
		} 
	}

	public FoodHistory postFoodHistory(FoodHistory fh) {
		try{

			return ssClient.postFoodHistory(fh);
		}
		catch(WebApplicationException e){
			return null;    		
		}  
	}

	public FoodHistory putFoodHistory(String id, FoodHistory fh) {
		try{

			return ssClient.putFoodHistory(id, fh);
		}
		catch(WebApplicationException e){
			return null;    		
		}  
	}

	public void deleteFoodHistory(String id) {
		ssClient.deleteFoodHistory(id);
		
	}

	
	
}
