package introsde.finalproj.client;

import javax.ws.rs.WebApplicationException;
import introsde.finalproj.client.MyClient;
import introsde.finalproj.model.User;

public class BlClient extends MyClient{
	private static final String ENDPOINT = "http://localhost:8080/business-logic/rest";
	
	public static User computeHealthData(User u) throws WebApplicationException{
		String url = ENDPOINT + "/user/health-data";
		return finalMethod(url, HttpMethods.POST, u).getEntity(User.class);	
	}

}
