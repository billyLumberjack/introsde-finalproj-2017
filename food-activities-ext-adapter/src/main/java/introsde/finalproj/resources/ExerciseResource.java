package introsde.finalproj.resources;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import introsde.finalproj.model.Exercises;

@Path("/activity-info")
public class ExerciseResource {
	
	/***************************************************************
	 * 		GET REQUESTS
	 * @return 
	 ***************************************************************/    	
	
    @GET
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public Exercises getExercises() {
    	try {
    		System.out.println("Getting exercises list");
    		
    		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    		InputStream is = classLoader.getResourceAsStream("/exercises.xml");

    		JAXBContext context = JAXBContext.newInstance(Exercises.class);
    		Unmarshaller unmarshaller = context.createUnmarshaller();
    		Exercises exercises = (Exercises) unmarshaller.unmarshal(is);

    		return exercises;
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    	
    }   
    
    
}
