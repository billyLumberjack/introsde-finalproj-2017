package introsde.finalproj.model;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AdapterFoods {

	private List<AdapterFood> adapterFood;
	
	public AdapterFoods() {
		super();
	}

	public List<AdapterFood> getFood() {
		return adapterFood;
	}

	public void setFood(List<AdapterFood> ff) {
		this.adapterFood = ff;
	}	
}