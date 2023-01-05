<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@page import="webservices.DtActividad" %>
<%@page import="webservices.DtSalida" %>
<%@page import="webservices.DtPaquete" %>
<%@page import="webservices.DtUsuario" %>
<%@page import="webservices.DtTurista" %>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>

<!doctype html>
<html>
	<head>
		<link rel="stylesheet" href="media/style/altaUsuario.css">
		<jsp:include page="/WEB-INF/templates/Head.jsp"/>
		<title>Turismo.uy</title>	
	</head>
    <body>
		<jsp:include page="/WEB-INF/templates/Navbar.jsp"/>
		<div class="row mt-5 mt-lg-0" style="padding-top: 10%; max-width: 1600px; padding-left: 5%; padding-right: 5%;">
			
			
			<div class="col-sm-8 text-center">
			
			<%
				DtActividad actividad = (DtActividad) request.getAttribute("datosActividad");
			%>
			
			<div class="card mb-3" style="max-width: 800px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="<%= actividad.getImgDir() %>" class="img-fluid rounded-start" alt="...">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title"><%= actividad.getNombre() %></h5>
							<p class="card-text"><%= actividad.getDescripcion() %></p>
							<p class="card-text"><small class="text-muted">Fecha alta:
							<%= 
									new SimpleDateFormat("dd/MM/yyyy").format(actividad.getFechaAlta().toGregorianCalendar().getTime())
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
		                        	<i class="fa fa-clock prefix white-text"></i>
		                        	<label for="inputPassword6" class="col-form-label disabled'">Duración:</label>
		                        </div>
		                        <div class="col-auto">
		                        	<input type="text" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="<%= actividad.getDuracionHs()%> hs">
		                    	</div>
		                    </div>
						</fieldset>
						
		                <fieldset disabled>
							<div class="row g-3 align-items-center pt-3">
								<div class="col-auto">
									<i class="fa-solid fa-money-bill prefix white-text"></i>
									<label for="inputPassword6" class="col-form-label">Costo:</label>
								</div>
								<div class="col-auto">
									<input type="text" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder="<%= actividad.getCosto()%> $">
								</div>
							
							</div>
						</fieldset>
						
						<fieldset disabled>
							<div class="row g-3 align-items-center pt-3">
								<div class="col-auto">
									<i class="fa fa-building prefix white-text"></i>
									<label for="inputPassword6" class="col-form-label">Ciudad:</label>
								</div>
								<div class="col-auto">
									<input type="text" id="inputPassword6" class="form-control disabled" aria-describedby="disabled" placeholder=<%= actividad.getNombreCiudad() %>>
								</div>
							              
							</div>
						</fieldset>
						
					 	<fieldset disabled>
							<div class="row g-3 align-items-center pt-3">
								<div class="col-auto">
									<i class="fa fa-video prefix white-text"></i>
									<label for="video" class="col-form-label">Video:</label>
								</div>
								<a href="<%=actividad.getUrl()%>" style=texto-decoration:none>
								<div class="col">
									<input type="text" name="video" class="form-control disabled" aria-describedby="disabled" placeholder=<%= actividad.getUrl() %>>
								</div>
								</a>
							              
							</div>
						</fieldset>
						
						<fieldset disabled>
							<div class="row g-3 align-items-center pt-3">
								<div class="col-auto">
									<i class="fa fa-star prefix white-text"></i>
									<label for="favorita" class="col-form-label">Cantidad de veces marcada como Favorita :</label>
								</div>
								<div class="col">
									<input type="text" name="favorita" class="form-control disabled" aria-describedby="disabled" placeholder=<%= actividad.getLikedBy().size() %>>
								</div>
							</div>
						</fieldset>
						
						<%
						if (session.getAttribute("usuario_logueado") != null) {
					  		DtUsuario usr = (DtUsuario)session.getAttribute("usuario_logueado");
					  		if (usr instanceof DtTurista) {
								List<String> usuariosConEstaActFavorita = actividad.getLikedBy();
								Boolean esFavorita = false;
								// si el usuario marco como favorita esta actividad
								for (String u : usuariosConEstaActFavorita) {
							  		if (usr.getNickname().equals(u)) {
							  		  	esFavorita = true;
							  		  	break;
							  		}
							  	}
							 	if (esFavorita) {%>
								 	<fieldset disabled>
										<div class="row g-3 align-items-center pt-3">
											<div class="col-auto">
												<i class="fa fa-star prefix white-text"></i>
												<label for="tufavorita" class="col-form-label">Para tí :</label>
											</div>
											<div class="col">
												<input type="text" name="tufavorita" class="form-control disabled" aria-describedby="disabled" placeholder="Esta actividad la has marcado como favorita !">
											</div>
										</div>
									</fieldset>
							 <%	  
							 	} // cierre if es favorita
					  		} // cierre es turista
						 } // cierre if logueado %>
		                
						<fieldset disabled>
							<div class="row g-3 align-items-center pt-3">
								<div class="col-auto">
									<i class="fa fa-tags prefix white-text"></i>
									<label for="inputPassword6" class="col-form-label disabled'">Categorias:</label>
								</div>
								
								<%
									for(String categoria: actividad.getNombCategorias()){
								%>
								<div class="col-auto">
									<a href="#" class="badge bg-secondary"><%= categoria %></a>
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
                <div class="card-header fw-semibold">SALIDAS DE ACTIVIDAD</div>
                <div class="card-body p-0">
                    <ul class="list-group list-group-flush">
                    
                    <%
                    	Set<DtSalida> salidasActividad = (Set<DtSalida>) request.getAttribute("datosSalidaActividad");
						for(DtSalida salida: salidasActividad){
					%>
                        <div class="list-group-item p-1">
                            <a class="text-decoration-none" href="unaSalida?nombreSalida=<%= salida.getNombre() %>">
                                <div class="row g-0 align-middle">
                                    <div class="col-md-4">
                                        <img src="<%= salida.getImgDir() %>" class="img-fluid rounded-start" alt="...">
                                    </div>
                                    <div class="col-md-8 pt-2 pt-lg-0 ps-lg-2 align-self-center">
                                        <ul class="list-group list-group-flush">
                                            <p class="list-group-item list-group-item-action"><%= salida.getNombre() %></p>
                                        </ul>
                                    </div>
                                </div>
                            </a>
                        </div>
 					<% } %>
 
                    </ul>
                </div>
            </div>
            <div class="card border-light mb-5 mx-auto text-center text-lg-start" style="max-width: 18rem; ">
                <div class="card-header fw-semibold">PAQUETES ASOCIADOS</div>
                <div class="card-body p-0">
                    <ul class="list-group list-group-flush">
                    
                   <%
                    	Set<DtPaquete> paquetesActividad = (Set<DtPaquete>) request.getAttribute("datosPaqueteActividad");
						for(DtPaquete paquete: paquetesActividad){
					%>
                    
                        <div class="list-group-item p-1">
                            <a class="text-decoration-none" href="#">
                                <div class="row g-0 align-middle">
                                    <div class="col-md-4">
                                        <img src="<%= paquete.getImgDir() %>" class="img-fluid rounded-start" alt="...">
                                    </div>
                                    <div class="col-md-8 pt-2 pt-lg-0 ps-lg-2 align-self-center">
                                        <ul class="list-group list-group-flush">
                                            <p class="list-group-item list-group-item-action"><%= paquete.getNombre() %></p>
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
			
			
        </div>
	</body>
</html>
