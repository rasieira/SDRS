
package agenda.gen;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the e2.gen package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddPersonResponse_QNAME = new QName("http://e1/", "addPersonResponse");
    private final static QName _GetNumber_QNAME = new QName("http://e1/", "getNumber");
    private final static QName _GetNumberResponse_QNAME = new QName("http://e1/", "getNumberResponse");
    private final static QName _AddPerson_QNAME = new QName("http://e1/", "addPerson");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: e2.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddPersonResponse }
     * 
     */
    public AddPersonResponse createAddPersonResponse() {
        return new AddPersonResponse();
    }

    /**
     * Create an instance of {@link GetNumber }
     * 
     */
    public GetNumber createGetNumber() {
        return new GetNumber();
    }

    /**
     * Create an instance of {@link GetNumberResponse }
     * 
     */
    public GetNumberResponse createGetNumberResponse() {
        return new GetNumberResponse();
    }

    /**
     * Create an instance of {@link AddPerson }
     * 
     */
    public AddPerson createAddPerson() {
        return new AddPerson();
    }

    /**
     * Create an instance of {@link Persona }
     * 
     */
    public Persona createPersona() {
        return new Persona();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://e1/", name = "addPersonResponse")
    public JAXBElement<AddPersonResponse> createAddPersonResponse(AddPersonResponse value) {
        return new JAXBElement<AddPersonResponse>(_AddPersonResponse_QNAME, AddPersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://e1/", name = "getNumber")
    public JAXBElement<GetNumber> createGetNumber(GetNumber value) {
        return new JAXBElement<GetNumber>(_GetNumber_QNAME, GetNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://e1/", name = "getNumberResponse")
    public JAXBElement<GetNumberResponse> createGetNumberResponse(GetNumberResponse value) {
        return new JAXBElement<GetNumberResponse>(_GetNumberResponse_QNAME, GetNumberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://e1/", name = "addPerson")
    public JAXBElement<AddPerson> createAddPerson(AddPerson value) {
        return new JAXBElement<AddPerson>(_AddPerson_QNAME, AddPerson.class, null, value);
    }

}
