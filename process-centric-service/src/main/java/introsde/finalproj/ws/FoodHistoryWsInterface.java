package introsde.finalproj.ws;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.ws.rs.core.Response;

import introsde.finalproj.model.FoodHistory;
import introsde.finalproj.model.HealthData;
import introsde.finalproj.model.User;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface FoodHistoryWsInterface {
	
	public FoodHistory getFoodHistoryFromInterval(int init, int end, String id);
	public FoodHistory getFoodHistoryFromIntervalAndUserId(int init, int end, String id);
	public FoodHistory postFoodHistory(FoodHistory fh);
	public FoodHistory putFoodHistory(String id, FoodHistory fh);
	public void deleteFoodHistory(String id);
}
