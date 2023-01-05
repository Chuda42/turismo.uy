package servlets;

import java.io.BufferedOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class imagen
 */
@WebServlet("/imagen")
public class imagen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private webservices.WebServicesService service = new webservices.WebServicesService();
    private webservices.WebServices port = service.getWebServicesPort();
    /**
     * Default constructor. 
     */
    public imagen() {
        // TODO Auto-generated constructor stub
    }
    
    private void mostrarIMG(HttpServletRequest request, HttpServletResponse response, byte [] bytes) {
        response.resetBuffer();
        ServletOutputStream outputStream =null;
        BufferedOutputStream bufferedOutputStream =null;
        response.setContentType("image/*");
        try {
            outputStream = response.getOutputStream();
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.write(bytes);

            response.flushBuffer();
            bufferedOutputStream.flush();
            outputStream.flush();
            bufferedOutputStream.close();
            outputStream.close();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
        String fileNick = request.getParameter("usr");
        String fileNombreAct = request.getParameter("act");
        String fileNombreSal = request.getParameter("sal");
        String fileNombrePaq = request.getParameter("paq");
       
        if(fileNick != null) {
            mostrarIMG(request, response, port.getFileImg(fileNick));
        }
        if(fileNombreAct != null) {
            mostrarIMG(request, response, port.getFileImg(fileNombreAct));
        }
        if(fileNombreSal != null) {
            mostrarIMG(request, response, port.getFileImg(fileNombreSal));
        }
        if(fileNombrePaq != null) {
            mostrarIMG(request, response, port.getFileImg(fileNombrePaq));
        }
        
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    processRequest(request, response);
	}

}
