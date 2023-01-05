<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="servlets.salida"%>
<%@page import="webservices.DtTurista"%>
<%@page import="webservices.DtPaquete"%>
<%@page import="webservices.DtActividad"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Set"%>
<!DOCTYPE html>
<html lang="es">

<head>
	<jsp:include page="/WEB-INF/templates/Head.jsp" />
    <title>Turismo.uy</title>
</head>

<body>
	<jsp:include page="/WEB-INF/templates/Navbar.jsp" />
	
	<% 
	DtPaquete paquete = (DtPaquete) request.getAttribute("paquete");
	Set<DtActividad> actividadesPaquete = (Set<DtActividad>) request.getAttribute("datosActividadPaquete");
	%>
	
	<div class="row mt-5 mt-lg-0 container-principal">
	
		<jsp:include page="/WEB-INF/templates/AccesoCasosDeUso.jsp" />

        <!-- contenido individual -->
		<div class="col-sm-6 text-center">
			<div class="card mb-3" style="max-width: 800px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="<%= paquete.getImgDir() %>" class="img-fluid rounded-start" alt="...">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title"><%= paquete.getNombre() %></h5>
							<p class="card-text"><%= paquete.getDescripcion() %></p>
							<%
							if(session.getAttribute("usuario_logueado") instanceof DtTurista && !(actividadesPaquete.isEmpty())){
							%>
							<div><a href="paquete?nombrePaquete=<%= paquete.getNombre() %>&COMPRA=1">Comprar Paquete Turístico</a></div>
							<%
							}
							%>
							<p class="card-text"><small class="text-muted">Fecha de alta: 
								<%= 
									new SimpleDateFormat("dd/MM/yyyy").format(paquete.getFechaAlta().toGregorianCalendar().getTime())
								%></small></p>
						</div>
					</div>
				</div>
			</div>
			
			<div class="card mb-3" style="max-width: 800px;">
				<div class="card-body">
				
					<form>
		                    
		            	<fieldset disabled>
		                	<div class="row g-3 align-items-center pt-3">
		                    	<div class="col-auto">
		                        	<i class="fa fa-calendar prefix white-text"></i>
		                        	<label for="inputPassword6" class="col-form-label disabled'">Validez:</label>
		                        </div>
		                        <div class="col-auto">
		                        	<input type="text" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="<%= paquete.getPeriodoValidez() %> dias">
		                    	</div>
		                    </div>
						</fieldset>
						
		                <fieldset disabled>
							<div class="row g-3 align-items-center pt-3">
								<div class="col-auto">
									<i class="fa fa-ticket prefix white-text"></i>
									<label for="inputPassword6" class="col-form-label">Descuento:</label>
								</div>
								<div class="col-auto">
									<input type="text" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="<%= paquete.getDescuento() %>%">
								</div>
							
							</div>
						</fieldset>
						
						<fieldset disabled>
							<div class="row g-3 align-items-center pt-3">
								<div class="col-auto">
									<i class="fa fa-tags prefix white-text"></i>
									<label for="inputPassword6" class="col-form-label disabled'">Categorias:</label>
								</div>
								<% 
									for(String categoria: paquete.getCategorias()){
								%>
								<div class="col-auto">
									<a href="categoria?nombreCat=<%= categoria %>" class="badge bg-secondary"><%= categoria %></a>
								</div>
								<% } %>
							</div>
						</fieldset>
				
		  			</form>
				</div>
			</div>
		</div>

		<div class="col-sm-3">
            <div class="card border-light mb-5 mx-auto text-center text-lg-start" style="max-width: 18rem; ">
                <div class="card-header fw-semibold">ACTIVIDADES DEL PAQUETE</div>
                <div class="card-body p-0">
                    <ul class="list-group list-group-flush">
                        
                        <%
                        	for(DtActividad actividad: actividadesPaquete){
                        %>
                        
                        <div class="list-group-item p-1">
                            <a class="text-decoration-none" href="consultaActividad?nombreAct=<%= actividad.getNombre() %>">
                                <div class="row g-0 align-middle">
                                    <div class="col-md-4">
                                        <img src="<%= actividad.getImgDir() %>" class="img-fluid rounded-start" alt="...">
                                    </div>
                                    <div class="col-md-8 pt-2 pt-lg-0 ps-lg-2 align-self-center">
                                        <ul class="list-group list-group-flush">
                                            <p class="list-group-item list-group-item-action"><%= actividad.getNombre() %></p>
                                        </ul>
                                    </div>
                                </div>
                            </a>
                        </div>
                        
                        <% } %>
                        
                    </ul>
                </div>
            </div>
        </div>
        <!-- contenido individual -->

    </div>
	
	<jsp:include page="/WEB-INF/templates/Footer.jsp" />
	
</body>
</html>