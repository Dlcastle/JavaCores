<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Explorador de Recetas</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">
    </head>
    <body>
        <h1>Explorador de Recetas</h1>

        <c:if test="${not empty listaRecetas}">
            <ul>
                <c:forEach var="receta" items="${listaRecetas}">
                    <li><c:out value="${receta}"/></li>
                </c:forEach>
            </ul>
        </c:if>

        <c:if test="${empty listaRecetas}">
            <p>No hay recetas disponibles.</p>
        </c:if>
    </body>
</html>