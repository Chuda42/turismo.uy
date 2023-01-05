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
@WebServlet("/consultaActividad")
public class consultaActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    webservices.WebServicesService service = new webservices.WebServicesService();
    webservices.WebServices port = service.getWebServicesPort();
    
    /**
     * @return 
     * @see HttpServlet#HttpServlet()
     */
    public  consultaActividad() {
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
    	
    	List<String> departamentos = port.listarDepartamentos().getItem();
    	
    	//Pedir atributo datosActividades en home.jsp
    	request.setAttribute("datosActividades", dtActs);
    	request.setAttribute("departamentos", departamentos);
    
    	
    	request.getRequestDispatcher("/WEB-INF/actividad/consultaActividad.jsp").forward(request, response);
    	
    
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<String> actividades = port.listarActividadesDepartamento(request.getParameter("departamentoSeleccionado")).getItem();
		Set<DtActividad> dtActs = new HashSet<DtActividad>();
		for(String act: actividades)
			dtActs.add(port.getInfoActividad(act));
		List<String> departamentos = port.listarDepartamentos().getItem();
		request.setAttribute("nombreDepartamento", request.getParameter("departamentoSeleccionado"));
		request.setAttribute("datosActividades", dtActs);
		request.setAttribute("departamentos", departamentos);
		request.getRequestDispatcher("/WEB-INF/actividad/consultaActividad.jsp").forward(request, response);
	}
}