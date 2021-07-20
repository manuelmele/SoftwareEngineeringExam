
package soapwsclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soapwsclient.generated package. 
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

    private final static QName _AddSeller_QNAME = new QName("http://soapws.softeng.sapienza.it/", "addSeller");
    private final static QName _AddSellerResponse_QNAME = new QName("http://soapws.softeng.sapienza.it/", "addSellerResponse");
    private final static QName _GetSellers_QNAME = new QName("http://soapws.softeng.sapienza.it/", "getSellers");
    private final static QName _GetSellersResponse_QNAME = new QName("http://soapws.softeng.sapienza.it/", "getSellersResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soapwsclient.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddSeller }
     * 
     */
    public AddSeller createAddSeller() {
        return new AddSeller();
    }

    /**
     * Create an instance of {@link AddSellerResponse }
     * 
     */
    public AddSellerResponse createAddSellerResponse() {
        return new AddSellerResponse();
    }

    /**
     * Create an instance of {@link GetSellers }
     * 
     */
    public GetSellers createGetSellers() {
        return new GetSellers();
    }

    /**
     * Create an instance of {@link GetSellersResponse }
     * 
     */
    public GetSellersResponse createGetSellersResponse() {
        return new GetSellersResponse();
    }

    /**
     * Create an instance of {@link SellerMap }
     * 
     */
    public SellerMap createSellerMap() {
        return new SellerMap();
    }

    /**
     * Create an instance of {@link SellerEntry }
     * 
     */
    public SellerEntry createSellerEntry() {
        return new SellerEntry();
    }

    /**
     * Create an instance of {@link Seller }
     * 
     */
    public Seller createSeller() {
        return new Seller();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSeller }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddSeller }{@code >}
     */
    @XmlElementDecl(namespace = "http://soapws.softeng.sapienza.it/", name = "addSeller")
    public JAXBElement<AddSeller> createAddSeller(AddSeller value) {
        return new JAXBElement<AddSeller>(_AddSeller_QNAME, AddSeller.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSellerResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddSellerResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soapws.softeng.sapienza.it/", name = "addSellerResponse")
    public JAXBElement<AddSellerResponse> createAddSellerResponse(AddSellerResponse value) {
        return new JAXBElement<AddSellerResponse>(_AddSellerResponse_QNAME, AddSellerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSellers }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSellers }{@code >}
     */
    @XmlElementDecl(namespace = "http://soapws.softeng.sapienza.it/", name = "getSellers")
    public JAXBElement<GetSellers> createGetSellers(GetSellers value) {
        return new JAXBElement<GetSellers>(_GetSellers_QNAME, GetSellers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSellersResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSellersResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soapws.softeng.sapienza.it/", name = "getSellersResponse")
    public JAXBElement<GetSellersResponse> createGetSellersResponse(GetSellersResponse value) {
        return new JAXBElement<GetSellersResponse>(_GetSellersResponse_QNAME, GetSellersResponse.class, null, value);
    }

}
