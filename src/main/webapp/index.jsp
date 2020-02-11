<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="AddClient.jsp">Add Client</a>
<br/>
<a href="AddCredit.jsp">Add Credit</a>
<br/>
<a href="AddSTB.jsp">Add State Treasury Bill</a>
<br/>
<a href="Find.jsp">Find something</a>
<br/>
<form action="${pageContext.request.contextPath}/nextMonthServlet" method="post">
    Next month:<input type="submit" name="next"/>
</form>
</body>
</html>
