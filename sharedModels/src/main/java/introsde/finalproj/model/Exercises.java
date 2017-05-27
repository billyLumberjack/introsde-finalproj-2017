package introsde.finalproj.model;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="exercises")
public class Exercises {

	private List<Exercise> exercise;
	
	public Exercises() {
		super();
	}

	public List<Exercise> getExercise() {
		return exercise;
	}

	public void setExercise(List<Exercise> exercise) {
		this.exercise = exercise;
	}	
}