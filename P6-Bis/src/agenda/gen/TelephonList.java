
package agenda.gen;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "TelephonList", targetNamespace = "http://e1/", wsdlLocation = "http://localhost:8080/TelephonList?wsdl")
public class TelephonList
    extends Service
{

    private final static URL TELEPHONLIST_WSDL_LOCATION;
    private final static WebServiceException TELEPHONLIST_EXCEPTION;
    private final static QName TELEPHONLIST_QNAME = new QName("http://e1/", "TelephonList");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/TelephonList?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TELEPHONLIST_WSDL_LOCATION = url;
        TELEPHONLIST_EXCEPTION = e;
    }

    public TelephonList() {
        super(__getWsdlLocation(), TELEPHONLIST_QNAME);
    }

    public TelephonList(WebServiceFeature... features) {
        super(__getWsdlLocation(), TELEPHONLIST_QNAME, features);
    }

    public TelephonList(URL wsdlLocation) {
        super(wsdlLocation, TELEPHONLIST_QNAME);
    }

    public TelephonList(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TELEPHONLIST_QNAME, features);
    }

    public TelephonList(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TelephonList(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AgendaTfno
     */
    @WebEndpoint(name = "AgendaTfnoPort")
    public AgendaTfno getAgendaTfnoPort() {
        return super.getPort(new QName("http://e1/", "AgendaTfnoPort"), AgendaTfno.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AgendaTfno
     */
    @WebEndpoint(name = "AgendaTfnoPort")
    public AgendaTfno getAgendaTfnoPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://e1/", "AgendaTfnoPort"), AgendaTfno.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TELEPHONLIST_EXCEPTION!= null) {
            throw TELEPHONLIST_EXCEPTION;
        }
        return TELEPHONLIST_WSDL_LOCATION;
    }

}
