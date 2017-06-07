import introsde.finalproj.ws.AdapterFoodDetails;
import introsde.finalproj.ws.AdapterFoods;
import introsde.finalproj.ws.DailyActivity;
import introsde.finalproj.ws.DailyFood;
import introsde.finalproj.ws.Exercise;
import introsde.finalproj.ws.ExerciseWsImplService;
import introsde.finalproj.ws.ExerciseWsInterface;
import introsde.finalproj.ws.Exercises;
import introsde.finalproj.ws.Food;
import introsde.finalproj.ws.FoodHistoryWsImplService;
import introsde.finalproj.ws.FoodHistoryWsInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;

import introsde.finalproj.ws.Activity;
import introsde.finalproj.ws.Activity.Details;
import introsde.finalproj.ws.Activity.Details.Entry;
import introsde.finalproj.ws.ActivityWsImplService;
import introsde.finalproj.ws.ActivityWsInterface;
import introsde.finalproj.ws.AdapterFood;
import introsde.finalproj.ws.FoodWsImplService;
import introsde.finalproj.ws.FoodWsInterface;
import introsde.finalproj.ws.HealthData;
import introsde.finalproj.ws.Pal;
import introsde.finalproj.ws.Statistics;
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
			break;
		case "2":
			hd.setSex(true);
			break;
		default:
			hd.setSex(true);
			break;
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
			break;
		case "2":
			hd.setPhysicalActivity(false);
			break;
		default:	
			hd.setPhysicalActivity(false);
			break;
		}

		System.out.println("enter your Physical Activity Level");
		System.out.println("1. LIGHT");
		System.out.println("2. MODERATE");
		System.out.println("3. HEAVY");
		switch(br.readLine()){
		case "1":
			hd.setPal(Pal.LIGHT);
			break;
		case "2":
			hd.setPal(Pal.MODERATE);
			break;
		case "3":
			hd.setPal(Pal.HEAVY);
			break;
		default:	
			hd.setPal(Pal.LIGHT);
			break;
		}

		u.setHealthData(hd);


		return userService.postUser(u);
	}

	private static void editProfile(User u) {
		// TODO Auto-generated method stub

	}

	private static void newActivity(User u) {
		String repeat = "no";
		DailyActivity da = new DailyActivity();
		da.setDate((int) (System.currentTimeMillis() / 1000L));
		do{
			try{
				Activity a = new Activity();

				System.out.println("------------ SPORTS LIST ---------------------");

				List<Exercise> ee = exerciseService.getExercises().getExercise();
				for(int c=0; c<ee.size(); c++){
					System.out.format("%5d. %40s %20s %10s\n",c, ee.get(c).getExerciseName(), ee.get(c).getCaloriesPerHour(), "calories / hour * kilo");
				}
				System.out.println("enter the id of your sport");
				int choice = Integer.parseInt(br.readLine());

				Entry e;
				Details dd = new Details();
				a.setDetails(dd);
				System.out.println("enter the duration of your training (minutes)");
				int duration = Integer.parseInt(br.readLine());
				e = new Entry();
				e.setKey("daration");
				e.setValue(String.valueOf(duration));



				a.getDetails().getEntry().add(e);
				e = new Entry();
				e.setKey("duration_unit");
				e.setValue("minutes");
				a.getDetails().getEntry().add(e);

				System.out.println((float) duration+" "+u.getHealthData().getWeight()+" "+ee.get(choice).getCaloriesPerHour());

				double calories = (double) duration * u.getHealthData().getWeight() * (double) ee.get(choice).getCaloriesPerHour();
				e = new Entry();
				e.setKey("calories");
				e.setValue(String.valueOf(calories));
				a.getDetails().getEntry().add(e);

				e = new Entry();

				e.setKey("type");
				e.setValue(ee.get(choice).getExerciseName());
				a.getDetails().getEntry().add(e);					

				da.getActivity().add(a);

				System.out.println("Would you like to add another training? (yes/no)");
				repeat = br.readLine();


			}
			catch(Exception e){
				e.printStackTrace();
			}


		}while(repeat.equals("yes"));

		u.getActivityHistory().getDailyActivity().add(da);
		activityService.putActivityHistory(u.getActivityHistory().getId(), u.getActivityHistory());




	}

	private static void newMeal(User u) {
		try{
			String repeat = "no";

			DailyFood df = new DailyFood();
			df.setDate((int) (System.currentTimeMillis() / 1000L));

			do{
				System.out.println("insert food to look for");
				String qry = br.readLine();

				for(AdapterFood f : foodService.searchFood(qry).getFood()){
					System.out.format("%10s.%25s - %25s\n", f.getId(),f.getName(), f.getAisle());
				}
				System.out.println();

				System.out.println("insert food id to get details");

				AdapterFoodDetails afd = foodService.getFoodInfo(br.readLine());

				System.out.format("%10s.\t%s - %s\n", afd.getId(),afd.getName(),afd.getAisle());
				System.out.format("%10s %10s\n", afd.getAmount(), afd.getUnit());

				System.out.format("%20s%20s\n", "calories", afd.getNutrition().getNutrients().get(0).getAmount());

				System.out.format("%20s%20s\n", "carbs percent", afd.getNutrition().getCaloricBreakdown().getPercentCarbs());
				System.out.format("%20s%20s\n", "protein percent", afd.getNutrition().getCaloricBreakdown().getPercentProtein());
				System.out.format("%20s%20s\n", "fat percent", afd.getNutrition().getCaloricBreakdown().getPercentFat());


				System.out.println("do you want do add this food to your meal? (yes/no)");

				if(br.readLine().equals("yes")){
					int calorie = (int) Float.parseFloat(afd.getNutrition().getNutrients().get(0).getAmount());
					int suTotale = (int) Float.parseFloat(afd.getAmount());

					Food food = new Food();

					System.out.println("please set the quantity in " + afd.getUnit());
					int qty = Integer.parseInt(br.readLine());

					food.setQuantity(qty);
					food.setCalories( (qty/suTotale)*calorie );
					food.setUnit(afd.getUnit());
					food.setName(afd.getName());
					df.getFood().add(food);
				}

				System.out.println("Would you like to add something else? (yes/no)");
				repeat = br.readLine();
			}while(repeat.equals("yes"));

			u.getFoodHistory().getDailyFood().add(df);
			foodHistoryService.putFoodHistory(u.getFoodHistory().getId(), u.getFoodHistory());



		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void showStatistics(User u) {
		try{
			int init = -1, end = -1;
			System.out.println("enter interval date for statistics");
			System.out.println("from date (-1 to avoid): ");
			try{
				init = Integer.parseInt(br.readLine());

				System.out.println("to date (-1 to avoid): ");
				end = Integer.parseInt(br.readLine());
			}
			catch(NumberFormatException e){
				e.printStackTrace();

			}

			Statistics s = userService.computeCaloriesCountFromDates(u.getId(), init, end);

			System.out.format("%20s %20s\n","introduced calories", s.getIntroduced());
			System.out.format("%20s %20s\n","spent calories", s.getSpent());
			System.out.format("%20s %20s\n","difference", s.getDifference());

		}catch(Exception e){
			e.printStackTrace();
		}

	}

	private static void showActivities(User u) {
		for(DailyActivity da : u.getActivityHistory().getDailyActivity()){
			System.out.println("Date: " + da.getDate());

			for(Activity a : da.getActivity()){
				for(Entry e : a.getDetails().getEntry()){
					System.out.format("%20s %20s\n",e.getKey(),e.getValue());
				}
				System.out.println();
			}
			System.out.println("------------------------------------------------------------\n");

		}

	}

	private static void showMeals(User u) {

		for(DailyFood df : u.getFoodHistory().getDailyFood()){
			System.out.println("Date: " + df.getDate());

			for(Food f : df.getFood()){
				System.out.format("%20s", f.getName());
			}
			System.out.println();

			for(Food f : df.getFood()){
				System.out.format("%15s%5s", f.getQuantity() , " " + f.getUnit());
			}
			System.out.println();

			for(Food f : df.getFood()){
				System.out.format("%15s%5s", f.getCalories() , " Kcal");
			}	
			System.out.println("\n------------------------------------------------------------");

		}

	}

	public static void main(String[] args) {
		String quit = "no";
		User u = init();

		do{
			try{
				System.out.println("Press:");
				System.out.println("1. to display your meals");
				System.out.println("2. to display your activities");
				System.out.println("3. to display your statistics");
				System.out.println("4. insert a new meal");
				System.out.println("5. insert a new activity");

				switch(br.readLine()){
				case "1":
					//show my meals
					showMeals(u);
					break;
				case "2":
					//show my activities
					showActivities(u);
					break;
				case "3":
					// show my calories
					showStatistics(u);
					break;
				case "4":
					// insert meal
					newMeal(u);
					break;
				case "5":
					//insert activity
					newActivity(u);
					break;
				}
				
				System.out.println("would you like to do something else? (yes/no)");
				quit = br.readLine();
				
			}
			catch(Exception e){
				e.printStackTrace();
			}

		}while(quit.equals("yes"));
	}

}
