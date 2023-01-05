<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="webservices.DtUsuario"%>
<%@page import="webservices.DtProveedor"%>
<%@page import="webservices.DtTurista"%>

<div class="col-sm-3 mt-5 mt-lg-0">
	<%
	DtUsuario usr = (DtUsuario) session.getAttribute("usuario_logueado");
	if (usr instanceof DtTurista) {
	%>
		<div class="card border-light mb-5 mx-auto text-center text-lg-start card-container">
                <div class="card-header ">Mi perfil <i class="fa fa-caret-right" aria-hidden="true"></i></div>
                <div class="card-body">
                    <ul class="list-group list-group-flush">
                        <a href="inscripcionSalida?listar=1" class="list-group-item list-group-item-action">Inscripción a Salida</a>
                        <a href="paquete?listar=1" class="list-group-item list-group-item-action">Compra de Paquete</a>
                    </ul>
                </div>
          </div>
	<%
	}else if (usr instanceof DtProveedor){
	%>
            <div class="card border-light mb-5 mx-auto text-center text-lg-start card-container">
                <div class="card-header fw-semibold">Mi perfil <i class="fa fa-caret-right" aria-hidden="true"></i>
                </div>
                <div class="card-body">
                    <ul class="list-group list-group-flush">
                        <a href="altaActividad" class="card-title list-group-item list-group-item-action">Alta de
                            Actividad</a>
                        <a href="altaSalida" class="card-title list-group-item list-group-item-action">Alta de
                            Salida</a>
                        <a href="FinalizarActividad" class="card-title list-group-item list-group-item-action">Finalizar Actividad</a>
                    </ul>
                </div>
            </div>
	<%
	}
	%>
	<div class="card border-light mb-5 mx-auto text-center text-lg-start card-container">
		<div class="card-header ">USUARIOS</div>
		<div class="card-body">
			 <ul class="list-group list-group-flush">
				<a href="consultaUsuario?STATE=LISTAR" class="list-group-item list-group-item-action">Consulta Usuarios</a>
			</ul>
		</div>
	</div>
	
	<div class="card border-light mb-5 mx-auto text-center text-lg-start" style="max-width: 18rem; ">
		          <div class="card-header">DEPARTAMENTOS</div>
		          <div class="card-body">
		             <ul class="list-group list-group-flush">
		             
		             	<%
							List<String> deptos = (List<String>)request.getAttribute("departamentos");
							for (String depto: deptos) {
						%>
		                	<a href="departamento?nombreDpto=<%= depto %>" class="list-group-item list-group-item-action"><%= depto %></a>
						<%
						}
						%>
		        	</ul>
		    	</div>
		    </div>
		    <div class="card border-light mb-5 mx-auto text-center text-lg-start" style="max-width: 18rem; ">
				<div class="card-header">CATEGORIAS</div>
		        <div class="card-body">
		              <ul class="list-group list-group-flush">
		              	<%
		              		List<String> categorias = (List<String>)request.getAttribute("categorias");
							for (String categoria: categorias) {
						%>
		                	<a href="categoria?nombreCat=<%= categoria %>" class="list-group-item list-group-item-action"><%= categoria %></a>
						<%
						}
						%>
		              
		        	</ul>
		    	</div>
			</div>
</div>


