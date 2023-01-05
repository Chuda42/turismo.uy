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
<%@page import="webservices.InscripcionDao"%>
<%@page import="webservices.SalidaDao"%>

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
		switch ((String) request.getAttribute("STATE")) {
			case "LISTAR" : {
				Set<DtUsuario> listaUsuarios = (Set<DtUsuario>) request.getAttribute("USUARIOS");
				if (listaUsuarios.isEmpty()) {
					%>
					<h1>No hay usuarios.</h1>
					<%
				} else {
					%>
					<div class="text-center col-sm-9">
						<div class="row row-cols-3 gy-3">
							<%for (DtUsuario usuario : listaUsuarios) {%>
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
			break;
		}
		case "INFO" : {
			DtUsuario Usr = (DtUsuario) request.getAttribute("PERFIL_USUARIO");
			DtUsuario miUsr = (DtUsuario) request.getAttribute("MI_PERFIL_USUARIO");
			//mi perfil
			if (miUsr != null) {
			%>
			<div class="col-sm-9 text-center" style="">
				<div class="col-sm" style="margin-right: 12%;">
					<div class="d-flex justify-content-center">
						<div class="card mb-3" style="max-width: 800px; width: 300px;">
							<div class="row g-0">
								<div class="" style="">
									<img src="<%=miUsr.getImgDir()%>"
										id="modificarImagenPerfil" class="img-fluid rounded-start; max-width: 100px;" alt="...">
								</div>
								<div class="col-md-12">
									<div class="card-body">
		
										<h5 class="card-title"><%=miUsr.getNombre()%></h5>
									
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">				
						<%
						List<String> seguidores = miUsr.getSeguidores();
						List<String> seguidos = miUsr.getSeguidos();
						%>
						<div class="d-flex justify-content-between">
							<div class="input-group mb-3 d-flex justify-content-center">
								  <a href="Follows?seguidores=true&&usr=<%=miUsr.getNickname()%>" class="btn btn-primary">
								  	Seguidores
								  </a>
							  <span class="input-group-text"><%=seguidores.size()%></span>
							</div>
							
							<div class="input-group mb-3 d-flex justify-content-center">
								<a href="Follows?seguidos=true&&usr=<%=miUsr.getNickname()%>" class="btn btn-primary">
								  	Seguidos
								</a>
							  <span class="input-group-text"><%=seguidos.size()%></span>
							</div>
						</div>
					</div>
	
	
					<div class="container" style="width: 650px;">
						<div class="row">
							<div class="">
								<div class="card-header">
									<ul class="nav nav-tabs card-header-tabs" id="bologna-list"
										role="tablist">
										<li class="nav-item"><a class="nav-link nav-link active"
											style="color: black;" href="#perfil" role="tab"
											aria-controls="perfil" aria-selected="true">Perfil</a></li>
										<li class="nav-item"><a class="nav-link nav-link-usr"
											href="#salidas" role="tab" aria-controls="salidas"
											aria-selected="false">Salidas</a></li>
										<%
										if (miUsr instanceof DtTurista) {
										%>
	
										<li class="nav-item"><a class="nav-link nav-link-usr"
											href="#inscripciones" role="tab" aria-controls="inscripciones"
											aria-selected="false">Inscripciones</a></li>
										<li class="nav-item"><a class="nav-link nav-link-usr"
											href="#paquetes" role="tab" aria-controls="paquetes"
											aria-selected="false">Paquetes Comprados</a></li>
	
										<%
										} else {
										%>
										<li class="nav-item"><a class="nav-link nav-link-usr "
											href="#actividades" role="tab" aria-controls="actividades"
											aria-selected="false">Actividades ofrecidas</a></li>
										<%
										}
										%>
	
									</ul>
								</div>
	
								<div class="card-body">
									<div class="tab-content mt-3">
	
										<%-- //////////////////////////P E R F I L //////////////////////--%>
										<div class="tab-pane active" id="perfil" role="tabpanel"
											aria-labelledby="perfil-tab">
											<div class="card-body">
	
												<form method="POST" action="consultaUsuario"
													id="FormularioModificarDatos" enctype="multipart/form-data">
													<h4 class=" font-up font-bold py-2 white-text">Datos
														del usuario</h4>
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-user prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Nickname:</label>
															</div>
															<div class="col-auto">
																<input type="text" id="inputPassword6"
																	class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=miUsr.getNickname()%>">
															</div>
															<div class="col-auto">
																<span id="passwordHelpInline" class="form-text">
																	No puede cambiar este campo. </span>
															</div>
														</div>
													</fieldset>
													<div class="row g-3 align-items-center pt-3">
														<div class="col-auto">
															<i class="fa fa-user prefix white-text"></i> <label
																for="Nombre" class="col-form-label">Nombre:</label>
														</div>
														<div class="col-auto">
															<input type="text" value="<%=miUsr.getNombre()%>"
																name="Nombre" class="form-control"
																aria-describedby="passwordHelpInline"
																placeholder="<%=miUsr.getNombre()%>">
														</div>
	
													</div>
	
													<div class="row g-3 align-items-center pt-3">
														<div class="col-auto">
															<i class="fa fa-user prefix white-text"></i> <label
																for="Apellido" class="col-form-label">Apellido:</label>
														</div>
														<div class="col-auto">
															<input type="text" value="<%=miUsr.getApellido()%>"
																name="Apellido" class="form-control"
																aria-describedby="passwordHelpInline"
																placeholder="<%=miUsr.getApellido()%>">
														</div>
	
													</div>
	
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-envelope prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Email:</label>
															</div>
															<div class="col">
																<input type="text" id="inputPassword6"
																	class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=miUsr.getEmail()%>">
															</div>
															<div class="col-auto">
																<span id="passwordHelpInline" class="form-text">
																	No puede cambiar este campo. </span>
															</div>
														</div>
													</fieldset>
	
													<div class="row g-3 align-items-center pt-3">
														<div class="col-auto">
															<i class="fa fa-birthday-cake prefix white-text"></i> <label
																for="FechaNacimiento" class="col-form-label disabled'">Fecha
																de Nacimiento: </label>
														</div>
														<div class="col-auto">
															<input type="text" name="FechaNacimiento"
																value=<%=new SimpleDateFormat("yyyy-MM-dd").format(miUsr.getFechaNac().toGregorianCalendar().getTime())%>
																class="form-control disabled" aria-describedby="disabled"
																onfocus="(this.type='date')" onblur="(this.type='text')"
																placeholder=<%=new SimpleDateFormat("yyyy-MM-dd").format(miUsr.getFechaNac().toGregorianCalendar().getTime())%>>
														</div>
	
													</div>
													
													<% if(miUsr instanceof DtTurista){ %>
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa-solid fa-flag prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Nacionalidad:</label>
															</div>
															<div class="col">
																<input type="text" id="inputPassword6"
																	class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=((DtTurista)miUsr).getNacionalidad()%>">
															</div>
															<div class="col-auto">
																<span id="passwordHelpInline" class="form-text">
																	No puede cambiar este campo. </span>
															</div>
														</div>
													</fieldset>
													<%} else{%>
														<div class="row g-3 align-items-center pt-3">
														<div class="col-auto">
															<i class="fa fa-bookmark prefix white-text"></i> <label
																for="Descripcion" class="col-form-label">Descripcion:</label>
														</div>
														<div class="col">
															<textarea name="Descripcion" class="form-control input-lg"
																aria-describedby="passwordHelpInline"><%=((DtProveedor)miUsr).getDescripcion()%></textarea>
														</div>
	
													</div>
													
													<div class="row g-3 align-items-center pt-3">
														<div class="col-auto">
															<i class="fa fa-globe"></i> <label
																for="Link" class="col-form-label">Sitio Web:</label>
														</div>
														<div class="col-auto">
															<input type="text" value=<%=((DtProveedor)miUsr).getSitioWeb()%>
																name="Link" class="form-control"
																aria-describedby="passwordHelpInline">
														</div>
	
													</div>
													
													
													<%} %>
	
													<div class="mb-3 pt-3">
													<input type ="file" id="inputNuevaImg" name= "nuevaImagenPerfil"/>
														<button type="submit" class="btn btn-primary"
															id="btnGuardar">Guardar cambios</button>
													</div>
												</form>
											</div>
										</div>
										<%--cierre perfil --%>
	
										<%--	///////////////////////////S A L I D A S//////////////////////--%>
										<div class="tab-pane" id="salidas" role="tabpanel"
											aria-labelledby="salidas-tab">
											<div class="card-body">
												<%--C O N T E N I D O       D E      S A L I D A S --%>
												<%
												Set<DtSalida> salidas = new HashSet<DtSalida>();
												Set<String> salidasNombre = new HashSet<String>();
												
												 webservices.WebServicesService service = new webservices.WebServicesService();
									             webservices.WebServices port = service.getWebServicesPort();
												if (miUsr instanceof DtTurista) {
													DtSalidaArray salidasArray =  port.listarInfoSalidasTurista(miUsr.getNickname());
													List <DtSalida> salidasList = salidasArray.getItem();
													for(DtSalida salida : salidasList){
														salidas.add(salida);
													}
												
													
												} else {
													List<DtActividad> act = port.listarInfoCompletaActividadesProveedor(miUsr.getNickname()).getItem();
						
													
													for (DtActividad nomb : act) {
														for (String sal : nomb.getSalidas()) {
														  DtSalida dtsal = port.getInfoCompletaSalida(sal);
															salidas.add(dtsal);
														}
	
													}
	
												}
												for (DtSalida sal : salidas) {
												%>
												<fieldset disabled>
													<div class="row g-3 align-items-center pt-3">
														<div class="col-auto">
	
															<label for="inputPassword6"
																class="col-form-label disabled'">Salida:</label>
														</div>
														<div class="col-auto">
															<a style="text-decoration: none"
																href="salida?nombreSalida=<%=sal.getNombre()%>"><%=sal.getNombre()%></a>
															
														</div>
	
													</div>
												</fieldset>
												<fieldset disabled>
													<div class="row g-3 align-items-center pt-3">
														<div class="col-auto">
															<i class="fa fa-clock prefix white-text"></i> <label
																for="inputPassword6" class="col-form-label disabled'">Hora:</label>
														</div>
														<div class="col-auto">
															<input type="text" class="form-control disabled"
																aria-describedby="disabled"
																placeholder=<%=new SimpleDateFormat("HH:mm").format(sal.getFechaSalida().toGregorianCalendar().getTime())%>>
														</div>
	
													</div>
												</fieldset>
	
												<fieldset disabled>
													<div class="row g-3 align-items-center pt-3">
														<div class="col-auto">
															<i class="fa fa-calendar prefix white-text"></i> <label
																for="inputPassword6" class="col-form-label disabled'">Fecha
																: </label>
														</div>
														<div class="col-auto">
															<input type="text" class="form-control disabled"
																aria-describedby="disabled"
																placeholder=<%=new SimpleDateFormat("dd/MM/yyyy").format(sal.getFechaSalida().toGregorianCalendar().getTime())%>>
														</div>
	
													</div>
												</fieldset>
	
												<fieldset disabled>
													<div class="row g-3 align-items-center pt-3">
														<div class="col-auto">
															<i class="fa fa-calendar prefix white-text"></i> <label
																for="inputPassword6" class="col-form-label disabled'">Fecha
																Alta: </label>
														</div>
														<div class="col-auto">
															<input type="text" class="form-control disabled"
																aria-describedby="disabled"
																placeholder=<%=new SimpleDateFormat("dd/MM/yyyy").format(sal.getFechaAlta().toGregorianCalendar().getTime())%>>
														</div>
	
													</div>
												</fieldset>
												<%}%>
	
											</div>
										</div>
										<%--cierre salidas --%>
	
										<%
										if (miUsr instanceof DtTurista) {
										%>
	
										<%--///////////////////PAQUETES/////////////////////////////////////////////////////--%>
										<div class="tab-pane" id="paquetes" role="tabpanel"
											aria-labelledby="paquetes-tab">
											<div class="card-body">
												<%
												
												DtTurista Usuario = (DtTurista) miUsr;
												for (DtCompra c : Usuario.getCompras()) {
													DtPaquete paq = port.getInfoPaquete(c.getPaquete());
												%>
												<form>
													<a style="text-decoration: none; font-size: larger;"
														href="paquete?nombrePaquete=<%=paq.getNombre()%>"><%=paq.getNombre()%></a>
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-user prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Cantidad
																	Turistas:</label>
															</div>
															<div class="col-auto">
																<input type="text" id="inputPassword6"
																	class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=c.getCantidadTuristas()%>">
															</div>
	
														</div>
													</fieldset>
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-calendar prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Validez:</label>
															</div>
															<div class="col-auto">
																<input type="text" id="inputPassword6"
																	class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=paq.getPeriodoValidez()%> dias">
															</div>
	
														</div>
													</fieldset>
													
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa-solid fa-money-bill"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Costo:</label>
															</div>
															<div class="col-auto">
																<input type="text" id="inputPassword6"
																	class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=paq.getCosto()*c.getCantidadTuristas()%> $">
															</div>
	
														</div>
													</fieldset>
													
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-ticket prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Descuento:</label>
															</div>
															<div class="col-auto">
																<input type="text" id="inputPassword6"
																	class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=paq.getDescuento()%> %">
															</div>
	
														</div>
													</fieldset>
	
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-calendar prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Fecha
																	Compra: </label>
															</div>
															<div class="col-auto">
																<input type="text" id="inputPassword6"
																	class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder=<%=new SimpleDateFormat("dd/MM/yyyy").format(c.getFechaCompra().toGregorianCalendar().getTime())%>>
															</div>
	
														</div>
													</fieldset>
													
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-calendar prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Fecha
																	Vencimiento: </label>
															</div>
															<div class="col-auto">
																<input type="text" id="inputPassword6"
																	class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder=<%=new SimpleDateFormat("dd/MM/yyyy").format(c.getFechaVencimiento().toGregorianCalendar().getTime())%>>
															</div>
	
														</div>
													</fieldset>
	
												</form>
												<%
												}
												%>
											</div>
										</div>
	
										<%--/////////////////////////I N S C R I P C I O N E S////////////////////////////////--%>
										<div class="tab-pane" id="inscripciones" role="tabpanel"
											aria-labelledby="inscripciones-tab">
											<div class="card-body">
	
												<%
												
												List<DtInscripcion> sali =(List<DtInscripcion>) request.getAttribute("mis_inscripciones");
												for (DtInscripcion sal : sali) {
												%>
	
												<form>
													<h4 class=" font-up font-bold py-2 white-text"><%=sal.getSalida()%></h4>
													<div>
														<a style="text-decoration: none"
															href="pdf-downloader?nombreSalida=<%=sal.getSalida()%>&&nombreUsuario=<%=miUsr.getNickname()%>">Comprobante de Inscripción</a></div>
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-user prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Cantidad
																	Turistas:</label>
															</div>
															<div class="col-auto">
																<input type="text" id="inputPassword6"
																	class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=sal.getCantTuristas()%>">
															</div>
	
														</div>
													</fieldset>
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa-solid fa-money-bill" aria-hidden="true"></i> <label
																	for="inputPassword6" class="col-form-label">Costo:</label>
															</div>
															<div class="col-auto">
																<input type="text" id="inputPassword6"
																	class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=sal.getCosto()%>">
															</div>
	
														</div>
													</fieldset>
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-calendar prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Fecha
																	inscripcion: </label>
															</div>
															<div class="col-auto">
																<input type="text" id="inputPassword6"
																	class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder=<%=new SimpleDateFormat("dd/MM/yyyy").format(sal.getFechaAlta().toGregorianCalendar().getTime())%>>
															</div>
	
														</div>
													</fieldset>
	
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-list prefix white-text"></i><label for="inputPassword6"
																	class="col-form-label disabled'">Tipo:</label>
															</div>
															<div class="col-auto">
																<input type="text" id="inputPassword6"
																	class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=sal.getTipo()%>">
															</div>
	
														</div>
													</fieldset>
	
												</form>
												<%
												}
												List<InscripcionDao> saliFin =(List<InscripcionDao>) request.getAttribute("mis_inscripciones_finalizadas");
												for (InscripcionDao salF : saliFin) {
													
												%>
												<form>
													<h4 class=" font-up font-bold py-2 white-text"><%=salF.getSalida().getNombre()%></h4>
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-user prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Cantidad
																	Turistas:</label>
															</div>
															<div class="col-auto">
																<input type="text" id="inputPassword6"
																	class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=salF.getCantidadTuristas()%>">
															</div>
	
														</div>
													</fieldset>
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa-solid fa-money-bill" aria-hidden="true"></i> <label
																	for="inputPassword6" class="col-form-label">Costo:</label>
															</div>
															<div class="col-auto">
																<input type="text" id="inputPassword6"
																	class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=salF.getCosto()%>">
															</div>
	
														</div>
													</fieldset>
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-calendar prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Fecha
																	inscripcion: </label>
															</div>
															<div class="col-auto">
																<input type="text" id="inputPassword6"
																	class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder=<%=new SimpleDateFormat("dd/MM/yyyy").format(salF.getFechaInscripcion().toGregorianCalendar().getTime())%>>
															</div>
	
														</div>
													</fieldset>
	
												</form>
												<%
												}
												%>
											</div>
										</div>
	
										<%
										} else {
										%>
										<%--///////////////////////////A C T I V I D A D E S //////////////////////--%>
										<div class="tab-pane" id="actividades" role="tabpanel"
											aria-labelledby="actividades-tab">
											<div class="card-body">
												<%
												
												List<DtActividad> actList = (List<DtActividad>)request.getAttribute("mis_actividades_confirmadasYrechazadas");
												for (DtActividad act : actList) {
												%>
												<a style="text-decoration: none; font-size: 24px;"
													href="consultaActividad?nombreAct=<%=act.getNombre()%>"
													class="font-up font-bold"><%=act.getNombre()%></a>
												<form>
	
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-clock prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Duracion:</label>
															</div>
															<div class="col-auto">
																<input type="text" class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=act.getDuracionHs()%>">
															</div>
	
														</div>
													</fieldset>
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa-solid fa-money-bill" aria-hidden="true"></i> <label
																	for="inputPassword6" class="col-form-label">Costo:</label>
															</div>
															<div class="col-auto">
																<input type="text" class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=act.getCosto()%>">
															</div>
	
														</div>
													</fieldset>
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-building prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label">Ciudad:</label>
															</div>
															<div class="col-auto">
																<input type="text" class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=act.getNombreCiudad()%>">
															</div>
	
														</div>
													</fieldset>
	
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-calendar prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Fecha
																	Alta: </label>
															</div>
															<div class="col-auto">
																<input type="text" class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder=
																	<%= 
														new SimpleDateFormat("dd/MM/yyyy").format(act.getFechaAlta().toGregorianCalendar().getTime())
																	%>>
															</div>
	
														</div>
													</fieldset>
	
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-check prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label">Estado:</label>
															</div>
															<div class="col-auto">
																<input type="text" class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=act.getEstado()%>">
															</div>
	
														</div>
													</fieldset>
	
	
												</form>
												<%}%>
												<%
												List<ActividadDao> finalizadas = (List<ActividadDao>)request.getAttribute("mis_actividades_finalizadas");
												for (ActividadDao ad : finalizadas) {
												  
												%>
												<a style="text-decoration: none; font-size: 24px;"
													href="consultaActividad?nombreActFin=<%=ad.getNombre()%>"
													class="font-up font-bold"><%=ad.getNombre()%></a>
												<form>
	
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-clock prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Duracion:</label>
															</div>
															<div class="col-auto">
																<input type="text" class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=ad.getDuracion()%>">
															</div>
	
														</div>
													</fieldset>
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa-solid fa-money-bill" aria-hidden="true"></i> <label
																	for="inputPassword6" class="col-form-label">Costo:</label>
															</div>
															<div class="col-auto">
																<input type="text" class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=ad.getCosto()%>">
															</div>
	
														</div>
													</fieldset>
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-building prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label">Ciudad:</label>
															</div>
															<div class="col-auto">
																<input type="text" class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=ad.getCiudad()%>">
															</div>
	
														</div>
													</fieldset>
	
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-calendar prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Fecha
																	Alta: </label>
															</div>
															<div class="col-auto">
																<input type="text" class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder=
																	<%= 
										new SimpleDateFormat("dd/MM/yyyy").format(ad.getFechaAlta().toGregorianCalendar().getTime())
									%>>
															</div>
	
														</div>
													</fieldset>
																									<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-calendar prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Fecha
																	Baja: </label>
															</div>
															<div class="col-auto">
																<input type="text" class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder=
																	<%= 
										new SimpleDateFormat("dd/MM/yyyy").format(ad.getFechaBaja().toGregorianCalendar().getTime())
									%>>
															</div>
	
														</div>
													</fieldset>
	
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-check prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label">Estado:</label>
															</div>
															<div class="col-auto">
																<input type="text" class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder="<%=ad.getEstado()%>">
															</div>
	
														</div>
													</fieldset>
	
	
												</form>
												<% } %>
											</div>
										</div>
	
										<%}%>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%-- cierre del col-sm principal --%>

			<%
			} else {
			  	Boolean loggueado = request.getAttribute("usuario_logueado") != null;
			  	
				DtUsuario usr_loggueado = null;
				if (loggueado) {
				  usr_loggueado = (DtUsuario)request.getAttribute("usuario_logueado");
				}
			%>
			<% if (loggueado) {%>
			<input type="hidden" id="usr" value="<%=usr_loggueado.getNickname()%>">
			<% } %>
			<input type="hidden" id="newFollower" value="<%=Usr.getNickname()%>">
			
			<div class="col-sm-9 text-center" style="">
				<div class="col-sm" style="margin-right: 12%;">
					<div class="d-flex justify-content-center">
						<div class="card mb-3"
							style="max-width: 800px; width: 200px;">
							<div class="row g-0">
								<div class="" style="">
									<img src="<%=Usr.getImgDir()%>"
										class="img-fluid rounded-start; max-height: 100px;" alt="...">
								</div>
								<div class="col-md-12">
									<div class="card-body">
	
										<h5 class="card-title"><%=Usr.getNombre()%></h5>
										<%--<p class="card-text"><%=miUsr.getEmail()%></p> --%>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">				
					<%
					List<String> seguidores = Usr.getSeguidores();
					List<String> seguidos = Usr.getSeguidos();
					String usr_loggueadoNick = null; 
					Boolean isAFollower = null;
					if (loggueado) {
					  usr_loggueadoNick = usr_loggueado.getNickname();
					
						isAFollower = false;
						for (String nick : seguidores) {
						  if (nick.equals(usr_loggueadoNick)) {
						    isAFollower = true;
						    break;
						  }
						}
					}
					%>
					<% if (loggueado) {%>
					<input id="isAFollower" type="hidden" value="<%=isAFollower%>">
					<% } %>
					
					<div class="d-flex justify-content-between">
						<div class="input-group mb-3 d-flex justify-content-center">
							  <a href="Follows?seguidores=true&&usr=<%=Usr.getNickname()%>" class="btn btn-primary">
							  	Seguidores
							  </a>
						  <span id="cantSeguidores" class="input-group-text"><%=seguidores.size()%></span>
						  <% if (loggueado) { %>
						  <button id="followButton" class="input-group-text">
						  	<i id="followIcon" class="fa fa-solid fa-plus"></i>
						  </button>
						  <% } %>
						</div>
						
						<div class="input-group mb-3 d-flex justify-content-center">
							<a href="Follows?seguidos=true&&usr=<%=Usr.getNickname()%>" class="btn btn-primary">
							  	Seguidos
							</a>
						  <span class="input-group-text"><%=seguidos.size()%></span>
						</div>
					</div>
				</div>
					
					<div class="container" style="width: 650px;">
						<div class="row">
							<div class="">
								<div class="card">
									<div class="card-header">
										<ul class="nav nav-tabs card-header-tabs" id="bologna-list"
											role="tablist">
											<li class="nav-item"><a class="nav-link nav-link active"
												style="color: black;" href="#perfil" role="tab"
												aria-controls="perfil" aria-selected="true">Perfil</a></li>
											<li class="nav-item"><a class="nav-link nav-link-usr"
												href="#salidas" role="tab" aria-controls="salidas"
												aria-selected="false">Salidas</a></li>
											<%
											if (Usr instanceof DtProveedor) {
											%>
											<li class="nav-item"><a class="nav-link nav-link-usr "
												href="#actividades" role="tab" aria-controls="actividades"
												aria-selected="false">Actividades ofrecidas</a></li>
											<%
											}
											%>

										</ul>
									</div>
									<div class="card-body">
										<div class="tab-content mt-3">
											<%--/////////////////////////// P E R F I L  //////////////////////--%>
											<div class="tab-pane active" id="perfil" role="tabpanel"
												aria-labelledby="perfil-tab">
												<div class="card-body">
													<form>
														<h4 class=" font-up font-bold py-2 white-text">Datos
															del usuario</h4>
														<fieldset disabled>
															<div class="row g-3 align-items-center pt-3">
																<div class="col-auto">
																	<i class="fa fa-user prefix white-text"></i> <label
																		for="inputPassword6" class="col-form-label disabled'">Nickname:</label>
																</div>
																<div class="col-auto">
																	<input type="text" id="inputPassword6"
																		class="form-control disabled"
																		aria-describedby="disabled"
																		placeholder="<%=Usr.getNickname()%>">
																</div>

															</div>
														</fieldset>
														<fieldset disabled>
															<div class="row g-3 align-items-center pt-3">
																<div class="col-auto">
																	<i class="fa fa-user prefix white-text"></i> <label
																		for="inputPassword6" class="col-form-label">Nombre:</label>
																</div>
																<div class="col-auto">
																	<input type="text" id="inputPassword6"
																		class="form-control"
																		aria-describedby="passwordHelpInline"
																		placeholder="<%=Usr.getNombre()%>">
																</div>

															</div>
														</fieldset>
														<fieldset disabled>
															<div class="row g-3 align-items-center pt-3">
																<div class="col-auto">
																	<i class="fa fa-user prefix white-text"></i> <label
																		for="inputPassword6" class="col-form-label">Apellido:</label>
																</div>
																<div class="col-auto">
																	<input type="text" id="inputPassword6"
																		class="form-control"
																		aria-describedby="passwordHelpInline"
																		placeholder="<%=Usr.getApellido()%>">
																</div>

															</div>
														</fieldset>

														<fieldset disabled>
															<div class="row g-3 align-items-center pt-3">
																<div class="col-auto">
																	<i class="fa fa-envelope prefix white-text"></i> <label
																		for="inputPassword6" class="col-form-label'">Email:</label>
																</div>
																<div class="col">
																	<input type="text" id="inputPassword6"
																		class="form-control"
																		aria-describedby="passwordHelpInLine"
																		placeholder="<%=Usr.getEmail()%>">
																</div>

															</div>
														</fieldset>
														<fieldset disabled>
															<div class="row g-3 align-items-center pt-3">
																<div class="col-auto">
																	<i class="fa fa-birthday-cake prefix white-text"></i> <label
																		for="inputPassword6" class="col-form-label disabled'">Fecha
																		de Nacimiento: </label>
																</div>
																<div class="col-auto">
																	<input type="text" id="inputPassword6"
																		class="form-control disabled"
																		aria-describedby="disabled"
																		onfocus="(this.type='date')"
																		onblur="(this.type='text')"
																		placeholder=<%=new SimpleDateFormat("dd/MM/yyyy").format(Usr.getFechaNac().toGregorianCalendar().getTime())%>>
																</div>

															</div>
														</fieldset>
														<%if(Usr instanceof DtTurista){ %>
															<fieldset disabled>
															<div class="row g-3 align-items-center pt-3">
																<div class="col-auto">
																	<i class="fa-solid fa-flag prefix white-text"></i> <label
																		for="inputPassword6" class="col-form-label'">Nacionalidad:</label>
																</div>
																<div class="col">
																	<input type="text" id="inputPassword6"
																		class="form-control"
																		aria-describedby="passwordHelpInLine"
																		placeholder="<%=((DtTurista)Usr).getNacionalidad()%>">
																</div>

															</div>
														</fieldset>
														<%} else{ %>
															<fieldset disabled>
															<div class="row g-3 align-items-center pt-3">
																<div class="col-auto">
																	<i class="fa fa-bookmark prefix white-text"></i> <label
																		for="inputPassword6" class="col-form-label'">Descripcion:</label>
																</div>
																<div class="col">
																	<textarea id="inputPassword6"
																		class="form-control"
																		aria-describedby="passwordHelpInLine"
																		placeholder="<%=((DtProveedor)Usr).getDescripcion()%>"></textarea>
																</div>

															</div>
														</fieldset>
														<fieldset disabled>
															<div class="row g-3 align-items-center pt-3">
																<div class="col-auto">
																	<i class="fa fa-globe"></i> <label
																		for="inputPassword6" class="col-form-label'">Sitio Web:</label>
																</div>
																<div class="col">
																	<input type="text" id="inputPassword6"
																		class="form-control"
																		aria-describedby="passwordHelpInLine"
																		placeholder="<%=((DtProveedor)Usr).getSitioWeb()%>">
																</div>

															</div>
														</fieldset>
														<%} %>
													</form>
												</div>
											</div>

											<%--	///////////////////////////S A L I D A S//////////////////////--%>
											<div class="tab-pane" id="salidas" role="tabpanel"
												aria-labelledby="salidas-tab">
												<div class="card-body">
													<%--C O N T E N I D O       D E      S A L I D A S --%>
													<%
													Set<DtSalida> salidas = new HashSet<DtSalida>();
													Set<String> salidasNombre = new HashSet<String>();
													 webservices.WebServicesService service = new webservices.WebServicesService();
										             webservices.WebServices port = service.getWebServicesPort();
													if (Usr instanceof DtTurista) {
														DtSalidaArray sal =port.listarInfoSalidasTurista(Usr.getNickname());
														List <DtSalida> salList = sal.getItem();
														for(DtSalida s :salList){
															salidas.add(s);
														}
													} else {
														
														List<DtActividad> activ = port.listarInfoCompletaActividadesProveedor(Usr.getNickname()).getItem();
														for (DtActividad nomb : activ) {
															for (String sal : nomb.getSalidas()) {
																salidas.add(port.getInfoCompletaSalida(sal));
															}

														}

													}
													for (DtSalida sal : salidas) {
													%>
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">

																<label for="inputPassword6"
																	class="col-form-label disabled'">Salida:</label>
															</div>
															<div class="col-auto">
																<a style="text-decoration: none"
																	href="salida?nombreSalida=<%=sal.getNombre()%>"><%=sal.getNombre()%></a>

															</div>

														</div>
													</fieldset>
													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-clock prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Hora:</label>
															</div>
															<div class="col-auto">
																<input type="text" class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder=<%=new SimpleDateFormat("HH:mm").format(sal.getFechaSalida().toGregorianCalendar().getTime())%>>
															</div>

														</div>
													</fieldset>

													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-calendar prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Fecha
																	: </label>
															</div>
															<div class="col-auto">
																<input type="text" class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder=<%=new SimpleDateFormat("dd/MM/yyyy").format(sal.getFechaSalida().toGregorianCalendar().getTime())%>>
															</div>

														</div>
													</fieldset>

													<fieldset disabled>
														<div class="row g-3 align-items-center pt-3">
															<div class="col-auto">
																<i class="fa fa-calendar prefix white-text"></i> <label
																	for="inputPassword6" class="col-form-label disabled'">Fecha
																	Alta: </label>
															</div>
															<div class="col-auto">
																<input type="text" class="form-control disabled"
																	aria-describedby="disabled"
																	placeholder=<%=new SimpleDateFormat("dd/MM/yyyy").format(sal.getFechaAlta().toGregorianCalendar().getTime())%>>
															</div>

														</div>
													</fieldset>
													<%}%>

												</div>
											</div>
											<%--cierre salidas --%>

											<%if (Usr instanceof DtProveedor) {%>
											<%--/////////////////////////// A C T I V I D A D E S  //////////////////////--%>
											<div class="tab-pane" id="actividades" role="tabpanel"
												aria-labelledby="actividades-tab">
												<div class="card-body">
													<%
													Set<DtActividad> actividades = new HashSet<DtActividad>();
													DtActividadArray activ = port.listarInfoCompletaActividadesProveedor(Usr.getNickname());
													List <DtActividad> actList = activ.getItem();
													for(DtActividad a : actList){
														actividades.add(a);
													}
													for (DtActividad act : actividades) {
														if (act.getEstado() == EstadoActividad.CONFIRMADA) {
													%>
													<a style="text-decoration: none; font-size: 24px;"
														href="consultaActividad?nombreAct=<%=act.getNombre()%>"
														class="font-up font-bold"><%=act.getNombre()%></a>
													<form>

														<fieldset disabled>
															<div class="row g-3 align-items-center pt-3">
																<div class="col-auto">
																	<i class="fa fa-clock prefix white-text"></i> <label
																		for="inputPassword6" class="col-form-label disabled'">Duracion:</label>
																</div>
																<div class="col-auto">
																	<input type="text" class="form-control disabled"
																		aria-describedby="disabled"
																		placeholder="<%=act.getDuracionHs()%>">
																</div>

															</div>
														</fieldset>
														<fieldset disabled>
															<div class="row g-3 align-items-center pt-3">
																<div class="col-auto">
																	<i class="fa-solid fa-money-bill" aria-hidden="true"></i> <label
																		for="inputPassword6" class="col-form-label">Costo:</label>
																</div>
																<div class="col-auto">
																	<input type="text" class="form-control disabled"
																		aria-describedby="disabled"
																		placeholder="<%=act.getCosto()%>">
																</div>

															</div>
														</fieldset>
														<fieldset disabled>
															<div class="row g-3 align-items-center pt-3">
																<div class="col-auto">
																	<i class="fa fa-building prefix white-text"></i> <label
																		for="inputPassword6" class="col-form-label">Ciudad:</label>
																</div>
																<div class="col-auto">
																	<input type="text" class="form-control disabled"
																		aria-describedby="disabled"
																		placeholder="<%=act.getNombreCiudad()%>">
																</div>

															</div>
														</fieldset>

														<fieldset disabled>
															<div class="row g-3 align-items-center pt-3">
																<div class="col-auto">
																	<i class="fa fa-calendar prefix white-text"></i> <label
																		for="inputPassword6" class="col-form-label disabled'">Fecha
																		Alta: </label>
																</div>
																<div class="col-auto">
																	<input type="text" class="form-control disabled"
																		aria-describedby="disabled"
																		placeholder=<%= 
									new SimpleDateFormat("dd/MM/yyyy").format(act.getFechaAlta().toGregorianCalendar().getTime())
								%>>
																</div>

															</div>
														</fieldset>


													</form>
													<%
													} //fin if
													} //fin for
													%>
												</div>
											</div>
											<%}%>


										</div>
									</div>
								</div>
							</div>
						</div>
					</div>


				</div>
				<%
				}
				break;
				}
				}
				%>
			</div>
			<!-- cierro div container principal -->
			<jsp:include page="/WEB-INF/templates/Footer.jsp" />
			<script
				src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
				
			</script>
			<script src="https://code.jquery.com/jquery-3.6.1.min.js"
				integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
				crossorigin="anonymous"></script>
			<script src="js/perfilUsuario.js"></script>
			<script src="js/follow.js"></script>
</body>

</html>
