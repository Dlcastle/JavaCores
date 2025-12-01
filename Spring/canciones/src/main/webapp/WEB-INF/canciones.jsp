<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Canciones</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <h1>Lista de Canciones</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Título</th>
                <th>Autor</th>
                <th>Detalle</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cancion" items="${canciones}">
                <tr>
                    <td><c:out value="${cancion.titulo}" /></td>
                    <td><c:out value="${cancion.artista}" /></td>
                    <td>
                        <c:url var="detalleUrl" value="/canciones/detalle/${cancion.id}" />
                        <a href="${detalleUrl}">Detalle</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:url var="agregarUrl" value="/canciones/formulario/agregar" />
    <button onclick="location.href='${agregarUrl}'">Agregar Nueva Canción</button>
</body>
</html>