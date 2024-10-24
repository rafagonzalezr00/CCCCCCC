<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Hermandad del Cautivo de Almonte</title>
        <link href="/aplicacionHermandad/css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Añadir persona a la Agenda</h1>

        <form id="formulario" action="/aplicacionHermandad/hermano/save" method="POST">
            <label for="nombre">Nombre:</label>
            <input id="nombre" type="text" name="nombre" ><br />
            <label for="apellidos">Apellidos</label>
            <input id="apellidos" type="text" name="apellidos" ><br />
            <label for="dni">DNI:</label>
            <input id="dni" type="text" name="dni" ><br />
            <label for="fechaNac">Fecha de Nacimiento:</label>
            <input id="fechaNac" type="date" name="fechaNac" ><br />
            <label for="direccion">Dirección:</label>
            <input id="direccion" type="text" name="direccion" ><br />
            <label for="telefono">Teléfono: </label>
            <input id="telefono" type="text" name="telefono" ><br />
            <label for="correo">Correo:</label>
            <input id="correo" type="text" name="correo" ><br />
            <label for="fechaAlta">Fecha de Alta:</label>
            <input id="fechaAlta" type="date" name="fechaAlta" ><br />
            <label for="fechaJura">Fecha de Alta:</label>
            <input id="fechaJura" type="date" name="fechaJura" ><br />
            <label for="opcCobro">Opción de Cobro:</label>
            <select id="opcCobro" name="opcCobro">
                <option value="Cobrador">Cobrador</option>
                <option value="Transferencia">Transferencia Bancaria</option>
            </select><br />
            <label for="numCuenta">Número de Cuenta</label>
            <input id="numCuenta" type="text" name="numCuenta" ><br />
            <input type="submit" value="Guardar" />
        </form>
        <a href="/aplicacionHermandad/hermanos">Inicio</a>
        
        <script src="/aplicacionHermandad/js/functions.js"></script>

    </body>
</html>
