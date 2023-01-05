/**
 * 
 */
 
$("#nombreDep").on("change", async function(){
	if($(this).val() != ""){
		$("#seleccionarDepto").submit();
	}
})

function formularioValido(){
	let dep = document.getElementById('departamento').selectedOptions[0].value;
	let act = document.getElementById('actividad').selectedOptions[0].value;
	let nomS = document.getElementById('nombreS').value.trim();
	let fecha = document.getElementById('fecha').value.trim();
	let hora = document.getElementById('hora').value.trim();
	let lugar = document.getElementById('lugarDeSalida').value.trim();
	let cantMaxTu = document.getElementById('cantidadMaximaDeTuristas').value.trim();
	
	//let fotoSal = document.getElementById('fotoDeLaSalida');
	
	if(dep == "" || act == "" || nomS == "" || lugar == "" || cantMaxTu < 1 || fecha == "" || !(hora>=0 && hora<24)){
		return false;
	}else{
		return true;
	}

}

document.querySelector("#submitBtn").addEventListener("click", async (event)=> {
   e.preventDefault();
    if(formularioValido()){
        /*await Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Registrado con exito',
            showConfirmButton: false,
            timer: 1700,
        })*/
        $("#formAltaSalida").submit();
    }
   
})
