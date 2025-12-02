<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle de Canción</title>
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <h1>Detalle de Canción</h1>

    <c:choose>
        <c:when test="${empty cancion}">
            <p>Canción no encontrada.</p>
        </c:when>
        <c:otherwise>
            <table border="1">
                <tbody>
                    <tr>
                        <th>Título</th>
                        <td><c:out value="${cancion.titulo}" /></td>
                    </tr>
                    <tr>
                        <th>Artista</th>
                        <td><c:out value="${cancion.artista.nombre}"/>&nbsp;<c:out value="${cancion.artista.apellido}"/></td>
                    </tr>
                    <tr>
                        <th>Álbum</th>
                        <td><c:out value="${cancion.album}" /></td>
                    </tr>
                    <tr>
                        <th>Género</th>
                        <td><c:out value="${cancion.genero}" /></td>
                    </tr>
                    <tr>
                        <th>Idioma</th>
                        <td><c:out value="${cancion.idioma}" /></td>
                    </tr>
                    <tr>
                        <th>Fecha de creación</th>
                        <td>
                            <c:choose>
                                <c:when test="${not empty cancion.fechaCreacion}">
                                    <fmt:formatDate value="${cancion.fechaCreacion}" pattern="yyyy-MM-dd HH:mm:ss" />
                                </c:when>
                                <c:otherwise>N/A</c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    <tr>
                        <th>Fecha de actualización</th>
                        <td>
                            <c:choose>
                                <c:when test="${not empty cancion.fechaActualizacion}">
                                    <fmt:formatDate value="${cancion.fechaActualizacion}" pattern="yyyy-MM-dd HH:mm:ss" />
                                </c:when>
                                <c:otherwise>N/A</c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
    <button onclick="location.href='${pageContext.request.contextPath}/canciones/formulario/editar/${cancion.id}'">Editar Canción</button>
    <form method="post" action="${pageContext.request.contextPath}/canciones/eliminar/${cancion.id}">
        <input type="hidden" name="_method" value="delete"/>
        <button type="submit">Eliminar Canción</button>
    </form>

    <p>
        <c:url var="listaUrl" value="/canciones" />
        <a href="${listaUrl}">Volver a lista de canciones</a>
    </p>
</body>
</html>