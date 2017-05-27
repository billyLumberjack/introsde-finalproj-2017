package introsde.finalproj.model;

import java.util.ArrayList;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

import com.fasterxml.jackson.annotation.JsonProperty;

import introsde.finalproj.dao.MyDao;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
@NoSql(dataFormat=DataFormatType.MAPPED)
public class DailyActivity {

	@JsonProperty
	private int date;
	
	@ElementCollection
	private ArrayList<Activity> activity = null;
	
	public DailyActivity() {
	}
	
	@JsonProperty
	public int getDate() {
		return date;
	}
	@JsonProperty
	public void setDate(int date) {
		this.date = date;
	}
	@JsonProperty
	public ArrayList<Activity> getActivity() {
		return activity;
	}
	@JsonProperty
	public void setActivity(ArrayList<Activity> activity) {
		this.activity = activity;
	}
	
}
