
package webservices;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoUsuario.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <pre>{@code
 * <simpleType name="tipoUsuario">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="turista"/>
 *     <enumeration value="proveedor"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "tipoUsuario")
@XmlEnum
public enum TipoUsuario {

    @XmlEnumValue("turista")
    TURISTA("turista"),
    @XmlEnumValue("proveedor")
    PROVEEDOR("proveedor");
    private final String value;

    TipoUsuario(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoUsuario fromValue(String v) {
        for (TipoUsuario c: TipoUsuario.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
