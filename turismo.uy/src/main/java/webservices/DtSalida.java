
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
 * <p>Clase Java para dtSalida complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="dtSalida">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="nombreActividad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="nombreDepartamentoActividad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="imgDir" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="fechaSalida" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         <element name="fechaAlta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         <element name="maxTuristas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="lugarSalida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="turistasInscriptos" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtSalida", propOrder = {
    "nombre",
    "nombreActividad",
    "nombreDepartamentoActividad",
    "imgDir",
    "fechaSalida",
    "fechaAlta",
    "maxTuristas",
    "lugarSalida",
    "turistasInscriptos"
})
public class DtSalida {

    protected String nombre;
    protected String nombreActividad;
    protected String nombreDepartamentoActividad;
    protected String imgDir;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaSalida;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaAlta;
    protected int maxTuristas;
    protected String lugarSalida;
    @XmlElement(nillable = true)
    protected List<String> turistasInscriptos;

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
     * Obtiene el valor de la propiedad nombreActividad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreActividad() {
        return nombreActividad;
    }

    /**
     * Define el valor de la propiedad nombreActividad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreActividad(String value) {
        this.nombreActividad = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreDepartamentoActividad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreDepartamentoActividad() {
        return nombreDepartamentoActividad;
    }

    /**
     * Define el valor de la propiedad nombreDepartamentoActividad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreDepartamentoActividad(String value) {
        this.nombreDepartamentoActividad = value;
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
     * Obtiene el valor de la propiedad fechaSalida.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Define el valor de la propiedad fechaSalida.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaSalida(XMLGregorianCalendar value) {
        this.fechaSalida = value;
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
     * Obtiene el valor de la propiedad maxTuristas.
     * 
     */
    public int getMaxTuristas() {
        return maxTuristas;
    }

    /**
     * Define el valor de la propiedad maxTuristas.
     * 
     */
    public void setMaxTuristas(int value) {
        this.maxTuristas = value;
    }

    /**
     * Obtiene el valor de la propiedad lugarSalida.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLugarSalida() {
        return lugarSalida;
    }

    /**
     * Define el valor de la propiedad lugarSalida.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLugarSalida(String value) {
        this.lugarSalida = value;
    }

    /**
     * Gets the value of the turistasInscriptos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the turistasInscriptos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTuristasInscriptos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     * @return
     *     The value of the turistasInscriptos property.
     */
    public List<String> getTuristasInscriptos() {
        if (turistasInscriptos == null) {
            turistasInscriptos = new ArrayList<>();
        }
        return this.turistasInscriptos;
    }

}
