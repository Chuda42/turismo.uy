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
 * Servlet Filter implementation class consultaSalidaFilter
 */
@WebFilter("/salida")
public class consultaSalidaFilter extends HttpFilter implements Filter {

	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    webservices.WebServicesService service = new webservices.WebServicesService();
        webservices.WebServices port = service.getWebServicesPort();
        
        HttpServletRequest req = (HttpServletRequest) request;
        
        String sal = (String) req.getParameter("nombreSalida");
        if(sal != null) {
            port.agregarVisita(sal, false);
        }
        
        
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
