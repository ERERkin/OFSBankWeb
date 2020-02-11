<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.02.2020
  Time: 0:23
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
<table>
    <tr>
        <th>
            ID
        </th>
        <th>
            Client ID
        </th>
        <th>
            Sum
        </th>
        <th>
            Percent
        </th>
        <th>
            Month
        </th>
        <th>
            Bank profit sum
        </th>
        <th>
            Kind
            <br/>
            False - Differential
            <br/>
            True - Annuity
        </th>
    </tr>
    <c:forEach items = "${list}" var = "item">
        <tr>
            <td>${item.id}</td>
            <td>${item.personId}</td>
            <td>${item.sum}</td>
            <td>${item.percent}%</td>
            <td>${item.month}</td>
            <%--<td>${item.countMonth}</td>--%>
            <td>${item.resultSum}</td>
            <td>${item.kind}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
