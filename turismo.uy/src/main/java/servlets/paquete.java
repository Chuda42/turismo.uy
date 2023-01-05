package servlets;

import java.io.IOException;
import java.util.Set;
import java.util.HashSet;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


import webservices.DtActividad;
import webservices.DtPaquete;
import webservices.DtTurista;
import webservices.DtUsuario;
import webservices.EstadoActividad;

@MultipartConfig
@WebServlet("/paquete")
public class paquete extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public paquete() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
        webservices.WebServicesService service = new webservices.WebServicesService();
        webservices.WebServices port = service.getWebServicesPort();
        
        HttpSession session = request.getSession();
        DtTurista tur = (DtTurista) session.getAttribute("usuario_logueado");
        
        String nomb = (String) request.getParameter("nombrePaquete");
        int cantTuristas = Integer.parseInt(request.getParameter("Cantidad"));
        
        try {
            GregorianCalendar fechaCompra = new GregorianCalendar();
            XMLGregorianCalendar fechaCompraXML = DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaCompra);
            port.ingresarCompra(tur.getNickname(), nomb, cantTuristas, fechaCompraXML);
            DtUsuario usuario = port.getUsuarioByNickName(tur.getNickname());
            session.setAttribute("usuario_logueado", usuario);
            response.sendRedirect("index?exito=Paquete comprado con exito");
        } catch(Exception e){
            e.printStackTrace();
            request.setAttribute("CompraFailError", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/paquete/compraPaquete.jsp").
                forward(request, response);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        webservices.WebServicesService service = new webservices.WebServicesService();
        webservices.WebServices port = service.getWebServicesPort();
        
        if(request.getParameter("listar") != null) {
            Set<DtPaquete> paquetes = new HashSet<DtPaquete>();
            for(String paq : port.listarPaquetes().getItem()) {
                DtPaquete actual = port.getInfoPaquete(paq);
                if(!actual.getActividades().isEmpty())
                    paquetes.add(actual);
            }
            
            request.setAttribute("paquetes", paquetes);
            request.getRequestDispatcher("/WEB-INF/paquete/listadoPaquetes.jsp").forward(request, response);
        } else {
            String name = request.getParameter("nombrePaquete");
            DtPaquete paqueteT = port.getInfoPaquete(name);
            request.setAttribute("paquete", paqueteT);
            
            if(request.getParameter("COMPRA") != null && request.getSession().getAttribute("usuario_logueado") instanceof DtTurista) {
                request.getRequestDispatcher("/WEB-INF/paquete/compraPaquete.jsp").
                    forward(request, response);
            } else {
                Set<DtActividad> datosActividades = new HashSet<DtActividad>();
                for(String actividad: paqueteT.getActividades()) {
                    DtActividad actual = port.getInfoActividad(actividad);
                    if(actual.getEstado() == EstadoActividad.CONFIRMADA)
                        datosActividades.add(actual);
                }
                
                request.setAttribute("datosActividadPaquete", datosActividades);
                
                request.getRequestDispatcher("/WEB-INF/paquete/consultaPaquete.jsp").
                    forward(request, response);
            }
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        webservices.WebServicesService service = new webservices.WebServicesService();
        webservices.WebServices port = service.getWebServicesPort();
        String name = request.getParameter("nombrePaquete");
        DtPaquete paqueteT = port.getInfoPaquete(name);
        request.setAttribute("paquete", paqueteT);
        processRequest(request, response);
    }
}