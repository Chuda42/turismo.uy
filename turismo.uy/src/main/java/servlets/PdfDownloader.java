package servlets;


import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservices.DocumentException_Exception;
import webservices.IOException_Exception;

@WebServlet("/pdf-downloader")
public class PdfDownloader extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    webservices.WebServicesService service = new webservices.WebServicesService();
    webservices.WebServices port = service.getWebServicesPort();
    
    public PdfDownloader() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario =(String) request.getParameter("nombreUsuario");
        String salida =(String) request.getParameter("nombreSalida");
                
        byte[] pdf = null;
        try {
            pdf = port.getFilePdf(usuario, salida);
        } catch (DocumentException_Exception | IOException_Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
        response.setContentType("APPLICATION/OCTET-STREAM");
        
        response.setHeader("Content-Disposition", "attachment; filename=\"" + "\\comprobante.pdf" +"\"");
        
        OutputStream out = response.getOutputStream();
        out.write(pdf);
        out.close();
    }
}