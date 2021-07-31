<%--
  Created by IntelliJ IDEA.
  User: Black Diamond
  Date: 7/30/2021
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Hello World</h3>
<form>
    <input type="submit" value="Borrow Book" formaction="/getListBook" formmethod="get">
    <input type="submit" value="Return Book" formaction="/returnBook" formmethod="post">
</form>
</body>
</html>
