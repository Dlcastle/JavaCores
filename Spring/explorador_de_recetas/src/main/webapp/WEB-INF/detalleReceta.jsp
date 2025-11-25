<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Detalle de Receta</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">
    </head>
    <body>
        <c:if test="${not empty recetaIngredientes}">
            <h2>Ingredientes:</h2>
            <ul>
                <c:forEach var="ingrediente" items="${recetaIngredientes}">
                    <li><c:out value="${ingrediente}"/></li>
                </c:forEach>
            </ul>
        </c:if>

        <c:if test="${empty recetaIngredientes}">
            <p>La receta no se encuentra en nuestra lista.</p>
        </c:if>
    </body>
</html>