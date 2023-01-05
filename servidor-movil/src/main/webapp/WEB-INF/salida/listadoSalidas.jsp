<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Set"%>
<%@page import="webservices.DtSalida"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/templates/Head.jsp" />
<title>Turismo.uy</title>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/Navbar.jsp" />

	<div class="row mt-5 mt-lg-0"
		style="padding-top: 10%; max-width: 1600px; padding-left: 5%; padding-right: 5%;">
x

		<div class="col-sm-12 text-center">

			<%
			@SuppressWarnings("unchecked")
			Set<DtSalida> salidas = (Set<DtSalida>) request.getAttribute("datosSalidas");
		   	
			for (DtSalida s : salidas) {
			    
			%>
				<a href="unaSalida?nombreSalida=<%= s.getNombre() %>" class="text-decoration-none">
					<div
						class="card mb-3 rounded-3 bg-image shadow-1-strong hover card-backgroundImg"
						style="background-image: url('<%=s.getImgDir()%>');">
						<div class="row g-0 mask card-color">
							<div class="col-md-4 align-self-center">
								<img src="<%=s.getImgDir()%>"
									class="img-fluid p-2 p-lg-0 ps-lg-3 my-lg-3 rounded-3"
									alt="salida Turistica: <%=s.getNombre()%>">
							</div>
							<div class="col-md-8">
								<div class="card-body text-white">
									<h5 class="card-title"><%=s.getNombre()%></h5>
									<p class="card-text"><%=s.getNombreActividad()%></p>
									<p class="card-text"><%=s.getNombreDepartamentoActividad()%></p>
									<p class="card-text">Fecha y Hora : <%=new SimpleDateFormat("dd/MM/yyyy - HH:mm").format(s.getFechaSalida().toGregorianCalendar().getTime())%></p>
									<p class="card-text"><%=s.getLugarSalida()%></p>
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
	<!-- Grid row -->
</body>
</html>