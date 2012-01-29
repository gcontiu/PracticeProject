<%--
  Created by IntelliJ IDEA.
  User: gelu
  Date: 1/29/12
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Injected page: List Companies</title>
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
</head>

<body>

<table border="1">
    <c:forEach var="company" items="${companies}">
        <tr><td>${company}</td></tr>
    </c:forEach>
</table>

</body>

</html>