
package webservices;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoInscripcion.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <pre>{@code
 * <simpleType name="tipoInscripcion">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="general"/>
 *     <enumeration value="paquete"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "tipoInscripcion")
@XmlEnum
public enum TipoInscripcion {

    @XmlEnumValue("general")
    GENERAL("general"),
    @XmlEnumValue("paquete")
    PAQUETE("paquete");
    private final String value;

    TipoInscripcion(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoInscripcion fromValue(String v) {
        for (TipoInscripcion c: TipoInscripcion.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
