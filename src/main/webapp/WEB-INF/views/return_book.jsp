<%--
  Created by IntelliJ IDEA.
  User: Black Diamond
  Date: 7/30/2021
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" action="/returnBook" modelAttribute="bookCard">
    <fieldset>
        <legend>Login</legend>
        <table>
            <tr>
                <td><form:label path="code">Code:</form:label></td>
                <td><form:input path="code" type="int" /></td>
            </tr>
            <tr>
                <td></td>
                <td><form:button>Send</form:button></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
