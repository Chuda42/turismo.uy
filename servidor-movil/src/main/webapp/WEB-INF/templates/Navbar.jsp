<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@page import="webservices.DtUsuario"%>
<div class="pos-f-t">
  
  <nav class="navbar bg-blue d-flex navbar-light ">
  
    <button style="    margin-left: 8px; " class=" ml-4 navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="ml-4 navbar-toggler-icon"></span>
    </button>
     <div class="container busq justify-content-center justify-content-lg-between"> 
   <a class="navbar-brand turismo ml-3" href="index">
       		<h4 class="mb-2 mb-lg-0 white">TURISMO.UY</h4>
        </a>
          <% 
        if(session.getAttribute("usuario_logueado") != null ){
        	DtUsuario usr = (DtUsuario) session.getAttribute("usuario_logueado");
        %>
       
      <div style="display:flex; flex-direction:row">
        <label style="color:black; width:120%; padding-top:10px; font-family: 'Prompt', sans-serif; "><%=usr.getNombre()%> </label>
        <div style="width:100%!important; height:50px;" >
        <img  style="width:80%; margin-left:50%; height:50px;" class=" logo-chico rounded" src="media/imagenes/logoChico.png"/>
        </div>
        </div>
        	
       <%} 
       else{%>
		<div class="collapse navbar-collapse" id="navbar4" style="flex-grow:0;">
        	<ul class="navbar-nav mr-0 mt-3 mt-lg-0">
            	<li class="nav-item"> 
                	<a class="nav-link" href="iniciarSesion"> 
                     	Iniciar Sesión
                        <i class="fa fa-sign-in"></i>
                    </a> 
                </li>
            </ul>
            <ul class="navbar-nav mr-0 mt-3 mt-lg-0">
            	<li class="nav-item"> 
                	<a class="nav-link" href="altaUsuario"> 
                     	Registrarse
                        <i class="fa fa-user-plus"></i>
                    </a> 
                </li>
        	</ul>
    	</div>
    	<%
        }
    	%>
  </nav>
  <div class="ml-4 collapse " id="navbarToggleExternalContent">
    <div class="bg-blue collapse-nav navbar-text p-4">
    <% 
     if(session.getAttribute("usuario_logueado") != null ){
        	DtUsuario usr = (DtUsuario) session.getAttribute("usuario_logueado");
        %>
      <a class="text-muted" href="consultaActividad">Ver Actividades Turisticas</a>
       <a class="text-muted" href="listadoSalidas">Ver Salidas</a>
      <span class="text-muted"> <a class="text-muted" href="cerrarSesion">Cerrar Sesion</a></span>
      <%}
      else
      { %>
      <a class="text-muted" href="iniciarSesion">Iniciar Sesion</a>
      <%} %>
    </div>
  </div>
 
</div>
