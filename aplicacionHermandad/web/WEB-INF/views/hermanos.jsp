<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Hermandad del Cautivo de Almonte</title>
        
        <link href="/aplicacionHermandad/css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav> | <a href="/aplicacionHermandad/hermano/new">Crear Nueva Entrada</a> | </nav>
        <h1>Registro de Hermanos</h1>
    <c:if test="${!empty requestScope.hermano}">
        <table>
            <tr>
                <th>Nº Hermano</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>DNI</th>
                <th>Fecha de Nacimiento</th>
                <th>Dirección</th>
                <th>Teléfono</th>
                <th>Correo</th>
                <th>Fecha de Alta</th>
                <th>Fecha de Jura</th>
            </tr>
            <c:forEach var="hermano" items="${requestScope.hermano}" >
                <tr>
                    <td>${hermano.n_Hermano}</td>
                    <td>${hermano.nombre}</td>
                    <td>${hermano.apellidos}</td>
                    <td>${hermano.DNI}</td>
                    <td>${hermano.fechaNac}</td>
                    <td>${hermano.direccion}</td>
                    <td>${hermano.numTelefono}</td>
                    <td>${hermano.correo}</td>
                    <td>${hermano.fechaAlta}</td>
                    <td>${hermano.fechaJura}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty requestScope.hermano}">
        <p>Oops! No hay Hermanos todavía!</p>
    </c:if>
</body>
</html>