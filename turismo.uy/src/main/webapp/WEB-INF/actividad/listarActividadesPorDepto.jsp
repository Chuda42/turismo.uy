<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="servlets.departamento"%>
<%@page import="webservices.DtActividad"%>
<%@page import="webservices.DtUsuario"%>
<%@page import="webservices.DtTurista"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">

<head>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
crossorigin="anonymous"></script>
		<script src="js/home.js"></script>
	<jsp:include page="/WEB-INF/templates/Head.jsp" />
	<title>Turismo.uy</title>
</head>

<body>
	<jsp:include page="/WEB-INF/templates/Navbar.jsp" />
	
	<div class="row mt-5 mt-lg-0"
		style="padding-top: 10%; max-width: 1600px; padding-left: 5%; padding-right: 5%;">
		
		<jsp:include page="/WEB-INF/templates/AccesoCasosDeUso.jsp" />
		
		<div class="col-sm-8 text-center">
	
			<%	
			@SuppressWarnings("unchecked") 
			Set<DtActividad> actividades = (Set<DtActividad>) request.getAttribute("datosActividades");
			for (DtActividad act : actividades) {
			%>
			<div
				class="card mb-3 rounded-3 bg-image shadow-1-strong hover card-backgroundImg"
				style="background-image: url('<%=act.getImgDir()%>');">
				<div class="row g-0 mask card-color">
					<div class="col-md-4 align-self-center">
						<a class="text-decoration-none" href="consultaActividad?nombreAct=<%=act.getNombre()%>">
							<img src="<%=act.getImgDir() %>"
								class="img-fluid p-2 p-lg-0 ps-lg-3 my-lg-3 rounded-3"
								alt="actividad Turistica: <%=act.getNombre()%>">
						</a>
					</div>
						<div class="col-md-8">
							<div class="card-body text-white">
								<h5 class="card-title"><%=act.getNombre()%></h5>
								<p class="card-text"><%=act.getDescripcion()%></p>
							</div>
																<%
							// si hay un usuario logueado
							if (session.getAttribute("usuario_logueado") != null) {
								  	DtUsuario usr = (DtUsuario)session.getAttribute("usuario_logueado");
								  	if (usr instanceof DtTurista) {
										List<String> usuariosConEstaActFavorita = act.getLikedBy();
										Boolean esFavorita = false;
										// si el usuario marco como favorita esta actividad
										for (String u : usuariosConEstaActFavorita) {
										  	if (usr.getNickname().equals(u)) {
										  	  	esFavorita = true;
										  	  	break;
										  	}
										}
							%>
							<div class="card-body text-white position-absolute bottom-0 end-0 btn btn-info me-2 mb-2 px-3 py-2"
								onclick="marcarDesmarcarFavoritos(this)"
							>
								<input type="hidden" name="esFav" value="<%=esFavorita%>">
								<input type="hidden" name="act" value="<%=act.getNombre()%>">
								<input type="hidden" name="usr" value="<%=usr.getNickname()%>">
								<div class="d-flex justify-content-end">
										<%
										// y marco la actividad como favorita
										if (!esFavorita) {
										%>
									<p class="my-auto me-4">Marcar como Favorito</p>
									<p class="my-auto me-4"><%=usuariosConEstaActFavorita.size()%></p>
									<div>
										<i class="fa fa-regular fa-star fa-2x my-auto"></i>
									</div>
										<%
										// sino
										} else {
										%>
									<p class="my-auto me-4">Desmarcar de Favoritos</p>
									<p class="my-auto me-4"><%=usuariosConEstaActFavorita.size()%></p>
									<div>
										<i class="fa fa-solid fa-star fa-2x my-auto"></i>
									</div>
										<% } %>
								</div>
							</div>
							<%
								} // ciera el if turista 
							} // cierra el if logueado %>
								</div>
							</div>
						</div>
			<%
			}
			%>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/templates/Footer.jsp" />
</body>

</html>