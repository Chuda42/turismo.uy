$("#PorPaqueteDiv").hide();
$("#btnInicribirseASalida").attr("disabled", "disabled");

$("#TipoDeInscripcionOption").on("mouseup", function(){
	if ($(this).val() == null){
        $("#PorPaqueteDiv").hide("slow");
        $("#btnInicribirseASalida").attr("disabled", true);
        return;
    }
    if ($(this).val() == "general") {
        $("#PorPaqueteDiv").hide("slow");
        $("#PorPaqueteOption").attr("disabled",true)
        $("#btnInicribirseASalida").attr("disabled", false);
    } else if ($(this).val() == "porPaquete"){
        $("#PorPaqueteDiv").show("slow");
        $("#PorPaqueteOption").attr("disabled",false)
        $("#btnInicribirseASalida").attr("disabled", false);
    }
})

$("#btnInicribirseASalida").on("click", async function(e) {
    if(parseInt($("#CantidadTuristasText").val()) <= 0 || $("#CantidadTuristasText").val()=="") {
        e.preventDefault();
        $("#CantidadTuristasText").addClass("is-invalid");
    }else{
        $("#FormularioInscripcionSalida").submit();
    }
  
})

/*
post sent with ajax
$.ajax({
  type: "POST",
  url: "https://reqbin.com/echo/post/json",
  data: `{
    "Id": 78912,
    "Customer": "Jason Sweet",
  }`,
  success: function (result) {
     console.log(result);
  },
  dataType: "json"
});

*/






