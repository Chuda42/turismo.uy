const tocheck = Array.prototype.slice.call(document.querySelectorAll(".non-empty"));

function validateForm(elements) {
    for (const el of elements) {
        if (el.value != "") continue;
        return false;
    };
    return true;
}

const form = document.querySelector("#formAltaActividad");

document.querySelector("#submitBtn").addEventListener("click", async (event)=> {
    event.preventDefault();
    if (!validateForm(tocheck)){
        form.classList.add("was-validated");
    }else{
        await Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Actividad registrada con exito',
            showConfirmButton: false,
            timer: 1700,
        })
        $("#formAltaActividad").submit();
    }
   
})
