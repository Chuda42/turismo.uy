package servlets;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import webservices.DtSalida;

/**
 * Servlet implementation class index
 */
@WebServlet("/listadoSalidas")
public class listadoSalidas extends HttpServlet {
private static final long serialVersionUID = 1L;
    
    webservices.WebServicesService service = new webservices.WebServicesService();
    webservices.WebServices port = service.getWebServicesPort();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listadoSalidas() {
        super();
    }
    
    /**
   	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   	 */
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   Set<DtSalida> dtsalidas = new HashSet<DtSalida>();
	        GregorianCalendar fecha = new GregorianCalendar();
	        XMLGregorianCalendar fechaXML = null;
	        
           try {
               fechaXML = DatatypeFactory.newInstance().newXMLGregorianCalendar(fecha);
           } catch (DatatypeConfigurationException e) {
               e.printStackTrace();
           }
	        
	        for(String act : port.listarActividadesConfirmadas().getItem()) {
	            dtsalidas.addAll(port.listarInfoSalidasVigentes(act, fechaXML).getItem());
	        }

	        request.setAttribute("datosSalidas", dtsalidas);
	        request.getRequestDispatcher("/WEB-INF/salida/listadoSalidas.jsp").forward(request, response);
    	   
       }
       
       /**
   	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   	 */
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		doGet(request, response);
   	}
	
}