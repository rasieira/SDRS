
package biblioteca.gen;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the biblioteca.gen package. 
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

    private final static QName _AddLibro_QNAME = new QName("http://biblioteca/", "addLibro");
    private final static QName _GetNombre_QNAME = new QName("http://biblioteca/", "getNombre");
    private final static QName _GetNombreResponse_QNAME = new QName("http://biblioteca/", "getNombreResponse");
    private final static QName _SetNombre_QNAME = new QName("http://biblioteca/", "setNombre");
    private final static QName _AddLibroResponse_QNAME = new QName("http://biblioteca/", "addLibroResponse");
    private final static QName _GetLibro_QNAME = new QName("http://biblioteca/", "getLibro");
    private final static QName _GetLibroResponse_QNAME = new QName("http://biblioteca/", "getLibroResponse");
    private final static QName _SetNombreResponse_QNAME = new QName("http://biblioteca/", "setNombreResponse");
    private final static QName _GetLibros_QNAME = new QName("http://biblioteca/", "getLibros");
    private final static QName _GetLibrosResponse_QNAME = new QName("http://biblioteca/", "getLibrosResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: biblioteca.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddLibro }
     * 
     */
    public AddLibro createAddLibro() {
        return new AddLibro();
    }

    /**
     * Create an instance of {@link GetNombre }
     * 
     */
    public GetNombre createGetNombre() {
        return new GetNombre();
    }

    /**
     * Create an instance of {@link GetNombreResponse }
     * 
     */
    public GetNombreResponse createGetNombreResponse() {
        return new GetNombreResponse();
    }

    /**
     * Create an instance of {@link SetNombre }
     * 
     */
    public SetNombre createSetNombre() {
        return new SetNombre();
    }

    /**
     * Create an instance of {@link AddLibroResponse }
     * 
     */
    public AddLibroResponse createAddLibroResponse() {
        return new AddLibroResponse();
    }

    /**
     * Create an instance of {@link GetLibro }
     * 
     */
    public GetLibro createGetLibro() {
        return new GetLibro();
    }

    /**
     * Create an instance of {@link GetLibroResponse }
     * 
     */
    public GetLibroResponse createGetLibroResponse() {
        return new GetLibroResponse();
    }

    /**
     * Create an instance of {@link SetNombreResponse }
     * 
     */
    public SetNombreResponse createSetNombreResponse() {
        return new SetNombreResponse();
    }

    /**
     * Create an instance of {@link GetLibrosResponse }
     * 
     */
    public GetLibrosResponse createGetLibrosResponse() {
        return new GetLibrosResponse();
    }

    /**
     * Create an instance of {@link GetLibros }
     * 
     */
    public GetLibros createGetLibros() {
        return new GetLibros();
    }

    /**
     * Create an instance of {@link Libro }
     * 
     */
    public Libro createLibro() {
        return new Libro();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLibro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://biblioteca/", name = "addLibro")
    public JAXBElement<AddLibro> createAddLibro(AddLibro value) {
        return new JAXBElement<AddLibro>(_AddLibro_QNAME, AddLibro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNombre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://biblioteca/", name = "getNombre")
    public JAXBElement<GetNombre> createGetNombre(GetNombre value) {
        return new JAXBElement<GetNombre>(_GetNombre_QNAME, GetNombre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNombreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://biblioteca/", name = "getNombreResponse")
    public JAXBElement<GetNombreResponse> createGetNombreResponse(GetNombreResponse value) {
        return new JAXBElement<GetNombreResponse>(_GetNombreResponse_QNAME, GetNombreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNombre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://biblioteca/", name = "setNombre")
    public JAXBElement<SetNombre> createSetNombre(SetNombre value) {
        return new JAXBElement<SetNombre>(_SetNombre_QNAME, SetNombre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLibroResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://biblioteca/", name = "addLibroResponse")
    public JAXBElement<AddLibroResponse> createAddLibroResponse(AddLibroResponse value) {
        return new JAXBElement<AddLibroResponse>(_AddLibroResponse_QNAME, AddLibroResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLibro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://biblioteca/", name = "getLibro")
    public JAXBElement<GetLibro> createGetLibro(GetLibro value) {
        return new JAXBElement<GetLibro>(_GetLibro_QNAME, GetLibro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLibroResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://biblioteca/", name = "getLibroResponse")
    public JAXBElement<GetLibroResponse> createGetLibroResponse(GetLibroResponse value) {
        return new JAXBElement<GetLibroResponse>(_GetLibroResponse_QNAME, GetLibroResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNombreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://biblioteca/", name = "setNombreResponse")
    public JAXBElement<SetNombreResponse> createSetNombreResponse(SetNombreResponse value) {
        return new JAXBElement<SetNombreResponse>(_SetNombreResponse_QNAME, SetNombreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLibros }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://biblioteca/", name = "getLibros")
    public JAXBElement<GetLibros> createGetLibros(GetLibros value) {
        return new JAXBElement<GetLibros>(_GetLibros_QNAME, GetLibros.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLibrosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://biblioteca/", name = "getLibrosResponse")
    public JAXBElement<GetLibrosResponse> createGetLibrosResponse(GetLibrosResponse value) {
        return new JAXBElement<GetLibrosResponse>(_GetLibrosResponse_QNAME, GetLibrosResponse.class, null, value);
    }

}
