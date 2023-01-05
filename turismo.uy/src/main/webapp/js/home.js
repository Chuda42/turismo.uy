/**
 * 
 */

 async function marcarDesmarcarFavoritos(div) {
 	let estado = div.firstElementChild.value;
 	console.log(estado, typeof estado);
 	const act = div.firstElementChild.nextElementSibling;
 	const usr = act.nextElementSibling;
 	const p = usr.nextElementSibling.firstElementChild;
 	const cant = p.nextElementSibling;
 	const i = cant.nextElementSibling.firstElementChild;
	$.ajax({
  		method: "POST",
  		url: "index",
  		data: {
  			usr: usr.value, 
  			act: act.value
  		},
	}).done(function( jqXHR, textStatus ) {
		console.log(p.innerText);
		if (estado == "false") {
	 		p.innerText = "Desmarcar de Favoritos";
	 		i.classList.add("fa-solid");
	 		i.classList.remove("fa-regular");
	 		cant.innerText = parseInt(cant.innerText) + 1;
			div.firstElementChild.value = "true";
		} else {
	 		p.innerText = "Marcar como Favorito";
	 		i.classList.add("fa-regular");
	 		i.classList.remove("fa-solid");
	 		cant.innerText = parseInt(cant.innerText) - 1;
			div.firstElementChild.value = "false";
		}	
	})
 }