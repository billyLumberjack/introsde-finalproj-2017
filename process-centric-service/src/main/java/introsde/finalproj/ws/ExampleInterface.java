package introsde.finalproj.ws;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface ExampleInterface {
	
	@WebMethod(operationName="ciccioPasticcio")
    @WebResult(name="ciccioPasticcioResult")
	public String ciccioPasticcio();

}
