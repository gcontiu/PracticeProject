<%--
  Created by IntelliJ IDEA.
  User: anghel
  Date: 1/23/12
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add company</title>
</head>
<body>

<form:form commandName="newCompany" method="POST" name="addCompany">
    <form:errors path="name" /><br/>
    <form:input path="name" />
    <input type="submit" value="Add Company">
</form:form>

</body>
</html>