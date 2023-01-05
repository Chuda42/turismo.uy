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

import webservices.DtActividad;
import webservices.EstadoActividad;

@WebServlet("/departamento")
public class departamento extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public departamento() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        webservices.WebServicesService service = new webservices.WebServicesService();
        webservices.WebServices port = service.getWebServicesPort();
        String name = (String) request.getParameter("nombreDpto");
        List<String> actividades = port.listarActividadesDepartamento(name).getItem();
        
        Set<DtActividad> dtAct = new HashSet<DtActividad>();
        for(String act : actividades) {
            DtActividad actual = port.getInfoActividad(act);
            if(actual.getEstado() == EstadoActividad.CONFIRMADA)
                dtAct.add(actual);
        }
        
        request.setAttribute("datosActividades", dtAct);
        
        request.getRequestDispatcher("/WEB-INF/actividad/listarActividadesPorDepto.jsp").
            forward(request, response);
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}