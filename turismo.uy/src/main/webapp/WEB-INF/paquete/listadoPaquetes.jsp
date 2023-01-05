<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Set"%>
<%@page import="webservices.DtPaquete"%>

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
		
		<jsp:include page="/WEB-INF/templates/AccesoCasosDeUso.jsp" />
		
		<div class="col-sm-8 text-center">
			<%
			@SuppressWarnings("unchecked")
			Set<DtPaquete> paquetes = (Set<DtPaquete>) request.getAttribute("paquetes");  
			
			for (DtPaquete p : paquetes) {
			%>
			<a href="paquete?nombrePaquete=<%= p.getNombre() %>&COMPRA=1" class="text-decoration-none">
				<div
					class="card mb-3 rounded-3 bg-image shadow-1-strong hover card-backgroundImg"
					style="background-image: url('<%=p.getImgDir()%>');">
					<div class="row g-0 mask card-color">
						<div class="col-md-4 align-self-center">
							<img src="<%=p.getImgDir()%>"
								class="img-fluid p-2 p-lg-0 ps-lg-3 my-lg-3 rounded-3"
								alt="paquete Turistico: <%=p.getNombre()%>">
						</div>
						<div class="col-md-8">
							<div class="card-body text-white">
								<h5 class="card-title"><%=p.getNombre()%></h5>
								<p class="card-text"><%=p.getDescripcion()%></p>
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
</body>
</html>