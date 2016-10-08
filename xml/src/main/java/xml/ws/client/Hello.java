
package xml.ws.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;

import static javax.jws.soap.SOAPBinding.Style.RPC;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(targetNamespace = "http://ws.xml/")
@SOAPBinding(style = RPC)
public interface Hello {

    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://ws.xml/Hello/sayHelloRequest", output = "http://ws.xml/Hello/sayHelloResponse")
    String sayHello(@WebParam(name = "arg0", partName = "arg0") String arg0);
}
