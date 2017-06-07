package introsde.finalproj.ws;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.ws.rs.core.Response;

import introsde.finalproj.model.HealthData;
import introsde.finalproj.model.Statistics;
import introsde.finalproj.model.User;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface UserWsInterface {
	
	public User getUserById(String id, int init, int end);
	public User getUserByIdWithoutDailyDetails(String id);
	public HealthData getHealthDataByUserId(String id);
	public User postUser(User u);
	public User putUser(String id, User u);
	public void deleteUser(String id);
	public Statistics computeCaloriesCountFromDates(String id, int init, int end);
	public User computeUserHealthData(User u);

}
