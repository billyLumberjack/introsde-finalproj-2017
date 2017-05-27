package introsde.finalproj.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import introsde.finalproj.client.SsClient;
import introsde.finalproj.model.*;

@Path("/user")
public class UserAnalysisResource {
	
	/***************************************************************
	 * 		GET REQUESTS
	 ***************************************************************/    		

    @GET
    @Path("{userId}/calories-count")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public String computeCaloriesCountFromDates(@PathParam("userId") String id,
    		@DefaultValue("-1") @QueryParam("from") int init,
    		@DefaultValue("-1") @QueryParam("to") int end
    		){
    	int introdotte = 0, spese = 0;
    	// retrieve the food history from to
    	FoodHistory fh = SsClient.retrieveFoodHistoryByIntervalAndUserId(id, init, end);
    	// retrieve the activity history from to
    	ActivityHistory ah = SsClient.retrieveActivityHistoryByIntervalAndUserId(id, init, end);
    	// retrieve the baseline consumption
    	spese += SsClient.getHealthDataByUserId(id).getBmr();
    	// compute the sum and return
    	if(fh != null && ah != null){
	    	for(DailyFood df : fh.getDailyFood()){
	    		for(Food f : df.getFood())
	    			introdotte += f.getCalories();
	    	}
	    	for(DailyActivity da : ah.getDailyActivity()){
	    		for(Activity a: da.getActivity())
	    			spese += Integer.parseInt(a.getDetails().get("calories"));
	    	}
	    	return "{\"spese\":"+spese+", \"introdotte\":"+introdotte+", \"differenza\":"+(introdotte - spese)+"}";
    	}
    	else
    		return null;
    	
    	}   

    @POST
    @Path("health-data")
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	@Consumes({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public User computeUserHealthData(User user){
    	HealthData healthData = user.getHealthData();
    	// compute bmi
    	healthData.setBmi(computeBmi(healthData.getWeight(), healthData.getHeight()));
    	// compute bmr
    	healthData.setBmr(computeBmr(
    			healthData.isSex(),
    			healthData.getWeight(),
    			healthData.getHeight(),
    			healthData.getAge()
    			));
    	// compute optimal weight - MISSING
    	// compute goal
    	healthData.setDailyKCaloriesGoal((int) generateGoal(healthData));
    	// set health data
    	user.setHealthData(healthData);
    	// update user and return new user
    	return user;
    }    
    
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	@Consumes({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public void recommendActivities(){
    	// look for similar users and suggest their activities
    }
    
    @Produces({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
	@Consumes({MediaType.TEXT_XML,  MediaType.APPLICATION_JSON ,  MediaType.APPLICATION_XML })
    public void recommendFoods(){
    	// look for similar users and suggest their food
    }
    
    
    private double computeBmi(double weight, double height){
    	// to meters conversion
    	height /= 100;
    	// compute Quetelet index
    	return weight / (height * height);
    }
    
    private double computeBmr(boolean s, double w, double h, double a){
    	// MALE
    	// Harris & Benedict: 66,4730 + (13,7156 * W) + (5,033* H) - (6,775 * A)
    	// FEMALE
    	// Harris & Benedict: 655,095 + (9,5634 * W) + (1,849 * H) - (4,6756 * A)
    	if(s)
    		return 10 * w + 6.25 * h - 5 * a + 5; //66.4730 + (13.7156 * w) + (5.033* h) - (6.775 * a);
    	else
    		return 655.095 + (9.5634 * w) + (1.849 * h) - (4.6756 * a);
    }
    
    private double computeCaloricRequirement(HealthData hd){
/*
			Age 	PAL 		Active 	NOT Active
--------------------MALE----------------------------			
			18÷59	leggero		1,55 	1,41
					moderato	1,78 	1,70
					pesante		2,10 	2.01
			60÷74				1,51 	1,40
			≥ 75				1,51 	1,33
--------------------FEMALE----------------------------	
			18÷59	leggero		1,56	1,42
					moderato	1,60 	1,56
					pesante		1,82	1,73
			
			60÷74				1,56	1,44
			≥ 75				1,56	1,37
*/
    	double cr = hd.getBmr();
    	if(hd.isSex()){
    		// MALE
    		if(hd.getAge() <= 59){
    			if(hd.getPal() == HealthData.Pal.LIGHT){
    				if(hd.isPhysicalActivity())
    					cr *=1.55;
    				else
    					cr *=1.41;
    			} else if(hd.getPal() == HealthData.Pal.MODERATE){
    				if(hd.isPhysicalActivity())
    					cr *=1.78;
    				else
    					cr *=1.7;
    			} else {
    				if(hd.isPhysicalActivity())
    					cr *=2.1;
    				else
    					cr *=2.01;
    			}
    		} else if(hd.getAge() <= 74){
    			if(hd.isPhysicalActivity())
    				cr *=1.51;
    			else
    				cr *=1.4;
    		} else {
    			if(hd.isPhysicalActivity())
    				cr *=1.51;
    			else
    				cr *=1.33;    			
    		}
    	} else {
    		// FEMALE
    		if(hd.getAge() <= 59){
    			if(hd.getPal() == HealthData.Pal.LIGHT){
    				if(hd.isPhysicalActivity())
    					cr *=1.56;
    				else
    					cr *=1.42;
    			} else if(hd.getPal() == HealthData.Pal.MODERATE){
    				if(hd.isPhysicalActivity())
    					cr *=1.64;
    				else
    					cr *=1.56;
    			} else {
    				if(hd.isPhysicalActivity())
    					cr *=1.82;
    				else
    					cr *=1.73;
    			}
    		} else if(hd.getAge() <= 74){
    			if(hd.isPhysicalActivity())
    				cr *=1.56;
    			else
    				cr *=1.44;
    		} else {
    			if(hd.isPhysicalActivity())
    				cr *=1.56;
    			else
    				cr *=1.37;    			
    		}
    	}
    	return cr;
    }
    
    private double generateGoal(HealthData hd){
    	double caloric_requirement = computeCaloricRequirement(hd);
    	/*
	    	Sottopeso 			< 18,50			+ 500
	    	Intervallo normale 	18,50 - 24,99	0
	    	Sovrappeso: 		>= 25,00 		-500
	    	Preobeso 			25,00 - 29,99	-500
	    	Obeso classe I 		30,00 - 34,99	-500
	    	Obeso classe II 	35,00 - 39,99	-750
	    	Obeso classe III 	>= 40,00		-1000
    	*/
    	if(hd.getBmi() < 18.5)
    		return caloric_requirement + 500;
    	else if(hd.getBmi() < 25)
    		return caloric_requirement;
    	else if(hd.getBmi() < 30)
    		return caloric_requirement - 500;
    	else if(hd.getBmi() < 35)
    		return caloric_requirement - 500;
    	else if(hd.getBmi() < 40)
    		return caloric_requirement - 750;
    	else
    		return caloric_requirement - 1000;
    }   

}