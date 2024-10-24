<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Hermandad del Cautivo de Almonte</title>
        <link href="/aplicacionHermandad/css/formulario.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Añadir nuevo Hermano</h1>

        <form id="formularionuevohermano" action="/aplicacionHermandad/hermano/save" method="POST">
            <label for="nombre">Nombre:</label>
            <input id="nombre" type="text" name="nombre" required><br />
            <label for="apellidos">Apellidos</label>
            <input id="apellidos" type="text" name="apellidos" required><br />
            <label for="dni">DNI:</label>
            <input id="dni" type="text" name="dni" required><br />
            <label for="fechaNac">Fecha de Nacimiento:</label>
            <input id="fechaNac" type="date" name="fechaNac" required><br />
            <label for="direccion">Dirección:</label>
            <input id="direccion" type="text" name="direccion" required><br />
            <label for="telefono">Teléfono:</label>
            <input id="telefono" type="text" name="telefono" required><br />
            <label for="correo">Correo:</label>
            <input id="correo" type="email" name="correo" required><br />
            <label for="fechaAlta">Fecha de Alta:</label>
            <input id="fechaAlta" type="date" name="fechaAlta" required><br />
            <label for="fechaJura">Fecha de Jura:</label>
            <input id="fechaJura" type="date" name="fechaJura" required><br />
            <label for="opcCobro">Opción de Cobro:</label>
            <select id="opcCobro" name="opcCobro" required>
                <option value="Cobrador">Cobrador</option>
                <option value="Transferencia">Transferencia Bancaria</option>
            </select><br />
            <label for="numCuenta">Número de Cuenta</label>
            <input id="numCuenta" type="text" name="numCuenta" required><br />
            <input type="submit" value="Guardar" />
        </form>
        <a href="/aplicacionHermandad/hermanos">Inicio</a>
        
        <script src="/aplicacionHermandad/js/comprobarnuevohermano.js"></script>
    </body>
</html>
