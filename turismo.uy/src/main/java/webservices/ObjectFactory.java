
package webservices;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservices package. 
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

    private final static QName _CompraFailException_QNAME = new QName("http://webservices/", "CompraFailException");
    private final static QName _DocumentException_QNAME = new QName("http://webservices/", "DocumentException");
    private final static QName _Exception_QNAME = new QName("http://webservices/", "Exception");
    private final static QName _IOException_QNAME = new QName("http://webservices/", "IOException");
    private final static QName _InscriptionFailException_QNAME = new QName("http://webservices/", "InscriptionFailException");
    private final static QName _YaExisteException_QNAME = new QName("http://webservices/", "YaExisteException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DtCompra }
     * 
     * @return
     *     the new instance of {@link DtCompra }
     */
    public DtCompra createDtCompra() {
        return new DtCompra();
    }

    /**
     * Create an instance of {@link DtCompra.Disponibles }
     * 
     * @return
     *     the new instance of {@link DtCompra.Disponibles }
     */
    public DtCompra.Disponibles createDtCompraDisponibles() {
        return new DtCompra.Disponibles();
    }

    /**
     * Create an instance of {@link CompraFailException }
     * 
     * @return
     *     the new instance of {@link CompraFailException }
     */
    public CompraFailException createCompraFailException() {
        return new CompraFailException();
    }

    /**
     * Create an instance of {@link DocumentException }
     * 
     * @return
     *     the new instance of {@link DocumentException }
     */
    public DocumentException createDocumentException() {
        return new DocumentException();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     * @return
     *     the new instance of {@link Exception }
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     * @return
     *     the new instance of {@link IOException }
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link InscriptionFailException }
     * 
     * @return
     *     the new instance of {@link InscriptionFailException }
     */
    public InscriptionFailException createInscriptionFailException() {
        return new InscriptionFailException();
    }

    /**
     * Create an instance of {@link YaExisteException }
     * 
     * @return
     *     the new instance of {@link YaExisteException }
     */
    public YaExisteException createYaExisteException() {
        return new YaExisteException();
    }

    /**
     * Create an instance of {@link DtInscripcion }
     * 
     * @return
     *     the new instance of {@link DtInscripcion }
     */
    public DtInscripcion createDtInscripcion() {
        return new DtInscripcion();
    }

    /**
     * Create an instance of {@link DtUsuario }
     * 
     * @return
     *     the new instance of {@link DtUsuario }
     */
    public DtUsuario createDtUsuario() {
        return new DtUsuario();
    }

    /**
     * Create an instance of {@link DtSalida }
     * 
     * @return
     *     the new instance of {@link DtSalida }
     */
    public DtSalida createDtSalida() {
        return new DtSalida();
    }

    /**
     * Create an instance of {@link InscripcionDao }
     * 
     * @return
     *     the new instance of {@link InscripcionDao }
     */
    public InscripcionDao createInscripcionDao() {
        return new InscripcionDao();
    }

    /**
     * Create an instance of {@link SalidaDao }
     * 
     * @return
     *     the new instance of {@link SalidaDao }
     */
    public SalidaDao createSalidaDao() {
        return new SalidaDao();
    }

    /**
     * Create an instance of {@link ActividadDao }
     * 
     * @return
     *     the new instance of {@link ActividadDao }
     */
    public ActividadDao createActividadDao() {
        return new ActividadDao();
    }

    /**
     * Create an instance of {@link ProveedorDao }
     * 
     * @return
     *     the new instance of {@link ProveedorDao }
     */
    public ProveedorDao createProveedorDao() {
        return new ProveedorDao();
    }

    /**
     * Create an instance of {@link UsuarioDao }
     * 
     * @return
     *     the new instance of {@link UsuarioDao }
     */
    public UsuarioDao createUsuarioDao() {
        return new UsuarioDao();
    }

    /**
     * Create an instance of {@link DtActividad }
     * 
     * @return
     *     the new instance of {@link DtActividad }
     */
    public DtActividad createDtActividad() {
        return new DtActividad();
    }

    /**
     * Create an instance of {@link DtPaquete }
     * 
     * @return
     *     the new instance of {@link DtPaquete }
     */
    public DtPaquete createDtPaquete() {
        return new DtPaquete();
    }

    /**
     * Create an instance of {@link DtTurista }
     * 
     * @return
     *     the new instance of {@link DtTurista }
     */
    public DtTurista createDtTurista() {
        return new DtTurista();
    }

    /**
     * Create an instance of {@link DtProveedor }
     * 
     * @return
     *     the new instance of {@link DtProveedor }
     */
    public DtProveedor createDtProveedor() {
        return new DtProveedor();
    }

    /**
     * Create an instance of {@link DtInscripcionArray }
     * 
     * @return
     *     the new instance of {@link DtInscripcionArray }
     */
    public DtInscripcionArray createDtInscripcionArray() {
        return new DtInscripcionArray();
    }

    /**
     * Create an instance of {@link InscripcionDaoArray }
     * 
     * @return
     *     the new instance of {@link InscripcionDaoArray }
     */
    public InscripcionDaoArray createInscripcionDaoArray() {
        return new InscripcionDaoArray();
    }

    /**
     * Create an instance of {@link DtSalidaArray }
     * 
     * @return
     *     the new instance of {@link DtSalidaArray }
     */
    public DtSalidaArray createDtSalidaArray() {
        return new DtSalidaArray();
    }

    /**
     * Create an instance of {@link DtActividadArray }
     * 
     * @return
     *     the new instance of {@link DtActividadArray }
     */
    public DtActividadArray createDtActividadArray() {
        return new DtActividadArray();
    }

    /**
     * Create an instance of {@link SalidaDaoArray }
     * 
     * @return
     *     the new instance of {@link SalidaDaoArray }
     */
    public SalidaDaoArray createSalidaDaoArray() {
        return new SalidaDaoArray();
    }

    /**
     * Create an instance of {@link DtPaqueteArray }
     * 
     * @return
     *     the new instance of {@link DtPaqueteArray }
     */
    public DtPaqueteArray createDtPaqueteArray() {
        return new DtPaqueteArray();
    }

    /**
     * Create an instance of {@link ActividadDaoArray }
     * 
     * @return
     *     the new instance of {@link ActividadDaoArray }
     */
    public ActividadDaoArray createActividadDaoArray() {
        return new ActividadDaoArray();
    }

    /**
     * Create an instance of {@link DtCompra.Disponibles.Entry }
     * 
     * @return
     *     the new instance of {@link DtCompra.Disponibles.Entry }
     */
    public DtCompra.Disponibles.Entry createDtCompraDisponiblesEntry() {
        return new DtCompra.Disponibles.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompraFailException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CompraFailException }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "CompraFailException")
    public JAXBElement<CompraFailException> createCompraFailException(CompraFailException value) {
        return new JAXBElement<>(_CompraFailException_QNAME, CompraFailException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentException }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "DocumentException")
    public JAXBElement<DocumentException> createDocumentException(DocumentException value) {
        return new JAXBElement<>(_DocumentException_QNAME, DocumentException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InscriptionFailException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InscriptionFailException }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "InscriptionFailException")
    public JAXBElement<InscriptionFailException> createInscriptionFailException(InscriptionFailException value) {
        return new JAXBElement<>(_InscriptionFailException_QNAME, InscriptionFailException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YaExisteException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link YaExisteException }{@code >}
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "YaExisteException")
    public JAXBElement<YaExisteException> createYaExisteException(YaExisteException value) {
        return new JAXBElement<>(_YaExisteException_QNAME, YaExisteException.class, null, value);
    }

}
