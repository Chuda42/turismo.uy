<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="webservices.DtActividad"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">

<head>

	<jsp:include page="/WEB-INF/templates/Head.jsp" />
	<title>Turismo.uy</title>
</head>

<body>
	<jsp:include page="/WEB-INF/templates/Navbar.jsp" />
	<%String depto = null; %>
	<form  method="post" action="consultaActividad" id="FormDepto" >
		<div class="dropdown mt-5 d-flex flex-col text-center">

		             <label style="font-family: 'Prompt', sans-serif; margin-left:40px; margin-right:40px;"class="form-label ml-4 mt-2" for="form1Example23">FILTRAR DEPARTAMENTO:</label>
		       
	<select id ="deepto" name ="departamentoSeleccionado" style="    width: 50%;" class="form-select non-empty">
	<%if (request.getAttribute("nombreDepartamento") == null){ %>
							<option style="font-family: 'Prompt', sans-serif;" value="Seleccionar" selected disabled > Elija una opción </option>  
							<%} else { %>   
							<option value="Seleccionar" style="font-family: 'Prompt', sans-serif;" selected disabled><%=request.getAttribute("nombreDepartamento")  %> </option>        
                        
  <%}
  List<String> departamentos = (List<String>) request.getAttribute("departamentos");
  for(String deptos : departamentos){
		if (request.getAttribute("nombreDepartamento") != null && request.getAttribute("nombreDepartamento").equals( deptos) ){ %>
  %>     
    <%}else{ %>
      <option value="<%=deptos%>"style="font-family: 'Prompt', sans-serif;" > <%=deptos%></option>
      <%}} %>
  </select>
</div> 
</form>
	<div class="row mt-5 mt-lg-0"
		style="padding-top: 10%; max-width: 1600px; padding-left: 5%; padding-right: 5%;">
	
	
		<div class="col-sm-12 text-center">
	
			<%	
			@SuppressWarnings("unchecked") 
			Set<DtActividad> actividades = (Set<DtActividad>) request.getAttribute("datosActividades");
			for (DtActividad act : actividades) {
			%>
			<a class="text-decoration-none" href="unaActividad?nombreAct=<%=act.getNombre()%>">
						<div class="card mb-3 rounded-3 bg-image shadow-1-strong hover card-backgroundImg" style="background-image: url('<%=act.getImgDir()%>');">
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
		</div>
	</div>
	<script src="js/consultaActividad.js"></script>
</body>

</html>