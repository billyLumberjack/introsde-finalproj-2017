package introsde.finalproj.ws;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.ws.rs.core.Response;

import introsde.finalproj.model.AdapterFoodDetails;
import introsde.finalproj.model.AdapterFoods;
import introsde.finalproj.model.Food;
import introsde.finalproj.model.HealthData;
import introsde.finalproj.model.User;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface FoodWsInterface {
	
	public AdapterFoods searchFood(String str);
	public AdapterFoodDetails getFoodInfo(String str);

}
