package introsde.finalproj.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"name",
"id",
"aisle",
"image"
})
	public class AdapterFood {
	
	@JsonProperty("name")
	private String name;
	@JsonProperty("id")
	private int id;
	@JsonProperty("aisle")
	private String aisle;
	@JsonProperty("image")
	private String image;
	
	/**
	* No args constructor for use in serialization
	*
	*/
	public AdapterFood() {
	}
	
	@JsonProperty("image")
	public String getImage() {
	return name;
	}
	
	@JsonProperty("image")
	public void setImage(String image) {
	this.image = image;
	}
	
	@JsonProperty("name")
	public String getName() {
	return name;
	}
	
	@JsonProperty("name")
	public void setName(String name) {
	this.name = name;
	}
	
	@JsonProperty("id")
	public int getId() {
	return id;
	}
	
	@JsonProperty("id")
	public void setId(int id) {
	this.id = id;
	}
	
	@JsonProperty("aisle")
	public String getAisle() {
	return aisle;
	}
	
	@JsonProperty("aisle")
	public void setAisle(String aisle) {
	this.aisle = aisle;
	}
	
}