/*Eventos de altaUsuario*/
/*Información que no se muestra al inicio*/
$("#NacionalidadRegistroDiv").hide();
$("#DescripcionRegistroDiv").hide();
$("#SitioWebRegistroDiv").hide();
$("#DivAjaxUsuarioYaExiste").hide();
$("#DivAjaxUsuarioYaExisteEmail").hide();

/*Cuando selecciona un tipo de usuario*/
$("#TipoUsuarioRegistroOption").on("mouseup", function(){
    if($(this).val() == "Turista"){
        $(this).removeClass("is-invalid");
        $("#NacionalidadRegistroDiv").show();
        $("#NacionalidadRegistroText").attr("required", true);
        $("#DescripcionRegistroDiv").hide();
        $("#DescripcionRegistroText").attr("required", false);
        $("#SitioWebRegistroDiv").hide();
    }else if ($(this).val() == "Proveedor"){
        $(this).removeClass("is-invalid");
        $("#NacionalidadRegistroDiv").hide();
        $("#NacionalidadRegistroText").attr("required", false);
        $("#DescripcionRegistroDiv").show();
        $("#DescripcionRegistroText").attr("required", true);
        $("#SitioWebRegistroDiv").show();
    }else{
        $("#NacionalidadRegistroDiv").hide();
        $("#DescripcionRegistroDiv").hide();
        $("#SitioWebRegistroDiv").hide();
    }
})

/*Verificar campos vacios*/
const verificarCamposMostrarError = (campo) => {
    $(`#${campo}RegistroText`).on("focusout", function(){
        if ($(this).val() == ""){
            $(this).addClass("is-invalid");
            $(`#${campo}RegistroDiv`).removeClass("mb-4");
            $(`#${campo}RegistroDiv`).addClass("mb-0");
        }else{
            $(this).removeClass("is-invalid");
            $(`#${campo}RegistroDiv`).addClass("mb-4");
            $(`#${campo}RegistroDiv`).removeClass("mb-0");
        }
            
    })
}

$("#FechaNacimientoRegistroText").on("focusout", function(){
    if ($(this).val() == ""){
        $(this).addClass("is-invalid");
        $("#FechaNacimientoRegistroTextNullValidate").show();
    }else{
        $(this).removeClass("is-invalid");
        $("#FechaNacimientoRegistroTextNullValidate").hide();
    }
})

verificarCamposMostrarError("Nickname");
verificarCamposMostrarError("Nombre");
verificarCamposMostrarError("Apellido");
verificarCamposMostrarError("Email");
verificarCamposMostrarError("Contrasenia");
verificarCamposMostrarError("Nacionalidad");
verificarCamposMostrarError("Descripcion");

/*Mostrar obligatorios cuando le da sumbit sin tenerlos todos llenos tira false si estan vacios*/
const marcarObligatorios = (campo) => {
    if($(`#${campo}RegistroText`).val() == ""){
        $(`#${campo}RegistroText`).addClass("is-invalid");
        $(`#${campo}RegistroDiv`).removeClass("mb-4");
        $(`#${campo}RegistroDiv`).addClass("mb-0");

        if(campo == "FechaNacimiento"){
            $("#FechaNacimientoRegistroText").addClass("is-invalid");
            $("#FechaNacimientoRegistroTextNullValidate").show();
        }
        return false;
    }
    return true;

}

/*Coincidencia de contraseñas*/
$("#ContraseniaRegistroText").on("keyup", function(){
    if($(this).val() == $("#ConfirmarContraseniaRegistroText").val()){
        $("#ConfirmarContraseniaRegistroText").addClass("is-valid");
        $("#ConfirmarContraseniaRegistroText").removeClass("is-invalid");
        $(`#ConfirmarContraseniaRegistroDiv`).addClass("mb-4");
        $(`#ConfirmarContraseniaRegistroDiv`).removeClass("mb-0");
    }else{
        $("#ConfirmarContraseniaRegistroText").removeClass("is-valid");
        $("#ConfirmarContraseniaRegistroText").addClass("is-invalid");
        $(`#ConfirmarContraseniaRegistroDiv`).removeClass("mb-4");
        $(`#ConfirmarContraseniaRegistroDiv`).addClass("mb-0");
    }
})

$("#ConfirmarContraseniaRegistroText").on("keyup", function(){
    if($(this).val() == $("#ContraseniaRegistroText").val()){
        $(this).addClass("is-valid");
        $(this).removeClass("is-invalid");
        $(`#ConfirmarContraseniaRegistroDiv`).addClass("mb-4");
        $(`#ConfirmarContraseniaRegistroDiv`).removeClass("mb-0");
    }else{
        $(this).removeClass("is-valid");
        $(this).addClass("is-invalid");
        $(`#ConfirmarContraseniaRegistroDiv`).removeClass("mb-4");
        $(`#ConfirmarContraseniaRegistroDiv`).addClass("mb-0");
    }
})

const formularioValidado = () => {
    if($("#TipoUsuarioRegistroOption").val()=="Seleccionar"){
        $("#TipoUsuarioRegistroOption").addClass("is-invalid");
        return false;
    }
    if($("#ConfirmarContraseniaRegistroText").val() != $("#ContraseniaRegistroText").val()){
        return false
    }
    let campoExtra;
    if($("#TipoUsuarioRegistroOption").val()=="Turista")
        campoExtra = marcarObligatorios("Nacionalidad");
    if($("#TipoUsuarioRegistroOption").val()=="Proveedor")
        campoExtra = marcarObligatorios("Descripcion");
    let nick = marcarObligatorios("Nickname");
    let nomb = marcarObligatorios("Nombre");
    let apel = marcarObligatorios("Apellido");
    let fNac = marcarObligatorios("FechaNacimiento")
    let email =marcarObligatorios("Email")
    let contrasenia = marcarObligatorios("Contrasenia")
    return  nick && nomb && apel && email && fNac && contrasenia && campoExtra;
    
}

const sugerirNick = () =>{
	let numeroAleatorio = Math.floor(Math.random() * 1000);
	let resultado =  $("#NicknameRegistroText").val() + numeroAleatorio.toString();
	$.ajax({
  			method: "GET",
  			url: "altaUsuario",
  			data: {existe:$("#NicknameRegistroText").val() + numeroAleatorio.toString()},
	}).fail(function(){
		sugerirNick();
	})
	return resultado;
}

$("#NicknameRegistroText").on("keyup", async function(){
	$.ajax({
  		method: "GET",
  		url: "altaUsuario",
  		data: {existe:$("#NicknameRegistroText").val()},
	}).fail(function( jqXHR, textStatus ) {
  		$("#DivAjaxUsuarioYaExiste").show();
  		$(`#NicknameRegistroDiv`).removeClass("mb-4");
        $(`#NicknameRegistroDiv`).addClass("mb-0");
  		$("#spanNicknameYaExisteAjax").text($("#NicknameRegistroText").val());
  		
  		$("#spanNicknameSugerencia").text(sugerirNick());
  		
	}).done(function( jqXHR, textStatus ) {
  		$("#DivAjaxUsuarioYaExiste").hide();
  		$(`#NicknameRegistroDiv`).addClass("mb-4");
        $(`#NicknameRegistroDiv`).removeClass("mb-0");
	})
})

$("#EmailRegistroText").on("keyup", async function(){
	$.ajax({
  		method: "GET",
  		url: "altaUsuario",
  		data: {existeEmail:$("#EmailRegistroText").val()},
	}).fail(function( jqXHR, textStatus ) {
  		$("#DivAjaxUsuarioYaExisteEmail").show();
  		$(`#EmailRegistroDiv`).removeClass("mb-4");
        $(`#EmailRegistroDiv`).addClass("mb-0");
  		$("#spanEmailYaExisteAjax").text($("#EmailRegistroText").val());
  		
	}).done(function( jqXHR, textStatus ) {
  		$("#DivAjaxUsuarioYaExisteEmail").hide();
  		$(`#EmailRegistroDiv`).addClass("mb-4");
        $(`#EmailRegistroDiv`).removeClass("mb-0");
	})
})

/*Comportamiento de boton sumbit cuando no tiene todo lo requerido*/
$("#btnRgistrarse").on("click", async function(e){
    e.preventDefault();
    if(formularioValidado()){
        /*await Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Registrado con exito',
            showConfirmButton: false,
            timer: 1700,
        })*/
        $("#FormularioRegistro").submit();
    }
})