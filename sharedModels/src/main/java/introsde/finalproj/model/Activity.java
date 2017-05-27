package introsde.finalproj.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@Embeddable
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Activity{	
	/*
	 * @ElementCollection
	 * @MapKey(name="someProp")
	 */
	@JsonProperty
	private Map<String,String> details = new HashMap<String, String>();
	
	public Activity() {
		// TODO Auto-generated constructor stub
	}


	@JsonProperty
	public Map<String, String> getDetails() {
		return details;
	}

	@JsonProperty
	public void setDetails(Map<String, String> details) {
		this.details = details;
	}
}