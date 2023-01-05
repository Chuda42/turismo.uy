$('#bologna-list a').on('click', function (e) {
    e.preventDefault()
    $(this).tab('show')
  })
  
$("#btnGuardar").on("click", async function(e){
    e.preventDefault();
    $("#FormularioModificarDatos").submit(); 
});

$("#inputNuevaImg").hide();

$("#modificarImagenPerfil").on("click", function() {
	$("#inputNuevaImg").trigger('click');
});