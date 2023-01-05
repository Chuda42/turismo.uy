<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@page import="servlets.altaActividad" %>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>


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
		String error_msg = (String)request.getAttribute("AltaYaExiste");
		if (error_msg != null) {
		%>
			<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
			<script>
			$( document ).ready(async function(e){
				await Swal.fire({
				            position: 'center',
				            icon: 'error',
				            title: 'Error en el alta',
				            text: '<%=error_msg%>',
				            showConfirmButton: false,
				            timer: 3000,
				});
			});
			</script>
		<%
		}
		%>
		
		<%
		List<String> deptos = (List<String>)request.getAttribute("listaDepartamentos");
		List<String> cates = (List<String>)request.getAttribute("listaCategorias");
		%>
		
		<div class="row mt-5 mt-lg-0" style="padding-top: 10%; max-width: 1600px; padding-left: 5%; padding-right: 5%;">
			<jsp:include page="/WEB-INF/templates/AccesoCasosDeUso.jsp"/>
		
			<div class="col-sm-9 text-center">
			
				<div class="card mb-3 formularioAltaActividad shadow" style="max-width: 800px">
				
					<div class="card-body">
				
						<h5 class="card-title">Alta de Actividad</h5>
						
						
				
						<form method="POST" action="altaActividad" id="FormularioAltaActividad" enctype="multipart/form-data">
						
							<div class="row g-3 mb-4 align-items-center mt-3">
								<div class="col-auto">
									<label for="Departamento" class ="form-label">Seleccione un departamento</label>
								</div>
								<div class="col-auto">
									<select name="Departamento" id="DepartamentoAltaActOption" class="form-control" aria-describedby="DepartamentoAltaActNullValidate">
										<option selected>Seleccionar</option>
										<%
										for(String depto : deptos){
										%>
											<option value="<%=depto%>"><%=depto%></option>
										<%
										} 
										%>
									</select>
									<div id="DepartamentoAltaActNullValidate" class="invalid-feedback">
										Debe seleccionar un departamento para la actividad.
									</div>
								</div>
							</div>
						
							<div class="mb-4 text-start" id="NombreAltaActDiv">
								<label for="Nombre" class = "form-label" id="NombreAltaActLabel">Nombre</label>
								<input type="text" name="Nombre" id="NombreAltaActText" placeholder="Ingrese un nombre" class ="form-control" aria-describedby="NombreAltaActTextNullValidate" required>
	                      		<div id="NombreAltaActTextNullValidate" class="invalid-feedback">
	                         		El campo Nombre es obligatorio.
	                      		</div>
							</div>
							
							<div class="mb-4 text-start" id="DescripcionAltaActDiv">
								<label for="Descripcion" class = "form-label" id="DescripcionAltaActLabel">Descripcion</label>
								<input type="text" name="Descripcion" id="DescripcionAltaActText" placeholder="Ingrese una descripcion" class ="form-control" aria-describedby="DescripcionAltaActTextNullValidate" required>
	                      		<div id="DescripcionAltaActTextNullValidate" class="invalid-feedback">
	                         		El campo Descripcion es obligatorio.
	                      		</div>
							</div>
							
							<div class="mb-4 text-start" id="DuracionAltaActDiv">
								<label for="Duracion" class = "form-label" id="DuracionAltaActLabel">Duracion</label>
								<input type="number" step="1" name="Duracion" id="DuracionAltaActText" placeholder="Ingrese una duracion en horas" class ="form-control" aria-describedby="DuracionAltaActTextNullValidate" required>
	                      		<div id="DuracionAltaActTextNullValidate" class="invalid-feedback">
	                         		El campo Duracion es obligatorio y debe ser mayor a 0
	                      		</div>
							</div>
							
							<div class="mb-4 text-start" id="CostoAltaActDiv">
								<label for="Costo" class = "form-label" id="CostoAltaActLabel">Costo</label>
								<input type="number" step="0.01" name="Costo" id="CostoAltaActText" placeholder="Ingrese el costo" class ="form-control" aria-describedby="CostoAltaActTextNullValidate" required>
	                      		<div id="CostoAltaActTextNullValidate" class="invalid-feedback">
	                         		El campo Costo es obligatorio y debe ser mayor a 0
	                      		</div>
							</div>
							
							<div class="mb-4 text-start" id="CiudadAltaActDiv">
								<label for="Ciudad" class = "form-label" id="CiudadAltaActLabel">Ciudad</label>
								<input type="text" name="Ciudad" id="CiudadAltaActText" placeholder="Ingrese una ciudad" class ="form-control" aria-describedby="CiudadAltaActTextNullValidate" required>
	                      		<div id="CiudadAltaActTextNullValidate" class="invalid-feedback">
	                         		El campo Ciudad es obligatorio.
	                      		</div>
							</div>
							
							<div class="mb-4 text-start" id="CiudadAltaActDiv">
								<label for="URLvideo" class = "form-label" id="URLvideoLabel">URL de video</label>
								<input type="text" name="URLvideo" id="URLvideoText" value="" placeholder="Ingrese un URL de video" class ="form-control" aria-describedby="CiudadAltaActTextNullValidate" required>
							</div>
							
							<div class="row g-3 align-items-center">
	                      		<div class="col-auto">
	                          		<label for="ImagenActividad" class ="form-label">Subir imagen de actividad</label>
	                      		</div>
	                      		<div class="col-auto">
	                          		<input type="file" class="form-control" name="ImagenActividad">
	                      		</div>
	                  		</div>
	                  		
	                  		<div class="row g-3 mb-4 align-items-center mt-3">
	                  			<div class="col-auto">
									<label for="Categorias" class ="form-label">Seleccione la/s categoria/s de la actividad</label>
									<div class="col-auto">
										<select id="CategoriasAltaAct" name="Categorias" multiple="multiple" aria-describedby="CategoriasAltaActNullValidate" required>
										<%
										for(String cat : cates){
										%>
    										<option value="<%=cat%>"><%=cat%></option>
    									<%
										}
    									%>
										</select>
										<div id="CategoriasAltaActNullValidate" class="invalid-feedback">
	                         				Debe seleccionar al menos una categoria.
	                      				</div>
									</div>
								</div>
	                  		</div>
	                  		
	                  		<div class="mb-3">
	                      		<button type="submit" class="btn btn-primary" id="btnRegistrarAct">Registrar</button>
	                  		</div>
						
						</form>
						
					</div>
				
				</div>
			
			</div>
		
		</div>
		
		<jsp:include page="/WEB-INF/templates/Footer.jsp"/>
		<script src="js/altaActividad.js"></script>
	</body>
	
</html>