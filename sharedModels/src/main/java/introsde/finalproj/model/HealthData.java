package introsde.finalproj.model;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

import introsde.finalproj.dao.MyDao;

@XmlRootElement
@Embeddable
@NoSql(dataFormat=DataFormatType.MAPPED)
public class HealthData{	
	
	public enum Pal { LIGHT, MODERATE, HEAVY };

	private double weight = -1, height= -1, bmr= -1, bmi= -1, optimalWeight= -1;
	private int age=-1, dailyKCaloriesGoal= -1;
	private boolean sex = true, physicalActivity = false; // true : MAN | false : WOMAN
	private Pal pal = Pal.LIGHT;
	


	public HealthData() {
		// TODO Auto-generated constructor stub
	}	
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getBmr() {
		return bmr;
	}
	public void setBmr(double bmr) {
		this.bmr = bmr;
	}
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	public double getOptimalWeight() {
		return optimalWeight;
	}
	public void setOptimalWeight(double optimalWeight) {
		this.optimalWeight = optimalWeight;
	}
	public int getDailyKCaloriesGoal() {
		return dailyKCaloriesGoal;
	}
	public void setDailyKCaloriesGoal(int dailyKCaloriesGoal) {
		this.dailyKCaloriesGoal = dailyKCaloriesGoal;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isPhysicalActivity() {
		return physicalActivity;
	}

	public void setPhysicalActivity(boolean physicalActivity) {
		this.physicalActivity = physicalActivity;
	}

	public Pal getPal() {
		return pal;
	}

	public void setPal(Pal pal) {
		this.pal = pal;
	}
}