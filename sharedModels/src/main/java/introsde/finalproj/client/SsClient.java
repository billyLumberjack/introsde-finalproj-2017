package introsde.finalproj.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import introsde.finalproj.client.MyClient;
import introsde.finalproj.client.MyClient.HttpMethods;
import introsde.finalproj.faea_client.FaeaClient;
import introsde.finalproj.model.*;

public class SsClient extends MyClient{

	private static String ENDPOINT = "http://localhost:8080/storage-service/rest";

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
	
	public static Exercises getExercises(){
		String url = ENDPOINT + "/activity-info";
		return finalMethod(url, HttpMethods.GET).getEntity(Exercises.class);		
	}
	
    public static String searchFood(String query) {
    	String url = ENDPOINT + "/food-info/search/" + query;
		return finalMethod(url, HttpMethods.GET).getEntity(String.class); 
    }
    
    public static String getFoodInfo(String id) {
    	String url = ENDPOINT + "/food-info"+id;
		return finalMethod(url, HttpMethods.GET).getEntity(String.class); 
    }  
          
       
	


}
