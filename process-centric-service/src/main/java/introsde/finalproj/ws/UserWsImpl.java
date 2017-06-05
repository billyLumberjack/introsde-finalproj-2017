package introsde.finalproj.ws;

import javax.jws.WebService;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import introsde.finalproj.client.BlClient;
import introsde.finalproj.client.SsClient;
import introsde.finalproj.model.HealthData;
import introsde.finalproj.model.User;

@WebService(endpointInterface = "introsde.finalproj.ws.UserWsInterface")
public class UserWsImpl implements UserWsInterface{
	private SsClient ssClient = new SsClient();
	private BlClient blClient = new BlClient();


	public User getUserById(String id, int init, int end) {
		if(init == 0 && end == 0)
		{
			init = -1;
			end = -1;
		}
		try
		{
			return ssClient.getUserById(id, init, end);
			

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public User getUserByIdWithoutDailyDetails(String id) {
		try
		{
			return ssClient.getUserByIdWithoutDailyDetails(id);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public HealthData getHealthDataByUserId(String id) {
		try
		{
			return ssClient.getHealthDataByUserId(id);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public User postUser(User u) {
		try
		{
			u = blClient.computeHealthData(u);
			return ssClient.postUser(u);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public User putUser(String id, User u) {
		try
		{
			return ssClient.putUser(id, u);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public void deleteUser(String id) {
		try
		{
			ssClient.deleteUser(id);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public String computeCaloriesCountFromDates(String id, int init, int end) {
		if(init == 0 && end == 0)
		{
			init = -1;
			end = -1;
		}
		try{

			return blClient.computeCaloriesCountFromDates(id, init, end);
		}
		catch(WebApplicationException e){
			return null; 		
		}  
	}

	public User computeUserHealthData(User u) {
		try{

			return blClient.computeHealthData(u);
		}
		catch(WebApplicationException e){
			return null;    		
		}  
	}

	
	
}
