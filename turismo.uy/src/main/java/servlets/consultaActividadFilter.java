package servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class HitCounterFilter
 */
@WebFilter("/consultaActividad")
public class consultaActividadFilter extends HttpFilter implements Filter {
       
   public void destroy() {
    }

    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        webservices.WebServicesService service = new webservices.WebServicesService();
        webservices.WebServices port = service.getWebServicesPort();
        
        HttpServletRequest req = (HttpServletRequest) request;
        
        String act = (String) req.getParameter("nombreAct");
        if(act != null) {
            port.agregarVisita(act, true);
        }
        
        chain.doFilter(request, response);
    }

    
    public void init(FilterConfig fConfig) throws ServletException {
    }

}