
package webservices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtActividad complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="dtActividad">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="departamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="imgDir" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="nombreCiudad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="fechaAlta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         <element name="duracionHs" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="costo" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         <element name="nombCategorias" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="salidas" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="paquetes" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="estado" type="{http://webservices/}estadoActividad" minOccurs="0"/>
 *         <element name="likedBy" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtActividad", propOrder = {
    "nombre",
    "descripcion",
    "departamento",
    "imgDir",
    "nombreCiudad",
    "fechaAlta",
    "duracionHs",
    "costo",
    "nombCategorias",
    "salidas",
    "paquetes",
    "estado",
    "likedBy",
    "url"
})
public class DtActividad {

    protected String nombre;
    protected String descripcion;
    protected String departamento;
    protected String imgDir;
    protected String nombreCiudad;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaAlta;
    protected int duracionHs;
    protected float costo;
    @XmlElement(nillable = true)
    protected List<String> nombCategorias;
    @XmlElement(nillable = true)
    protected List<String> salidas;
    @XmlElement(nillable = true)
    protected List<String> paquetes;
    @XmlSchemaType(name = "string")
    protected EstadoActividad estado;
    @XmlElement(nillable = true)
    protected List<String> likedBy;
    protected String url;

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad departamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Define el valor de la propiedad departamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartamento(String value) {
        this.departamento = value;
    }

    /**
     * Obtiene el valor de la propiedad imgDir.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImgDir() {
        return imgDir;
    }

    /**
     * Define el valor de la propiedad imgDir.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImgDir(String value) {
        this.imgDir = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreCiudad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCiudad() {
        return nombreCiudad;
    }

    /**
     * Define el valor de la propiedad nombreCiudad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCiudad(String value) {
        this.nombreCiudad = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaAlta.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Define el valor de la propiedad fechaAlta.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaAlta(XMLGregorianCalendar value) {
        this.fechaAlta = value;
    }

    /**
     * Obtiene el valor de la propiedad duracionHs.
     * 
     */
    public int getDuracionHs() {
        return duracionHs;
    }

    /**
     * Define el valor de la propiedad duracionHs.
     * 
     */
    public void setDuracionHs(int value) {
        this.duracionHs = value;
    }

    /**
     * Obtiene el valor de la propiedad costo.
     * 
     */
    public float getCosto() {
        return costo;
    }

    /**
     * Define el valor de la propiedad costo.
     * 
     */
    public void setCosto(float value) {
        this.costo = value;
    }

    /**
     * Gets the value of the nombCategorias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the nombCategorias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNombCategorias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     * @return
     *     The value of the nombCategorias property.
     */
    public List<String> getNombCategorias() {
        if (nombCategorias == null) {
            nombCategorias = new ArrayList<>();
        }
        return this.nombCategorias;
    }

    /**
     * Gets the value of the salidas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the salidas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSalidas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     * @return
     *     The value of the salidas property.
     */
    public List<String> getSalidas() {
        if (salidas == null) {
            salidas = new ArrayList<>();
        }
        return this.salidas;
    }

    /**
     * Gets the value of the paquetes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the paquetes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaquetes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     * @return
     *     The value of the paquetes property.
     */
    public List<String> getPaquetes() {
        if (paquetes == null) {
            paquetes = new ArrayList<>();
        }
        return this.paquetes;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link EstadoActividad }
     *     
     */
    public EstadoActividad getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoActividad }
     *     
     */
    public void setEstado(EstadoActividad value) {
        this.estado = value;
    }

    /**
     * Gets the value of the likedBy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the likedBy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLikedBy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     * @return
     *     The value of the likedBy property.
     */
    public List<String> getLikedBy() {
        if (likedBy == null) {
            likedBy = new ArrayList<>();
        }
        return this.likedBy;
    }

    /**
     * Obtiene el valor de la propiedad url.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Define el valor de la propiedad url.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

}
