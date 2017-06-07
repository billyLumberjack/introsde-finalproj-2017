package introsde.finalproj.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"spent",
	"introduced",
	"difference"
})
@XmlRootElement
public class Statistics {

	@JsonProperty("spent")
	private int spent;
	@JsonProperty("introduced")
	private int introduced;
	@JsonProperty("difference")
	private int difference;

	@JsonProperty("spent")
	public int getSpent() {
		return spent;
	}

	@JsonProperty("spent")
	public void setSpent(int spent) {
		this.spent = spent;
	}

	public Statistics withSpent(int spent) {
		this.spent = spent;
		return this;
	}

	@JsonProperty("introduced")
	public int getIntroduced() {
		return introduced;
	}

	@JsonProperty("introduced")
	public void setIntroduced(int introduced) {
		this.introduced = introduced;
	}

	public Statistics withIntroduced(int introduced) {
		this.introduced = introduced;
		return this;
	}

	@JsonProperty("difference")
	public int getDifference() {
		return difference;
	}

	@JsonProperty("difference")
	public void setDifference(int difference) {
		this.difference = difference;
	}

	public Statistics withDifference(int difference) {
		this.difference = difference;
		return this;
	}

}