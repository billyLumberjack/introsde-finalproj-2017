package introsde.finalproj.ws;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.ws.rs.core.Response;

import introsde.finalproj.model.ActivityHistory;
import introsde.finalproj.model.HealthData;
import introsde.finalproj.model.User;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface ActivityWsInterface {
	public ActivityHistory getActivityHistoryFromInterval(int init, int end, String id);
	public ActivityHistory getActivityHistoryFromIntervalAndUserId(int init, int end, String id);
	public ActivityHistory postActivityHistory(ActivityHistory ah);
	public ActivityHistory putActivityHistory(String id, ActivityHistory ah);
	public void deleteActivityHistory(String id);
}
