$("#UnDiaEnColoniaInfo").hide();
$("#DisfrutarRochaInfo").hide();

$("#PaqueteSeleccionado").on("mouseup", function(){
    if($(this).val() == "Disfrutar Rocha"){
        $("#UnDiaEnColoniaInfo").hide("slow");
        $("#DisfrutarRochaInfo").show("slow");
        $("#btnComprarPaquete").attr("disabled", false);
    }else if($(this).val() == "Un dia Colonia"){
        $("#UnDiaEnColoniaInfo").show("slow");
        $("#DisfrutarRochaInfo").hide("slow");
        $("#btnComprarPaquete").attr("disabled", false);
    }else{
        $("#UnDiaEnColoniaInfo").hide();
        $("#DisfrutarRochaInfo").hide();
        $("#btnComprarPaquete").attr("disabled", true);
    }
})

$("#btnComprarPaquete").on("click", async function(e) {
    e.preventDefault();
    await Swal.fire({
        position: 'center',
        icon: 'error',
        title: 'Ya compro el paquete',
        showConfirmButton: false,
        timer: 1700,
    })
})
