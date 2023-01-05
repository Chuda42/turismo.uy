package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservices.DtSalida;

@WebServlet("/consultaSalida")
public class consultaSalida extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	webservices.WebServicesService service = new webservices.WebServicesService();
    webservices.WebServices port = service.getWebServicesPort();
	
	public consultaSalida() {
		super();
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
		// parametro requerido: nombreSalida
		String name = (String) request.getParameter("nombreSalida");
		DtSalida salidaT = port.getInfoCompletaSalida(name);
		String actividad = salidaT.getNombreActividad();
		
		//Pedir atributos en consultaSalida.jsp
		request.setAttribute("salida", salidaT);
		request.setAttribute("nombreActividadSalida", actividad);
				
		request.getRequestDispatcher("/WEB-INF/consultaSalida.jsp").
			forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		processRequest(request, response);
	}
}