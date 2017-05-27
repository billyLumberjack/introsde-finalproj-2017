package introsde.finalproj.model;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@Embeddable
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Food
{
	
	@JsonProperty("name")
	private String name;
	@JsonProperty("quantity")
	private int quantity;
	@JsonProperty("unit")
	private String unit;
	@JsonProperty("calories")
	private int calories;

	public Food() {
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("quantity")
	public int getQuantity() {
		return quantity;
	}

	@JsonProperty("quantity")
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@JsonProperty("unit")
	public String getUnit() {
		return unit;
	}

	@JsonProperty("unit")
	public void setUnit(String unit) {
		this.unit = unit;
	}

	@JsonProperty("calories")
	public int getCalories() {
		return calories;
	}

	@JsonProperty("calories")
	public void setCalories(int calories) {
		this.calories = calories;
	}

}