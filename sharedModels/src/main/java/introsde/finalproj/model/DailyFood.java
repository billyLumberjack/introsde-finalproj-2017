package introsde.finalproj.model;

import java.util.List;

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
public class DailyFood
{
	
	
	@ElementCollection
	private List<Food> food = null;
	
	@JsonProperty
	private int date;

	public DailyFood() {
	}
	
	@JsonProperty("food")
	public List<Food> getFood() {
		return food;
	}

	@JsonProperty("food")
	public void setFood(List<Food> food) {
		this.food = food;
	}

	@JsonProperty
	public int getDate() {
		return date;
	}

	@JsonProperty
	public void setDate(int date) {
		this.date = date;
	}

}