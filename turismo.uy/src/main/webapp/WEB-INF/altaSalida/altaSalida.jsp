<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@page import="servlets.altaSalida" %>

<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="/WEB-INF/templates/Head.jsp"/>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"
	integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
	crossorigin="anonymous"></script>
	<title>Turismo.uy</title>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/Navbar.jsp"/>
	<div class="row mt-5 mt-lg-0" style="padding-top: 10%; max-width: 1600px; padding-left: 5%; padding-right: 5%;">

		<jsp:include page="/WEB-INF/templates/AccesoCasosDeUso.jsp" />
				<%
		String error_msg = (String)request.getAttribute("SalidaFailedError");
		if (error_msg != null) {
		%>
			<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
			<script>
			$( document ).ready(async function(e){
				await Swal.fire({
				            position: 'center',
				            icon: 'error',
				            title: 'Error en la alta de salida',
				            text: '<%=error_msg%>',
				            showConfirmButton: false,
				            timer: 3000,
				});
			});
			</script>
		<%
		}
		%>
		
		<div class="col-sm-8 text-center">
		
		     <div class="card mb-3 formularioRegistro shadow">
                <div class="card-body">
                    <h5 class="card-title mb-3">Registrar Salida</h5>
                    
					<form method="GET" action="altaSalida" enctype="multipart/form-data" id="seleccionarDepto">
                        <div class="mb-4 text-start needs-validate">
                        	<div>
                        		<label for="nombreDep" class="form-label">Departamento donde se llevará a cabo la salida</label>
                        	</div>
                            <div>
	                            <select id="nombreDep" name="nombreDep" class="form-select non-empty" required >
	                                <option value="" disabled <%if(request.getAttribute("nombreDep") == null){ %>selected="selected"
	                                <%} %>> Seleccione un Departamento</option>
	                 					
	                 				<%
	                 				List<String> deptos = (List<String>)request.getAttribute("listadoDepartamentos");
	                 				for (String depto: deptos) {
									%>
										<option value="<%= depto %>" <%if(request.getAttribute("nombreDep") != null && request.getAttribute("nombreDep").equals(depto)){ 
										%> selected="selected" <%} %>><%= depto %></option>
									<%
										}
									%>
	                            </select>
                            </div>
                          <div id="validarDepto" class="invalid-feedback">
	                          Es obligatorio seleccionar un departamento.
	                      </div>
                        </div>
                       </form>
                        
				<form method="POST" action="altaSalida" enctype="multipart/form-data" id="formAltaSalida">
                        <div class="mb-4 text-start needs-validate">
                            <label for="ciudad">Actividad:</label>
                            <select id="actividad" name="actividad" class="form-select non-empty" required>
                                <option value="" selected disabled>Seleccione una Actividad</option>
                                
                                <%
                               		if(request.getAttribute("listaAct") != null){
                               			Set<String> nombreActs = (Set<String>) request.getAttribute("listaAct");
										for (String act:  nombreActs) {
								%>
										<option value="<%= act %>"><%= act %></option>
								<%
										}
                               		}
								%>
                            </select>
                          <div id="validarAct" class="invalid-feedback">
	                          Es obligatorio seleccionar una actividad.
	                      </div>
                        </div>

                        <div class="mb-4 text-start needs-validate check input" id="nombreSDiv">
                            <label  for="nombre" class="form-label">Nombre : </label>
                            <input id="nombreSText" type="text" name="nombre"
                                placeholder="Nombre de la salida" class="form-control non-empty" required>
                          <div id="validarNombre" class="invalid-feedback">
	                          El campo nombre es obligatorio.
	                      </div>
                        </div>

                        <div class="mb-4 text-start row needs-validate">
                            <div class="col">
                                <label for="duracion" class="form-label">Fecha de salida: </label>
                                <input id="fecha" type="date" name="fechaNuevaYUnica" class="form-control w-75 non-empty" required>
                            </div>
                            <div class="col">
                                <label for="costo" class="form-label">Hora de salida: </label>
                                <input type="number" min="0" max="23" name="hora"
                                placeholder="Hora de salida" class="form-control non-empty" required>
                            </div>
                        </div>
                        
                        <div class="mb-4 text-start needs-validate check input" id="lugarDeSalidaDiv">
                            <label for="nombre" class="form-label">Lugar : </label>
                            <input id="lugarDeSalidaText" type="text" name="lugar"
                                placeholder="Lugar de la salida" class="form-control non-empty" required>
                          <div id="validarLugar" class="invalid-feedback">
	                          El campo lugar es obligatorio.
	                      </div>
                        </div>
                        
                        <div class="mb-4 text-start needs-validate check input" id="validarMaxTuDiv">
                            <label id="cantidadMaximaDeTuristas" for="nombre" class="form-label">Cantidad maxima de turistas : </label>
                            <input type="number" min="0" name="cantMaxTur"
                                placeholder="Cantidad maxima de turistas" class="form-control non-empty" required>
                          <div id="validarMaxTuText" class="invalid-feedback">
	                          El campo cantidad maxima de turistas es obligatorio.
	                      </div>                        
	                   </div>

                        <div class="mb-4 text-start row g-3 align-items-center">
                            <div class="col-auto">
                                <label for="fotoDeLaSalida" class="form-label">Subir foto de la salida</label>
                            </div>
                            <div class="ps-lg-3 col-auto">
                                <input name="fotoDeLaSalida" type="file" class="form-control">
                            </div>
                        </div>

                        <div class="mb-3">
                            <button type="submit" class="btn btn-primary" id="submitBtn">Registrar</button>
                        </div>

                    </form>
                </div>
            </div>


		</div>
	</div>

	<jsp:include page="/WEB-INF/templates/Footer.jsp" />
	<script src="js/altaSalida.js"></script>
</body>
</html>