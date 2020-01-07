
package agenda.gen;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AgendaTfno", targetNamespace = "http://e1/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AgendaTfno {


    /**
     * 
     * @param person
     */
    @WebMethod
    @RequestWrapper(localName = "addPerson", targetNamespace = "http://e1/", className = "e2.gen.AddPerson")
    @ResponseWrapper(localName = "addPersonResponse", targetNamespace = "http://e1/", className = "e2.gen.AddPersonResponse")
    @Action(input = "http://e1/AgendaTfno/addPersonRequest", output = "http://e1/AgendaTfno/addPersonResponse")
    public void addPerson(
        @WebParam(name = "person", targetNamespace = "")
        Persona person);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getNumber", targetNamespace = "http://e1/", className = "e2.gen.GetNumber")
    @ResponseWrapper(localName = "getNumberResponse", targetNamespace = "http://e1/", className = "e2.gen.GetNumberResponse")
    @Action(input = "http://e1/AgendaTfno/getNumberRequest", output = "http://e1/AgendaTfno/getNumberResponse")
    public String getNumber(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}