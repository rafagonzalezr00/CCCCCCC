<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Iniciar Sesión - Hermandad del Cautivo de Almonte</title>
    <link href="${pageContext.request.contextPath}/css/inicio.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="login-container">
        <h2>Inicio de Sesión</h2>
        <form action="${pageContext.request.contextPath}/inicio" method="post">
            <label for="username">Usuario</label>
            <input type="text" id="username" name="username" required>
            <label for="password">Contraseña</label>
            <input type="password" id="password" name="password" required>
            <button type="submit">Iniciar Sesión</button>
            <c:if test="${not empty errorMessage}">
                <p style="color:red;">${errorMessage}</p>
            </c:if>
        </form>
    </div>
</body>
</html>
