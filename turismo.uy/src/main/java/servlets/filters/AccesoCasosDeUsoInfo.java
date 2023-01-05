package servlets.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*")
public class AccesoCasosDeUsoInfo implements Filter {
 
    webservices.WebServicesService service = new webservices.WebServicesService();
    webservices.WebServices port = service.getWebServicesPort();
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // invoked when a matching request sent to the server
        // used to intercept the request and transform the response
        
        List<String> deptos = port.listarDepartamentos().getItem();
        List<String> categorias = port.listarCategorias().getItem();
        
        request.setAttribute("departamentos", deptos);
        request.setAttribute("categorias", categorias);
        
        chain.doFilter(request, response);  // invokes next filter in the chain
 
    }
}