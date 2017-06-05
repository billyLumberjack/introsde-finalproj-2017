package introsde.finalproj.ws;

import javax.jws.WebService;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import introsde.finalproj.client.BlClient;
import introsde.finalproj.client.SsClient;
import introsde.finalproj.model.Exercise;
import introsde.finalproj.model.Exercises;
import introsde.finalproj.model.HealthData;
import introsde.finalproj.model.User;

@WebService(endpointInterface = "introsde.finalproj.ws.ExerciseWsInterface")
public class ExerciseWsImpl implements ExerciseWsInterface{
	
	private SsClient ssClient = new SsClient(); 

	public Exercises getExercises() {
		try{

			return ssClient.getExercises();
		}
		catch(WebApplicationException e){
			return null;    		
		}   
	}

	
	
}
