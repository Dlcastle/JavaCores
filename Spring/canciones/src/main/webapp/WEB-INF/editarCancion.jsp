<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Canción</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <h1>Editar Canción</h1>
    <form:form method="POST" modelAttribute="cancion" action="${pageContext.request.contextPath}/canciones/procesa/editar/${cancion.id}">
        <form:hidden path="id" />
        <label for="titulo">Título:</label>
        <form:input path="titulo" placeholder="Título" />
        <form:errors path="titulo" cssClass="error"/>
        <label for="artista">Artista:</label>
        <select name="artistaId">
            <option value="">-- Seleccione un artista --</option>
            <c:forEach var="artista" items="${artistas}">
                <option value="${artista.id}"
                    <c:if test="${not empty cancion.artista and cancion.artista.id == artista.id}">selected</c:if>>
                    ${artista.nombre} ${artista.apellido}
                </option>
            </c:forEach>
        </select>
        <form:errors path="artista" cssClass="error"/>
        <label for="album">Álbum:</label>
        <form:input path="album" placeholder="Álbum" />
        <form:errors path="album" cssClass="error"/>
        <label for="genero">Género:</label>
        <form:input path="genero" placeholder="Género" />
        <form:errors path="genero" cssClass="error"/>
        <label for="idioma">Idioma:</label>
        <form:input path="idioma" placeholder="Idioma" />
        <form:errors path="idioma" cssClass="error"/>
        <c:url var="listaUrl" value="/canciones" />
        <button type="submit">Guardar Cambios</button>
        <a href="${listaUrl}">Volver a la Lista de Canciones</a>
    </form:form>
</body>
</html>