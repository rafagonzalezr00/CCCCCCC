<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión - Hermandad del Cautivo de Almonte</title>
        
        <link href="/aplicacionHermandad/css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="login-container">
            <h2>Inicio de Sesión</h2>
            <form action="/aplicacionHermandad/hermanos.jsp" method="post">
                <!-- Campo oculto para indicar la acción -->
                <input type="hidden" name="accion" value="login">
                
                <label for="username">Usuario</label>
                <input type="text" id="username" name="username" required>
                
                <label for="password">Contraseña</label>
                <input type="password" id="password" name="password" required>
                
                <button type="submit">Iniciar Sesión</button>
            </form>
        </div>
    </body>
</html>
