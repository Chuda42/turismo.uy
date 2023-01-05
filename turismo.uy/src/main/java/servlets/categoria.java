package servlets;

import java.io.IOException;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservices.DtPaquete;

@WebServlet("/categoria")
public class categoria extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public categoria() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        webservices.WebServicesService service = new webservices.WebServicesService();
        webservices.WebServices port = service.getWebServicesPort();
        String name = (String) request.getParameter("nombreCat");
        List<String> paquetes = port.listarPaquetesCategoria(name).getItem();
        
        Set<DtPaquete> dtPaq = new HashSet<DtPaquete>();
        for(String paq : paquetes)
            dtPaq.add(port.getInfoPaquete(paq));
        
        request.setAttribute("datosPaquetes", dtPaq);
        
        request.getRequestDispatcher("/WEB-INF/paquete/listarPaquetesPorCategoria.jsp").
            forward(request, response);
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}