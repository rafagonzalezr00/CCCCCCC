let f = document.getElementById("formulario");
f.addEventListener("submit", checkData);
function checkData(evt) {

    let ok = true;

    let nombre = document.getElementById("nombre").value;
    let apellidos = document.getElementById("apellidos").value;
    let fechanac = document.getElementById("fechaNac").value;
    let direccion = document.getElementById("direccion").value;
    let telefono = document.getElementById("telefono").value;
    let opccobro = document.getElementById("opcCobro").value;
    

    if (nombre === "") {
        alert("El nombre es obligatorio");
        evt.preventDefault();
        ok = false;
    }
    
    if (apellidos === "") {
        alert("Los apellidos son obligatorios");
        evt.preventDefault();
        ok = false;
    }
    
    if (fechanac === "") {
        alert("La Fecha de Nacimiento");
        evt.preventDefault();
        ok = false;
    }
    
    if (direccion === "") {
        alert("La Direccion es obligatoria");
        evt.preventDefault();
        ok = false;
    }
    
    if (telefono === "") {
        alert("El número de teléfono es obligatorio");
        evt.preventDefault();
        ok = false;
    }
    
    if (opccobro === "") {
        alert("El método de pago es obligatorio");
        evt.preventDefault();
        ok = false;
    }

    return ok;
}