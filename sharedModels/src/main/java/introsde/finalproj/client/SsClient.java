package introsde.finalproj.client;

import javax.ws.rs.WebApplicationException;

import introsde.finalproj.client.MyClient;
import introsde.finalproj.client.MyClient.HttpMethods;
import introsde.finalproj.model.*;

public class SsClient extends MyClient{
	
	private static String ENDPOINT = "http://localhost:8080/storage-service/rest";
	
	/*
			public static ActivityHistory getActivityHistoryFromInterval(int init, int end, String id) throws WebApplicationException{
		
				String url = ENDPOINT + "/activity-history/"+id+"?from="+init+"&to="+end;
				return finalMethod(url, HttpMethods.GET).getEntity(ActivityHistory.class);	
		
			}
	 */
	
	public static FoodHistory retrieveFoodHistoryByIntervalAndUserId(String id, int init, int end){
		String url = ENDPOINT + "/food-history/"+id+"?from="+init+"&to="+end;
		return finalMethod(url, HttpMethods.GET).getEntity(FoodHistory.class);	
	}
	
	public static ActivityHistory retrieveActivityHistoryByIntervalAndUserId(String id, int init, int end){
		String url = ENDPOINT + "/food-history/"+id+"?from="+init+"&to="+end;
		return finalMethod(url, HttpMethods.GET).getEntity(ActivityHistory.class);	
	}
	
	public static User getUserById(String id){
		String url = ENDPOINT + "/user/"+id;
		return finalMethod(url, HttpMethods.GET).getEntity(User.class);	
	}
	
	public static HealthData getHealthDataByUserId(String id){	
		String url = ENDPOINT + "/user/"+id+"/health-data";
		return finalMethod(url, HttpMethods.GET).getEntity(HealthData.class);	
	}
	
	public static User updateUser(User u){
		String url = ENDPOINT + "/user";
		return finalMethod(url, HttpMethods.PUT, u).getEntity(User.class);	
	}

}
