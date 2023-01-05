package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservices.DtActividad;
import webservices.DtPaquete;

@MultipartConfig
@WebServlet("/busquedaTexto")
public class busquedaTexto extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    webservices.WebServicesService service = new webservices.WebServicesService();
    webservices.WebServices port = service.getWebServicesPort();
    
    List<DtActividad> acts;
    List<DtPaquete> paqs;
    
    public busquedaTexto() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
        String busqueda = request.getParameter("busqueda");
        List<DtActividad> actividades = port.busquedaTextoActividades(busqueda).getItem();
        List<DtPaquete> paquetes = port.busquedaTextoPaquetes(busqueda).getItem();
        acts = actividades;
        paqs = paquetes;
        
        request.setAttribute("datosActividades", actividades);
        request.setAttribute("datosPaquetes", paquetes);
        
        request.getRequestDispatcher("/WEB-INF/busqueda/busquedaActividadesPaquetes.jsp").
        forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
        request.setCharacterEncoding("UTF-8");
        processRequest(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
        
        if(request.getParameter("orden").contains("alfabetico")) {
            paqs.sort((a,b) -> a.getNombre().toUpperCase().charAt(0) < b.getNombre().toUpperCase().charAt(0) ? -1 : 1);
            acts.sort((a,b) -> a.getNombre().toUpperCase().charAt(0) < b.getNombre().toUpperCase().charAt(0) ? -1 : 1);
            request.setAttribute("datosActividades", acts);
            request.setAttribute("datosPaquetes", paqs);
        } else {
            paqs.sort((a,b) -> a.getFechaAlta().toGregorianCalendar().before(b.getFechaAlta().toGregorianCalendar()) ? 1 : -1);
            acts.sort((a,b) -> a.getFechaAlta().toGregorianCalendar().before(b.getFechaAlta().toGregorianCalendar()) ? 1 : -1);
            request.setAttribute("datosActividades", acts);
            request.setAttribute("datosPaquetes", paqs);
        }
        
        
        
        request.getRequestDispatcher("/WEB-INF/busqueda/busquedaActividadesPaquetes.jsp").
        forward(request, response);
    }
}