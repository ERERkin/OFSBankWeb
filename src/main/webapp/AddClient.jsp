<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.02.2020
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addClientServlet" method="post">
    Client id:<input type="number" name="clientId"/>
    <br/><%--
    Bank id:<input type="number" name="bankId"/>
    <br/>--%>
    Name:<input type="text" name="name"/>
    <br/>
    Address:<input type="text" name="address"/>
    <br/>
    Age:<input type="number" name="age"/>
    <br/>
    Gender:<input type="text" name="gender"/>
    <br/>
    <input type="submit" name="add client"/>
</form>
</body>
</html>
