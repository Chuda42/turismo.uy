
/*Comportamiento de boton sumbit cuando no tiene todo lo requerido*/
$("#btnIniciarSesion").on("click", function(e){
    if(($("#NicknameOEmailIniciarSesionText").val() == "washington" || $("#NicknameOEmailIniciarSesionText").val() == "washington@turismorocha.gub.uy") && $("#ContraseniaIniciarSesionText").val() == "asdfg654"){
        $("#FormularioIniciarSesion").attr("action","./homeLogueadoProv.html")
    }
    if(($("#NicknameOEmailIniciarSesionText").val() == "lachiqui" || $("#NicknameOEmailIniciarSesionText").val() == "mirtha.legrand.ok@hotmail.com.ar") && $("#ContraseniaIniciarSesionText").val() == "awdrg543"){
        $("#FormularioIniciarSesion").attr("action","./homeLogueado.html")
    }
})

//**//

const inputs = document.querySelectorAll(".input");


function addcl(){
    let parent = this.parentNode.parentNode;
    parent.classList.add("focus");
}

function remcl(){
    let parent = this.parentNode.parentNode;
    if(this.value == ""){
        parent.classList.remove("focus");
    }
}


inputs.forEach(input => {
    input.addEventListener("focus", addcl);
    input.addEventListener("blur", remcl);
});