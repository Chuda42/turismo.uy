/*Verificar campos vacios*/
const verificarCamposMostrarError = (campo) => {
    $(`#${campo}CompraPaqText`).on("focusout", function(){
        if ($(this).val() == ""){
            $(this).addClass("is-invalid");
            $(`#${campo}CompraPaqDiv`).removeClass("mb-4");
            $(`#${campo}CompraPaqDiv`).addClass("mb-0");
        }else{
            $(this).removeClass("is-invalid");
            $(`#${campo}CompraPaqDiv`).addClass("mb-4");
            $(`#${campo}CompraPaqDiv`).removeClass("mb-0");
        }
            
    })
}

verificarCamposMostrarError("Cant");

/*Mostrar obligatorios cuando le da sumbit sin tenerlos todos llenos tira false si estan vacios*/
const marcarObligatorios = (campo) => {
    if($(`#${campo}CompraPaqText`).val() == ""){
        $(`#${campo}CompraPaqText`).addClass("is-invalid");
        $(`#${campo}CompraPaqDiv`).removeClass("mb-4");
        $(`#${campo}CompraPaqDiv`).addClass("mb-0");
        
        return false;
    }
    return true;

}

const formularioValidado = () => {
    let cant = marcarObligatorios("Cant");
    
    if($("#CantCompraPaqText").val()<1){
		$("#CantCompraPaqText").addClass("is-invalid");
		return false;
	}
    
    return  cant;
}

/*Comportamiento de boton sumbit*/
$("#btnComprar").on("click", async function(e){
    e.preventDefault();
    if(formularioValidado()){
        $("#FormularioCompraPaquete").submit();
    }
})