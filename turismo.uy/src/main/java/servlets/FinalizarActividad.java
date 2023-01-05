package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webservices.DtActividad;
import webservices.DtProveedor;

/**
 * Servlet implementation class FinalizarActividad
 */
@WebServlet("/FinalizarActividad")
public class FinalizarActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    webservices.WebServicesService service = new webservices.WebServicesService();
    webservices.WebServices port = service.getWebServicesPort();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalizarActividad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	    
        HttpSession session = request.getSession();
        DtProveedor prov = (DtProveedor)session.getAttribute("usuario_logueado");
        
        List<DtActividad> finalizables = port.listarActividadesFinalizablesProveedor(prov.getNickname()).getItem();
	    
        request.setAttribute("actividades_finalizables", 
		        finalizables);
	    
		request.getRequestDispatcher("/WEB-INF/actividad/FinalizarActividad.jsp").forward(request,
                response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String actividad = (String)request.getParameter("act");
	    port.finalizarActividad(actividad);
        response.sendRedirect("index?exito= La actividad " + actividad + " se ha finalizado con exito");
	}

}
