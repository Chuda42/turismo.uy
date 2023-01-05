/**
 * 
 */
 
 const cantSeguidoresSpan = document.querySelector("#cantSeguidores");
let isAFollower = $("#isAFollower").val();
if (isAFollower == "true") {
	$("#followIcon").removeClass("fa-plus");
	$("#followIcon").addClass("fa-check");
} else {
	$("#followIcon").removeClass("fa-check");
	$("#followIcon").addClass("fa-plus");
}

$("#followButton").on("click", async function(){
	const usrVal = $(usr).val();
	const newFollowerVal = $(newFollower).val();
	$.ajax({
  		method: "POST",
  		url: "Follows",
  		data: {
  			usr: usrVal, 
  			newFollower: newFollowerVal
  		},
	}).done(function( jqXHR, textStatus ) {
		if (isAFollower == "true") {
			$("#followIcon").removeClass("fa-check");
	  		$("#followIcon").addClass("fa-plus");
	  		cantSeguidoresSpan.innerText =  parseInt(cantSeguidoresSpan.innerText) - 1;
	  		console.log(cantSeguidoresSpan.innerText);
	  		isAFollower = "false";
		} else {
	  		$("#followIcon").removeClass("fa-plus");
	  		$("#followIcon").addClass("fa-check");
	  		cantSeguidoresSpan.innerText =  parseInt(cantSeguidoresSpan.innerText) + 1;
	  		console.log(cantSeguidoresSpan.innerText);
	  		isAFollower = "true";
  		}
	})
})