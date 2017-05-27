package introsde.finalproj.faea_client;

import introsde.finalproj.client.MyClient;
import introsde.finalproj.model.Exercises;

public class FaeaClient extends MyClient{
	private static final String ENDPOINT = "http://localhost:8080/food-activities-ext-adapter/rest";
	

	public static Exercises getExercises(){
		String url = ENDPOINT + "/activity-info";
		return finalMethod(url, HttpMethods.GET).getEntity(Exercises.class);		
	}
	public static String searchFood(String searchStr){
		String url = ENDPOINT + "/food-info/search/"+searchStr;
		return finalMethod(url, HttpMethods.GET).getEntity(String.class);		
	}
	public static String getFoodInfo(String foodId){
		String url = ENDPOINT + "/food-info/"+foodId;
		return finalMethod(url, HttpMethods.GET).getEntity(String.class);		
	}

}
