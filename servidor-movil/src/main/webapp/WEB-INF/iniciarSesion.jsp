<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Turismo.uy</title>
<jsp:include page="/WEB-INF/templates/Head.jsp" />
</head>

<body class="back" >
	<jsp:include page="/WEB-INF/templates/Navbar.jsp"/>
<section class="vh-80">
  <div class="container py-5 h-100">
    <div class="row d-flex align-items-center justify-content-center h-100">
      <div class="col-md-8 col-lg-7 col-xl-6">
        <img src="media/imagenes/logo2.png"
          class="img-fluid rounded" alt="Phone image">
      </div>
      <div class="col-md-7 mt-5 col-lg-5 col-xl-5 offset-xl-1">
        <form id="formularioInicioSesion" method="POST" action="iniciarSesion" class="needs-validation" no-validate>
          <!-- Email input -->
          <div class="form-outline mb-4">
            <input type="text" class="form-control form-control-lg" name="nick-or-email"
									id="NicknameOEmailIniciarSesionText" required/>
            <label class="form-label" for="form1Example13">Email o Nickname</label>
          </div>

          <!-- Password input -->
          <div class="form-outline mb-4">
            <input class="form-control form-control-lg"  type="password" class="input" name="password"
									id="ContraseniaIniciarSesionText" required/>
            <label class="form-label" for="form1Example23">Contraseña</label>
          </div>

        <!--   <div class="d-flex justify-content-around align-items-center mb-4">
           
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="form1Example3" checked />
              <label class="form-check-label" for="form1Example3"> Remember me </label>
            </div>
            <a href="#!">Forgot password?</a>
          </div> -->
	<%
						Boolean invalid_attempt = (Boolean) request.getAttribute("invalid_attempt");
						if (invalid_attempt) {
						%>
						<div class="alert alert-danger d-flex align-items-center"
							role="alert">
							<i class="fa fa-exclamation-triangle" aria-hidden="true"></i> El
							nombre de usuario, el email o la contraseña son invalidas!
						</div>
						<%
						}
						%>
          <!-- Submit button -->
<input type="submit" class="btn btn-primary btn-lg btn-block " value="Login"
							id="btnIniciarSesion"/>
         
        </form>
      </div>
    </div>
  </div>
</section>

	<script src="https://code.jquery.com/jquery-3.6.1.min.js"
		integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
		crossorigin="anonymous"></script>
	<script src="js/iniciarSesion.js"></script>
</body>
</html>
