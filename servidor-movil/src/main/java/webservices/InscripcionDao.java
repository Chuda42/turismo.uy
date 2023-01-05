
package webservices;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para inscripcionDao complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="inscripcionDao">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="cantidadTuristas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="costo" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         <element name="fechaInscripcion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         <element name="salida" type="{http://webservices/}salidaDao" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inscripcionDao", propOrder = {
    "cantidadTuristas",
    "costo",
    "fechaInscripcion",
    "salida"
})
public class InscripcionDao {

    protected int cantidadTuristas;
    protected float costo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInscripcion;
    protected SalidaDao salida;

    /**
     * Obtiene el valor de la propiedad cantidadTuristas.
     * 
     */
    public int getCantidadTuristas() {
        return cantidadTuristas;
    }

    /**
     * Define el valor de la propiedad cantidadTuristas.
     * 
     */
    public void setCantidadTuristas(int value) {
        this.cantidadTuristas = value;
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
     * Obtiene el valor de la propiedad fechaInscripcion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaInscripcion() {
        return fechaInscripcion;
    }

    /**
     * Define el valor de la propiedad fechaInscripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaInscripcion(XMLGregorianCalendar value) {
        this.fechaInscripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad salida.
     * 
     * @return
     *     possible object is
     *     {@link SalidaDao }
     *     
     */
    public SalidaDao getSalida() {
        return salida;
    }

    /**
     * Define el valor de la propiedad salida.
     * 
     * @param value
     *     allowed object is
     *     {@link SalidaDao }
     *     
     */
    public void setSalida(SalidaDao value) {
        this.salida = value;
    }

}
