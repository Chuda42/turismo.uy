 jQuery('option').mousedown(function(e) {
    e.preventDefault();
    jQuery(this).toggleClass('selected');
  
    jQuery(this).prop('selected', !jQuery(this).prop('selected'));
    return false;
});

const tocheck = Array.prototype.slice.call(document.querySelectorAll(".non-empty"));

$("#CategoriasAltaAct").on("click", function(){
	if($(this).get(0).selectedIndex != -1){
		$(this).removeClass("is-invalid");
	}
})

/*Verificar campos vacios*/
const verificarCamposMostrarError = (campo) => {
    $(`#${campo}AltaActText`).on("focusout", function(){
        if ($(this).val() == ""){
            $(this).addClass("is-invalid");
            $(`#${campo}AltaActDiv`).removeClass("mb-4");
            $(`#${campo}AltaActDiv`).addClass("mb-0");
        }else{
            $(this).removeClass("is-invalid");
            $(`#${campo}AltaActDiv`).addClass("mb-4");
            $(`#${campo}AltaActDiv`).removeClass("mb-0");
        }
            
    })
}

verificarCamposMostrarError("Nombre");
verificarCamposMostrarError("Descripcion");
verificarCamposMostrarError("Duracion");
verificarCamposMostrarError("Costo");
verificarCamposMostrarError("Ciudad");

/*Mostrar obligatorios cuando le da sumbit sin tenerlos todos llenos tira false si estan vacios*/
const marcarObligatorios = (campo) => {
    if($(`#${campo}AltaActText`).val() == ""){
        $(`#${campo}AltaActText`).addClass("is-invalid");
        $(`#${campo}AltaActDiv`).removeClass("mb-4");
        $(`#${campo}AltaActDiv`).addClass("mb-0");
        
        return false;
    }
    return true;

}

const formularioValidado = () => {
    if($("#DepartamentoAltaActOption").val()=="Seleccionar"){
        $("#DepartamentoAltaActOption").addClass("is-invalid");
        return false;
    }
    
    if($("#CategoriasAltaAct").get(0).selectedIndex == -1){
		$("#CategoriasAltaAct").addClass("is-invalid");
		return false;
	}
	
	if($("#DuracionAltaActText").val()<1){
		$("#DuracionAltaActText").addClass("is-invalid");
		return false;
	}
	
	if($("#CostoAltaActText").val()<0.01){
		$("#CostoAltaActText").addClass("is-invalid");
		return false;
	}
    
    let nomb = marcarObligatorios("Nombre");
    let desc = marcarObligatorios("Descripcion");
    let dur = marcarObligatorios("Duracion");
    let cost = marcarObligatorios("Costo");
    let ciud =marcarObligatorios("Ciudad");
    return  nomb && desc && dur && cost && ciud;
}

/*Comportamiento de boton sumbit*/
$("#btnRegistrarAct").on("click", async function(e){
    e.preventDefault();
    if(formularioValidado()){
        $("#FormularioAltaActividad").submit();
    }
})