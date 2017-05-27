package introsde.finalproj.model;
/*
 * 	<exercise>
		<exerciseName>Cycling, <10 mph, leisure bicycling</exerciseName>
		<caloriesPerHour>4,002241255</caloriesPerHour>
	</exercise>
 */
public class Exercise {

	public Exercise() {
		// TODO Auto-generated constructor stub
	}
	private String exerciseName;
	private float caloriesPerHour;
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	public float getCaloriesPerHour() {
		return caloriesPerHour;
	}
	public void setCaloriesPerHour(float caloriesPerHour) {
		this.caloriesPerHour = caloriesPerHour;
	}
	
}
