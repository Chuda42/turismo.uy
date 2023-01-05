package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webservices.DtTurista;
import webservices.DtUsuario;

/**
 * Servlet implementation class iniciarSesion
 */
@WebServlet("/iniciarSesion")
public class iniciarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    webservices.WebServicesService service = new webservices.WebServicesService();
    webservices.WebServices port = service.getWebServicesPort();
	
    /**
     * Default constructor. 
     */
    public iniciarSesion() {
        super();
    }
    
    /**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 * 
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
		
		//Vienen de un form con method=POST desde iniciarSesion.jsp
		String nickOrEmail = (String)request.getParameter("nick-or-email");
		String pass = (String)request.getParameter("password");

		// validacion en la logica
		
    DtUsuario usr = null;
    if (port.existeUsuarioConNickname(nickOrEmail))
      usr = port.getUsuarioByNickName(nickOrEmail);
    else if (port.existeUsuarioEmail(nickOrEmail))
			usr = port.getUsuarioByEmail(nickOrEmail);
		
		if (usr == null || !(usr instanceof DtTurista) || !(port.verifiedUserPassword(usr.getNickname(), pass))) {
			// Controlar en JSP y dar aviso de intento invalido
			request.setAttribute("invalid_attempt", true);
		
			
			 request.getRequestDispatcher("/WEB-INF/iniciarSesion.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("usuario_logueado", usr);
			response.sendRedirect("home");
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("invalid_attempt", false);
		request.getRequestDispatcher("/WEB-INF/iniciarSesion.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		processRequest(request, response);
	}
}