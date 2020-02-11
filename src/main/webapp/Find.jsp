<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.02.2020
  Time: 0:15
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
<h1>Find credit story</h1>
<form action="${pageContext.request.contextPath}/showCreditsServlet" method="post">
    Client ID:<input type="number" name="clientId"/>
    <br/>
    Active/Finished:<input type="checkbox" name="kind"/>
    <br/>
    <input type="submit" name="Show credit story"/>
</form>
<h1>Payment graphics</h1>
<form action="${pageContext.request.contextPath}/showPaymentsServlet" method="post">
    Credit ID:<input type="number" name="creditId"/>
    <br/>
    <input type="submit" name="Show payment graphics"/>
</form>
<h1>STB list</h1>
<form action="${pageContext.request.contextPath}/showSTBServlet" method="post">
    Client ID<input type="number" name="clientId"/>
    <br/>
    <input type="submit" name="Show state treasury bills list"/>
</form>
</body>
</html>
