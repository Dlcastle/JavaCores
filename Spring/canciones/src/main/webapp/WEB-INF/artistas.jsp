<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Artistas</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <h1>Lista de Artistas</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Nombre y Apellido</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="artista" items="${artistas}">
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/artistas/detalle/${artista.id}">
                            <c:out value="${artista.nombre}"/>&nbsp;<c:out value="${artista.apellido}"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/canciones">Ir a canciones</a>
</body>
</html>