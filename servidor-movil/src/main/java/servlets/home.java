package servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservices.DtActividad;

/**
 * Servlet implementation class index
 */
@WebServlet("/home")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    webservices.WebServicesService service = new webservices.WebServicesService();
    webservices.WebServices port = service.getWebServicesPort();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public home() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<String> actividades = port.listarActividadesConfirmadas().getItem();
    	Set<DtActividad> dtActs = new HashSet<DtActividad>();
    	for(String act: actividades)
    		dtActs.add(port.getInfoActividad(act));
    	
    	//Pedir atributo act_confirmadas en home.jsp
    	request.setAttribute("act_confirmadas", dtActs);
    	
    	request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}