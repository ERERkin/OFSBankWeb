<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.02.2020
  Time: 22:59
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
<form action="${pageContext.request.contextPath}/addSTB" method="post">
    Client ID:<input type="number" name="clientId"/>
    <br/>
    Month:<input type="number" name="month"/>
    <br/>
    First sum:<input type="number" name="firstSum"/>
    <br/>
    <input type="submit" name="Add State Treasury Bill"/>
</form>
</body>
</html>
