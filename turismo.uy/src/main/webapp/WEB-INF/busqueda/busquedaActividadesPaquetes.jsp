<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="servlets.categoria"%>
<%@page import="webservices.DtPaquete"%>
<%@page import="webservices.DtActividad"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">

<head>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
	<jsp:include page="/WEB-INF/templates/Head.jsp" />
	<title>Turismo.uy</title>
</head>

<body>
	<jsp:include page="/WEB-INF/templates/Navbar.jsp" />
	
	<div class="row mt-5 mt-lg-0"
		style="padding-top: 10%; max-width: 1600px; padding-left: 5%; padding-right: 5%;">
		
		<jsp:include page="/WEB-INF/templates/AccesoCasosDeUso.jsp" />
		
		<div id="centralDiv" class="col-sm-8 text-center">
		
			<%
			@SuppressWarnings("unchecked")
			List<DtActividad> actividades = (List<DtActividad>) request.getAttribute("datosActividades");
			
			@SuppressWarnings("unchecked") 
			List<DtPaquete> paquetes = (List<DtPaquete>) request.getAttribute("datosPaquetes");
			%>
			<form method="GET" action="busquedaTexto" id="FormOrdenar">
				<div class="row g-3 mb-4 align-items-right mt-3">
					<div class ="col-auto"><%=actividades.size() + paquetes.size() %> resultados</div>
					
					<div class="col mb-6" style="text-align: right">
		            	<label for="orden" class ="form-label">Ordenar por: </label>
		            </div>
		            <div class="col-auto">
						<select id ="orden" name ="orden" class="form-select non-empty">
							<option value="Seleccionar" selected disabled> Elija una opción </option>
							<option value="alfabetico">Alfababéticamente (ascendente)</option>
							<option value="anio">Año (descendente)</option>
						</select>
					</div>
				</div>
			</form>
			
		
			<div>
				<h3>Actividades</h3>
			</div>
		
			<%	
			for (DtActividad act : actividades) {
			%>
			
			<a class="text-decoration-none" href="consultaActividad?nombreAct=<%=act.getNombre()%>">
						<div
							class="card mb-3 rounded-3 bg-image shadow-1-strong hover card-backgroundImg"
							style="background-image: url('<%=act.getImgDir()%>');">
							<div class="row g-0 mask card-color">
								<div class="col-md-4 align-self-center">
									<img src="<%=act.getImgDir()%>"
										class="img-fluid p-2 p-lg-0 ps-lg-3 my-lg-3 rounded-3"
										alt="actividad Turistica: <%=act.getNombre()%>">
								</div>
								<div class="col-md-8">
									<div class="card-body text-white">
										<h5 class="card-title"><%=act.getNombre()%></h5>
										<p class="card-text"><%=act.getDescripcion()%></p>
									</div>
								</div>
							</div>
						</div>
					</a>
			
			<%
			}
			%>
			
			<div>
				<h3>Paquetes</h3>
			</div>
		
			<%	
			for (DtPaquete paq : paquetes) {
			%>
			
				<a class="text-decoration-none" href="paquete?nombrePaquete=<%=paq.getNombre()%>">
					<div
						class="card mb-3 rounded-3 bg-image shadow-1-strong hover card-backgroundImg"
						style="background-image: url('<%=paq.getImgDir()%>');">
						<div class="row g-0 mask card-color">
							<div class="col-md-4 align-self-center">
								<img src="<%=paq.getImgDir() %>"
									class="img-fluid p-2 p-lg-0 ps-lg-3 my-lg-3 rounded-3"
									alt="actividad Turistica: <%=paq.getNombre()%>">
							</div>
							<div class="col-md-8">
								<div class="card-body text-white">
									<h5 class="card-title"><%=paq.getNombre()%></h5>
									<p class="card-text"><%=paq.getDescripcion()%></p>
								</div>
							</div>
						</div>
					</div>
				</a>
			
			<%
			}
			%>
		
		</div>
		
	</div>

	<jsp:include page="/WEB-INF/templates/Footer.jsp" />
	
	<script src="js/busquedaActividadesPaquetes.js"></script>
</body>

</html>