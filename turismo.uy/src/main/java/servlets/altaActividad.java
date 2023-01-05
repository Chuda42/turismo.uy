package servlets;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


import webservices.DtProveedor;
import webservices.EstadoActividad;
import webservices.YaExisteException_Exception;



@MultipartConfig
@WebServlet("/altaActividad")
public class altaActividad extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String[] ext = {".icon", ".png", ".jpg", ".jpeg", ".webp"};
    webservices.WebServicesService service = new webservices.WebServicesService();
    webservices.WebServices port = service.getWebServicesPort();
    
    public altaActividad() {
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
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException ,IOException, YaExisteException_Exception, DatatypeConfigurationException {
        HttpSession ses = req.getSession();
        DtProveedor prov = (DtProveedor) ses.getAttribute("usuario_logueado");
        
        String dpt =(String) req.getParameter("Departamento");
        String nom =(String) req.getParameter("Nombre");
        String des =(String) req.getParameter("Descripcion");
        String url =(String) req.getParameter("URLvideo");
        int dhs = Integer.parseInt(req.getParameter("Duracion"));
        float cos = Float.parseFloat(req.getParameter("Costo"));
        String ciu = req.getParameter("Ciudad");
        //Set<String> cat = new HashSet<String>(Arrays.asList(req.getParameterValues("Categorias")));
        List<String> cat = Arrays.asList((req.getParameterValues("Categorias")));
        String aEnviarCat = "";
        for(String cate : cat) {
           aEnviarCat += cate + "//";
        }
        
        Part p     = req.getPart("ImagenActividad");
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
            XMLGregorianCalendar xmlFecha= DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
            port.altaActividadTuristica(dpt, nom, des, dhs, cos, ciu, prov.getNickname(), xmlFecha, fotoBin, ext, aEnviarCat, url, EstadoActividad.AGREGADA);
            res.sendRedirect("index?exito=La actividad fue registrada con exito");
        } catch(YaExisteException_Exception e) {
            e.printStackTrace();
            req.setAttribute("AltaYaExiste", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/actividad/altaActividad.jsp").forward(req, res);
        }
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
        HttpSession ses = request.getSession();
        
        if(!(ses.getAttribute("usuario_logueado") instanceof DtProveedor)) {
            response.sendRedirect("index");
            return;
        } else {
        request.setAttribute("listaDepartamentos", port.listarDepartamentos().getItem());
        request.setAttribute("listaCategorias", port.listarCategorias().getItem());
        
        request.getRequestDispatcher("/WEB-INF/actividad/altaActividad.jsp").forward(request, response);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("listaDepartamentos", port.listarDepartamentos().getItem());
        request.setAttribute("listaCategorias", port.listarCategorias().getItem());
        try {
            processRequest(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (YaExisteException_Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DatatypeConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}