// functions.js

document.addEventListener("DOMContentLoaded", function() {
    const formulario = document.getElementById("formularionuevohermano");

    formulario.addEventListener("submit", function(event) {
        // Prevenir el envío del formulario si hay errores
        let valid = true;
        const today = new Date();

        // Limpiar los estilos de error de los campos
        limpiarEstilos();

        // Comprobar campos obligatorios
        const camposObligatorios = [
            { id: "nombre", nombre: "Nombre" },
            { id: "apellidos", nombre: "Apellidos" },
            { id: "fechaNac", nombre: "Fecha de Nacimiento" },
            { id: "direccion", nombre: "Dirección" },
            { id: "telefono", nombre: "Teléfono" },
            { id: "opcCobro", nombre: "Forma de Cobro" }
        ];

        camposObligatorios.forEach(campo => {
            const valor = document.getElementById(campo.id).value.trim();
            if (!valor) {
                alert(`${campo.nombre} es obligatorio.`);
                marcarError(campo.id);
                valid = false;
            }
        });

        // Comprobar DNI
        const dni = document.getElementById("dni").value.trim();
        const dniPattern = /^\d{8}[A-Za-z]$/; // Formato: 8 dígitos seguidos de una letra
        if (!dniPattern.test(dni)) {
            alert("El DNI debe tener 8 dígitos seguidos de una letra.");
            marcarError("dni");
            valid = false;
        } else {
            const numeroDNI = dni.slice(0, 8);
            const letraDNI = dni.charAt(8).toUpperCase();
            const letraCalculada = calcularLetraDNI(numeroDNI);

            if (letraDNI !== letraCalculada) {
                alert("La letra del DNI no es correcta.");
                marcarError("dni");
                valid = false;
            }
        }

        // Comprobar Fecha de Nacimiento
        const fechaNac = new Date(document.getElementById("fechaNac").value);
        if (fechaNac >= today) {
            alert("La fecha de nacimiento debe ser menor a la fecha actual.");
            marcarError("fechaNac");
            valid = false;
        }

        // Comprobar Fecha de Alta
        const fechaAlta = new Date(document.getElementById("fechaAlta").value);
        if (fechaAlta > today) {
            alert("La fecha de alta debe ser igual o menor a la fecha actual.");
            marcarError("fechaAlta");
            valid = false;
        }

        // Comprobar Fecha de Jura
        const fechaJura = new Date(document.getElementById("fechaJura").value);
        if (fechaJura > today) {
            alert("La fecha de jura debe ser igual o menor a la fecha actual.");
            marcarError("fechaJura");
            valid = false;
        }

        // Comprobar Opción de Cobro y Número de Cuenta
        const opcCobro = document.getElementById("opcCobro").value;
        const numCuenta = document.getElementById("numCuenta").value;
        if (opcCobro === "Transferencia" && numCuenta.trim() === "") {
            alert("Si la opción de cobro es 'Transferencia Bancaria', el número de cuenta es obligatorio.");
            marcarError("numCuenta");
            valid = false;
        }

        // Si hay un error, prevenir el envío del formulario
        if (!valid) {
            event.preventDefault();
        }
    });

    // Función para calcular la letra del DNI
    function calcularLetraDNI(dni) {
        const letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        const numero = parseInt(dni, 10);
        return letras.charAt(numero % 23);
    }

    // Función para marcar error en el campo
    function marcarError(id) {
        const campo = document.getElementById(id);
        campo.style.border = "2px solid red"; // Resalta el borde en rojo
    }

    // Función para limpiar los estilos de error
    function limpiarEstilos() {
        const campos = ["nombre", "apellidos", "fechaNac", "direccion", "telefono", "dni", "fechaAlta", "fechaJura", "numCuenta"];
        campos.forEach(campoId => {
            const campo = document.getElementById(campoId);
            campo.style.border = ""; // Limpia el borde
        });
    }
});
