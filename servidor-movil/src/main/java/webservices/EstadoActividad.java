
package webservices;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para estadoActividad.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <pre>{@code
 * <simpleType name="estadoActividad">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="confirmada"/>
 *     <enumeration value="rechazada"/>
 *     <enumeration value="agregada"/>
 *     <enumeration value="finalizada"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "estadoActividad")
@XmlEnum
public enum EstadoActividad {

    @XmlEnumValue("confirmada")
    CONFIRMADA("confirmada"),
    @XmlEnumValue("rechazada")
    RECHAZADA("rechazada"),
    @XmlEnumValue("agregada")
    AGREGADA("agregada"),
    @XmlEnumValue("finalizada")
    FINALIZADA("finalizada");
    private final String value;

    EstadoActividad(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EstadoActividad fromValue(String v) {
        for (EstadoActividad c: EstadoActividad.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
