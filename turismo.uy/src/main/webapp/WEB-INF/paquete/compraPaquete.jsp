<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@page import="servlets.paquete" %>
<%@page import="webservices.DtPaquete"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="/WEB-INF/templates/Head.jsp" />
		<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
    	<title>Turismo.uy</title>
	</head>
	
	<body>
		<jsp:include page="/WEB-INF/templates/Navbar.jsp" />
		
		<%
		String error_msg = (String)request.getAttribute("CompraFailError");
		if (error_msg != null) {
		%>
			<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
			<script>
			$( document ).ready(async function(e){
				await Swal.fire({
				            position: 'center',
				            icon: 'error',
				            title: 'Error en la compra',
				            text: '<%=error_msg%>',
				            showConfirmButton: false,
				            timer: 3000,
				});
			});
			</script>
		<%
		}
		%>
		
		<% DtPaquete paquete = (DtPaquete) request.getAttribute("paquete"); %>
		
		<div class="row mt-5 mt-lg-0" style="padding-top: 10%; max-width: 1600px; padding-left: 5%; padding-right: 5%;">
			<jsp:include page="/WEB-INF/templates/AccesoCasosDeUso.jsp"/>
			<div class="col-sm-9 text-center">
			
				<div class="card mb-3" style="max-width: 800px;">
					<div class="row g-0">
						<div class="col-md-4">
							<img src="<%= paquete.getImgDir() %>" class="img-fluid rounded-start" alt="...">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title"><%= paquete.getNombre() %></h5>
								<p class="card-text"><%= paquete.getDescripcion() %></p>
								<p class="card-text">Costo por persona: <%= paquete.getCosto() %> $</p>
								<p class="card-text"><small class="text-muted">Fecha de alta: 
									<%= 
										new SimpleDateFormat("dd/MM/yyyy").format(paquete.getFechaAlta().toGregorianCalendar().getTime())
									%></small></p>
							</div>
						</div>
					</div>
				</div>
				
				<div class="card mb-3 formularioCompraPaquete shadow" style="max-width: 800px">
					<div class="card-body">
						<h5 class="card-title">Compra de Paquete</h5>
						
		              		
						<form method="POST" action="paquete" id="FormularioCompraPaquete" enctype="multipart/form-data" >
							
							<input type="hidden" name="nombrePaquete" value="<%=paquete.getNombre()%>" />
							
							<div class="mb-4 text-start" id="CantCompraPaqDiv">
								<label for="Cantidad" class = "form-label" id="CantCompraPaqLabel">Cantidad de turistas</label>
								<input type="number" step="1" min="1" name="Cantidad" id="CantCompraPaqText" placeholder="Ingrese la cantidad de turistas" class ="form-control" aria-describedby="CantcompraPaqTextNullValidate" required>
		                      	<div id="CantcompraPaqTextNullValidate" class="invalid-feedback">
		                         	El campo Cantidad de turistas es obligatorio y deber ser mayor a 0.
		                      	</div>
							</div>
							
							<div class="mb-3">
		                      		<button type="submit" class="btn btn-primary" id="btnComprar">Comprar</button>
		                  	</div>
		                  	
						</form>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/templates/Footer.jsp"/>
		<script src="js/compraPaquete.js"></script>
	</body>
</html>