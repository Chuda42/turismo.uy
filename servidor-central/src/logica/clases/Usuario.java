package logica.clases;

import java.util.GregorianCalendar;
//import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Usuario {

    protected String nickname, email, nombre, apellido, contrasena, imgDir;
    protected GregorianCalendar fechaNac;
    protected Map<String, Usuario> seguidores;
    protected Map<String, Usuario> seguidos;
    
    public Usuario(String nickname, String email, String nombre, String apellido, String contrasena, GregorianCalendar fechaNac, String imgDir) {
        this.nickname = nickname;
        this.email = email;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.imgDir = imgDir;
        seguidores = new HashMap<String, Usuario>();
        seguidos = new HashMap<String, Usuario>();
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    public String getContrasena() {
        return contrasena;
    }
    
    public String getImgDir() {
        return imgDir;
    }
    
    public GregorianCalendar getFechaNac() {
        return fechaNac;
    }
    
    public Map<String, Usuario> getSeguidores(){
    	return seguidores;
    }
    
    public Map<String, Usuario> getSeguidos(){
    	return seguidos;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void setImg(String img) {
        this.imgDir = img;
    }
    
    public void setFechaNac(GregorianCalendar fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    public void agregarSeguidor(Usuario seguidor) {
    	seguidores.put(seguidor.getNickname(), seguidor);
    }
    
    public void eliminarSeguidor(String seguidor) {
    	seguidores.remove(seguidor);
    }
    
    public void agregarSeguido(Usuario seguido) {
    	seguidos.put(seguido.getNickname(), seguido);
    }
    
    public void eliminarSeguido(String seguido) {
    	seguidos.remove(seguido);
    }
    
    public boolean tieneSeguidor(String seguidor) {
    	return seguidores.containsKey(seguidor);
    }
}
