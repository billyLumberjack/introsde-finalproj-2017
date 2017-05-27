package introsde.finalproj.client;

import javax.ws.rs.WebApplicationException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MyClient {
	
	
	protected static Client c = Client.create();
	public enum HttpMethods { GET, POST, PUT, DELETE};	
	
	protected static ClientResponse finalMethod(String url, HttpMethods method) throws WebApplicationException{
		return finalMethod(url,method,null);
	}

	protected static ClientResponse finalMethod(String url, HttpMethods method, Object o) throws WebApplicationException{
		System.out.println(method + " " + url);

		WebResource wr = c.resource(url);

		ClientResponse response = null;
		if(method == HttpMethods.GET)
			response = wr.accept("application/json").get(ClientResponse.class);
		else if(method == HttpMethods.POST)
			response = wr.accept("application/json").header("Content-Type","application/json").post(ClientResponse.class,o);
		else if(method == HttpMethods.PUT)
			response = wr.accept("application/json").header("Content-Type","application/json").put(ClientResponse.class,o);
		else if(method == HttpMethods.DELETE)
			response = wr.accept("application/json").delete(ClientResponse.class);
		
		if(response.getClientResponseStatus() != ClientResponse.Status.OK)
			throw new WebApplicationException(response.getStatus());			

		return response;
	}
}
