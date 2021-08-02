<%--
  Created by IntelliJ IDEA.
  User: Black Diamond
  Date: 7/30/2021
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <c:forEach var="emp" items="${list}">
        <li>
            <form>
                <p>${emp.name}-Remain:${emp.remain}</p>
                <input type="submit" value="Borrow" formaction="/borrowBook/${emp.id}" formmethod="post">
            </form>
        </li>
    </c:forEach>
</ul>
</body>
</html>
