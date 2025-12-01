<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Libros</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <h1>Lista de Libros</h1>
    <c:forEach var="libro" items="${libros}">
        <ul>
            <li>
                <a href="/libros/${libro.key}"> Libro: ${libro.key}, Autor: ${libro.value} </a></br>
            </li>
        </ul>
    </c:forEach>

    <button onclick="window.location.href='/libros/formulario'">Agregar nuevo libro</button>
</body>
</html>