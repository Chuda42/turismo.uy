/*Inicialmente*/
$("#InformacionSalidasDegustaAgosto").hide();
$("#InformacionSalidasDegustaSetiembre").hide();
$("#PorPaqueteDiv").hide();
$("#CantidadTuristasDiv").hide();
$("#btnInicribirseASalida").attr("disabled", "disabled");



/*Seleccionar el departamento, si no es Rocha no tiene actividades*/
$("#DepartamentoSeleccionado").on("mouseup", function(){
    if($(this).val()!=null){
        $("#ActividadesOption").attr("disabled", false);
            if($(this).val() == "Rocha" && (($("#CategoriaSeleccionado").val()=="Gastronomia") ||$("#CategoriaSeleccionado").val()==null)){
                $(".noHayActividad").hide();
                $(".hayActividad").show();
            }else{
                $(".noHayActividad").show();
                $(".hayActividad").hide();
            }
    }
})

$("#CategoriaSeleccionado").on("mouseup", function(){
    if($(this).val()!=null){
        $("#ActividadesOption").attr("disabled", false);
            if($(this).val() == "Gastronomia" && (($("#DepartamentoSeleccionado").val()=="Rocha") ||$("#DepartamentoSeleccionado").val()==null)){
                $(".noHayActividad").hide();
                $(".hayActividad").show();
            }else{
                $(".noHayActividad").show();
                $(".hayActividad").hide();
            }
    }
})

$("#ActividadesOption").on("mouseup", function(){
    if ($(this).val() == "DeGusta") {
        $("#SalidasActividadOption").attr("disabled", false);
        $("#DeGustaAgostoSalidasActividad").show();
        $("#DeGustaSetiembreSalidasActividad").show();
        $("#NoHaySalidasActividad").hide();
    }else if ($(this).val() == "Teatro con Sabores"){
        $("#SalidasActividadOption").attr("disabled", false);
        $("#DeGustaAgostoSalidasActividad").hide();
        $("#DeGustaSetiembreSalidasActividad").hide();
        $("#NoHaySalidasActividad").show();
    }else{
        $("#DeGustaAgostoSalidasActividad").hide();
        $("#DeGustaSetiembreSalidasActividad").hide();
        $("#NoHaySalidasActividad").hide();
    }
})

$("#SalidasActividadOption").on("mouseup", function(){
    if ($(this).val() == "DeGusta Agosto") {
        $("#InformacionSalidasDegustaAgosto").show("slow");
        $("#InformacionSalidasDegustaSetiembre").hide("slow");
        $("#TipoDeIncripcionOption").attr("disabled", false);
    }else if ($(this).val() == "DeGusta Setiembre"){
        $("#InformacionSalidasDegustaAgosto").hide("slow");
        $("#InformacionSalidasDegustaSetiembre").show("slow");
        $("#TipoDeIncripcionOption").attr("disabled", false);
    }else{
        $("#InformacionSalidasDegustaAgosto").hide("slow");
        $("#InformacionSalidasDegustaSetiembre").hide("slow");
        $("#TipoDeIncripcionOption").attr("disabled", true);
    }
})

$("#TipoDeIncripcionOption").on("mouseup", function(){
    if ($(this).val() == "InscripcionGeneral") {
        $("#CantidadTuristasDiv").show("slow");
        $("#PorPaqueteDiv").hide("slow");
        $("#PorPaqueteOption").attr("disabled",true)
        $("#btnInicribirseASalida").attr("disabled", false);
    }else if ($(this).val() == "InscripcionPorPaquete"){
        $("#CantidadTuristasDiv").hide("slow");
        $("#PorPaqueteDiv").show("slow");
        $("#PorPaqueteOption").attr("disabled",false)
        $("#btnInicribirseASalida").attr("disabled", true);
    }else{
        $("#CantidadTuristasDiv").hide("slow");
        $("#PorPaqueteDiv").hide("slow");
        $("#PorPaqueteOption").attr("disabled",true)
        $("#btnInicribirseASalida").attr("disabled", true);
    }
})

$("#PorPaqueteOption").on("mouseup", function(){
    if ($(this).val() == "DisfrutarRocha") {
        $("#CantidadTuristasDiv").show("slow");
        $("#btnInicribirseASalida").attr("disabled", false);
    }else{
        $("#CantidadTuristasDiv").hide("slow");
        $("#btnInicribirseASalida").attr("disabled", true);
        
    }
})

$("#btnInicribirseASalida").on("click", async function(e) {
    if(parseInt($("#CantidadTuristasText").val()) <= 0 || $("#CantidadTuristasText").val()=="") {
        e.preventDefault();
        $("#CantidadTuristasText").addClass("is-invalid");
    }else{
        e.preventDefault();
        await Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Incripción realizada con exito',
            showConfirmButton: false,
            timer: 1700,
        })
        $("#FormularioInscripcionSalida").submit();
    }
  
})







