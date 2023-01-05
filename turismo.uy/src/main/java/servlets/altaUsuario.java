package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import webservices.DtUsuario;

@MultipartConfig
@WebServlet("/altaUsuario")
public class altaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String[] ext = {".icon", ".png", ".jpg", ".jpeg", ".webp"};
	
	public altaUsuario() {
		super();
	}
	
	private String extencionValida(String fn) {
	    String res = "";
		for(String es : ext) {
			if(fn.toLowerCase().endsWith(es)) {
			    res = es;
				return res;
			}
		}
		return res;
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
		HttpSession ses = request.getSession();
	    webservices.WebServicesService service = new webservices.WebServicesService();
	    webservices.WebServices port = service.getWebServicesPort();
		if(ses.getAttribute("usuario_logueado") != null) {
			response.sendRedirect("index");
			return;
		}
		 
		String nic     = request.getParameter("Nickname");
		String nom     = request.getParameter("Nombre");
		String ape    = request.getParameter("Apellido");
		String ema    = request.getParameter("Email");
		String nac = request.getParameter("FechaNacimiento");
		String tU  = request.getParameter("TipoUsuario");
		String pas     = request.getParameter("Contrasenia");
		
		 
		 Part p     = request.getPart("FotoPerfil");
		 String ext = "";
         byte [] fotoBin = null;  //guardar binario de la foto
         if(p != null && !extencionValida(p.getSubmittedFileName()).isEmpty()) {
             fotoBin = p.getInputStream().readAllBytes();
             ext = extencionValida(p.getSubmittedFileName());
         }
         if(ext.equals("")) {
             fotoBin = "No hay imagen".getBytes();
         }
         try {
             if(tU.equals("Turista")) {
                 String nacionalidad = request.getParameter("Nacionalidad");
                 port.altaUsuario(nic, ema, nom, ape, pas, nac, fotoBin, ext, "Turista", nacionalidad, "", "");
             }else {
                 String des = request.getParameter("Descripcion");
                 String web = request.getParameter("LinkSitioWeb");
                 port.altaUsuario(nic, ema, nom, ape, pas, nac, fotoBin, ext, "Proveedor", "", des, web);
             }
             DtUsuario usr = port.getUsuarioByNickName(nic);
             ses.setAttribute("usuario_logueado", usr);
             response.sendRedirect("index?exito=Usuario registrado correctamente");
             
         }catch(Exception e) {
             e.printStackTrace();
             request.setAttribute("UsuarioYaExiste", e.getMessage());
             request.getRequestDispatcher("/WEB-INF/altaUsuario/altaUsuario.jsp").forward(request, response);
         }   
		
	}
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException ,IOException {
	       webservices.WebServicesService service = new webservices.WebServicesService();
	       webservices.WebServices port = service.getWebServicesPort();
	       if(req.getParameter("existe") != null) {
	            boolean existe = port.existeUsuarioNick(req.getParameter("existe"));
	            
	            if(existe) {
	                res.sendError(400);
	            }
	            return;
	        }else if (req.getParameter("existeEmail") != null) {
	            boolean existe2 = port.existeUsuarioEmail(req.getParameter("existeEmail"));
	            if(existe2) {
	                res.sendError(400);
	            }
	        }else {
	            req.getRequestDispatcher("/WEB-INF/altaUsuario/altaUsuario.jsp").forward(req, res);
	        }
			
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException ,IOException {
	    req.setCharacterEncoding("UTF-8");
		processRequest(req, res);
	}
	
}