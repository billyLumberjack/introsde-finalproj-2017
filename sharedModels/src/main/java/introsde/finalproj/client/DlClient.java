package introsde.finalproj.client;

import javax.ws.rs.WebApplicationException;
import introsde.finalproj.client.MyClient;
import introsde.finalproj.model.ActivityHistory;
import introsde.finalproj.model.FoodHistory;
import introsde.finalproj.model.HealthData;
import introsde.finalproj.model.User;



public class DlClient extends MyClient{

	private static String ENDPOINT = "http://localhost:8080/data-layer/rest";

	public static ActivityHistory getActivityHistoryFromInterval(int init, int end, String id) throws WebApplicationException{

		String url = ENDPOINT + "/activity-history/"+id+"?from="+init+"&to="+end;
		return finalMethod(url, HttpMethods.GET).getEntity(ActivityHistory.class);	

	}

	public static ActivityHistory getActivityHistoryFromIntervalAndUserId(int init, int end, String id) throws WebApplicationException{
		String url = ENDPOINT + "/activity-history/by-user-id/"+id+"?from="+init+"&to="+end;
		return finalMethod(url, HttpMethods.GET).getEntity(ActivityHistory.class);
	}

	public static ActivityHistory postActivityHistory(ActivityHistory payload) throws WebApplicationException{
		String url = ENDPOINT + "/activity-history";
		return finalMethod(url, HttpMethods.POST, payload).getEntity(ActivityHistory.class);

	}

	public static ActivityHistory putActivityHistory(String id, ActivityHistory payload) throws WebApplicationException{
		String url = ENDPOINT + "/activity-history";
		return finalMethod(url, HttpMethods.PUT, payload).getEntity(ActivityHistory.class);	
	}

	public static void deleteActivityHistory(String id) throws WebApplicationException{
		String url = ENDPOINT + "/activity-history/"+id;
		finalMethod(url, HttpMethods.DELETE);			
	}


	public static FoodHistory getFoodHistoryFromInterval(int init, int end, String id){
		String url = ENDPOINT + "/food-history/"+id+"?from="+init+"&to="+end;
		return finalMethod(url, HttpMethods.GET).getEntity(FoodHistory.class);	
	}

	public static FoodHistory getFoodHistoryFromIntervalAndUserId(int init, int end, String id){
		String url = ENDPOINT + "/food-history/by-user-id/"+id+"?from="+init+"&to="+end;
		return finalMethod(url, HttpMethods.GET).getEntity(FoodHistory.class);	
	}

	public static FoodHistory postFoodHistory(FoodHistory payload){
		String url = ENDPOINT + "/food-history";
		return finalMethod(url, HttpMethods.POST, payload).getEntity(FoodHistory.class);	
	}

	public static FoodHistory putFoodHistory(String id, FoodHistory payload){
		String url = ENDPOINT + "/food-history/"+id;
		return finalMethod(url, HttpMethods.PUT, payload).getEntity(FoodHistory.class);	
	}

	public static void deleteFoodHistory(String id){
		String url = ENDPOINT + "/food-history";
		finalMethod(url, HttpMethods.DELETE);
	}

	public static User getUserById(String id, int init, int end){
		String url = ENDPOINT + "/user/"+id+"?from="+init+"&to="+end;
		return finalMethod(url, HttpMethods.GET).getEntity(User.class);	
	}

	public static User getUserByIdWithoutDailyDetails(String id){
		String url = ENDPOINT + "/user";
		return finalMethod(url, HttpMethods.GET).getEntity(User.class);	
	}

	public static User postUser(User payload){
		String url = ENDPOINT + "/user";
		return finalMethod(url, HttpMethods.POST, payload).getEntity(User.class);	
	}

	public static User putUser(String id, User payload){
		String url = ENDPOINT + "/user";
		return finalMethod(url, HttpMethods.PUT, payload).getEntity(User.class);	
	}

	public static void deleteUser(String id){
		String url = ENDPOINT + "/user";
		finalMethod(url, HttpMethods.DELETE);
	}

	public static HealthData getHealthDataByUserId(String id){
		String url = ENDPOINT + "/user/"+id+"/health-data";
		return finalMethod(url, HttpMethods.GET).getEntity(HealthData.class);	
	}	
}
