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
<form action="${pageContext.request.contextPath}/addCreditServlet" method="post">
    Client ID:<input type="number" name="clientId"/>
    <br/>
    Sum:<input type="number" name="sum"/>
    <br/>
    %:<input type="number" name="percent"/>
    <br/>
    Month:<input type="number" name="month"/>
    <br/>
    Annuity/Differential:<input type="checkbox" name="kind"/>
    <br/>
    <input type="submit" name="Add credit"/>
</form>
</body>
</html>
