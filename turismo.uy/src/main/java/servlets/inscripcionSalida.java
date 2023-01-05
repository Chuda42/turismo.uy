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
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import webservices.DtPaquete;
import webservices.DtSalida;
import webservices.DtTurista;
import webservices.DtUsuario;
import webservices.TipoInscripcion;
import webservices.DtCompra;

/**
 * Servlet implementation class inscripcionSalida
 */
@WebServlet("/inscripcionSalida")
public class inscripcionSalida extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public inscripcionSalida() {
        super();
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        webservices.WebServicesService service = new webservices.WebServicesService();
        webservices.WebServices port = service.getWebServicesPort();
        
		/*
		 El turista indico la salida a la que se quiere inscribir.
		 RENDERIZADO DEL FORMULARIO DE INSCRIPCION
		*/
	    if(!(request.getSession().getAttribute("usuario_logueado") instanceof DtTurista))
	        response.sendRedirect("index");
	    else {
            
    	    if (request.getParameter("nombreSalida") != null){
    	        
    	        // obtener info de la salida seleccionada
    	        DtSalida dts = port.getInfoCompletaSalida((String)request.getParameter("nombreSalida"));
    	        
    	        request.setAttribute("salida", dts);
    	        
    	        /*
                    En caso de que el turista haya comprado paquetes que aún estén vigentes y
                que incluyan la actividad turística de la salida seleccionada y posea
                inscripciones disponibles, el sistema muestra estos paquetes y el turista
                podrá elegir uno de ellos para realizar la inscripción. 
                */
                HttpSession session = request.getSession();
                DtTurista dttur = (DtTurista)session.getAttribute("usuario_logueado");
                
                String nomAct = dts.getNombreActividad();
                Set<DtPaquete> paqCompVig = new HashSet<DtPaquete>();
                DtPaquete p;
                for (DtCompra c : dttur.getCompras()) {
                    if(c.isVigente()) {
                        p = port.getInfoPaquete(c.getPaquete());
                        int cuposAct = 0;
                        for(DtCompra.Disponibles.Entry entry: c.getDisponibles().getEntry())
                            if(entry.getKey().equals(nomAct))
                                cuposAct = entry.getValue();

                        if (p.getActividades().contains(nomAct) && cuposAct > 0)
                            paqCompVig.add(p);
                    }
                }
                request.setAttribute("paquetes", paqCompVig);
    	        
    			request.getRequestDispatcher("/WEB-INF/salida/inscripcionSalida.jsp").forward(request, response);
    	    } else if (request.getParameter("listar") != null) {
    	        // se llego desde acceso a casos de uso
    	        // se listan todas las salidas vigentes al dia actual
    	        
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
    
    	        request.setAttribute("salidas", dtsalidas);
    	        request.getRequestDispatcher("/WEB-INF/salida/listadoSalidas.jsp").forward(request, response);
    	    } else {
    		    // ERROR: se llego a la pagina de inscripcion salida sin paso previo
    	        response.sendRedirect("/WEB-INF/errorPages/500.jsp");
    		}
	    
	    }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    webservices.WebServicesService service = new webservices.WebServicesService();
        webservices.WebServices port = service.getWebServicesPort();
	    
	    //Si llegas al POST ya tenes nombreSalida, y si la inscripcion falla necesitas mandar de nuevo el DTSalida y los DTPaquete al JSP
	    
	    DtSalida dts = port.getInfoCompletaSalida((String)request.getParameter("nombreSalida"));
        request.setAttribute("salida", dts);
        
        HttpSession session = request.getSession();
        DtTurista turista = (DtTurista)session.getAttribute("usuario_logueado");
        
        String nomAct = dts.getNombreActividad();
        Set<DtPaquete> paqCompVig = new HashSet<DtPaquete>();
        DtPaquete p;
        for (DtCompra c : turista.getCompras()) {
            if(c.isVigente()) {
                p = port.getInfoPaquete(c.getPaquete());
                int cuposAct = 0;
                for(DtCompra.Disponibles.Entry entry: c.getDisponibles().getEntry())
                    if(entry.getKey().equals(nomAct))
                        cuposAct = entry.getValue();
                if (p.getActividades().contains(nomAct) && cuposAct > 0)
                    paqCompVig.add(p);
            }
        }
        request.setAttribute("paquetes", paqCompVig);
        
		/* 
		Respuesta del formulario de inscripcion a salida
		SE PROCESA LA PETICION DE INSCRIPCION
		*/
	    
	    /*
	    En caso de que ya exista un registro de el/la turista a la salida turística o
	    se haya alcanzado el límite máximo de turistas para la salida, el turista
	    podrá (dependiendo del caso): cambiar la salida seleccionada o cancelar el
	    caso de uso.
	    */
        
           
        int cantTuristas = Integer.parseInt(request.getParameter("cantTuristas"));
        String sal = request.getParameter("nombreSalida");
        
        try {
            GregorianCalendar fecha = new GregorianCalendar();
            XMLGregorianCalendar fechaXML = DatatypeFactory.newInstance().newXMLGregorianCalendar(fecha);
            if(request.getParameter("tipoDeInscripcion").equals("porPaquete")) {
                String paq = request.getParameter("paqueteSeleccionado");
                port.ingresarInscripcion(turista.getNickname(), sal, cantTuristas, fechaXML, TipoInscripcion.PAQUETE, paq);
            }
            else {
                port.ingresarInscripcion(turista.getNickname(), sal, cantTuristas, fechaXML, TipoInscripcion.GENERAL, "");
            }
            DtUsuario usuario = port.getUsuarioByNickName(turista.getNickname());
            session.setAttribute("usuario_logueado", usuario);
            response.sendRedirect("index?exito=La inscripción se ha realizado con éxito");
        } catch(Exception e) {
            e.printStackTrace();
            request.setAttribute("InscriptionFailedError", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/salida/inscripcionSalida.jsp").forward(request, response);
        }
            
	}
}
