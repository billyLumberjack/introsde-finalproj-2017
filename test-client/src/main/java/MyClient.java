import introsde.finalproj.ws.AdapterFoodDetails;
import introsde.finalproj.ws.ExerciseWsImplService;
import introsde.finalproj.ws.ExerciseWsInterface;
import introsde.finalproj.ws.FoodHistoryWsImplService;
import introsde.finalproj.ws.FoodHistoryWsInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import introsde.finalproj.ws.ActivityWsImplService;
import introsde.finalproj.ws.ActivityWsInterface;
import introsde.finalproj.ws.FoodWsImplService;
import introsde.finalproj.ws.FoodWsInterface;
import introsde.finalproj.ws.HealthData;
import introsde.finalproj.ws.Pal;
import introsde.finalproj.ws.User;
import introsde.finalproj.ws.UserWsImplService;
import introsde.finalproj.ws.UserWsInterface;

public class MyClient {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static FoodWsImplService foodServiceImpl = new FoodWsImplService(); 
	private static FoodWsInterface foodService = foodServiceImpl.getFoodWsImplPort();

	private static UserWsImplService userServiceImpl = new UserWsImplService(); 
	private static UserWsInterface userService = userServiceImpl.getUserWsImplPort();

	private static ActivityWsImplService activityServiceImpl = new ActivityWsImplService(); 
	private static ActivityWsInterface activityService = activityServiceImpl.getActivityWsImplPort();

	private static FoodHistoryWsImplService foodHistoryServiceImpl = new FoodHistoryWsImplService(); 
	private static FoodHistoryWsInterface foodHistoryService = foodHistoryServiceImpl.getFoodHistoryWsImplPort();

	private static ExerciseWsImplService exerciseServiceImpl = new ExerciseWsImplService(); 
	private static ExerciseWsInterface exerciseService = exerciseServiceImpl.getExerciseWsImplPort();

	private static User init(){
		while(true){
			System.out.println("Press,");
			System.out.println("1. To create a new User");
			System.out.println("2. To enter your user id");

			try {  
				switch(br.readLine()){
				case "1":
					return newUser();
				case "2":
					return existentUser();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
	}

	private static User existentUser() throws IOException {
		System.out.println("please enter your user _id");
		return userService.getUserById(br.readLine(), -1, -1);
	}

	private static User newUser() throws IOException {
		User u = new User();
		HealthData hd = new HealthData();

		System.out.println("enter your username");
		u.setUsername(br.readLine());

		System.out.println("enter your password");
		u.setPassword(br.readLine());

		System.out.println("enter your sex");
		System.out.println("1. Woman");
		System.out.println("2. Men");
		switch(br.readLine()){
		case "1":
			hd.setSex(false);
		case "2":
			hd.setSex(true);
		default:
			hd.setSex(true);
		}
		System.out.println("enter your age");
		hd.setAge(Integer.parseInt(br.readLine()));
		System.out.println("enter your height");
		hd.setHeight(Integer.parseInt(br.readLine()));
		System.out.println("enter your weight");
		hd.setWeight(Integer.parseInt(br.readLine()));
		
		System.out.println("do you practice sport?");
		System.out.println("1. yes");
		System.out.println("2. no");
		switch(br.readLine()){
		case "1":
			hd.setPhysicalActivity(true);
		case "2":
			hd.setPhysicalActivity(false);
		default:	
			hd.setPhysicalActivity(false);
		}

		System.out.println("enter your Physical Activity Level");
		System.out.println("1. LIGHT");
		System.out.println("2. MODERATE");
		System.out.println("3. HEAVY");
		switch(br.readLine()){
		case "1":
			hd.setPal(Pal.LIGHT);
		case "2":
			hd.setPal(Pal.MODERATE);
		case "3":
			hd.setPal(Pal.HEAVY);
		default:	
			hd.setPal(Pal.LIGHT);
		}
		
		u.setHealthData(hd);
		

		return userService.postUser(u);
	}

	public static void main(String[] args) {


			User u = init();
			
			System.out.println(u.getId());
			/*
			User u = new User();
			u.setUsername("myUsername");
			u.setPassword("");

			HealthData hd = new HealthData();
			hd.setAge(arg0);
			hd.setWeight(arg0);
			hd.setHeight(arg0);
			hd.setPal(arg0);
			hd.setPhysicalActivity(arg0);
			hd.setSex(arg0);
			 */
	}

}
