package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webservices.DtActividad;
import webservices.DtUsuario;

/**
 * Servlet implementation class index
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    webservices.WebServicesService service = new webservices.WebServicesService();
    webservices.WebServices port = service.getWebServicesPort();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<String> actividades = port.listarActividadesConfirmadas().getItem();
        List<DtActividad> dtActs = new ArrayList<>();
        
        for(String act : actividades)
            dtActs.add(port.getInfoActividad(act));
	    request.setAttribute("act_confirmadas", dtActs);
	    
	    if(request.getParameter("exito") != null) {
	        request.setAttribute("exito", request.getParameter("exito"));
	    }
	    
	    
        request.getRequestDispatcher("/WEB-INF/home/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    
	    if(request.getParameter("usr") != null && request.getParameter("act") != null) {
	      port.marcarDesmarcarFav(
	                (String)request.getParameter("usr"),
	                (String)request.getParameter("act")
	        );
	    }
	    
	}

}
