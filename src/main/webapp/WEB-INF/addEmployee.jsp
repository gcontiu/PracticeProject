<%--
  Created by IntelliJ IDEA.
  User: anghel
  Date: 1/23/12
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Add Employee</title>
</head>
<body>
    <form:form commandName="newEmployee" method="POST">
        <form:errors path="name" /><br/>
        <form:input path="name">name</form:input>

        <form:option items="${companies}"  value="company" />
    </form:form>

</body>
</html>