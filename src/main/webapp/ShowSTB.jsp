<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.02.2020
  Time: 9:20
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
<a href="index.jsp">Main</a>
<br/>
<table>
    <tr>
        <td>
            ID
        </td>
        <td>
            Credit ID
        </td>
        <td>
            Month
        </td>
        <td>
            First sum
        </td>
    </tr>
    <c:forEach items = "${list}" var = "item">
        <tr>
                <%--<td>${item.id}</td>--%>
            <td>${item.id}</td>
            <td>${item.personId}</td>
            <td>${item.month}</td>
            <td>${item.firstSum}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
