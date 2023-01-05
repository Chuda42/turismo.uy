$("#orden").on("change", async function(){
	if($(this).val() != "Seleccionar"){
		$("#FormOrdenar").submit();
	}
})