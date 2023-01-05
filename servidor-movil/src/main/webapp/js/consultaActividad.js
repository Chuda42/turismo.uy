$("#deepto").on("change", async function(){
	if($(this).val() != "Seleccionar"){
		$("#FormDepto").submit();
	}
})