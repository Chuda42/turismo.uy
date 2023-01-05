<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/templates/Head.jsp" />
<title>Turismo.uy</title>
</head>
<body>
	<div class="d-flex align-items-center justify-content-center vh-100">
		<div class="text-center">
			<h1 class="display-1 fw-bold">404</h1>
			<p class="fs-3">
				<span class="text-danger">Ups!</span> Página no encontrada.
			</p>
			<p class="lead">La página que estabas buscando no existe.</p>
			<!-- Fijarse porque no esta andando la clase primary-color
				Por eso se agrega el atributo style
			 -->
			<a href="index.html" class="btn primary-color text-white" style="background-color: #53b5ce;">Volver a Home</a>
		</div>
	</div>
</body>
</html>