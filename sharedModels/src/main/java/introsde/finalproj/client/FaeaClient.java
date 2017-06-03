package introsde.finalproj.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import introsde.finalproj.client.MyClient;
import introsde.finalproj.model.Exercises;

public class FaeaClient extends MyClient{
	private String ENDPOINT = null;
	
	public FaeaClient(){
		
		Properties prop = new Properties();
		InputStream input = null;

		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			input = classLoader.getResourceAsStream("/config.properties");

			// load a properties file
			prop.load(input);
			
			ENDPOINT = prop.getProperty("food-activities-ext-adapter-url") + "/rest";

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
	

	public Exercises getExercises(){
		String url = ENDPOINT + "/activity-info";
		return finalMethod(url, HttpMethods.GET).getEntity(Exercises.class);		
	}
	public String searchFood(String searchStr){
		String url = ENDPOINT + "/food-info/search/"+searchStr;
		return finalMethod(url, HttpMethods.GET).getEntity(String.class);		
	}
	public String getFoodInfo(String foodId){
		String url = ENDPOINT + "/food-info/"+foodId;
		return finalMethod(url, HttpMethods.GET).getEntity(String.class);		
	}

}
