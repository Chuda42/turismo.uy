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
<script>
var slideIndex = 0;
showPics();

function showPics(){  

  var i = 0;
  var slides = document.getElementsByClassName("images");

  for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none"; 
  }
  
  slideIndex++; 

  if (slideIndex > slides.length) {
        slideIndex = 1;
  }
   for (i = 0; i < slides.length; i++) {
       slides[slideIndex - 1].style.display = "block";
    }
      setTimeout(showPics, 2000); 

}
</script>
<jsp:include page="/WEB-INF/templates/Navbar.jsp" />
<div style="  padding-bottom:500px"  >
             
             <img style="width:100%" src="media/imagenes/welcome3.png">
  
  <div  class="images fade">
    
    <img style= "width:100%; height:300px" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQr29ZgoHPUWHaiPPlZbdhTuFJkT30rYYy3ZxflwYC2TZoZUFpHJybyurw1RuBBE1N3EbA&usqp=CAU" alt="photo1">
  </div>
  
  <div class="images fade">
    <img style=  "width:100% ;height:300px" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRy9lv9Wzoc0ARQbJyck7Ot5vRDbpeJeurDzg&usqp=CAU" alt="">
  </div>
  
  <div class="images fade">
    <img style=  "width:100%; height:300px" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAHuIKNz-wq_QhYkWd1Mjd5AUR2wuTI5dNhVbRmPp5gZS-YJsbnwT6jav-eIDiguAuwOA&usqp=CAU" alt="">
  </div>
  
  <div class="images fade">
    <img style=  "width:100%; height:300px" src="http://www.rtv.org.mx/masnoticias/wp-content/uploads/sites/13/2013/06/turismo_aventura_02.jpg" alt="">
  </div>
</div>
</body>
</html>