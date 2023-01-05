<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlets.consultaUsuario"%>
<%@page import="webservices.DtUsuario"%>
<%@page import="webservices.DtSalida"%>
<%@page import="webservices.DtCompra"%>
<%@page import="webservices.DtTurista"%>
<%@page import="webservices.DtActividad"%>
<%@page import="webservices.EstadoActividad"%>
<%@page import="webservices.DtProveedor"%>
<%@page import="webservices.DtPaquete"%>
<%@page import="webservices.DtSalidaArray"%>
<%@page import="webservices.DtActividadArray"%>
<%@page import="webservices.DtInscripcion"%>
<%@page import="webservices.ActividadDao"%>

<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html lang="es">

<head>
<jsp:include page="/WEB-INF/templates/Head.jsp" />
<title>Tursimo.uy</title>

<style>
.sameImg img {
	height: 210px;
	object-fit: cover;
}
</style>
</head>

<body>

	<jsp:include page="/WEB-INF/templates/Navbar.jsp" />
	
	<div class="row mt-5 mt-lg-0 container-principal">
		
		<jsp:include page="/WEB-INF/templates/AccesoCasosDeUso.jsp" />
		
		<% 
		List<DtUsuario> listaUsuarios = (List<DtUsuario>) request.getAttribute("usuarios");
		%>
		<div class="text-center col-sm-9">
			<%
			if (listaUsuarios.isEmpty()) {
			%>
				<h1>No hay usuarios.</h1>
			<%
			} else {
			%>
			<div class="row row-cols-3 gy-3">
				<%for (DtUsuario usuario : listaUsuarios) {
				%>
				<div class="col">
					<a
						href="consultaUsuario?STATE=INFO&&NICKNAME=<%=usuario.getNickname()%>">
						<div class="card rounded sameImg mb-1" style="width: 15rem;">
							<img class="card-img-top" src="<%=usuario.getImgDir()%>"
								alt="Card image cap">
							<div class="card-body">

								<p class="card-text"><%=usuario.getNombre()%></p>
							</div>
						</div>
					</a>
				</div>
				<%
				}
				%>
			</div>
		</div>
		<%
		}
		%>
	</div>
		
			<jsp:include page="/WEB-INF/templates/Footer.jsp" />
			<script
				src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
				
			</script>
			<script src="https://code.jquery.com/jquery-3.6.1.min.js"
				integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
				crossorigin="anonymous"></script>
</body>

</html>