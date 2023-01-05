
package webservices;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtInscripcion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="dtInscripcion">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="cantTuristas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="fechaAlta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         <element name="fechaSalida" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         <element name="costo" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         <element name="salida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="actividad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="nombreTurista" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="tipo" type="{http://webservices/}tipoInscripcion" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtInscripcion", propOrder = {
    "cantTuristas",
    "fechaAlta",
    "fechaSalida",
    "costo",
    "salida",
    "actividad",
    "nombreTurista",
    "tipo"
})
public class DtInscripcion {

    protected int cantTuristas;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaAlta;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaSalida;
    protected float costo;
    protected String salida;
    protected String actividad;
    protected String nombreTurista;
    @XmlSchemaType(name = "string")
    protected TipoInscripcion tipo;

    /**
     * Obtiene el valor de la propiedad cantTuristas.
     * 
     */
    public int getCantTuristas() {
        return cantTuristas;
    }

    /**
     * Define el valor de la propiedad cantTuristas.
     * 
     */
    public void setCantTuristas(int value) {
        this.cantTuristas = value;
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
     * Obtiene el valor de la propiedad salida.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalida() {
        return salida;
    }

    /**
     * Define el valor de la propiedad salida.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalida(String value) {
        this.salida = value;
    }

    /**
     * Obtiene el valor de la propiedad actividad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActividad() {
        return actividad;
    }

    /**
     * Define el valor de la propiedad actividad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActividad(String value) {
        this.actividad = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreTurista.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreTurista() {
        return nombreTurista;
    }

    /**
     * Define el valor de la propiedad nombreTurista.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreTurista(String value) {
        this.nombreTurista = value;
    }

    /**
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link TipoInscripcion }
     *     
     */
    public TipoInscripcion getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoInscripcion }
     *     
     */
    public void setTipo(TipoInscripcion value) {
        this.tipo = value;
    }

}
