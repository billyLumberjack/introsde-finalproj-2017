package introsde.finalproj.ws;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import introsde.finalproj.client.BlClient;
import introsde.finalproj.client.SsClient;
import introsde.finalproj.model.ActivityHistory;
import introsde.finalproj.model.HealthData;
import introsde.finalproj.model.User;

@WebService(endpointInterface = "introsde.finalproj.ws.ActivityWsInterface")
public class ActivityWsImpl implements ActivityWsInterface{
	
	private SsClient ssClient = new SsClient(); 

	public ActivityHistory getActivityHistoryFromInterval(int init, int end, String id) {
		try
		{
			return ssClient.getActivityHistoryFromInterval(init, end, id);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public ActivityHistory getActivityHistoryFromIntervalAndUserId(int init, int end, String id) {
		return ssClient.getActivityHistoryFromIntervalAndUserId(init, end, id);
	}

	public ActivityHistory postActivityHistory(ActivityHistory ah) {
		return ssClient.postActivityHistory(ah);	
	}

	public ActivityHistory putActivityHistory(String id, ActivityHistory ah) {
		return ssClient.putActivityHistory(id, ah);
	}

	public void deleteActivityHistory(String id) {
		ssClient.deleteActivityHistory(id);
		
	}

	
	
}
