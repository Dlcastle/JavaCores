<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle libro</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <h1>Detalle del Libro</h1>
    <c:if test="${mensaje != null}">
       <p>${mensaje}</p>
    </c:if>
    <c:if test="${titulo != null && autor != null}">
        <p><strong>Título:</strong> ${titulo}</p>
        <p><strong>Autor:</strong> ${autor}</p>
    </c:if>

    <button onclick="window.location.href='/libros'">Volver a la lista</button>
</body>
</html>