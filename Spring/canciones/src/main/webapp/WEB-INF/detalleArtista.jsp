<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle artista</title>
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <h1>Detalle de Artista</h1>

    <c:choose>
        <c:when test="${empty artista}">
            <p>Artista no encontrado.</p>
        </c:when>
        <c:otherwise>
            <table border="1">
                <tbody>
                    <tr>
                        <th>Nombre</th>
                        <td><c:out value="${artista.nombre}" /></td>
                    </tr>
                    <tr>
                        <th>Apellido</th>
                        <td><c:out value="${artista.apellido}" /></td>
                    </tr>
                    <tr>
                        <th>Bibliografía</th>
                        <td><c:out value="${artista.bibliografia}" /></td>
                    </tr>
                    <tr>
                        <th>Fecha de creación</th>
                        <td>
                            <c:choose>
                                <c:when test="${not empty artista.fechaCreacion}">
                                    <fmt:formatDate value="${artista.fechaCreacion}" pattern="yyyy-MM-dd HH:mm:ss" />
                                </c:when>
                                <c:otherwise>N/A</c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    <tr>
                        <th>Fecha de actualización</th>
                        <td>
                            <c:choose>
                                <c:when test="${not empty artista.fechaActualizacion}">
                                    <fmt:formatDate value="${artista.fechaActualizacion}" pattern="yyyy-MM-dd HH:mm:ss" />
                                </c:when>
                                <c:otherwise>N/A</c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    <tr>
                        <th>Canciones</th>
                        <td>
                            <c:choose>
                                <c:when test="${not empty artista.canciones}">
                                    <ul>
                                        <c:forEach var="c" items="${artista.canciones}">
                                            <li>
                                                <a href="${pageContext.request.contextPath}/canciones/detalle/${c.id}">
                                                    <c:out value="${c.titulo}" />
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </c:when>
                                <c:otherwise>No tiene canciones.</c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>

    <p>
        <c:url var="listaUrl" value="/artistas" />
        <a href="${listaUrl}">Volver a la Lista de Artistas</a>
    </p>
</body>
</html>