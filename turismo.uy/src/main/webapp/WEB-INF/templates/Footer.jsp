<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@page import="webservices.DtUsuario"%>

<%
	DtUsuario usr = (DtUsuario) session.getAttribute("usuario_logueado");
	if (usr == null) {
	%>
		<div class="footer row">
			<div class="row container m-0 p-0 ps-5 footerEstatico fixed-bottom">
		    	<p class="col text-end my-auto copyright-color">© All rights reserved to Turismo.uy 2022 </p>
		    </div>
		</div>
	<%
	}else{
	%>
	  	<div class="footer row">
	        <div class="row container m-0 p-0 ps-5 footerEstatico fixed-bottom">
	            <p class="col float-start my-2">
	                <a href="cerrarSesion" class="text-decoration-none">
	                    <i class="fa fa-sign-out"></i>
	                    Cerrar Sesión
	                </a>
	            </p>
	            <p class="col text-end my-auto copyright-color">© All rights reserved to Turismo.uy 2022 </p>
	        </div>
	    </div>
	<%
	}
	%>

