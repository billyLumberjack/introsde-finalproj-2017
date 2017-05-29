package introsde.finalproj.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "introsde.finalproj.ws.ExampleInterface")
public class ExampleImplementation implements ExampleInterface{
	//@Override
	public String ciccioPasticcio() {
		return "manna";
	}

}
