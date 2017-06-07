package introsde.finalproj.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.ws.rs.WebApplicationException;
import introsde.finalproj.client.MyClient;
import introsde.finalproj.model.ActivityHistory;
import introsde.finalproj.model.FoodHistory;
import introsde.finalproj.model.HealthData;
import introsde.finalproj.model.User;



public class DlClient extends MyClient{

	private String ENDPOINT = null;
	
	public DlClient(){
		
		Properties prop = new Properties();
		InputStream input = null;

		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			input = classLoader.getResourceAsStream("/config.properties");

			// load a properties file
			prop.load(input);
			
			ENDPOINT = prop.getProperty("data-layer-url") + "/rest";

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

	public ActivityHistory getActivityHistoryFromInterval(int init, int end, String id) throws WebApplicationException{

		String url = ENDPOINT + "/activity-history/"+id+"?from="+init+"&to="+end;
		return finalMethod(url, HttpMethods.GET).getEntity(ActivityHistory.class);	

	}

	public ActivityHistory getActivityHistoryFromIntervalAndUserId(int init, int end, String id) throws WebApplicationException{
		String url = ENDPOINT + "/activity-history/by-user-id/"+id+"?from="+init+"&to="+end;
		return finalMethod(url, HttpMethods.GET).getEntity(ActivityHistory.class);
	}

	public ActivityHistory postActivityHistory(ActivityHistory payload) throws WebApplicationException{
		String url = ENDPOINT + "/activity-history";
		return finalMethod(url, HttpMethods.POST, payload).getEntity(ActivityHistory.class);

	}

	public ActivityHistory putActivityHistory(String id, ActivityHistory payload) throws WebApplicationException{
		String url = ENDPOINT + "/activity-history/" + id;
		return finalMethod(url, HttpMethods.PUT, payload).getEntity(ActivityHistory.class);	
	}

	public void deleteActivityHistory(String id) throws WebApplicationException{
		String url = ENDPOINT + "/activity-history/"+id;
		finalMethod(url, HttpMethods.DELETE);			
	}


	public FoodHistory getFoodHistoryFromInterval(int init, int end, String id){
		String url = ENDPOINT + "/food-history/"+id+"?from="+init+"&to="+end;
		return finalMethod(url, HttpMethods.GET).getEntity(FoodHistory.class);	
	}

	public FoodHistory getFoodHistoryFromIntervalAndUserId(int init, int end, String id){
		String url = ENDPOINT + "/food-history/by-user-id/"+id+"?from="+init+"&to="+end;
		return finalMethod(url, HttpMethods.GET).getEntity(FoodHistory.class);	
	}

	public FoodHistory postFoodHistory(FoodHistory payload){
		String url = ENDPOINT + "/food-history";
		return finalMethod(url, HttpMethods.POST, payload).getEntity(FoodHistory.class);	
	}

	public FoodHistory putFoodHistory(String id, FoodHistory payload){
		String url = ENDPOINT + "/food-history/"+id;
		return finalMethod(url, HttpMethods.PUT, payload).getEntity(FoodHistory.class);	
	}

	public void deleteFoodHistory(String id){
		String url = ENDPOINT + "/food-history";
		finalMethod(url, HttpMethods.DELETE);
	}

	public User getUserById(String id, int init, int end){
		String url = ENDPOINT + "/user/"+id+"?from="+init+"&to="+end;
		return finalMethod(url, HttpMethods.GET).getEntity(User.class);	
	}

	public User getUserByIdWithoutDailyDetails(String id){
		String url = ENDPOINT + "/user";
		return finalMethod(url, HttpMethods.GET).getEntity(User.class);	
	}

	public User postUser(User payload){
		String url = ENDPOINT + "/user";
		return finalMethod(url, HttpMethods.POST, payload).getEntity(User.class);	
	}

	public User putUser(String id, User payload){
		String url = ENDPOINT + "/user";
		return finalMethod(url, HttpMethods.PUT, payload).getEntity(User.class);	
	}

	public void deleteUser(String id){
		String url = ENDPOINT + "/user";
		finalMethod(url, HttpMethods.DELETE);
	}

	public HealthData getHealthDataByUserId(String id){
		String url = ENDPOINT + "/user/"+id+"/health-data";
		return finalMethod(url, HttpMethods.GET).getEntity(HealthData.class);	
	}	
}
