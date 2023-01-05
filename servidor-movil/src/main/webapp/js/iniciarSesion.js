const form = document.getElementById("formularioInicioSesion");
const nickEmail = document.getElementById("NicknameOEmailIniciarSesionText");
const pass = document.getElementById("ContraseniaIniciarSesionText");

pass.addEventListener("change", (e) => {
    form.classList.add('was-validated');
});

nickEmail.addEventListener("change", (e) => {
    form.classList.add('was-validated');
});

document.getElementById("btnIniciarSesion").addEventListener("click", (e) => {
    form.classList.add('was-validated');
    if (form.checkValidity())
    	form.submit();
});