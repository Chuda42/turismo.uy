<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@page import="servlets.altaUsuario" %>


<!doctype html>
<html>
	<head>
		<link rel="stylesheet" href="media/style/altaUsuario.css">
		<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
		<jsp:include page="/WEB-INF/templates/Head.jsp"/>
		<title>Turismo.uy</title>	
	</head>
    <body>
		<jsp:include page="/WEB-INF/templates/Navbar.jsp"/>
		<div class="row mt-5 mt-lg-0" style="padding-top: 10%; max-width: 1600px; padding-left: 5%; padding-right: 5%;">
			<jsp:include page="/WEB-INF/templates/AccesoCasosDeUso.jsp"/>
		
			<div class="col-sm-6 text-center">
	          <div class="card mb-3 formularioRegistro shadow">
	            <div class="card-body">
	              <h5 class="card-title">Registrarse</h5>
	              
	              <%
					String error_msg = (String)request.getAttribute("UsuarioYaExiste");
					if (error_msg != null) {
				  %>
					<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
					<script>
					$( document ).ready(async function(e){
						await Swal.fire({
						            position: 'center',
						            icon: 'error',
						            title: 'Error en el alta',
						            text: '<%=error_msg%>',
						            showConfirmButton: false,
						            timer: 3000,
						});
					});
					</script>
				<%
				}
				%>
	              
	              <form method="POST" action="altaUsuario" id="FormularioRegistro" enctype="multipart/form-data">
	                  <div class="mb-4 text-start" id="NicknameRegistroDiv">
	                      <label for="Nickname" class = "form-label" id="NicknameRegistroLabel">Nickname</label>
	                      <input type="text" name="Nickname" id="NicknameRegistroText" placeholder="Ingrese un nickname" class ="form-control" aria-describedby="NicknameRegistroTextNullValidate" required>
	                      <div id="NicknameRegistroTextNullValidate" class="invalid-feedback">
	                          El campo Nickname es obligatorio.
	                      </div>
	                      <div id="DivAjaxUsuarioYaExiste">
	                      	<i class="fa-solid fa-triangle-exclamation"></i>
	                      	El usuario con el nickname <span id="spanNicknameYaExisteAjax"></span> ya existe.
	                      	Sugerencias: <span id="spanNicknameSugerencia"></span>
	                      </div>
	                  </div>
	                  
	                  <div class="mb-4 text-start" id="NombreRegistroDiv">
	                      <label for="Nombre" class = "form-label">Nombre</label>
	                      <input type="text" name="Nombre" id="NombreRegistroText" placeholder="Ingrese su Nombre" class ="form-control" aria-describedby="NombreRegistroTextNullValidate" required>
	                      <div id="NombreRegistroTextNullValidate" class="invalid-feedback">
	                          El campo Nombre es obligatorio.
	                      </div>
	                  </div>
	                  
	                  <div class="mb-4 text-start" id="ApellidoRegistroDiv">
	                      <label for="Apellido" class ="form-label">Apellido</label>
	                      <input type="text" name = "Apellido" id="ApellidoRegistroText" placeholder="Ingrese su Apellido" class ="form-control" aria-describedby="ApellidoRegistroTextNullValidate" required>
	                      <div id="ApellidoRegistroTextNullValidate" class="invalid-feedback">
	                          El campo Apellido es obligatorio.
	                      </div>
	                  </div>
	            
	                  <div class="mb-4 text-start" id="EmailRegistroDiv">
	                      <label for="Email" class ="form-label">Email</label>
	                      <input type="email" name="Email" id="EmailRegistroText" placeholder="Ingrese un email" class ="form-control" aria-describedby="EmailRegistroTextNullValidate" required>
	                      <div id="EmailRegistroTextNullValidate" class="invalid-feedback">
	                          El campo Email es obligatorio.
	                      </div>
	                      <div id="DivAjaxUsuarioYaExisteEmail">
	                      		<i class="fa-solid fa-triangle-exclamation"></i>
	                      		El usuario con el email <span id="spanEmailYaExisteAjax"></span> ya existe.
	                      </div>
	                  </div>
	            
	                  <div class="row g-3 align-items-center" id="FechaNacimientoRegistroDiv">
	                      <div class="col-auto">
	                          <label for="FechaNacimiento" class="form-label">Fecha de Nacimiento</label>
	                      </div>
	                      <div class="col-auto">
	                          <input type="date" name="FechaNacimiento" id="FechaNacimientoRegistroText" class ="form-control" aria-describedby="FechaNacimientoRegistroTextNullValidate" required>    
	                      </div>
	                      <div class="col-auto">
	                          <span id="FechaNacimientoRegistroTextNullValidate" class="FechaNacimientoSpanValidate">
	                              Es un campo obligatorio
	                          </span>
	                      </div>
	                      
	                  </div>
	                  
	                  <div class="mb-4 text-start" id="ContraseniaRegistroDiv">
	                      <label for="Contrasenia" class="form-label">Contraseña</label>
	                      <input type="password" name="Contrasenia" id="ContraseniaRegistroText" placeholder="Ingresar una contraseña" class ="form-control" aria-describedby="ContraseniaRegistroTextNullValidate">
	                      <div id="ContraseniaRegistroTextNullValidate" class="invalid-feedback">
	                          El campo Contrasenia es obligatorio.
	                      </div>
	                  </div>
	            
	                  <div class="mb-4 text-start" id="ConfirmarContraseniaRegistroDiv">
	                      <label for="ConfirmarContrasenia" class="form-label">Confirmar contraseña</label>
	                      <input type="password" name="ConfirmarContrasenia" id="ConfirmarContraseniaRegistroText" placeholder="Ingresar contraseña" class="form-control" aria-describedby="ConfirmarCrontraseniaValidate" required>
	                      <div id="ConfirmarCrontraseniaValidate" class="invalid-feedback">
	                          Las contraseñas no coinciden
	                      </div>
	                  </div>
	                  
	                  <div class="row g-3 align-items-center">
	                      <div class="col-auto">
	                          <label for="FotoPerfil" class ="form-label">Subir foto de perfil</label>
	                      </div>
	                      <div class="col-auto">
	                          <input type="file" class="form-control" name="FotoPerfil">
	                      </div>
	                      
	                  </div>
	            
	                  <div class="row g-3 mb-4 align-items-center mt-3">
	                      <div class="col-auto">
	                          <label for="TipoUsuario" class ="form-label">Registrarse como</label>
	                      </div>
	                      <div class="col-auto">
	                          <select name="TipoUsuario" id="TipoUsuarioRegistroOption" class="form-control" defaultOptions="Seleccionar" aria-describedby="TipoUsuarioNullValidate">
	                              <option value="Seleccionar"></option>
	                              <option value="Turista">Turista</option>
	                              <option value="Proveedor">Proveedor</option>
	                          </select> 
	                          <div id="TipoUsuarioNullValidate" class="invalid-feedback">
	                              Debe seleccionar el tipo de usuario que se va a registrar.
	                          </div>
	                      </div>  
	                  </div>
	            
	                  <div class="mb-4 text-start" id="NacionalidadRegistroDiv">
	                      <label for="Nacionalidad" class ="form-label">Nacionalidad</label>
	                      <input type="text" name="Nacionalidad" placeholder="Ingrese su nacionalidad"
	                      class ="form-control" id="NacionalidadRegistroText" aria-describedby="NacionalidadTextNullValidate">
	                      <div id="NacionalidadNullValidate" class="invalid-feedback">
	                          La nacionalidad es un campo obligatorio.
	                      </div>
	                  </div>
	                  
	                  <div class="mb-4 text-start"  id="DescripcionRegistroDiv">
	                      <label for="Descripcion" class ="form-label">Descripción general</label>
	                      <textarea name="Descripcion" class="form-control" placeholder="Escribir una descripción" id="DescripcionRegistroText" style="height: 100px" aria-describedby="DescripcionTextNullValidate"></textarea>
	                      <div id="DescripcionNullValidate" class="invalid-feedback">
	                          La descripción es un campo obligatorio.
	                      </div>
	            
	                  </div>
	            
	                  <div class="mb-4 text-start"  id="SitioWebRegistroDiv">
	                      <label for="LinkSitioWeb" class ="form-label">Link de su sitio web</label>
	                      <input type="url" name="LinkSitioWeb" id="LinkSitioWeb" placeholder="Ingrese el link de su sitio web" class="form-control">
	                  </div>
	                  
	                  <div class="mb-3">
	                      <button type="submit" class="btn btn-primary" id="btnRgistrarse">Registrarse</button>
	                  </div>
	            
	              </form>
	            </div>
	          </div>
	        </div>
        </div>
        
        <jsp:include page="/WEB-INF/templates/Footer.jsp"/>
        
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		<script src="js/altaUsuario.js"></script>
	</body>
</html>
