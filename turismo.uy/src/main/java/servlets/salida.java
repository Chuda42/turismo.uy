package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservices.DtSalida;
import webservices.SalidaDao;

@WebServlet("/salida")
public class salida extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public salida() {
		super();
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
	    webservices.WebServicesService service = new webservices.WebServicesService();
        webservices.WebServices port = service.getWebServicesPort();
		if(request.getParameter("nombreSalida") != null) {
		    String name = (String) request.getParameter("nombreSalida");
	        DtSalida salidaT = port.getInfoCompletaSalida(name);
	        String actividad = salidaT.getNombreActividad();
	        
	        request.setAttribute("salida", salidaT);
	        request.setAttribute("nombreActividadSalida", actividad);
	                
	        request.getRequestDispatcher("/WEB-INF/salida/consultaSalida.jsp").
	            forward(request, response);
		}else if(request.getParameter("nombreSalidaFin") != null) {
		    String name = (String) request.getParameter("nombreSalidaFin");
            SalidaDao salidaT = port.getSalidaDeActividadFinalizada(name);
            String actividad = salidaT.getActividad().getNombre();
            
            request.setAttribute("salida", salidaT);
            request.setAttribute("nombreActividadSalida", actividad);
                    
            request.getRequestDispatcher("/WEB-INF/salida/consultaSalidaFinalizada.jsp").forward(request, response);
		    
		}
        
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
		processRequest(request, response);
	}
}