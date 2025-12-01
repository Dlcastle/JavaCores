<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario de Libros</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <h1>Formulario de Libros</h1>
    <form action="/procesa/libro" method="post">
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="nombreLibro" required><br><br>
        <label for="autor">Autor:</label>
        <input type="text" id="autor" name="nombreAutor" required><br><br>
        <button type="submit">Enviar</button>
    </form>

    <button onclick="window.location.href='/libros'">Volver a la lista</button>    
</body>
</html>